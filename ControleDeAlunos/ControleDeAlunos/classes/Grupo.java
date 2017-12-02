package classes;

import java.util.ArrayList;

public class Grupo {
	private String nome;
	private ArrayList<Aluno> alunos;
	
	public Grupo(String nome) {
		this.nome = nome;
		alunos = new ArrayList<>();
	}
	
	public void adicionaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
}
