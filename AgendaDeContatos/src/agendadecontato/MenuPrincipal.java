package agendadecontato;

import java.util.Scanner;

import classes.Agenda;
import uteis.LeituraDeDados;

public class MenuPrincipal {
	public static void main(String[] args) {
		final String MENU = "(C)adastrar Contato\n"
							+ "(L)istar Contatos\n"
							+ "(E)xibir Contato\n"
							+ "(S)air\n\n"
							+ "Opção> ";
		final char CADASTRAR = 'C';
		final char LISTAR = 'L';
		final char EXIBIR = 'E';
		final char SAIR = 'S';
		char opc;
		Scanner teclado = new Scanner(System.in);
		Agenda agenda = new Agenda();
		do {
			opc = LeituraDeDados.leChar(MENU, teclado);
			switch(opc) {
			case CADASTRAR:
				cadastrarContato(agenda, teclado);
				break;
			case LISTAR:
				listarContatos(agenda);
				break;
			case EXIBIR:
				exibirContato(agenda, teclado);
				break;
			case SAIR:
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		} while(opc != SAIR);
	}
	
	private static void cadastrarContato(Agenda agenda, Scanner teclado) {
		int posicao = LeituraDeDados.leInt("Posição: ", teclado);
		String nome = LeituraDeDados.leString("Nome: ", teclado);
		String sobrenome = LeituraDeDados.leString("Sobrenome: ", teclado);
		int nivel_amizade = LeituraDeDados.leInt("Nivel de amizade:", teclado);
		String telefone_tipo = LeituraDeDados.leString("Telefone(tipo): ", teclado);
		String telefone_codigo = LeituraDeDados.leString("Telefone(codigo): ", teclado);
		String telefone_ddd = LeituraDeDados.leString("Telefone(ddd): ", teclado);
		String telefone_numero = LeituraDeDados.leString("Telefone(numero): ", teclado);
		if(agenda.cadastraContato(nome,  sobrenome, nivel_amizade, telefone_tipo, telefone_codigo, telefone_ddd, telefone_numero, posicao)) {
			System.out.println("CADASTRO REALIZADO!\n");
		} else {
			System.out.println("POSIÇÃO INVÁLIDA!\n");
		}
	}
	
	private static void listarContatos(Agenda agenda) {
		System.out.println(agenda.listaContatos());
	}
	
	private static void exibirContato(Agenda agenda, Scanner teclado) {
		int posicao = LeituraDeDados.leInt("Contato> ", teclado);
		try {
			System.out.println(agenda.pesquisaContato(posicao));
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
