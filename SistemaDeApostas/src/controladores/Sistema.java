package controladores;

import java.util.ArrayList;
import classes.Cenario;
import classes.CenarioBonus;
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

	/**
	 * Cria um novo objeto de sistema, inicializando o valor do caixa e a taxa de ganho com os valores recebido.
	 * E também inicializa a lista de cenários com um ArrayList vazio
	 * 
	 * @param caixa - valor inicial do caixa
	 * @param taxa - taxa de ganho do sistema em cima das apostas perdedoras de cada cenario
	 */
	
	public Sistema(int caixa, double taxa) {
		Validacao.validaInteiroNaoNegativo("Erro na inicializacao: Caixa nao pode ser inferior a 0", caixa);
		Validacao.validarPercentage("Erro na inicializacao: Taxa nao pode ser inferior a 0", taxa);
		this.caixa = caixa;
		this.taxa = taxa;
		this.listaCenarios = new ArrayList<>();
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
			if(bonus > caixa) throw new IllegalArgumentException("Bonus invalido");
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
			caixa += custoSeguro;
			return listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao, valorSeguro, custoSeguro);
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
			caixa += custoSeguro;
			return listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao, taxaSeguro, custoSeguro);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e.getMessage());
		} 
	}
	
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
	
	public int alteraSeguroTaxa(int idCenario, int id, double taxa) {
		return listaCenarios.get(idCenario - 1).alteraSeguroTaxa(id, taxa);
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
			Cenario c = listaCenarios.get(idCenario - 1);
			return c.valorTotalDasApostas();
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
			Cenario c = listaCenarios.get(idCenario - 1);
			return c.getTotalApostas();
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

		Cenario c = listaCenarios.get(idCenario - 1);
		return c.listaApostas();

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
			return listaCenarios.get(idCenario - 1).lucroCenario(taxa);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro na consulta do caixa do cenario: " + e.getMessage());
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
			Cenario c = listaCenarios.get(idCenario - 1);
			return c.rateioCenario(taxa);

		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		} catch(NullPointerException e) {
			throw new NullPointerException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		} catch(UnsupportedOperationException e) {
			throw new NullPointerException("Erro na consulta do total de rateio do cenario: " + e.getMessage());
		}

	}

	private void verificaCenarioInvalido(int idCenario) {
		if(idCenario < 1) throw new IllegalArgumentException("Cenario invalido");
		if(idCenario > listaCenarios.size()) throw new IllegalArgumentException("Cenario nao cadastrado");
	}

}
