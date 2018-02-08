package classes;

public class SeguroValor extends Seguro{
	private int valor;

	public SeguroValor(int custo, int valor) {
		super(custo);
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "(VALOR) - R$ " + valor;
	}
}
