package classes;

/**
 * Representação do registro de saúde de um estudante do curso de CC da UFCG.
 * Este registro contém a situação da saúde mental e física do aluno e também
 * pode conter o estado de espírito atual dele, representado por um emoji.
 *
 * @author Vitoria Heliane
 */
public class Saude {

	private String saudeMental;
	private String saudeFisica;
	private String emoji;

	/**
	 * Constroi um registro da saude do aluno. Todo registro começa com os campos
	 * saude mental e fisica setados com o valor "boa".
	 */
	public Saude() {
		saudeMental = "boa";
		saudeFisica = "boa";
		emoji = "";
	}

	/**
	 * Atualiza o estado de saude mental com o valor recebido e reseta o emoji
	 * 
	 * @param valor
	 *            string que representa o estado atual da saude mental
	 * @returns null
	 */
	public void defineSaudeMental(String valor) {
		saudeMental = valor.toLowerCase();
		emoji = "";
	}

	/**
	 * Atualiza o estado de saude fisica com o valor recebido e reseta o emoji
	 * 
	 * @param valor
	 *            string que representa o estado atual da saude mental
	 * @returns null
	 */
	public void defineSaudeFisica(String valor) {
		saudeFisica = valor.toLowerCase();
		emoji = "";
	}

	/**
	 * Atualiza o emoji que representa o estado de espirito atual
	 * 
	 * @param valor
	 *            string que representa o emoji
	 * @returns null
	 */
	public void definirEmoji(String emoji) {
		this.emoji = emoji;
	}

	/**
	 * Calcula qual o estado geral atual da saude. Se a saude fisica e mental forem
	 * fracas, retorna fraca e o emoji Se a saude mental e fisica forem boas,
	 * retorna boa e o emoji Por fim, se ambas forme diferentes, retorna ok e o
	 * emoji
	 * 
	 * @returns uma string com o estado geral da saude e o emoji
	 */
	public String geral() {
		if (saudeMental.equals("fraca") && saudeFisica.equals("fraca"))
			return "fraca " + emoji;
		if (saudeMental.equals("boa") && saudeFisica.equals("boa"))
			return "boa " + emoji;
		return "ok " + emoji;
	}
}
