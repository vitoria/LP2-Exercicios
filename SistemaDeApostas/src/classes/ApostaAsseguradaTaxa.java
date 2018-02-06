package classes;

public class ApostaAsseguradaTaxa extends Aposta {

	private double taxaSeguro;
	private int custoSeguro;
	
	public ApostaAsseguradaTaxa(String nome, int valor, String previsao, double taxaSeguro, int custoSeguro) {
		super(nome, valor, previsao);
		this.taxaSeguro = taxaSeguro;
		this.custoSeguro = custoSeguro;
	}

	public double getTaxaSeguro() {
		return taxaSeguro;
	}

	public void setTaxaSeguro(float taxa) {
		this.taxaSeguro = taxa;
	}

	public int getCustoSeguro() {
		return custoSeguro;
	}

	public void setCustoSeguro(int custoSeguro) {
		this.custoSeguro = custoSeguro;
	}

	public void setTaxaSeguro(double taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}

	@Override
	public String toString() {
		return super.toString() + "ASSEGURADA(TAXA) - " + taxaSeguro + "%";
	}
	
}
