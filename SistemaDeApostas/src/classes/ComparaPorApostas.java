package classes;

import java.util.Comparator;

public class ComparaPorApostas implements Comparator<Cenario> {

	@Override
	public int compare(Cenario arg0, Cenario arg1) {
		if(arg0.getTotalApostas() > arg1.getTotalApostas()) return -1;
		if(arg0.getTotalApostas() < arg1.getTotalApostas()) return 1;
		return 0;
	}

}
