/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisa;

import java.util.Scanner;

/**
 *
 * @author ruidobranco
 */
public class CoisaMenu {
    
    private final static String INVALIDA = "Opcao invalida!";
    
    public static void main(String[] args){

        final String MENU_PRINCIPAL = "\n------- BEM VINDO(A) AO COISA -------\n"
                                        + "1- Contas Laboratório\n"
                                        + "2- Contas Cantina\n"
                                        + "3- Disciplinas\n"
                                        + "4- Saúde\n"
                                        + "5- Sair\n"
                                        + "Dgite a Opcao Desejada: ";
        final int MENU_LABORATORIOS = 1;
        final int MENU_CANTINAS = 2;
        final int MENU_DISCIPLINAS = 3;
        final int MENU_SAUDE = 4;
        final int SAIR = 5;
        
        Aluno aluno = new Aluno();
        Scanner sc = new Scanner(System.in);
        int opc;
        
        do {
            opc = leInt(MENU_PRINCIPAL, sc);
            switch(opc){
                case MENU_LABORATORIOS:
                    menuContasLaboratorios(aluno, sc);
                    break;
                case MENU_CANTINAS:
                    menuContasCantinas(aluno, sc);
                    break;
                case MENU_DISCIPLINAS:
                    menuDisciplinas(aluno, sc);
                    break;
                case MENU_SAUDE:
                    menuSaude(aluno, sc);
                    break;
                case SAIR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(opc != SAIR);
    }
    
    private static void menuContasLaboratorios(Aluno aluno, Scanner sc){
        
        final String menu = "\n------- MENU DAS CONTAS DE LABORATORIO -------\n"
                            + "1- Cadastrar Laboratorio\n"
                            + "2- Explorar i-esimo Laboratorio\n"
                            + "3- Voltar\n"
                            + "Digite a Opcao Desejada: ";
        final int CADASTRAR = 1;
        final int EXPLORAR = 2;
        final int VOLTAR = 3;
        int op;
        
        do {
            op = leInt(menu, sc);
            switch(op){
                case CADASTRAR:
                    criaContaLaboratorio(aluno, sc);
                    break;
                case EXPLORAR:
                    exploraContaLaboratorio(aluno, sc);
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(op != VOLTAR);
    }
    
    private static void menuContasCantinas(Aluno a, Scanner sc){
        
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
            opc = leInt(MENU, sc);
            switch(opc){
                case CADASTRAR:
                    criaContaCantina(a, sc);
                    break;
                case EXPLORAR:
                    exploraCantina(a, sc);
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(opc != VOLTAR);
        
    }
    
    private static void menuDisciplinas(Aluno a, Scanner sc){
        
        final String MENU = "\n---------- MENU DAS CONTAS DAS DISCIPLINAS ---------\n"
                            + "1- Cadastrar Disiciplina\n"
                            + "2- Explorar Disciplina\n"
                            + "3- Voltar\n"
                            + "Digita a opcao desejada: ";
        final int CADASTRAR = 1;
        final int EXPLORAR = 2;
        final int VOLTAR = 3;
        int opc;
        
        do {
            opc = leInt(MENU, sc);
            switch(opc){
                case CADASTRAR:
                    cadastraDisciplina(a, sc);
                    break;
                case EXPLORAR:
                    exploraDisciplina(a, sc);
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while(opc != VOLTAR);
        
    }
    
    private static void menuSaude(Aluno aluno, Scanner sc){
        
        final String MENU = "\n------- MENU SAUDE -------\n"
                            + "1- Alterar Saude Mental\n"
                            + "2- Alterar Saude Fisica\n"
                            + "3- Ver Detalhes\n"
                            + "4- Voltar\n"
                            + "Digite a Opcao Desejada: ";
        final int ALTERAR_SAUDE_MENTAL = 1;
        final int ALTERAR_SAUDE_FISICA = 2;
        final int VER_DETALHES = 3;
        final int VOLTAR = 4;
        int op;
        
        do {
            op = leInt(MENU, sc);
            switch(op){
                case ALTERAR_SAUDE_MENTAL:
                    alteraSaudeMental(aluno, sc);
                    break;
                case ALTERAR_SAUDE_FISICA:
                    alteraSaudeFisica(aluno, sc);
                    break;
                case VER_DETALHES:
                    System.out.println("Saude geral: " + aluno.geral());
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(op != VOLTAR);
    }
    
    private static void alteraSaudeMental(Aluno aluno, Scanner sc){
        aluno.defineSaudeMental(leString("Estado (boa/fraca): ", sc));
        aluno.defineSaudeEmoji(leString("Emoji (opcional): ", sc));
    }
    
    private static void alteraSaudeFisica(Aluno aluno, Scanner sc){
        aluno.defineSaudeFisica(leString("Estado (boa/fraca): ", sc));
        aluno.defineSaudeEmoji(leString("Emoji (opcional): ", sc));
    }
        
    private static void criaContaLaboratorio(Aluno aluno, Scanner sc){
        String nome = leString("Nome do Laboratorio: ", sc);
        String cota = leString("Cota de Armazenamento (opcional): ", sc);
        if(cota.equals("")) aluno.cadastraLaboratorio(nome);
        else aluno.cadastraLaboratorio(nome, Integer.parseInt(cota));
    }
    
    private static void criaContaCantina(Aluno aluno, Scanner sc){
        aluno.cadastraCantina(leString("Nome da Cantina: ", sc));
    }
    
    private static void cadastraDisciplina(Aluno aluno, Scanner sc){
        aluno.cadastraDisciplina(leString("Nome da Disciplina: ", sc));
    }
    
    private static void exploraContaLaboratorio(Aluno a, Scanner sc){
        
        String nome = leString("Nome do lab: ", sc);
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
            op = leInt(MENU, sc);
            switch(op){
                case CONSUMIR:
                    a.consomeEspaco(nome, leInt("Espaco: ", sc));
                    break;
                case LIBERAR:
                    a.liberaEspaco(nome, leInt("Espaco ", sc));
                    break;
                case ATINGIU:
                    System.out.println("Atingiu cota:" + a.atingiuCota(nome));
                    break;
                case VERCONTA:
                    System.out.println(a.laboratorioToString(nome));
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(op != VOLTAR);
    }
    
    private static void exploraCantina(Aluno a, Scanner sc){
        
        String nome = leString("Nome da Cantina: ", sc);
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
            op = leInt(MENU, sc);
            switch(op){
                case CADASTRAR:
                    cadastraLanche(a, nome, sc);
                    break;
                case PAGAR:
                    a.pagarConta(nome, leInt("Valor (centavos): ", sc));
                    break;
                case VER:
                    System.out.println(a.cantinaToString(nome));
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(op != VOLTAR);
        
    }
    
    private static void exploraDisciplina(Aluno a, Scanner sc){
        
        String nome = leString("Nome da Disciplina: ", sc);
        final String MENU = "\n------- EXPLORAR DISCIPLINA DE " + nome + " -------\n"
                            + "1- Cadastrar Horas\n"
                            + "2- Cadastrar Nota\n"
                            + "3- Ver Aprovacao\n"
                            + "4- Ver Detalhes\n"
                            + "5- Voltar\n"
                            + "Digite a Opcao Desejada: ";
        final int CADASTRAR_HORAS = 1;
        final int CADASTRAR_NOTA = 2;
        final int APROVACAO = 3;
        final int VER = 4;
        final int VOLTAR = 5;
        int op;
        
        do{
            op = leInt(MENU, sc);
            switch(op){
                case CADASTRAR_HORAS:
                    a.cadastraHoras(nome, leInt("Quantidade de Horas: ", sc));
                    break;
                case CADASTRAR_NOTA:
                    a.cadastraNota(nome, leInt("Estagio: ", sc), leDouble("Nota: ", sc));
                    break;
                case APROVACAO:
                    System.out.println("Aprovado(a): " + a.aprovado(nome));
                    break;
                case VER:
                    System.out.println(a.disciplinaToString(nome));
                    break;
                case VOLTAR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(op != VOLTAR);
        
    }
    
    private static void cadastraLanche(Aluno a, String nome, Scanner sc){
        int qtd = leInt("Quantidade de Itens: ", sc);
        int valor = leInt("Valor Total da Compra (cents): ", sc);
        a.cadastraLanche(nome, qtd, valor);
    }
    
    private static int leInt(String msg, Scanner sc){
        System.out.print(msg);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    private static double leDouble(String msg, Scanner sc){
        System.out.print(msg);
        double num = Double.parseDouble(sc.nextLine());
        return num;
    }
    
    private static String leString(String msg, Scanner sc){
        System.out.print(msg);
        return sc.nextLine();
    }
}