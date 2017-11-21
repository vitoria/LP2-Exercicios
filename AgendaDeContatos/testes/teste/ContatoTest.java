package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Contato;

public class ContatoTest {
	private static final String ERROR_VAZIO = "Nenhum parametro do construtor de Contato pode ser vazio";
	private static final String ERROR_NULL = "Parâmetros do construtor de Contato não podem ser nulos";
	private static final String ERROR_NIVEL_AMIZADE = "Nivel de amizade precisa ser um inteiro no intervalo [1, 5].";
	private static final String MSG_FAIL_ILLEGAL = "Deveria ter lançado uma exceção de IllegalArgumentException";
	private static final String MSG_FAIL_NULL = "Deveria ter lançado uma exceção de NullPointerException";
	private Contato contato1;
	private Contato contato2;
	private Contato contato3;
	/**
	 * Método que cria três contatos um com um telefone, outro com dois e mais um com três.
	 */
	@Before
	public void setUp() {
		contato1 = new Contato("Vitoria", "Heliane", 1,
								"+55", "83", "99169-7808", "CELULAR");
		contato2 = new Contato("Matheus", "Sales", 5, 
								"+55", "83", "3271-3032", "TRABALHO",
								"+55", "83", "99322-2058", "CELULAR");
		contato3 = new Contato("Veronica", "Mainha", 5,
								"+55", "21", "3271-3032", "TRABALHO",
								"+55", "21", "99322-2058", "CELULAR",
								"+55", "21", "11111-1111", "CASA");
	}
	
	@Test
	public void testContato() {
		assertEquals("Vitoria", contato1.getNome());
		assertEquals("Heliane", contato1.getSobrenome());
		assertEquals("- CELULAR : +55 83 99169-7808 -", contato1.listarTelefones());
		assertEquals("Matheus", contato2.getNome());
		assertEquals("Sales", contato2.getSobrenome());
		assertEquals("- CELULAR : +55 83 99322-2058 - TRABALHO : +55 83 3271-3032 -", contato2.listarTelefones());
		assertEquals("Veronica", contato3.getNome());
		assertEquals("Mainha", contato3.getSobrenome());
		assertEquals("- CELULAR : +55 21 99322-2058 - TRABALHO : +55 21 3271-3032 - CASA : +55 21 11111-1111 -", contato3.listarTelefones());
	}
	
	@Test
	public void testContatoComExcecoes() {
		Contato c;
		try {
			c = new Contato(null, "Heliane", 1, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_NULL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", null, 1, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_NULL);
		} catch(NullPointerException e) {
			assertEquals(ERROR_NULL, e.getMessage());
		}
		try {
			c = new Contato("   ", "Heliane", 1, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_ILLEGAL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "        ", 1, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_ILLEGAL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_VAZIO, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "Heliane", 0, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_ILLEGAL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_NIVEL_AMIZADE, e.getMessage());
		}
		try {
			c = new Contato("Vitoria", "Heliane", 6, "+55", "83", "99169-7808", "CELULAR");
			fail(MSG_FAIL_ILLEGAL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERROR_NIVEL_AMIZADE, e.getMessage());
		}
		c = new Contato("Vitoria", "Heliane", 1, "+55", "83", "111111-1111", "CELULAR", "+24", "21", "22222-2222", "CELULAR");
		assertEquals("- CELULAR : +24 21 22222-2222 -", c.listarTelefones());
	}

	@Test
	public void testVerNivelAmizade() {
		assertEquals("distante", contato1.verNivelAmizade());
		contato1.setNivelAmizade(2);
		assertEquals("colega", contato1.verNivelAmizade());
		contato1.setNivelAmizade(3);
		assertEquals("amigo", contato1.verNivelAmizade());
		contato1.setNivelAmizade(4);
		assertEquals("amigão", contato1.verNivelAmizade());
		contato1.setNivelAmizade(5);
		assertEquals("irmão", contato1.verNivelAmizade());
	}

	@Test
	public void testAdicionarTelefone() {
		assertEquals(false, contato2.adicionarTelefone("+55", "83", "1111111", "PESSOAL"));
		assertEquals(false, contato2.adicionarTelefone("+55", "83", "1111111", "   "));
		assertEquals(false, contato2.adicionarTelefone("+55", "83", "1111111", null));
		assertEquals(true, contato2.adicionarTelefone("+55", "83", "1111111", "CELULAR"));
		assertEquals(true, contato2.adicionarTelefone("+55", "83", "1111111", "celular"));
		assertEquals(true, contato2.adicionarTelefone("+55", "83", "1111111", "TRABALHO"));
		assertEquals(true, contato2.adicionarTelefone("+55", "83", "1111111", "CASA"));
	}

	@Test
	public void testToString() {
		assertEquals("Vitoria Heliane - Nivel de amizade: distante - CELULAR : +55 83 99169-7808 -", contato1.toString());
		assertEquals("Matheus Sales - Nivel de amizade: irmão - CELULAR : +55 83 99322-2058 - TRABALHO : +55 83 3271-3032 -", contato2.toString());
		assertEquals("Veronica Mainha - Nivel de amizade: irmão - CELULAR : +55 21 99322-2058 - TRABALHO : +55 21 3271-3032 - CASA : +55 21 11111-1111 -", contato3.toString());
	}

	@Test
	public void testEqualsContato() {
		assertEquals(false, contato1.equals(null));
		assertEquals(false, contato1.equals("Vitoria Heliane"));
		assertEquals(false, contato1.equals(new Contato("Matheus", "Sales", 2, "1", "2", "123456", "TRABALHO")));
		assertEquals(false, contato1.equals(new Contato("Matheus", "Sales", 1, "+55", "83", "99169-7808", "CELULAR")));
		assertEquals(false, contato1.equals(new Contato("Matheus", "Heliane", 1, "+55", "83", "99169-7808", "CELULAR")));
		assertEquals(false, contato1.equals(new Contato("Vitoria", "Sales", 1, "+55", "83", "99169-7808", "CELULAR")));
		assertEquals(true, contato1.equals(new Contato("Vitoria", "Heliane", 1, "+55", "83", "99169-7808", "CELULAR")));
		assertEquals(true, contato1.equals(new Contato("Vitoria", "Heliane", 1, "+55", "83", "99169-7808", "TRABALHO")));
	}

}
