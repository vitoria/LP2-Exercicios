package menu;

import classes.Aluno;
import utils.LeituraDeDados;

public class MenuContasCantina {
	private Aluno aluno;
	private LeituraDeDados leituraDeDados;
	
	public MenuContasCantina(Aluno aluno) {
		this.aluno = aluno;
		leituraDeDados = new LeituraDeDados();
	}
	
    public void display(){
        
        final String MENU = "\n---------- MENU DAS CONTAS DAS CANTINA ---------\n"
                            + "1- Cadastrar Conta\n"
                            + "2- Explorar Conta\n"
                            + "3- Voltar\n"
                            + "Digita a opcao desejada: ";
        final int CADASTRAR = 1;
        final int EXPLORAR = 2;
        final int VOLTAR = 3;
        int opc;
        
        do {
            opc = leituraDeDados.leInt(MENU);
            switch(opc){
                case CADASTRAR:
                    criaContaCantina();
                    break;
                case EXPLORAR:
                    exploraCantina();
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(opc != VOLTAR);
        
    }
    
	
    private void criaContaCantina(){
        aluno.cadastraCantina(leituraDeDados.leString("Nome da Cantina: "));
    }
    
    private void exploraCantina(){
        
        String nome = leituraDeDados.leString("Nome da Cantina: ");
        final String MENU = "\n------- EXPLORAR CONTA DA " + nome + " -------\n"
                            + "1- Cadastrar Lanche\n"
                            + "2- Pagar Conta\n"
                            + "3- Ver Conta\n"
                            + "4- Voltar\n"
                            + "Digite a Opcao Desejada: ";
        final int CADASTRAR = 1;
        final int PAGAR = 2;
        final int VER = 3;
        final int VOLTAR = 4;
        int op;
        
        do{
            op = leituraDeDados.leInt(MENU);
            switch(op){
                case CADASTRAR:
                    cadastraLanche(nome);
                    break;
                case PAGAR:
                    aluno.pagarConta(nome, leituraDeDados.leInt("Valor (centavos): "));
                    break;
                case VER:
                    System.out.println(aluno.cantinaToString(nome));
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(op != VOLTAR);
        
    }
    
    private void cadastraLanche(String nome){
        int qtd = leituraDeDados.leInt("Quantidade de Itens: ");
        int valor = leituraDeDados.leInt("Valor Total da Compra (cents): ");
        aluno.cadastraLanche(nome, qtd, valor);
    }
    
    
}
