/**
 * 
 */
package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Agenda;
import classes.Contato;

/**
 * Classe de testes unitários da classe Agenda
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class AgendaTest {
	private static final String MSG_FAIL_POSITION = "Deveria ter lançado uma exceção de IndexOutOfBoundsException";
	private static final String MSG_FAIL_NULL = "Deveria ter lançado uma exceção de NullPointerException";
	private static final String ERROR = "POSIÇÃO INVÁLIDA!\n";
	private Agenda agenda;

	@Before
	public void setUp(){
		agenda = new Agenda();
	}

	/**
	 * Metodo que testa o cadastro de contato na agenda
	 * Testa-se:
	 * 1- um contato na posicação 0, espera-se um valor false
	 * 2- um contato na posição 101, espera-se um valor false
	 * 3- um contato na posição 1 com um telefone, espera-se true
	 * 4- um contato na posicao 1 com dois telefones, espera-se true
	 * 5- um contato na posição 2 com três contatos, espera-se true
	 */
	@Test
	public void testCadastrarContato() {
		assertEquals(false, agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", 0));
		assertEquals(false, agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", 101));
		assertEquals(true, agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", 1));
		assertEquals(true, agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", "TRABALHO", "+55", "83", "33333-3333", 1));
		assertEquals(true, agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", "TRABALHO", "+55", "83", "33333-3333", "CASA", "+55", "83", "1111", 2));
	}

	/**
	 * testa o método de pesquisar contato pelo indice
	 * testa-se:
	 * 1- Procura um ocntaot em posições invalidas (0 e 101), espera-se uma exceção
	 * 2- Procura um contato na posição que o contaot é nulo, espera-se exceção
	 * 3- Prucra um contato numa posição válida e espera-se que dê certo
	 */
	@Test
	public void testPesquisaContato() {
		try {
			agenda.pesquisaContato(0);
			fail(MSG_FAIL_POSITION);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR, e.getMessage());
		}
		try {
			agenda.pesquisaContato(101);
			fail(MSG_FAIL_POSITION);
		} catch(IndexOutOfBoundsException e) {
			assertEquals(ERROR, e.getMessage());
		}
		try {
			agenda.pesquisaContato(2);
			fail(MSG_FAIL_NULL);
		} catch(NullPointerException e) {
			assertEquals(ERROR, e.getMessage());
		}
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", 1);
		assertEquals("\nVitoria Heliane - Nivel de amizade: distante - CELULAR : +55 83 99169-7808 -\n", agenda.pesquisaContato(1));
	}

	/**
	 * Testa o método de pesquisar contato por nome
	 * testa-se:
	 * 1- Pesquisa um contato válido, espera-se que dê certo
	 * 2- Pesquisa seu por um nome inválido, espera-se que não retorne um ocntato
	 * 3- Pesquisa por um nome repetido e espera-se o primeiro repetido da lista
	 */
	@Test
	public void testPesquisaContatoPorNome() {
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "99169-7808", 1);
		assertEquals("Vitoria Heliane - Nivel de amizade: distante - CELULAR : +55 83 99169-7808 -", agenda.pesquisaContatoPorNome("Vitoria"));
		assertEquals("Contato não encontrado!", agenda.pesquisaContatoPorNome("Joao"));
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals("Vitoria Heliane - Nivel de amizade: distante - CELULAR : +55 83 99169-7808 -", agenda.pesquisaContatoPorNome("Vitoria"));
	}

	/**
	 * Testa o método que pesquisa um contato por outro contato
	 * testa-se:
	 * 1- presquisa por null, retorna null
	 * 2- pesquisa por um contato válido e recebe um conyato com mesmo nome
	 */
	@Test
	public void testPesquisaContatoPorContato() {
		Contato c1 = new Contato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808");
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		Contato c = new Contato("Vitoria", "Heliane", 1, "TRABALHO", "+55", "83", "11111");
		assertEquals(null, agenda.pesquisaContatoPorContato(null));
		assertEquals(c1, agenda.pesquisaContatoPorContato(c));
	}

	/**
	 * Testa o método de pesquisar contato por nivel de amizade
	 * testa-se:
	 * 1- para dois contato com o nivel 1, espera-se que venha o primeiro repetido da lista 
	 * 2- para apnas um contato com nivel 2
	 * 3- para nenhum conyato com nivel 3
	 */
	@Test
	public void testPesquisaContatoPorNivelAmizade() {
		Contato c = new Contato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808");
		Contato c2 = new Contato("Vitoria", "Pereira", 2, "TRABALHO", "1", "2", "1234");
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		agenda.cadastraContato("Vitoria", "Pereira", 2, "TRABALHO", "1", "2", "1234", 3);
		assertEquals(c, agenda.pesquisaContatoPorNivelAmizade(1));
		assertEquals(c2, agenda.pesquisaContatoPorNivelAmizade(2));
		assertEquals(null, agenda.pesquisaContatoPorNivelAmizade(3));
	}

	/**
	 * Testa o método de listar os contatos da agenda
	 * testa-se:
	 * 1- para quando a agenda tem nenhum contato
	 * 2- para quando a agenda tem dois contatos
	 * 3- para quando um contato é substituido
	 */
	@Test
	public void testListaContatos() {
		assertEquals("\n", agenda.listaContatos());
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals("\n1 - Vitoria Heliane\n2 - Vitoria Pereira\n", agenda.listaContatos());
		agenda.cadastraContato("Matheus", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals("\n1 - Vitoria Heliane\n2 - Matheus Pereira\n", agenda.listaContatos());
	}

	/**
	 * Testa o método equals da agenda
	 * testa-se se a agenda é igual a:
	 * 1- um objeto null
	 * 2- uma string
	 * 3- uma agenda sem os contatos na mesma posição
	 * 4- uma agenda com os mesmo contatos nas mesmas posições
	 */
	@Test
	public void testEqualsObject() {
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		Agenda a = null;
		assertEquals(false, agenda.equals(a));
		a = new Agenda();
		assertEquals(false, agenda.equals(a));
		assertEquals(false, agenda.equals("Eu sou uma agenda!"));
		a.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals(false, agenda.equals(a));
		a.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		assertEquals(true, agenda.equals(a));
	}

	/**
	 * Testa o metodo que conta quantos contatos tem o mesmo nivel de amizade
	 * testa-se:
	 * 1- para qunado não há contatos na agenda pelo nivel 1
	 * 2- quando há contatos na agenda pelo nivel 1
	 */
	@Test
	public void testContaContatosDoTipo() {
		assertEquals(0, agenda.contaContatosDoTipo(1));
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals(2, agenda.contaContatosDoTipo(1));
	}

	/**
	 * Teste o método que calcula a media do nivel de amizade
	 * testa-se:
	 * 1- a media calculada quando a agente tá vazia
	 * 2- quando a agente tem dois contaots de nivel 1
	 * 3- quando a agenda tem três contatos (dois de 1 e um de 3)
	 */
	@Test
	public void testMediaDoNivelDeAmizade() {
		assertEquals(0.0, agenda.mediaDoNivelDeAmizade(), 0.000001);
		agenda.cadastraContato("Vitoria", "Heliane", 1, "CELULAR", "+55", "83", "9169-7808", 1);
		agenda.cadastraContato("Vitoria", "Pereira", 1, "TRABALHO", "1", "2", "1234", 2);
		assertEquals(1.0, agenda.mediaDoNivelDeAmizade(), 0.000001);
		agenda.cadastraContato("Vitoria", "Pereira", 3, "TRABALHO", "1", "2", "1234", 3);
		assertEquals(1.666666666, agenda.mediaDoNivelDeAmizade(), 0.000001);
	}

}
