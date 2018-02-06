package classes;

public class CenarioBonus extends Cenario{

	private float bonus; 
	
	public CenarioBonus(int id, String descricao, float bonus) {
		super(id, descricao);
		this.bonus = bonus;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + bonus;
	}
	
}
