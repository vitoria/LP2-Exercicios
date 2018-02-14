package classes;

public class SeguroValor implements Seguro{
	
	private int valor;

	public SeguroValor(int valor) {
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

	@Override
	public int valorAssegurado(int valorAposta) {
		return valor;
	}
}
