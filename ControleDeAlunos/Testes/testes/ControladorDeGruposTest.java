package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDeAlunos;
import controladores.ControladorDeGrupos;

class ControladorDeGruposTest {
	private static final String FAIL = "Deveria ter lançado uma exceção.";
	private static final int ALOCA_SUCESSO = 1;
	private static final int ALOCA_ALUNO_NAO_EXISTE = 0;
	private static final int ALOCA_GRUPO_NAO_EXISTE = -1;
	private static final int ALOCA_ALUNO_GRUPO_NAO_EXISTEM = -2;
	private ControladorDeGrupos cg;
	
	@BeforeEach
	void setUp() {
		cg = new ControladorDeGrupos();
	}
	/**
	 * Testes do método que cria um novo grupo
	 * Testa-se:
	 * 1 - Adicionar um grupo com nome nulo, espera-se exceção
	 * 2 - Verificar se a quantidade de grupos adicionados é zero
	 * 3 - Adicionar um grupo com nome válido
	 * 4 - Verificar se a quantidade de grupos adicionaos é um
	 * 5 - Adicionar um grupo com o mesmo nome
	 * 6 - Verificar se a qtd de grupos add é um
	 * 7 - Adicionar um grupo com o mesmo nome em minusculo
	 * 8 - Verificar se a qtd de grupos add é um
	 * 9 - Adicionar um grupo com mesmo nome em maiusculo
	 * 10 - Verificar se a qtd de grupos add é um
	 * 11 - Adicionar um grupo com nome diferente
	 * 12 - Verificar se a qtd de grupos add é 2
	 */
	@Test
	void testCriaGrupo() {
		try {
			cg.criaGrupo(null);
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		assertEquals(0, cg.getQtdGrupos());
		assertEquals(true, cg.criaGrupo("Embedded"));
		assertEquals(1, cg.getQtdGrupos());
		assertEquals(false, cg.criaGrupo("Embedded"));
		assertEquals(1, cg.getQtdGrupos());
		assertEquals(false, cg.criaGrupo("embedded"));
		assertEquals(1, cg.getQtdGrupos());
		assertEquals(false, cg.criaGrupo("EMBEDDED"));
		assertEquals(1, cg.getQtdGrupos());
		assertEquals(true, cg.criaGrupo("SPLab"));
		assertEquals(2, cg.getQtdGrupos());
	}
	/**
	 * testes do método de alocar alunos em grupos
	 * Testa-se:
	 * 1 - Alocar aluno passando um controlador de alunos nulo, espera-se exceção
	 * 2 - Alocar aluno passando um nome de grupo nulo, espera-se exceção
	 * 3 - Alocar aluno passando nome de grupo e matricula do aluno não cadastrados
	 * 4 - Alocar aluno passando nome de grupo cadastrado e mat de aluno não cadastrada
	 * 5 - Alocar aluno passando nome de grupo e mat de aluno cadastrados
	 * 6 - Alocar aluno passando nome de grupo não cadastrado e mat de aluno cadastrado
	 */
	@Test
	void testAlocaAluno() {
		ControladorDeAlunos ca = new ControladorDeAlunos();
		try {
			cg.alocaAluno("Embedded", "1", null);
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		try {
			cg.alocaAluno(null, "1", ca);
			fail(FAIL);
		} catch(NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		assertEquals(ALOCA_ALUNO_GRUPO_NAO_EXISTEM, cg.alocaAluno("Embedded", "1", ca));
		cg.criaGrupo("Embedded");
		assertEquals(ALOCA_ALUNO_NAO_EXISTE, cg.alocaAluno("Embedded", "1", ca));
		ca.cadastraAluno("1", "Vitoria", "CC");
		assertEquals(ALOCA_SUCESSO, cg.alocaAluno("embedded", "1", ca));
		assertEquals(ALOCA_GRUPO_NAO_EXISTE, cg.alocaAluno("SPLab", "1", ca));
	}
	/**
	 * Testes do método de listar grupo
	 * Testa-se:
	 * 1 - Listar um grupo passando um nome nulo, espera-se exceção
	 * 2 - Listar um grupo não cadastrado
	 * 3 - Listar um grupo cadastrado, mas sem alunos alocados
	 * 4 - Listar um grupo cadastrado e com alunos alocados
	 */
	@Test
	void testListaGrupo() {
		ControladorDeAlunos ca = new ControladorDeAlunos();
		ca.cadastraAluno("1", "Vitoria", "CC");
		try {
			cg.listaGrupo(null);
		} catch(NullPointerException e) {
			assertEquals(null, e.getMessage());
		}
		assertEquals(null, cg.listaGrupo("Embedded"));
		cg.criaGrupo("Embedded");
		assertEquals("Alunos do grupo Embedded:\n", cg.listaGrupo("Embedded"));
		cg.alocaAluno("Embedded", "1", ca);
		assertEquals("Alunos do grupo Embedded:\n* 1 - Vitoria - CC\n", cg.listaGrupo("Embedded"));
	}

}
