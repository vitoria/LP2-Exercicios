package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import classes.Contato;

public class ContatoTest {
	private Contato contato;
	private static final String ERROR_VAZIO = "Nenhum parametro do construtor de Contato pode ser vazio";
	private static final String ERROR_NULL = "Parâmetros do construtor de Contato não podem ser nulos";
	private static final String MSG_FAIL = "Deveria ter lançado uma exceção de IllegalArgumentException";

	@Before
	public void setUp() throws Exception {
		contato = new Contato("Vitoria", "Heliane", "83991697808");
	}
	
	@Test
	public void testContato( ) {
		assertEquals("Vitoria", contato.getNome());
		assertEquals("Heliane", contato.getSobrenome());
		assertEquals("83991697808", contato.getTelefone());
	}

	@Test
	public void testContatoNull() {
		Contato c;
		//Testes para parâmetros null
		try {
			c = new Contato(null, "Heliane", "83991697808");
			fail(MSG_FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", null, "83991697808");
			fail(MSG_FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "Heliane", null);
			fail(MSG_FAIL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
	}
	
	@Test
	public void testContatoVazio() {
		Contato c;
		//Testes para parâmetros vazios
		try {
			c = new Contato("", "Heliane", "83991697808");
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "", "83991697808");
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "Heliane", "");
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
	}

	@Test
	public void testToString() {
		assertEquals("Vitoria Heliane - 83991697808", contato.toString());
	}
	
	@Test
	public void testEquals() {
		Contato c1 = new Contato("Vitoria", "Heliane", "32713032");
		Contato c2 = new Contato("Matheus", "Sales", "83991697808");
		assertEquals(true, contato.equals(c1));
		assertEquals(false, contato.equals(c2));
	}
}