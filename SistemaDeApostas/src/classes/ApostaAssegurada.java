package classes;

import uteis.Validacao;

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
		
		Validacao.validarPercentage("Taxa assegurada inválida!!", taxaSeguro);
		
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
		
		Validacao.validarLessEqualThan("VALOR ASSEGURADO MUITO ALTO!", valorSeguro,
				super.getValor());
		
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	/**
	 * Este metodo altera o seguro para o tipo de seguro por valor
	 * @param valorSeguro valor do novo seguro
	 */
	public void alteraSeguro(int valorSeguro) {
		seguro = new SeguroValor(valorSeguro);
	}
	
	/**
	 * Este metodo altera o seguro para seguro por taxa
	 * @param taxaSeguro taxa do novo seguro
	 */
	public void alteraSeguro(double taxaSeguro) {
		seguro = new SeguroTaxa(taxaSeguro);
	}
	
	/**
	 * Este metodo calcula a perda gerada no sistema
	 * calculado a partir das apostadas perdedoras
	 */
	@Override
	public int perdaGerada() {
		return super.getValor() - seguro.valorAssegurado(super.getValor());
	}
	
	@Override
	public String toString() {
		return super.toString() + "ASSEGURADA " + seguro.toString();
	}
	
}