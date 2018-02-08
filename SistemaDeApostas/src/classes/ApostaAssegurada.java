package classes;

public class ApostaAssegurada extends Aposta {

	private Seguro seguro;
	
	public ApostaAssegurada(String nome, int valor, String previsao, int custoSeguro, double taxaSeguro) {
		super(nome, valor, previsao);
		this.seguro = new SeguroTaxa(custoSeguro, taxaSeguro);
	}
	
	public ApostaAssegurada(String nome, int valor, String previsao, int custoSeguro, int valorSeguro) {
		super(nome, valor, previsao);
		this.seguro = new SeguroValor(custoSeguro, valorSeguro);
	}

	public void alteraSeguro(int valor) {
		if(!(seguro instanceof SeguroValor)) throw new UnsupportedOperationException("Seguro não é do tipo por valor");
		((SeguroValor) seguro).setValor(valor);
	}
	
	public void alteraSeguro(double taxa) {
		if(!(seguro instanceof SeguroTaxa)) throw new UnsupportedOperationException("Seguro não é do tipo por taxa");
		((SeguroTaxa) seguro).setTaxa(taxa);
	}
	
	@Override
	public String toString() {
		return super.toString() + "ASSEGURADA " + seguro.toString();
	}
	
}