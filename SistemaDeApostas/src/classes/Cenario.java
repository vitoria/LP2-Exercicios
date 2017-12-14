package classes;

public class Cenario {
	private static int id;
	private String descricao;
	private EstadoCenario estado;
	
	public Cenario(String descricao) {
		this.id++;
		this.descricao = descricao;
		estado = EstadoCenario.NAO_FINALIZADO;
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado.getNome();
	}
	
	public void finalizaCenario(boolean estado) {
		this.estado = (estado) ? EstadoCenario.FINALIZADO_OCORREU : EstadoCenario.FINALIZADO_NAO_OCORREU; 
	}

	public String toString() {
		return this.getId() + " - " + this.getDescricao() + " - " + this.getEstado();
	}
}