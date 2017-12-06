package controladores;

import java.util.HashMap;

import classes.Aluno;
import classes.Grupo;
/**
 * Classe que realiza gerencia os grupos dos alunos e
 * realiza operações sobre eles
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class ControladorDeGrupos {
	private HashMap<String, Grupo> mapaNomeGrupos;
	/**
	 * Cria um novo controlador de grupos
	 * E iinicializa o mapa que irá armazenar os grupos dos alunos
	 */
	public ControladorDeGrupos() {
		this.mapaNomeGrupos = new HashMap<>();
	}
	/**
	 * Recebe um nome, verifica se existe algum grupo com esse mesmo nome,
	 * Se não cria um novo grupo
	 * @param nome nome do grupo a ser criado
	 * @return boolean indicando se o grupo foi criado ou não
	 */
	public boolean criaGrupo(String nome) {
		if(!existeGrupo(nome)) {
			Grupo grupo = new Grupo(nome);
			mapaNomeGrupos.put(nome.toLowerCase(), grupo);
			return true;
		}
		return false;
	}
	/**
	 * Adiciona um aluno (identificado pela matricula) a um grupo (identificado pelo nome)
	 * se ambos existirem
	 * @param nome nome do grupo
	 * @param matricula matricula do aluno
	 * @param ca controlador de aluno p verificar a existência do aluno
	 * @return boolean indicando se o aluno foi acionado ou não
	 */
	public int alocaAluno(String nome, String matricula, ControladorDeAlunos ca) {
		Aluno aluno = ca.getAluno(matricula);
		if(aluno == null && !existeGrupo(nome)) return -2;
		if(aluno == null) return 0;
		if(!existeGrupo(nome)) return -1;
		mapaNomeGrupos.get(nome.toLowerCase()).adicionaAluno(aluno);
		return 1;
	}
	/**
	 * Cria uma string com a lista da representação de um grupo com o nome recebido
	 * @param nome nome do grupo
	 * @return string com essa representação
	 */
	public String listaGrupo(String nome ) {
		if(!existeGrupo(nome)) return null;
		return mapaNomeGrupos.get(nome.toLowerCase()).toString();
	}
	/**
	 * Recebe o nome de um grupo e verifica se existe algum grupo com esse nome
	 * @param nome nome do grupo
	 * @return boolean indicando se existe esse grupo ou não
	 */
	private boolean existeGrupo(String nome) {
		return mapaNomeGrupos.containsKey(nome.toLowerCase());
	}
	/**
	 * Acessador da quantidade de grupos cadastrados
	 * @return inteiro representando a quantidade de grupos
	 */
	public int getQtdGrupos() { return this.mapaNomeGrupos.size(); }
}