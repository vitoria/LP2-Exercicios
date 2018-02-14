package classes;

import uteis.Validacao;

public class CenarioBonus extends Cenario{

	private int bonus; 
	
	public CenarioBonus(int id, String descricao, int bonus) {
		super(id, descricao);
		Validacao.validaInteiroNaoNegativo("Bonus invalido", bonus);
		this.bonus = bonus;
	}

	public int getBonus() {
		return (int) bonus/100;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public int rateioCenario(double taxa) {
		return super.rateioCenario(taxa) + bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " - R$ " + String.format("%1$,.2f", (bonus/100.00));
	}
	
}
