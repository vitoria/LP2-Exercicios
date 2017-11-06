package menu;

import classes.Aluno;
import utils.LeituraDeDados;

public class MenuSaude {
	private Aluno aluno;
	private LeituraDeDados leituraDeDados;

	public MenuSaude(Aluno aluno) {
		this.aluno = aluno;
		leituraDeDados = new LeituraDeDados();
	}
	/**
	 * Exibe o menu com as operacoes que podem ser realizadas com a saude do aluno
	 * Le a opcao desejada por ela e, a partir disso, executa a funcao escolhida
	 * 
	 * @returns null
	 */
	public void display() {

		final String MENU = "\n------- MENU SAUDE -------\n" +
							"1- Alterar Saude Mental\n" +
							"2- Alterar Saude Fisica\n"+
							"3- Ver Detalhes\n" +
							"4- Voltar\n" +
							"Digite a Opcao Desejada: ";
		final int ALTERAR_SAUDE_MENTAL = 1;
		final int ALTERAR_SAUDE_FISICA = 2;
		final int VER_DETALHES = 3;
		final int VOLTAR = 4;
		int op;

		do {
			op = leituraDeDados.leInt(MENU);
			switch (op) {
			case ALTERAR_SAUDE_MENTAL:
				alteraSaudeMental();
				break;
			case ALTERAR_SAUDE_FISICA:
				alteraSaudeFisica();
				break;
			case VER_DETALHES:
				System.out.println("Saude geral: " + aluno.geral());
				break;
			case VOLTAR:
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		} while (op != VOLTAR);
	}

	private void alteraSaudeMental() {
		aluno.defineSaudeMental(leituraDeDados.leString("Estado (boa/fraca): "));
		aluno.defineSaudeEmoji(leituraDeDados.leString("Emoji (opcional): "));
	}

	private void alteraSaudeFisica() {
		aluno.defineSaudeFisica(leituraDeDados.leString("Estado (boa/fraca): "));
		aluno.defineSaudeEmoji(leituraDeDados.leString("Emoji (opcional): "));
	}
}
