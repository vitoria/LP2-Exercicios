package classes;

import java.util.HashMap;

public class ControladorDeAlunos {
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	
	public ControladorDeAlunos() {
		mapaMatriculaAlunos = new HashMap<>();
	}
	
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if(!existeAluno(matricula)) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			mapaMatriculaAlunos.put(matricula, aluno);
			return true;
		} 
		return false;
	}
	
	public String consultaAluno(String matricula) {
		if(existeAluno(matricula)) {
			return mapaMatriculaAlunos.get(matricula).toString();
		}
		return "Aluno não cadastrado!";
	}
	
	private boolean existeAluno(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}

}
