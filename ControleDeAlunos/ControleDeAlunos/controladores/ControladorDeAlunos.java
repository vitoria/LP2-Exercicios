package controladores;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Aluno;
/**
 * Classe que realiza operações sobre o cojunto de alunos do controle
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class ControladorDeAlunos {
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	private ArrayList<Aluno> alunosRespondedores;
	/**
	 * Cria um novo controlador de alunos
	 * cada novo controlador possui um mapa de matriculas para alunos
	 * e uma lista de alunos que reponderam as questçoess no quadro
	 */
	public ControladorDeAlunos() {
		mapaMatriculaAlunos = new HashMap<>();
		alunosRespondedores = new ArrayList<>();
	}
	/**
	 * Adiciona um novo aluno no mapa, caso não haja um outro
	 * aluno com a mesma matrícula já cadastrado
	 * @param matricula matricula do aluno (chave do mapa)
	 * @param nome nome do aluno
	 * @param curso curso no qual o aluno esa matriculado
	 * @return boolean que indica se foi adicionado ou não
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if(!existeAluno(matricula)) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.mapaMatriculaAlunos.put(matricula, aluno);
			return true;
		} 
		return false;
	}
	/**
	 * Verifica se existe algum aluno cadastrado com a matricula recebida
	 * se sim, retorna esse aluno
	 * @param matricula matricula do aluno
	 * @return aluno que tem essa matricula
	 */
	public String consultaAluno(String matricula) {
		if(existeAluno(matricula)) {
			return "Aluno: " + getAluno(matricula).toString();
		}
		return null;
	}
	/**
	 * Acessador de um aluno através da matricula
	 * @param matricula matricula do aluno
	 * @return aluno que tenha essa matricula
	 */
	public Aluno getAluno(String matricula) {
		return mapaMatriculaAlunos.get(matricula);
	}
	/**
	 * Verifica se existe algum aluno cadastrado com a matricula
	 * e adiciona ele na lista de alunos que responderam perguntas no quadro
	 * @param matricula matricula do aluno
	 * @return boolean indicando se foi adicionado oou não
	 */
	public boolean CadastraAlunoResponde(String matricula) {
		if(existeAluno(matricula)) {
			alunosRespondedores.add(getAluno(matricula));
			return true;
		}
		return false;
	}
	/**
	 * Cria uma representação em sitrng de todos alunos que responderam
	 * questões no quadro 
	 * @return string com a lista dos alunos
	 */
	public String listaAlunosRespondedores() {
		String resultado = "Alunos:";
		for(int i = 0; i < alunosRespondedores.size(); i ++) {
			resultado += "\n" + (i+1) + ". " + alunosRespondedores.get(i).toString();
		} return resultado;
	}
	/**
	 * Verifica se existe algum aluno cadastrado com a matricula recebida
	 * @param matricula matricula do aluno
	 * @return boolean indicando se existe ou não esse aluno
	 */
	private boolean existeAluno(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}
	/**
	 * Acessador da quantidade de alunos cadastrados
	 * @return int indicando a quantidade desses alunos
	 */
	public int getQtdAlunos() { return this.mapaMatriculaAlunos.size(); }
	/**
	 * Acessador da quantidade de alunos que responderam questões
	 * @return inteiro indicando a quantidades desses alunos
	 */
	public int getQtdAlunosRespondem() { return this.alunosRespondedores.size(); }
}
