package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControladorDeAlunos;

class ControladorDeAlunosTest {
	private ControladorDeAlunos ca;
	
	@BeforeEach
	void setUp() {
		ca = new ControladorDeAlunos();
	}

	@Test
	void testControladorDeAlunos() {
		ControladorDeAlunos c = new ControladorDeAlunos();
		assertEquals(0, c.getQtdAlunos());
		assertEquals(0, c.getQtdAlunosRespondem());
	}

	@Test
	void testCadastraAluno() {
		assertEquals(true, ca.cadastraAluno("1", "Vitoria", "CC"));
		assertEquals(1, ca.getQtdAlunos());
		assertEquals(false, ca.cadastraAluno("1", "Matheus", "EM"));
		assertEquals(1, ca.getQtdAlunos());
		assertEquals(true, ca.cadastraAluno("2", "Matheus", "EM"));
		assertEquals(2, ca.getQtdAlunos());
	}

	@Test
	void testConsultaAluno() {
		assertEquals(null, ca.consultaAluno("11"));
		assertEquals(null, ca.consultaAluno(null));
		assertEquals(null, ca.consultaAluno("  "));
		ca.cadastraAluno("1", "Vitoria", "CC");
		assertEquals("Aluno: 1 - Vitoria - CC", ca.consultaAluno("1"));
	}

	@Test
	void testCadastraAlunoResponde() {
		ca.cadastraAluno("1", "Vitoria", "CC");
		ca.cadastraAluno("2", "Matheus", "EM");
		assertEquals(false, ca.CadastraAlunoResponde(null));
		assertEquals(0, ca.getQtdAlunosRespondem());
		assertEquals(false, ca.CadastraAlunoResponde(""));
		assertEquals(0, ca.getQtdAlunosRespondem());
		assertEquals(false, ca.CadastraAlunoResponde("3"));
		assertEquals(0, ca.getQtdAlunosRespondem());
		assertEquals(true, ca.CadastraAlunoResponde("1"));
		assertEquals(1, ca.getQtdAlunosRespondem());
		assertEquals(true, ca.CadastraAlunoResponde("1"));
		assertEquals(2, ca.getQtdAlunosRespondem());
		assertEquals(true, ca.CadastraAlunoResponde("2"));
		assertEquals(3, ca.getQtdAlunosRespondem());
		
	}

	@Test
	void testListaAlunosRespondedores() {
		assertEquals("Alunos:", ca.listaAlunosRespondedores());
		ca.cadastraAluno("1", "Vitoria", "CC");
		ca.cadastraAluno("2", "Matheus", "EM");
		ca.CadastraAlunoResponde("1");
		ca.CadastraAlunoResponde("1");
		ca.CadastraAlunoResponde("2");
		assertEquals("Alunos:\n1. 1 - Vitoria - CC\n2. 1 - Vitoria - CC\n3. 2 - Matheus - EM", ca.listaAlunosRespondedores());
	}

}
