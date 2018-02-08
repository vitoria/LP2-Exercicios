package classes;

/**
 * Classe que representa uma aposta
 * que contém o nome do apostador, o valor apostado e a previsão
 * 
 * @author Vitória Heliane
 *
 */
public class Aposta {
	private String nome;
	private int valor;
	private String previsao;


	/**
	 * Cria uma nova aposta a partir do nome, valor e previsao recebidos
	 * 
	 * @param nome - nome do apostador
	 * @param valor - valor apostado em centavos
	 * @param previsao - previsao do que ira acontecer
	 */
	public Aposta(String nome, int valor, String previsao) {
		verificaParametros(nome, valor, previsao);
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
	}

	/**
	 * Valida os parâmetros do contrutor, verifica-se:
	 * nome e previsao sao diferentes de vazio e nulo, se verdade, lança exceção
	 * valor menor que um, se verdade, lanca exceção
	 * 
	 * @param nome - nome do apostador
	 * @param valor - valor apostado
	 * @param previsao - previsao do que acontecera
	 */
	private void verificaParametros(String nome, double valor, String previsao) {
		if(nome == null) throw new NullPointerException("Apostador nao pode ser vazio ou nulo");
		if(nome.trim().equals("")) throw new IllegalArgumentException("Apostador nao pode ser vazio ou nulo");
		if(previsao == null) throw new NullPointerException("Previsao nao pode ser vazia ou nula");
		if(previsao.trim().equals("")) throw new IllegalArgumentException("Previsao nao pode ser vazia ou nula");
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) throw new IllegalArgumentException("Previsao invalida");
		if(valor < 1) throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero");
	}

	/**
	 * Acessador do nome
	 * 
	 * @return String que representa o nome do apostador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Acessador do valor apostado
	 * 
	 * @return double representando o valor apostado
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Acessador da previsao
	 * 
	 * @return Stirng representaod a previsao
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * Criia uma representação em stringo da aposta no seguinte formato:
	 * nome - R$valor - previsao
	 */
	@Override
	public String toString() {
		return this.getNome() + " - R$" + this.getValor()/100 + " - " + this.getPrevisao();
	}

	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	
}