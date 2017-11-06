package utils;

import java.util.Scanner;

/**
 * Classe que trabalha com a leitura de dados inteiros, reais e texto.
 *
 * @author Vitória Heliane
 */
public class LeituraDeDados {
	private Scanner sc;
	/**
	 * Constroi um objeto que manipulada as mensagens impressas no terminal
	 * e as informacoes lidas a partir da entrada padrao, o teclaod. Ao inicializar o objeto,
	 * o atributo scanner tambem eh inicializado
	 */
	public LeituraDeDados() {
		sc = new Scanner(System.in);
	}
	/**
	 * Imprime a mensagem recebida por parametro e le um numero inteiro recebido
	 * pela entrada padrao, o teclado.
	 * 
	 * @param msg
	 *            - uma string que representa mensagem que sera impressa no terminal
	 * @returns um numero inteiro lido do teclado
	 */
    public int leInt(String msg){
        System.out.print(msg);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
	/**
	 * Imprime a mensagem recebida por parametro e le um numero real recebido
	 * pela entrada padrao, o teclado.
	 * 
	 * @param msg
	 *            - uma string que representa mensagem que sera impressa no terminal
	 * @returns um numero real lido do teclado
	 */
    public double leDouble(String msg){
        System.out.print(msg);
        double num = Double.parseDouble(sc.nextLine());
        return num;
    }
	/**
	 * Imprime a mensagem recebida por parametro e ler uma linha de texto recebida
	 * pela entrada padrao, o teclado.
	 * 
	 * @param msg
	 *            - uma string que representa mensagem que sera impressa no terminal
	 * @returns uma string lida do teclado
	 */
    public String leString(String msg){
        System.out.print(msg);
        return sc.nextLine();
    }
	
}
