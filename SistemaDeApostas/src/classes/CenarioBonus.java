package classes;

import uteis.Validacao;

/**
 * Esta classe representa um cenário com bônus que herda de Cenario
 * @author vitoria
 *
 */
public class CenarioBonus extends Cenario{

	private int bonus; 
	
	/**
	 * Cria um novo cenario a partir do id, descrição e valor do bonus
	 * @param id id do cenario
	 * @param descricao descrição do cenario
	 * @param bonus bonus do cenario
	 */
	public CenarioBonus(int id, String descricao, int bonus) {
		super(id, descricao);
		Validacao.validaInteiroPositivo("Bonus invalido", bonus);
		this.bonus = bonus;
	}

	/**
	 * Acessador do bonus
	 * @return bonus do cenario
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * Alterador do bonus
	 * @param bonus novo valor do bonus
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * Este metodo calcula o rateio do cenario adicionando o valor do bonus
	 */
	@Override
	public int rateioCenario(double taxa) {
		return super.rateioCenario(taxa) + bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " - R$ " + String.format("%1$,.2f", (bonus/100.00));
	}
	
}
