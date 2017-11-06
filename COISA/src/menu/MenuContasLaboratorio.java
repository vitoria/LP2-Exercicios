package menu;

import classes.Aluno;
import coisa.Uteis;

public class MenuContasLaboratorio {
	private Aluno aluno;
	private Uteis uteis;

	public MenuContasLaboratorio(Aluno aluno) {
		this.aluno = aluno;
		uteis = new Uteis();
	}

	public void display() {

		final String menu = "\n------- MENU DAS CONTAS DE LABORATORIO -------\n" +
							"1- Cadastrar Laboratorio\n"+
							"2- Explorar i-esimo Laboratorio\n" +
							"3- Voltar\n" +
							"Digite a Opcao Desejada: ";
		final int CADASTRAR = 1;
		final int EXPLORAR = 2;
		final int VOLTAR = 3;
		int op;

		do {
			op = uteis.leInt(menu);
			switch (op) {
			case CADASTRAR:
				criaContaLaboratorio();
				break;
			case EXPLORAR:
				exploraContaLaboratorio();
				break;
			case VOLTAR:
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		} while (op != VOLTAR);
	}

    private void criaContaLaboratorio(){
        String nome = uteis.leString("Nome do Laboratorio: ");
        String cota = uteis.leString("Cota de Armazenamento (opcional): ");
        if(cota.equals("")) aluno.cadastraLaboratorio(nome);
        else aluno.cadastraLaboratorio(nome, Integer.parseInt(cota));
    }
    
    private void exploraContaLaboratorio(){
        
        String nome = uteis.leString("Nome do lab: ");
        final String MENU = "\n------- EXPLORAR CONTA DO " + nome + " -------\n"
                            + "1- Consumir Espaco\n"
                            + "2- Liberar Espaco\n"
                            + "3- Ver se a Cota foi Atingida\n"
                            + "4- Ver Informacoes\n"
                            + "5- Voltar\n"
                            + "Digite a Opcao Desejada: ";
        final int CONSUMIR = 1;
        final int LIBERAR = 2;
        final int ATINGIU = 3;
        final int VERCONTA = 4;
        final int VOLTAR = 5;
        int op;
        
        do{
            op = uteis.leInt(MENU);
            switch(op){
                case CONSUMIR:
                    aluno.consomeEspaco(nome, uteis.leInt("Espaco: "));
                    break;
                case LIBERAR:
                    aluno.liberaEspaco(nome, uteis.leInt("Espaco "));
                    break;
                case ATINGIU:
                    System.out.println("Atingiu cota:" + aluno.atingiuCota(nome));
                    break;
                case VERCONTA:
                    System.out.println(aluno.laboratorioToString(nome));
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(op != VOLTAR);
    }
}
