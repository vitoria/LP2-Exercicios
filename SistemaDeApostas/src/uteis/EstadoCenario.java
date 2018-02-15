package uteis;

/**
 * Este enum define os estados possíveis de um cenario
 * @author vitoria
 *
 */
public enum EstadoCenario {
	FINALIZADO_OCORREU("Finalizado (ocorreu)"),
	FINALIZADO_NAO_OCORREU("Finalizado (n ocorreu)"),
	NAO_FINALIZADO("Nao finalizado");

	private String nome;

	/**
	 * Cria um novo estado
	 * @param nome estado do estado
	 */
	EstadoCenario(String nome) {
		this.nome = nome;
	}

	/**
	 * Acessador da representação em string do estado
	 * @return estado
	 */
	public String getNome() {
		return this.nome;
	}
}
