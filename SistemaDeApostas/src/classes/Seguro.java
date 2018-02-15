package classes;

/**
 * Esta interface define que um seguro deve conter o metodo de calcular o valor assegurado
 * @author vitoria
 *
 */
public interface Seguro {
	
	/**
	 * Metodo que deve calcula o valor assegurado
	 * @param valorAposta valor da aposta que será usada para fzer o calculo
	 * @return valor assegurado da aposta
	 */
	public int valorAssegurado(int valorAposta);

}
