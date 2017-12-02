package classes;

import java.util.ArrayList;
import java.util.Scanner;
import uteis.LeituraDeDados;

public class Menu {
	public static void main(String[] args) {
		final String MENU = "(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Alunos no Grupo e Imprimir Grupos\n"
				+ "(R)egistrar Resposta de Aluno\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)ra, vamos fechar o programa!\n\n"
				+ "Opção> ";
		final char CADASTRAR_ALUNO = 'C';
		final char EXIBIR_ALUNO = 'E';
		final char NOVO_GRUPO = 'N';
		final char ALOCAR_IMPRIMIR_GRUPOS = 'A';
		final char REGISTRAR_REPOSTA = 'R';
		final char IMPRIMIR_RESPONDEDORES = 'I';
		final char SAIR = 'O';
		char opc;
		Scanner teclado = new Scanner(System.in);
		ControladorDeAlunos ca = new ControladorDeAlunos();
		ControladorDeGrupos cg = new ControladorDeGrupos();
		do {
			opc = LeituraDeDados.leChar(MENU, teclado);
			switch(opc) {
			case CADASTRAR_ALUNO:
				cadastrarAluno(ca, teclado);
				break;
			case EXIBIR_ALUNO:
				consultaAluno(ca, teclado);
				break;
			case NOVO_GRUPO:
				criaGrupo(cg, teclado);
				break;
			case ALOCAR_IMPRIMIR_GRUPOS:
				char op = LeituraDeDados.leChar("(A)locar Aluno ou (I)mprimir Grupo? ", teclado);
				if(op == 'A')
				break;
			case REGISTRAR_REPOSTA:
				break;
			case IMPRIMIR_RESPONDEDORES:
				break;
			case SAIR:
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		} while(opc != SAIR);
	}
	
	private static void cadastrarAluno(ControladorDeAlunos ca, Scanner teclado) {
		String matricula = LeituraDeDados.leString("Matrícula: ", teclado);
		String nome = LeituraDeDados.leString("Nome: ", teclado);
		String curso = LeituraDeDados.leString("Curso: ", teclado);
		if(ca.cadastraAluno(matricula, nome, curso)) {
			System.out.println("CADASTRO REALIZADO!");
		} else System.out.println("MATRÍCULA JÁ CADASTRADA!");
	}
	
	private static void consultaAluno(ControladorDeAlunos ca, Scanner teclado) {
		String matricula = LeituraDeDados.leString("Matrícula: ", teclado);
		System.out.println(ca.consultaAluno(matricula));
	}
	
	private static void criaGrupo(ControladorDeGrupos cg, Scanner teclado) {
		String nome = LeituraDeDados.leString("Grupo: ", teclado);
		if(cg.criaGrupo(nome)) {
			System.out.println("CADASTRO REALIZADO!");
		} else System.out.println("GRUPO JÁ CADASTRADO!");
	}
	
	//private static void alocarAlunos()
	
	private static void imprimirGrupos
}
