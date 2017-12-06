package classes;
/**
 * Classe que representa um aluno com
 * matricula, nome e curso
 * @author Vitória Heliane P. S. Sobrnha
 *
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	/**
	 * Cria um novo aluno a partir da matricula
	 * nome e curso
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		verificaParametros(matricula, nome, curso);
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	/**
	 * Verifica se os parametros do construtor são diferentes de
	 * vazio e null, senão lança uma exceção
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 */
	private void verificaParametros(String matricula, String nome, String curso) {
		if(matricula == null || nome == null || curso == null)
			throw new NullPointerException("Matricula, nome ou curso não pode ser nulo em Aluno.");
		if(matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals(""))
			throw new IllegalArgumentException("Matricula, nome ou curso não pode ser vazio em Aluno.");
	}
	/**
	 * Acessador de matricula
	 * @return matricula do aluno
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * Acessador de nome
	 * @return nome do aluno
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Acessador de curso
	 * @return curso do aluno
	 */
	public String getCurso() {
		return curso;
	}
	/**
	 * Cria uma representação em string do 
	 * estado do objeto
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
}
