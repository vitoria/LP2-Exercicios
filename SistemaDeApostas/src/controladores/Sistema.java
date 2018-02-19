package controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classes.Cenario;
import classes.CenarioBonus;
import classes.ComparaPorApostas;
import classes.ComparaPorID;
import classes.ComparaPorNome;
import uteis.Validacao;

/**
 * classe que representa um sistema de apostas que contém uma lista de cenarios
 * 
 * @author Vitória Heliane
 *
 */
public class Sistema {
	
	private int caixa;
	private double taxa;
	private ArrayList<Cenario> listaCenarios;
	private Comparator<Cenario> ordem;

	/**
	 * Cria um novo objeto de sistema, inicializando o valor do caixa e a taxa de ganho com os valores recebido.
	 * E também inicializa a lista de cenários com um ArrayList vazio
	 * 
	 * @param caixa - valor inicial do caixa
	 * @param taxa - taxa de ganho do sistema em cima das apostas perdedoras de cada cenario
	 */
	
	public Sistema(int caixa, double taxa) {
		try {
			Validacao.validaInteiroNaoNegativo("Caixa nao pode ser inferior a 0", caixa);
			Validacao.validarNotNegativeDouble("Taxa nao pode ser inferior a 0", taxa);
			Validacao.validarPercentage("TAXA INVÁLIDA!", taxa);
			this.caixa = caixa;
			this.taxa = taxa;
			this.listaCenarios = new ArrayList<>();
			this.ordem = new ComparaPorID();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na inicializacao: " + e.getMessage());
		}
	}

	/**
	 * Acesador do valor atual do caixa do sistema
	 * 
	 * @return inteiro representando o valor do caixa
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Acessador da taxa
	 * 
	 * @return double representando o valor da taxa
	 */
	
	public double getTaxa() {
		return this.taxa;
	}
	
	/**
	 * Cria um novo cenário e o adiciona na lista de cenários do sistema
	 * 
	 * @param descricao - descrição do cenário a ser criado
	 * 
	 * @return identificador do cenário criado
	 */
	
