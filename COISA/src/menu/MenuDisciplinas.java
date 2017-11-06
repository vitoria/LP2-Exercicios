package menu;

import classes.Aluno;
import coisa.Uteis;

public class MenuDisciplinas {
	private Aluno aluno;
	private Uteis uteis;

	public MenuDisciplinas(Aluno aluno) {
		this.aluno = aluno;
		uteis = new Uteis();
	}

	public void display() {

		final String MENU = "\n---------- MENU DAS CONTAS DAS DISCIPLINAS ---------\n" + 
							"1- Cadastrar Disiciplina\n"+
							"2- Explorar Disciplina\n" +
							"3- Voltar\n" + 
							"Digite a opcao desejada: ";
		final int CADASTRAR = 1;
		final int EXPLORAR = 2;
		final int VOLTAR = 3;
		int opc;

		do {
			opc = uteis.leInt(MENU);
			switch (opc) {
			case CADASTRAR:
				cadastraDisciplina();
				break;
			case EXPLORAR:
				exploraDisciplina();
				break;
			case VOLTAR:
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		} while (opc != VOLTAR);

	}

	private void cadastraDisciplina() {
		aluno.cadastraDisciplina(uteis.leString("Nome da Disciplina: "));
	}

	private void exploraDisciplina() {

		String nome = uteis.leString("Nome da Disciplina: ");
		final String MENU = "\n------- EXPLORAR DISCIPLINA DE " + nome + " -------\n" + 
							"1- Cadastrar Horas\n"+
							"2- Cadastrar Nota\n" +
							"3- Ver Aprovacao\n" +
							"4- Ver Detalhes\n" +
							"5- Voltar\n"
							+ "Digite a Opcao Desejada: ";
		final int CADASTRAR_HORAS = 1;
		final int CADASTRAR_NOTA = 2;
		final int APROVACAO = 3;
		final int VER = 4;
		final int VOLTAR = 5;
		int op;

		do {
			op = uteis.leInt(MENU);
			switch (op) {
			case CADASTRAR_HORAS:
				aluno.cadastraHoras(nome, uteis.leInt("Quantidade de Horas: "));
				break;
			case CADASTRAR_NOTA:
				aluno.cadastraNota(nome, uteis.leInt("Estagio: "), uteis.leDouble("Nota: "));
				break;
			case APROVACAO:
				System.out.println("Aprovado(a): " + aluno.aprovado(nome));
				break;
			case VER:
				System.out.println(aluno.disciplinaToString(nome));
				break;
			case VOLTAR:
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		} while (op != VOLTAR);

	}

}
