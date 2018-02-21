package classes;

import java.util.Comparator;

/**
 * Esta classe implementa o comparador de Cenario
 * para comparar ele pela quantidade de apostas cadastradas
 * @author vitoria
 *
 */
public class ComparaPorApostas implements Comparator<Cenario> {

	/**
	 * Compara os cenarios pela quantidade de apostas cadastradas neles
	 */
	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		if(arg0.getTotalApostas() > arg1.getTotalApostas()) return -1;
		if(arg0.getTotalApostas() < arg1.getTotalApostas()) return 1;
		return 0;
	}

}
