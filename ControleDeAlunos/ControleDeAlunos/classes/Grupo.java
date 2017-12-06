package classes;

import java.util.HashMap;
/**
 * Classe que representa um grupo de alunos
 * quw possui um nome e uma lista de alunos cadastrados nele
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class Grupo {
	private String nome;
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	/**
	 * Cria um novo grupo a partir do nome
	 * e também cria um HashMap de alunos
	 * @param nome nome do grupo
	 */
	public Grupo(String nome) {
		verificaParametro(nome);
		this.nome = nome;
		mapaMatriculaAlunos = new HashMap<String, Aluno>();
	}
	/**
	 * Verifica se o nome do grupo é nulo ou vazio,
	 * se for, lança uma exceção
	 * @param nome nome do grupo
	 */
	private void verificaParametro(String nome) {
		if(nome == null)
			throw new NullPointerException("Nome do grupo não pode ser nulo.");
		if(nome.trim().equals(""))
			throw new IllegalArgumentException("Nome do grupo não pode ser vazio.");
	}
	/**
	 * Se veirifica se o aluno ainda não foi cadastrado e o adiciona,
	 * caso contrário não adiciona
	 * @param aluno aluno que será adicionado no grupo
	 * @return boolean indicando se o aluno foi adicionado ou não
	 */ 
	public boolean adicionaAluno(Aluno aluno) {
		if(aluno == null) throw new NullPointerException();
		if(!existeAluno(aluno.getMatricula())) {
			mapaMatriculaAlunos.put(aluno.getMatricula(), aluno);
			return true;
		} else return false;
	}
	/**
	 * Verifica se algum aluno que a matrícula recebida está cadastrado no grupo
	 * @param matricula matricula do aluno
	 * @return boolean indicando se existe algum aluno que essa matricula
	 */
	private boolean existeAluno(String matricula) {
		return mapaMatriculaAlunos.containsKey(matricula);
	}
	/**
	 * Acessador do nome
	 * @return nome do grupo
	 */
	public String getNome() { return this.nome; }
	/**
	 * Acessador da quantidade de alunos cadastrados no grupo
	 * @return quantidade de alunos cadastrados
	 */
	public int getQtdAlunos() { return this.mapaMatriculaAlunos.size(); }
	/**
	 * Cria uma string com uma representação do estado do grupo
	 * Com o nome e a lista de todos os alunos cadastrados nele
	 */
	public String toString() {
		String retorno = "Alunos do grupo " + this.getNome() + ":\n";
		for(Aluno aluno : mapaMatriculaAlunos.values()) {
			retorno += "* " + aluno.toString() + "\n";
		}
		return retorno;
	}
}
