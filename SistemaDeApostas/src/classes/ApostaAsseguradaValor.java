package classes;

public class ApostaAsseguradaValor extends Aposta{

	private int valorSeguro;
	private int custoSeguro;
	
	public ApostaAsseguradaValor(String nome, int valor, String previsao, int valorSeguro, int custoSeguro) {
		super(nome, valor, previsao);
		this.valorSeguro = valorSeguro;
		this.custoSeguro = custoSeguro;
	}

	public int getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(int valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public int getCustoSeguro() {
		return custoSeguro;
	}

	public void setCustoSeguro(int custoSeguro) {
		this.custoSeguro = custoSeguro;
	}

	@Override
	public String toString() {
		return super.toString() + "ASSEGURADA(VALOR) - R$ " + (valorSeguro/100);
	}
}
