package classes;

public abstract class Seguro {
	
	private int custo;
	
	public Seguro(int custo) {
		this.custo = custo;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

}
