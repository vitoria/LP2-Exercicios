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
	
	private int id;
	private String descricao;
	private EstadoCenario estado;
	private ArrayList<Aposta> listaApostas;

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
	
	public int cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		verificaCenarioFechado();
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		listaApostas.add(aposta);
		return listaApostas.size();
	}
	
	/**
	 * Cria uma nova aposta assegurada por valor de acordo com os parametros recebidos e adiciona na lsita de apostas
	 * 
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado (em cnetavos)
	 * @param previsao - previsao (vai acontecer ou nao)
	 * @param valorSeguro - valor do seguro da aposta
	 */
	
	public int cadastraAposta(String nomeApostador, int valorAposta, String previsao, int valorSeguro) {
		verificaCenarioFechado();
		Aposta aposta = new ApostaAssegurada(nomeApostador, valorAposta, previsao, valorSeguro);
		listaApostas.add(aposta);
		return listaApostas.size();
	}
	
	/**
	 * Cria uma nova aposta assegurada por taxa de acordo com os parametros recebidos e adiciona na lsita de apostas
	 * 
	 * @param nomeApostador - nome do apostador
	 * @param valorAposta - valor apostado (em cnetavos)
	 * @param previsao - previsao (vai acontecer ou nao)
	 * @param taxaSeguro - valor da taxa do seguro da aposta
	 */
	public int cadastraAposta(String nomeApostador, int valorAposta, String previsao, double taxaSeguro) {
		verificaCenarioFechado();
		Aposta aposta = new ApostaAssegurada(nomeApostador, valorAposta, previsao, taxaSeguro);
		listaApostas.add(aposta);
		return listaApostas.size();
	}

	/**
	 * Altera o seguro da aposta para um seguro por valor de acordo com o valor recebido
	 * caso a aposta seja do tipo assegurada
	 * @param idAposta id da aposta
	 * @param valor valor do novo seguro
	 * @return id da aposta
	 */
	public int alteraSeguroValor(int idAposta, int valor) {
		verificaCenarioFechado();
		verificaIdApostaValida(idAposta);
		
		Aposta aposta = listaApostas.get(idAposta - 1);
		
		verificaApostaAssegurada(aposta);
		
		((ApostaAssegurada) aposta).alteraSeguro(valor);
		
		return idAposta;
	}
	
	/**
	 * Altera o seguro da aposta para um seguro por taxa de acordo com a taxa recebida
	 * caso a aposta seja do tipo assegurada
	 * @param idAposta id da aposta
	 * @param taxa taxa do novo seguro
	 * @return id da aposta
	 */
	public int alteraSeguroTaxa(int idAposta, double taxa) {
		verificaCenarioFechado();
		verificaIdApostaValida(idAposta);
		
		Aposta aposta = listaApostas.get(idAposta - 1);
		
		verificaApostaAssegurada(aposta);
		
		((ApostaAssegurada) aposta).alteraSeguro(taxa);
		
		return idAposta;
	}
	
	/**
	 * Calcula o somatorio do valor de todas apostas do cenario
	 * 
	 * @return inteiro representando o somatorio
	 */
	
	public int valorTotalDasApostas() {
		int total = 0;
		for(Aposta a : listaApostas) total += a.getValor();
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
		String listagemDasApostas = "";
		for(Aposta aposta : listaApostas) listagemDasApostas += aposta.toString() + "\n";
		return listagemDasApostas;
	}

	/**
	 * Calcula o somatorio do valor de todas as apostas perdedoras
	 * (cuja previsao e diferente do estado do cenario apos finalizado)
	 * 
	 * @return inteiro que representa o somatorio
	 */
	
	public int valorTotalDasApostasPerdedoras() {
		verificaCenarioAberto();
		int total = 0;
		
		for(Aposta a : listaApostas) {
			if(a.getPrevisao().equals("VAI ACONTECER") && estado.getNome().equals("Finalizado (n ocorreu)") ||
					a.getPrevisao().equals("N VAI ACONTECER") && estado.getNome().equals("Finalizado (ocorreu)"))
				total += a.getValor();
		}
		return total;
	}
	
	public int calculaLucro(double taxa) {
		return (int) Math.floor(valorTotalDasApostasPerdedoras() * taxa);
	}
	
	/**
	 * Retorna o valor (em centavos) que será destinado ao rateio entre os vencedores do Cenario.  
	 * 
	 * @param taxa A taxa de lucro informada pelo Sistema que contém o Cenario.
	 * 
	 * @return O valor (em centavos) que será destinado ao rateio entre os vencedores.
	 * 
	 */
	public int rateioCenario(double taxa) {
		return valorTotalDasApostasPerdedoras() - calculaLucro(taxa);
	}
	
	/**
	 * Retorna o valor (em centavos) correspondente ao lucro gerado a partir das Apostas perdedoras
	 * registradas no Cenario.  
	 * 
	 * @param taxa A taxa de lucro informada pelo Sistema que contém o Cenario.
	 * 
	 * @return O valor (em centavos) de lucro gerado pelo Cenario.
	 * 
	 */
	public int lucroCenario(double taxa) {
		return (int) Math.floor(valorTotalDasApostasPerdedoras() * taxa);
	}
	
	/**
	 * Retorna o custo total gerado pelo pagamento dos Seguros das ApostasAsseguradas perdedoras ca-
	 * dastradas no Cenario. Caso esse método seja executado por um Cenario ainda aberto, uma exce-
	 * ção adequada é lançada.
	 * 
	 * @return O valor total (em centavos) que será pago devido aos Seguros no Cenario.
	 * 
	 */
	public int pagamentoSeguros() {
		if (this.estado.equals(EstadoCenario.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		
		int perdas = 0;
		for (Aposta aposta : listaApostas) {
			if (aposta.getPrevisao().equals("VAI ACONTECER") && estado.getNome().equals("Finalizado (n ocorreu)") ||
					aposta.getPrevisao().equals("N VAI ACONTECER") && estado.getNome().equals("Finalizado (ocorreu)")) {
					perdas += aposta.perdaGerada();
			}
		}
		
		return valorTotalDasApostasPerdedoras() - perdas;
		
	}
	
	/**
	 * Cria uma representacao em string do cenario no seguinte formato
	 * id - descricao - estado
	 */
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getDescricao() + " - " + this.getEstado();
	}

	/**
	 * Verifica se o cenario está aberto e lança uma exceção se for verdade
	 */
	private void verificaCenarioAberto() {
		if(estado.getNome().equals("Nao finalizado"))
			throw new UnsupportedOperationException("Cenario ainda esta aberto");
	}

	/**
	 * Verifica se o cenario está fechado e lança uma exceção se for verdade
	 */
	private void verificaCenarioFechado() {
		if(!estado.getNome().equals("Nao finalizado"))
			throw new UnsupportedOperationException("Cenario ja esta fechado");
	}
	
	/**
	 * Verifica se o id recebido para consulta de alguma aposta é valido, 
	 * senao lança uma exceção
	 * @param id id da aposta
	 */
	private void verificaIdApostaValida(int id) {
		if(id < 1 && id > listaApostas.size()) throw new IllegalArgumentException("Id invalido");
	}
	
	/**
	 * Verifica se a aposta recebida é do tipo ApostaAssegurada
	 * Senão lança uma exceção
	 * @param aposta aposta a ser verificada
	 */
	private void verificaApostaAssegurada(Aposta aposta) {
		if(!(aposta instanceof ApostaAssegurada)) throw new IllegalArgumentException("ESSA APOSTA NÃO POSSUI SEGURO!");
	}
	
}