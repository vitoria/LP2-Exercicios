package classes;

public class SeguroTaxa implements Seguro {

	private double taxa;
	
	public SeguroTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public String toString() {
		return "(TAXA) - " + (taxa * 100) + "%";
	}

	@Override
	public int valorAssegurado(int valorAposta) {
		return (int) (Math.round(valorAposta * taxa));
	}
}