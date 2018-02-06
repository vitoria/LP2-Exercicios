package classes;

import java.util.ArrayList;

import uteis.EstadoCenario;
import uteis.Validacao;

/**
 * Classe que representa um cenário de apostas que contem
 * uma descrição, estado e uma lista de apostas
 * 
 * @author Vitoria Heliane
 *
 */

public class Cenario {
	private String descricao;
	private EstadoCenario estado;
	private ArrayList<Aposta> listaApostas;
	private int id;

	/**
	 * Cria um novo cenario inicializando
	 * o id e a descrição com os valores respectivos recebidos
	 * estado como nao finalizado e uma lista de apostas vazia
	 * 
	 * @param id - identificador do cenario
	 * @param descricao - descricao do cenario
	 */
	
	public Cenario(int id, String descricao) {
		Validacao.verificaStringVazia("Descricao nao pode ser vazia", descricao);
		this.id = id;
		this.descricao = descricao;
		estado = EstadoCenario.NAO_FINALIZADO;
		listaApostas = new ArrayList<>();
	}

	/**
	 * Acessador do id
	 * 
	 * @return inteiro que representa o id do cenario
	 */
	
	public int getId() {
		return this.id;
	}

	/**
	 * Acessador da descrição
	 * 
	 * @return string que representa a descricao do cenario
	 */
	
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Acessador do estado atual do cenario
	 * 
	 * @return string representaodo o estado atual do cenario
	 */
	
	public String getEstado() {
		return estado.getNome();
	}

	/**
	 * Metodo que finaliza o cenario, atribuindo o valor "Finalizado" e informando se occoreu ou não
	 * ao atributo estaod
	 * 
	 * @param estado - resultado final do cenario, informa se ele acontecue ou nao
	 */
	
	public void finalizaCenario(boolean estado) {
		verificaCenarioFechado();
		this.estado = (estado) ? EstadoCenario.FINALIZADO_OCORREU : EstadoCenario.FINALIZADO_NAO_OCORREU; 
	}

	/**
	 * Cria uma nova aposta de acordo com os parametros recebidos e adiciona na lsita de apostas
	 * 
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado (em cnetavos)
	 * @param previsao - previsao (vai acontecer ou nao)
	 */
	
	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		verificaCenarioFechado();
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		listaApostas.add(aposta);
	}
	
	/**
	 * Cria uma nova aposta assegurada por valor de acordo com os parametros recebidos e adiciona na lsita de apostas
	 * 
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado (em cnetavos)
	 * @param previsao - previsao (vai acontecer ou nao)
	 * @param valorSeguro - valor do seguro da aposta
	 * @param custoSeguro - custo do seguro da aposta
	 */
	
	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao, int valorSeguro, int custoSeguro) {
		verificaCenarioFechado();
		Aposta aposta = new ApostaAsseguradaValor(nomeApostador, valorAposta, previsao, valorSeguro, custoSeguro);
		listaApostas.add(aposta);
	}
	
	/**
	 * Cria uma nova aposta assegurada por taxa de acordo com os parametros recebidos e adiciona na lsita de apostas
	 * 
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado (em cnetavos)
	 * @param previsao - previsao (vai acontecer ou nao)
	 * @param taxaSeguro - valor da taxa do seguro da aposta
	 * @param custoSeguro - custo do seguro da aposta
	 */
	
	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao, double taxaSeguro, int custoSeguro) {
		verificaCenarioFechado();
		Aposta aposta = new ApostaAsseguradaTaxa(nomeApostador, valorAposta, previsao, taxaSeguro, custoSeguro);
		listaApostas.add(aposta);
	}

	public void alteraSeguroValor(int idAposta, int valor) {
		verificaCenarioFechado();
		verificaIdApostaValido(idAposta);
		Aposta aposta = listaApostas.get(idAposta - 1);
		if(aposta instanceof ApostaAsseguradaValor) {
			((ApostaAsseguradaValor) aposta).setValorSeguro(valor);
		}
	}
	
	public void alteraSeguroTaxa(int idAposta, double taxa) {
		verificaCenarioFechado();
		verificaIdApostaValido(idAposta);
		Aposta aposta = listaApostas.get(idAposta - 1);
		if(aposta instanceof ApostaAsseguradaTaxa) {
			((ApostaAsseguradaTaxa) aposta).setTaxaSeguro(taxa);
		}
	}
	
	/**
	 * Calcula o somatorio do valor de todas apostas do cenario
	 * 
	 * @return inteiro representando o somatorio
	 */
	
	public int totalValorApostas() {
		int total = 0;
		for(Aposta a : listaApostas) {
			total += a.getValor();
		}
		return total;
	}

	/**
	 * Acessador do total de apostas do cenario
	 */
	
	public int getTotalApostas() {
		return listaApostas.size();
	}

	/**
	 * Cria um represnetação em stirng de todas apostadas do cenario
	 * 
	 * @return string representando as apostas
	 */
	
	public String listaApostas() {
		String apostas = "";
		for(Aposta a : listaApostas) {
			apostas += a.toString() + "\n";
		}
		return apostas;
	}

	/**
	 * Calcula o somatorio do valor de todas as apostas perdedoras
	 * (cuja previsao e diferente do estado do cenario apos finalizado)
	 * 
	 * @return inteiro que representa o somatorio
	 */
	
	public int somaValorApostasPerdedoras() {
		verificaCenarioAberto();
		int total = 0;
		for(Aposta a : listaApostas) {
			if(a.getPrevisao().equals("VAI ACONTECER") && estado.getNome().equals("Finalizado (n ocorreu)") ||
					a.getPrevisao().equals("N VAI ACONTECER") && estado.getNome().equals("Finalizado (ocorreu)"))
				total += a.getValor();
		}
		return total;
	}
	
	/**
	 * Cria uma representacao em string do cenario no seguinte formato
	 * id - descricao - estado
	 */
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getDescricao() + " - " + this.getEstado();
	}

	//verifications
	private void verificaCenarioAberto() {
		if(estado.getNome().equals("Nao finalizado"))
			throw new UnsupportedOperationException("Cenario ainda esta aberto");
	}

	private void verificaCenarioFechado() {
		if(!estado.getNome().equals("Nao finalizado"))
			throw new UnsupportedOperationException("Cenario ja esta fechado");
	}
	
	private void verificaIdApostaValido(int id) {
		if(id < 1 && id > listaApostas.size()) throw new IllegalArgumentException("Id invalido");
	}
}