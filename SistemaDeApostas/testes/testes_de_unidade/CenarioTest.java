package testes_de_unidade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Cenario;

public class CenarioTest {
	private static final String ERRO_DESCRICAO = "Descricao nao pode ser vazia";
	private static final String ERRO_FECHADO = "Cenario ja esta fechado";
	private static final String ERRO_ABERTO = "Cenario ainda esta aberto";
	private static final String MSG_FAIL = "Deveria ter lançado exceção";
	private Cenario cenario;

	@Before
	public void setUp() {
		cenario  = new Cenario(1, "Vitoria tirar 10 neste lab");
	}

	@Test
	public void testCenario() {
		Cenario c;
		try {
			c = new Cenario(0, "");
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_DESCRICAO, e.getMessage());
		}
		c = new Cenario(1, "Vitoria tirar 10 neste lab");
		assertEquals(1, c.getId());
		assertEquals("Vitoria tirar 10 neste lab", c.getDescricao());
		assertEquals(0, c.getTotalApostas());
		assertEquals("Nao finalizado", c.getEstado());
	}

	@Test
	public void testFinalizaCenario() {
		cenario.finalizaCenario(false);
		assertEquals("Finalizado (n ocorreu)", cenario.getEstado());
		try {
			cenario.finalizaCenario(true);
			fail(MSG_FAIL);
		} catch(UnsupportedOperationException e) {
			assertEquals(ERRO_FECHADO, e.getMessage());
		}
		assertEquals("Finalizado (n ocorreu)", cenario.getEstado());
	}

	@Test
	public void testCadastraAposta() {
		cenario.cadastraAposta("Vitoria", 100, "VAI ACONTECER");
		assertEquals(1, cenario.getTotalApostas());
		cenario.cadastraAposta("Vitoria", 100, "VAI ACONTECER");
		assertEquals(2, cenario.getTotalApostas());
		cenario.cadastraAposta("Matheus", 200, "N VAI ACONTECER");
		assertEquals(3, cenario.getTotalApostas());
		cenario.cadastraAposta("Vitoria", 200, "N VAI ACONTECER");
		assertEquals(4, cenario.getTotalApostas());
		cenario.finalizaCenario(true);
		try {
			cenario.cadastraAposta("Vitoria", 200, "N VAI ACONTECER");
			fail(MSG_FAIL);
		} catch(UnsupportedOperationException e) {
			assertEquals(ERRO_FECHADO, e.getMessage());
		}
	}

	@Test
	public void testTotalValorApostas() {
		assertEquals(0, cenario.totalValorApostas());
		cadastraApostas();
		assertEquals(600, cenario.totalValorApostas());
	}

	@Test
	public void testListaApostas() {
		assertEquals("", cenario.listaApostas());
		cadastraApostas();
		assertEquals("Vitoria - R$1.0 - VAI ACONTECER\n"
				+ "Vitoria - R$1.0 - VAI ACONTECER\n"
				+ "Matheus - R$2.0 - N VAI ACONTECER\n"
				+ "Vitoria - R$2.0 - N VAI ACONTECER\n", cenario.listaApostas());
	}

	@Test
	public void testSomaValorApostasPerdedoras() {
		cadastraApostas();
		try {
			cenario.somaValorApostasPerdedoras();
		} catch (UnsupportedOperationException e) {
			assertEquals(ERRO_ABERTO, e.getMessage());
		}
		cenario.finalizaCenario(true);
		assertEquals(400, cenario.somaValorApostasPerdedoras());
	}

	@Test
	public void testToString() {
		assertEquals("1 - Vitoria tirar 10 neste lab - Nao finalizado", cenario.toString());
		cenario.finalizaCenario(false);
		assertEquals("1 - Vitoria tirar 10 neste lab - Finalizado (n ocorreu)", cenario.toString());
		
	}
	
	private void cadastraApostas() {
		cenario.cadastraAposta("Vitoria", 100, "VAI ACONTECER");
		cenario.cadastraAposta("Vitoria", 100, "VAI ACONTECER");
		cenario.cadastraAposta("Matheus", 200, "N VAI ACONTECER");
		cenario.cadastraAposta("Vitoria", 200, "N VAI ACONTECER");
	}
}