	public int criaCenario(String descricao) {
		try {
			Cenario cenario = new Cenario(listaCenarios.size() + 1, descricao);
			listaCenarios.add(cenario);
			return listaCenarios.size();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e.getMessage());
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e.getMessage());
		}
	}
	
	/**
	 * Cria um novo cenário e o adiciona na lista de cenários do sistema
	 * 
	 * @param descricao - descrição do cenário a ser criado
	 * 
	 * @return identificador do cenário criado
	 */
	
	public int criaCenario(String descricao, int bonus) {
		try {
			Validacao.validarLessEqualThan("O CAIXA NÃO SUPORTA ESSE BÔNUS!", bonus, caixa);
			Cenario cenario = new CenarioBonus(listaCenarios.size() + 1, descricao, bonus);
			listaCenarios.add(cenario);
			caixa -= bonus;
			return listaCenarios.size();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e.getMessage());
		}
	}

	/**
	 * Cria uma representação em String de um cenário determinado, caso ele exista
	 * 
	 * @param idCenario - identificador do cenário
	 * 
	 * @return stirng com a representação do cenário
	 */
	
	public String exibeCenario(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).toString();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de cenario: " + e.getMessage());
		}
	}

	/**
	 * Cria uma representtação em string dos cenários cadastrados no sistema
	 * 
	 * @return string com a representação dos cenários
	 */
	
	public String exibeCenarios() {
		String cenarios = "";
		Collections.sort(listaCenarios, new ComparaPorID());
		for(Cenario c : listaCenarios) {
			cenarios += c.toString() + "\n";
		}
		return cenarios;
	}

	/**
	 * Metodo que adiciona uma nova aposta em um determinado cenário, caso ele exista
	 * 
	 * @param idCenario - identificador do cenario
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado no cenário
	 * @param previsao - resultado esperado da aposta
	 */
	
	public int cadastraAposta(int idCenario, String nomeApostador, int valorAposta, String previsao) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta: " + e.getMessage());
		} 
	}
	
	/**
	 * Metodo que adiciona uma nova aposta assegurada por valor em um determinado cenário, caso ele exista
	 * 
	 * @param idCenario - identificador do cenario
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado no cenário
	 * @param previsao - resultado esperado da aposta
	 */
	
	public int cadastraAposta(int idCenario, String nomeApostador, int valorAposta, String previsao, int valorSeguro, int custoSeguro) {
		try {
			verificaCenarioInvalido(idCenario);
			Validacao.validaInteiroPositivo("CUSTO INVÁLIDO!", custoSeguro);
			caixa += custoSeguro;
			return listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao, valorSeguro);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: " + e.getMessage());
		} 
	}
	
	/**
	 * Metodo que adiciona uma nova aposta assegurada por taxa em um determinado cenário, caso ele exista
	 * 
	 * @param idCenario - identificador do cenario
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado no cenário
	 * @param previsao - resultado esperado da aposta
	 */
	
	public int cadastraAposta(int idCenario, String nomeApostador, int valorAposta, String previsao, double taxaSeguro, int custoSeguro) {
		try {
			verificaCenarioInvalido(idCenario);
			Validacao.validaInteiroPositivo("CUSTO INVÁLIDO!", custoSeguro);
			caixa += custoSeguro;
			return listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao, taxaSeguro);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} 
	}
	
	/**
	 * Altera o seguro de uma aposta assegurado parao seguro por valor
	 * Caso a aposta não seja assegura, é lnçada uma exceção
	 * @param idCenario id do cenario no qual a aposta está cadastrada
	 * @param id id da aposta 
	 * @param valor valor do seguro
	 * @return id da aposta
	 */
	public int alteraSeguroValor(int idCenario, int id, int valor) {
		try {
			
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).alteraSeguroValor(id, valor);
			
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		}
	}
	
	/**
	 * Este metodo altera o seguro de uma aposta assegurad para o tipo de seguro por taxa
	 * Caso a aposta não seja assegurada, é lançada uma exceção
	 * @param idCenario id do cenario no qual a aposta está cadastrada
	 * @param id id da aposta
	 * @param taxa taxa do seguro da aposta
	 * @return id da aposta
	 */
	public int alteraSeguroTaxa(int idCenario, int id, double taxa) {
		try {
			
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).alteraSeguroTaxa(id, taxa);
			
		} catch (IllegalArgumentException e) {
			
			throw new IllegalArgumentException("Erro na alteracao para seguro por taxa: " + e.getMessage());
			
		} catch(NullPointerException e) {
			
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		
		}
	}

	/**
	 * Acessador do somatório do valor de todas as apostas cadastradas em um cenário, caso ele exista
	 * 
	 * @param idCenario - identificador do cenario
	 * 
	 * @return inteiro indicando o somatorio do valor das apostas
	 */
	
	public int valorTotalApostas(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).valorTotalDasApostas();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro na consulta do valor total de apostas: " + e.getMessage());
		}
	}

	/**
	 * Acessador da quantidade de apostas cadastradas em um determinando cenário, caso ele exista
	 * 
	 * @param idCenario - identificador do cenário
	 * 
	 * @return inteiro indicando a quantidade de apostas
	 */
	
	public int totalApostas(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).getTotalApostas();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro na consulta do total de apostas: " + e.getMessage());
		}
	}

	/**
	 * Cria uma representação em string de todas as apostas de um cenário, caso ele esteja cadastrado no sistema
	 * 
	 * @param idCenario - identificador do cenário
	 * 
	 * @return stirng com a representação das apostas do cenário
	 */
	
	public String exibeApostas(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).listaApostas();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de apostas do cenario: " + e.getMessage());
		}

	}

	/**
	 * Finaliza um cenario determinado, caso ele exista, e atualiza o valor do caixa com o ganho do sistema
	 * 
	 * @param idCenario - identificador do cenario
	 * @param ocorreu - valor que indica se o cenario ocorreu ou nao
	 * 
	 */
	
	public void fechaCenario(int idCenario, boolean ocorreu) {
		try {
			verificaCenarioInvalido(idCenario);
			Cenario c = listaCenarios.get(idCenario - 1);
			c.finalizaCenario(ocorreu);
			caixa += getCaixaCenario(idCenario);
			caixa -= c.pagamentoSeguros();
			
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao fechar aposta: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro ao fechar aposta: " + e.getMessage());
		} catch(UnsupportedOperationException e) {
			throw new NullPointerException("Erro ao fechar aposta: " + e.getMessage());
		}
	}

	/**
	 * Calcula o ganho do caixa de acordo com sua taxa de retirada em cima do valor total das apostas perdedoras
	 * 
	 * @param idCenario - identificador do cenário
	 * 
	 * @return inteiro indicando o valor do ganho arredondado para baixo
	 */
	
	public int getCaixaCenario(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).calculaLucro(taxa);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: " + e.getMessage());
		} catch(UnsupportedOperationException e) {
			throw new NullPointerException("Erro na consulta do caixa do cenario: " + e.getMessage());
		}
	}

	/**
	 * Calcula o valor apostado no cenario que será destinado a apostas vencedoras
	 * 
	 * @param idCenario - identificador do cenario
	 * 
	 * @return inteiro representando esse valor arredondado para baixo
	 */
	
	public int getTotalRasteioCenario(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			return listaCenarios.get(idCenario - 1).rateioCenario(taxa);

		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		} catch(UnsupportedOperationException e) {
			throw new NullPointerException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		}

	}
	
	public void alteraOrdem(String ordem){
		if(ordem == null || ordem.trim().equals("")) throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		switch(ordem.toLowerCase()){
		case "cadastro":
			this.ordem = new ComparaPorID();
			break;
		case "nome":
			this.ordem = new ComparaPorNome();
			break;
		case "apostas":
			this.ordem = new ComparaPorApostas();
			break;
		default:
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
	
	public String exibeCenarioOrdenado(int idCenario){
		try{
			verificaCenarioInvalido(idCenario);
			ArrayList<Cenario> lista = new ArrayList<>(listaCenarios);
			Collections.sort(lista, this.ordem);
			return lista.get(idCenario - 1).toString();
		} catch (IllegalArgumentException e){
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: " + e.getMessage());
		}
	}

	/**
	 * Este metodo verifica se o id recebido é valido para algum cenario
	 * Senão lança uma exceção
	 * @param idCenario id do cenario
	 */
	private void verificaCenarioInvalido(int idCenario) {
		if(idCenario < 1) throw new IllegalArgumentException("Cenario invalido");
		if(idCenario > listaCenarios.size()) throw new IllegalArgumentException("Cenario nao cadastrado");
	}

}
