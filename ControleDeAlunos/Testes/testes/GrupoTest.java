package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
import classes.Grupo;
/**
 * Testes unitários da classe Grupo
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
class GrupoTest {
	private static final String ERROR_NULL = "Nome do grupo não pode ser nulo.";
	private static final String ERROR_VAZIO = "Nome do grupo não pode ser vazio.";
	private static final String FAIL = "Deveria ter lançado uma exceção.";
	private Grupo grupo;
	
	@BeforeEach
	void setUp(){
		grupo = new Grupo("Embedded");
	}
	/**
	 * Testes do construtor de Grupo
	 * Testa-se:
	 * 1 - Criar um grupo com nome nulo, espera-se exceção
	 * 2 - Criar um grupo com nome vazio, espera-se exceção
	 * 3 - Criar um grupo válido
	 * 4 - Verificar se os atributos (nome e conjunto de alunos) foram
	 * inicializaddos corretamente (nome = Embedded e qtd_alunos = 0)
	 */
	@Test
	void testGrupo() {
		Grupo g;
		try {
			g = new Grupo(null);
			fail(FAIL);
		} catch (NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			g = new Grupo("    ");
			fail(FAIL);
		} catch (IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		g = new Grupo("Embedded");
		assertEquals("Embedded", g.getNome());
		assertEquals(0, g.getQtdAlunos());
	}
	/**
	 * Testes do método de adiconar aluno ao grupo
	 * Testa-se:
	 * 1 - Adicionar um aluno nulo, espera-se exceção
	 * 2 - Verifica se a quanridade de alunos no grupo é zero
	 * 3 - Adicioanr um aluno válido, espera-se true
	 * 4 - Verifica se a quantidade de alunos é igual a um
	 * 5 - Adicionar outro aluno com a mesma matŕicula, espera-se false
	 * 6 - Verifica se a quanridade de alunos continua 1
	 */
	@Test
	void testAdicionaAluno() {
		try {
			grupo.adicionaAluno(null);
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		assertEquals(0, grupo.getQtdAlunos());
		assertEquals(true, grupo.adicionaAluno(new Aluno("1", "Vitoria", "CC")));
		assertEquals(1, grupo.getQtdAlunos());
		assertEquals(false, grupo.adicionaAluno(new Aluno("1", "Matheus", "EM")));
		assertEquals(1, grupo.getQtdAlunos());
	}
	/**
	 * Testes do método toString
	 * Testa-se:
	 * 1 - para um grupo sem alunos
	 * 2 - para um grupo com um aluno addicionado
	 */
	@Test
	void testToString() {
		assertEquals("Alunos do grupo Embedded:\n", grupo.toString());
		grupo.adicionaAluno(new Aluno("1", "Vitoria", "CC"));
		assertEquals("Alunos do grupo Embedded:\n* 1 - Vitoria - CC\n", grupo.toString());
	}

}
