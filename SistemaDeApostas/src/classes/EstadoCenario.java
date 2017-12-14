package classes;

public enum EstadoCenario {
	FINALIZADO_OCORREU("Finalizado (ocorreu)"),
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)"),
	NAO_FINALIZADO("Finalizado");
	
	private String nome;
	
	EstadoCenario(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
