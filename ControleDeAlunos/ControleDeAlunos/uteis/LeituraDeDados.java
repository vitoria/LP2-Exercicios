package uteis;

import java.util.Scanner;

public class LeituraDeDados {
	
	public static char leChar(String msg, Scanner teclado) {
		System.out.print(msg);
		String leitura = teclado.nextLine();
		validaString(leitura);
		return leitura.charAt(0);
	}
	
	public static String leString(String msg, Scanner teclado) {
		System.out.print(msg);
		String leitura = teclado.nextLine();
		validaString(leitura);
		return leitura;
	}
	
	public static int leInt(String msg, Scanner teclado) {
		System.out.print(msg);
		int num = teclado.nextInt();
		teclado.nextLine();
		return num;
	}
	
	private static void validaString(String frase) {
		if(frase == null) throw new NullPointerException();
		if(frase.trim().equals("")) throw new IllegalArgumentException();
	}
}