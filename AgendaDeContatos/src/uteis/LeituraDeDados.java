package uteis;

import java.util.Scanner;

public class LeituraDeDados {
	
	public static char leChar(String msg, Scanner teclado) {
		System.out.print(msg);
		return teclado.nextLine().charAt(0);
	}
	
	public static String leString(String msg, Scanner teclado) {
		System.out.print(msg);
		return teclado.nextLine();
	}
	
	public static int leInt(String msg, Scanner teclado) {
		System.out.print(msg);
		while(!teclado.hasNextInt())
			teclado.next();
		int num = teclado.nextInt();
		teclado.nextLine();
		return num;
	}
}
