package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Aluno;
/**
 * Testes unitários da classe Aluno
 * @author ruidobranco
 *
 */
class AlunoTest {
	private static final String ERROR_NULL = "Matricula, nome ou curso não pode ser nulo em Aluno.";
	private static final String ERROR_VAZIO = "Matricula, nome ou curso não pode ser vazio em Aluno.";
	private static final String FAIL = "Deveria ter lançado uma exceção.";
	private Aluno aluno;
	
	@BeforeEach
	void setUp() {
		aluno = new Aluno("117110666", "Vitoria H. P. S. Sobrinha", "CC");
	}
	/**
	 * Testes do construtor de Aluno
	 * Testa-se:
	 * 1 - Criar aluno com matricula nula, espera-se exceção
	 * 2 - Criar aluno com nome nulo, espera-se exceção
	 * 3 - Criar aluno com curso nulo, espera-se exceção
	 * 4 - Criar aluno com matricula vazia, espera-se exceção
	 * 5 - Criar aluno com nome vazio, espera-se exceção
	 * 6 - Criar aluno com curso vazio, espera-se exceção
	 * 7 - Criar um curso válido
	 * 8 - Verificar se os dados(matricula, nome e curso) foram setados corretamente
	 */
	@Test
	void testAluno() {
		Aluno a;
		//Testes para quando um dos parâmetros é null
		try {
			a = new Aluno(null, "Vitoria", "CC");
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			a = new Aluno("117110666", null, "CC");
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			a = new Aluno("117110666", "Vitoria", null);
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		//Testes para quando um dos parâmetros é vazio
		try {
			a = new Aluno("  ", "Vitoria", "CC");
			fail(FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			a = new Aluno("117110666", "", "CC");
			fail(FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			a = new Aluno("117110666", "Vitoria", " ");
			fail(FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		a = new Aluno("117110666", "Vitoria", "CC");
		assertEquals("117110666", a.getMatricula());
		assertEquals("Vitoria", a.getNome());
		assertEquals("CC", a.getCurso());
	}
	/**
	 * Testes do método toString de Aluno
	 * Testa-se:
	 * 1 - Verifica se o toString está representando corretamente o objeto
	 */
	@Test
	void testToString() {
		assertEquals("117110666 - Vitoria H. P. S. Sobrinha - CC", aluno.toString());
	}

}
