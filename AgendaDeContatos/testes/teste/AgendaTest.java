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
		assertEquals("\nVitoria Heliane - 83991697808\n", agenda.pesquisarContato(1));
	}
	
	@Test
	public void testToString() {
		assertEquals("\n", agenda.toString());
		agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 1);
		assertEquals("\n1 - Vitoria Heliane\n", agenda.toString());
		agenda.cadastrarContato("Matheus", "Sales", "83991697808", 1);
		assertEquals("\n1 - Matheus Sales\n", agenda.toString());
		agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 100);
		assertEquals("\n1 - Matheus Sales\n100 - Vitoria Heliane\n", agenda.toString());
	}

	@Test
	public void testContatoToString() {
		agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 1);
		assertEquals("\nVitoria Heliane - 83991697808\n", agenda.pesquisarContato(1));
		agenda.cadastrarContato("Vitoria", "Heliane", "99999999999", 1);
		assertEquals("\nVitoria Heliane - 99999999999\n", agenda.pesquisarContato(1));
		try {
			agenda.pesquisarContato(2);
			fail(MSG_FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_POSICAO, e.getMessage());
		}
		try {
			agenda.pesquisarContato(0);
			fail(MSG_FAIL);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR_POSICAO, e.getMessage());
		}
		try {
			agenda.pesquisarContato(200);
			fail(MSG_FAIL);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR_POSICAO, e.getMessage());
		}
	}
	
	@Test
	public void testEquals() {
		Agenda a1 = new Agenda();
		assertEquals(true, agenda.equals(a1));
		a1.cadastrarContato("Vitoria", "Heliane", "83991697808", 1);
		assertEquals(false, agenda.equals(a1));
		agenda.cadastrarContato("Vitoria", "Heliane", "83991697808", 1);
		assertEquals(true, agenda.equals(a1));
	}

}
