package classes;

import java.util.Comparator;

/**
 * Esta classe implementa o Comparator de Cenario 
 * para comparar pelo id do cenario
 * @author vitoria
 *
 */
public class ComparaPorID implements Comparator<Cenario> {

	/**
	 * Compara cenario pelo id
	 */
	@Override
	public int compare(Cenario obj1, Cenario obj2) {
		if(obj1.getId() > obj2.getId()) return 1;
		if(obj1.getId() < obj2.getId()) return -1;
		return 0;
	}

}
