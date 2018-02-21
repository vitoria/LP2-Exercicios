package classes;

import java.util.Comparator;

/**
 * Esta classe implementa o Comparator de Cenário
 * para comparar pela descrição dele
 * 
 * @author vitoria
 *
 */
public class ComparaPorNome implements Comparator<Cenario> {

	/**
	 * Compara os cenarios recebidos pela descrição
	 * Caso a descrição seja igual, compara o tamanho da descrição
	 */
	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		if(arg0.getDescricao().compareTo(arg1.getDescricao()) == 0){
			if(arg0.getDescricao().length() <= arg1.getDescricao().length()) return -1;
			return 1;
		}
		return arg0.getDescricao().compareTo(arg1.getDescricao());
	}

}
