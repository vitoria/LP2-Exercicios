package classes;

import java.util.Comparator;

public class ComparaPorID implements Comparator<Cenario> {

	@Override
	public int compare(Cenario obj1, Cenario obj2) {
		if(obj1.getId() > obj2.getId()) return 1;
		if(obj1.getId() < obj2.getId()) return -1;
		return 0;
	}

}
