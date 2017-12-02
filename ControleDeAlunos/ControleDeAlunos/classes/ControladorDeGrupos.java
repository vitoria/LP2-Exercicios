package classes;

import java.util.HashMap;

public class ControladorDeGrupos {
	private HashMap<String, Grupo> mapaNomeGrupos;
	
	public ControladorDeGrupos() {
		this.mapaNomeGrupos = new HashMap<>();
	}
	
	public boolean criaGrupo(String nome) {
		if(!existeGrupo(nome)) {
			Grupo grupo = new Grupo(nome);
			mapaNomeGrupos.put(nome, grupo);
			return true;
		}
		return false;
	}
	
	
	
	private boolean existeGrupo(String nome) {
		return mapaNomeGrupos.containsKey(nome);
	}

}