package classes;

/**
 * 
 * Esta classe representa uma aposta assegura, que contem um tipo de seguro
 * 
 * @author vitoria
 *
 */
public class ApostaAssegurada extends Aposta {

	private Seguro seguro;
	
	/**
	 * Cria uma nova aposta de acordo com o nome do apostador, previsão, valor apostado
	 * e os parametros do seguro por taxa
	 * @param nome nome do apostador
	 * @param valor valor apostado
	 * @param previsao previsão da aposta
	 * @param taxaSeguro taxa do seguro
	 */
	public ApostaAssegurada(String nome, int valor, String previsao, double taxaSeguro) {
		super(nome, valor, previsao);
		this.seguro = new SeguroTaxa(taxaSeguro);
	}
	
	/**
	 * Cria uma nova aposta de acordo com o nome do apostador, previsão, valor apostado e
	 * parametros do seguro por valor
	 * @param nome nomde do apostador
	 * @param valor valor apostado
	 * @param previsao previsão da aposta
	 * @param valorSeguro valor do seguro
	 */
	public ApostaAssegurada(String nome, int valor, String previsao, int valorSeguro) {
		super(nome, valor, previsao);
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	
	public void alteraSeguro(int valorSeguro) {
		seguro = new SeguroValor(valorSeguro);
	}
	
	public void alteraSeguro(double taxaSeguro) {
		seguro = new SeguroTaxa(taxaSeguro);
	}
	
	@Override
	public int getValor() {
		return super.getValor() - this.seguro.valorAssegurado(this.getValor());
	}
	
	@Override
	public String toString() {
		return super.toString() + "ASSEGURADA " + seguro.toString();
	}
	
}