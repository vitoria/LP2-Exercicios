package classes;

import java.util.Comparator;

public class ComparaPorNome implements Comparator<Cenario> {

	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		if(arg0.getDescricao().compareTo(arg1.getDescricao()) == 0){
			if(arg0.getDescricao().length() <= arg1.getDescricao().length()) return -1;
			return 1;
		}
		return arg0.getDescricao().compareTo(arg1.getDescricao());
	}

}
