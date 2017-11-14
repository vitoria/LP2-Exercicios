package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Agenda;

public class AgendaTest {
	private static final String MSG_FAIL = "Deveria ter lançado uma exceção de IndexOutOfBoundsException";
	private static final String ERROR_POSICAO = "POSIÇÃO INVÁLIDA!\n";
	private Agenda agenda;
	
	@Before
	public void setUp() {
		agenda = new Agenda();
	}

	@Test
	public void testAgenda() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastrarContato() {
		try {
			agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 0);
			fail(MSG_FAIL);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR_POSICAO, e.getMessage());
		}
		try {
			agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 101);
			fail(MSG_FAIL);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR_POSICAO, e.getMessage());
		}
		agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 1);
		assertEquals("Vitoria Heliane - 83991697808", agenda.contatoToString(1));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testContatoToString() {
		fail("Not yet implemented");
	}

}
