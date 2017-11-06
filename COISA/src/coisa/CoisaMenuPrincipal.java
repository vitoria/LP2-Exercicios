/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisa;

import classes.Aluno;
import menu.MenuContasCantina;
import menu.MenuContasLaboratorio;
import menu.MenuDisciplinas;
import menu.MenuSaude;
import utils.LeituraDeDados;

/**
 *
 * @author Vitoria Heliane
 */
public class CoisaMenuPrincipal {
    
    private final static String INVALIDA = "Opcao invalida!";
    
    public static void main(String[] args){

        final String MENU_PRINCIPAL = "\n------- BEM VINDO(A) AO COISA -------\n"
                                        + "1- Contas Laboratório\n"
                                        + "2- Contas Cantina\n"
                                        + "3- Disciplinas\n"
                                        + "4- Saúde\n"
                                        + "5- Sair\n"
                                        + "Digite a Opcao Desejada: ";
        final int MENU_LABORATORIOS = 1;
        final int MENU_CANTINAS = 2;
        final int MENU_DISCIPLINAS = 3;
        final int MENU_SAUDE = 4;
        final int SAIR = 5;
        
        Aluno aluno = new Aluno();
        MenuContasLaboratorio menuContasLab = new MenuContasLaboratorio(aluno);
        MenuContasCantina menuContasCantina = new MenuContasCantina(aluno);
        MenuDisciplinas menuDisciplina = new MenuDisciplinas(aluno);
        MenuSaude menuSaude = new MenuSaude(aluno);
        LeituraDeDados u = new LeituraDeDados();
        int opc;
        
        do {
            opc = u.leInt(MENU_PRINCIPAL);
            switch(opc){
                case MENU_LABORATORIOS:
                    menuContasLab.display();
                    break;
                case MENU_CANTINAS:
                    menuContasCantina.display();
                    break;
                case MENU_DISCIPLINAS:
                    menuDisciplina.display();
                    break;
                case MENU_SAUDE:
                    menuSaude.display();
                    break;
                case SAIR:
                    break;
                default:
                    System.out.println(INVALIDA);
            }
        } while(opc != SAIR);
    }
}