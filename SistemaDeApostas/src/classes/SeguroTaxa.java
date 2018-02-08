package classes;

public class SeguroTaxa extends Seguro {

	private double taxa;
	
	public SeguroTaxa(int custo, double taxa) {
		super(custo);
		this.taxa = taxa;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public String toString() {
		return "(TAXA) - " + taxa + "%";
	}
}