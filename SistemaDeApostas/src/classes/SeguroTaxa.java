package classes;

/**
 * Esta classe representa um seguro por taxa
 * @author vitoria
 *
 */
public class SeguroTaxa implements Seguro {

	private double taxa;
	
	/**
	 * Cria um novo seguro de acordo com o valor da taxa recebido
	 * @param taxa taxa do seguro
	 */
	public SeguroTaxa(double taxa) {
		this.taxa = taxa;
	}

	/**
	 * Acessador da taxa do seguro
	 * @return taxa do seguro
	 */
	public double getTaxa() {
		return taxa;
	}

	/**
	 * Alterador da taxa do seguro
	 * @param taxa novo valor da taxa
	 */
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	/**
	 * calcula o valor assegurado a partir do valor da taxa
	 */
	@Override
	public int valorAssegurado(int valorAposta) {
		return (int) (Math.round(valorAposta * taxa));
	}
	
	@Override
	public String toString() {
		return "(TAXA) - " + (int) (taxa * 100) + "%";
	}
	
}