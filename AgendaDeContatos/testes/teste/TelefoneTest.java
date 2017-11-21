/**
 * 
 */
package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Telefone;

/**
 * Testes unitários da classe Telefone
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class TelefoneTest {
	private static final String ERRO_NULL = "Numero ou tipo de Telefone não podem ser nulo.";
	private static final String ERRO_VAZIO = "Numero ou tipo de Telefone não pode ser vazio.";
	private static final String ERRO_TIPO = "Tipo de Telefone precisa ser CELULAR, TRABALHO ou CASA.";
	private Telefone telefone;

	@Before
	public void setUp() {
		telefone = new Telefone("+55", "83", "991697808", "CELULAR");
	}

	/**
	 * Método de teste do construtor de telefone
	 * Testa-se aqui:
	 * 1- Criar um telefone com numero igual a null
	 * 2- Criar um telefone com tipo igual a null
	 * 3- Criar um telefone com numero vazio
	 * 4- Criar um telefone com tipo vazio
	 * 5- Criar um telefone com um tipo diferente dos definidos
	 * 6- Criar um telefone com parâmetor válidos e 
	 * 		verificar se seus atributos foram sertados corretamente
	 */
	@Test
	public void testTelefone() {
		Telefone telefone;
		try {
			telefone = new Telefone("+55", "83", null, "CELULAR");
			fail("Deveria ter lançado NullPointerException!");
		} catch(NullPointerException e) {
			assertEquals(ERRO_NULL, e.getMessage());
		}
		try {
			telefone = new Telefone("+55", "83", "991697808", null);
			fail("Deveria ter lançado NullPointerException!");
		} catch(NullPointerException e) {
			assertEquals(ERRO_NULL, e.getMessage());
		}
		try {
			telefone = new Telefone("+55", "83", "  ", "CASA");
			fail("Deveria ter lançado IllegalArgumentException!");
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_VAZIO, e.getMessage());
		}
		try {
			telefone = new Telefone("+55", "83", "991697808", "   ");
			fail("Deveria ter lançado IllegalArgumentException!");
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_VAZIO, e.getMessage());
		}
		try {
			telefone = new Telefone("+55", "83", "991697808", "EMPRESA");
		} catch (IllegalArgumentException e) {
			assertEquals(ERRO_TIPO, e.getMessage());
		}
		telefone = new Telefone("+55", "83", "991697808", "CELULAR");
		assertEquals("+55", telefone.getCodigo());
		assertEquals("83", telefone.getDdd());
		assertEquals("991697808", telefone.getNumero());
		assertEquals("CELULAR", telefone.getTipo());
	}

	/**
	 * Método de teste do toStirng de Telefone
	 * Testa-se aqui:
	 * 1- Verifica se o toString retorna a representação correta do objeto
	 * 2- Muda o codigo do telefone
	 * 3- Verifica se o toString retorna o valor esperado
	 * 4- Muda o ddd
	 * 5- Verifica se o toString retorna o valor esperado
	 * 6- Muda o numero
	 * 7- Verifica se o toString retorna o valor esperado
	 * 8- Muda o tipo
	 * 9- Verifica se o toString retorna o valor esperado
	 */
	@Test
	public void testToString() {
		assertEquals("CELULAR : +55 83 991697808", telefone.toString());
		telefone.setCodigo("+24");
		assertEquals("CELULAR : +24 83 991697808", telefone.toString());
		telefone.setDdd("84");
		assertEquals("CELULAR : +24 84 991697808", telefone.toString());
		telefone.setNumero("993222058");
		assertEquals("CELULAR : +24 84 993222058", telefone.toString());
		telefone.setTipo("TRABALHO");
		assertEquals("TRABALHO : +24 84 993222058", telefone.toString());
	}

}
