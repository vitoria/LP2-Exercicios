package testes_de_unidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.Sistema;

class SistemaTest {
	private static final String ERRO_INICIALIZA_CAIXA_NEGATIVO = "Erro na inicializacao: Caixa nao pode ser inferior a 0";
	private static final String ERRO_INICIALIZA_TAXA_NEGATIVA = "Erro na inicializacao: Taxa nao pode ser inferior a 0";
	private static final String ERRO_CRIA_CENARIO = "Erro no cadastro de cenario: Descricao nao pode ser vazia";
	private static final String ERRO_EXIBE_CENARIO_NAO_CADASTRADO = "Erro na consulta de cenario: Cenario nao cadastrado";
	private static final String ERRO_EXIBE_CENARIO_INVALIDO = "Erro na consulta de cenario: Cenario invalido";
	private static final String MSG_FAIL = "Deveria ter lançado uma exceção";
	private Sistema sistema;
	
	@BeforeEach
	void setUp() {
		sistema = new Sistema(100, 0.1);
	}

	@Test
	void testSistema() {
		Sistema s;
		try {
			s = new Sistema(-100, 0.1);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_INICIALIZA_CAIXA_NEGATIVO, e.getMessage());
		}
		try {
			s = new Sistema(100, -0.1);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_INICIALIZA_TAXA_NEGATIVA, e.getMessage());
		}
		s = new Sistema(100, 0.1);
		assertEquals(100, s.getValorCaixa());
		assertEquals(0.1, s.getTaxaRetirada());
	}

	@Test
	void testCriaCenario() {
		try {
			sistema.criaCenario("");
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_CRIA_CENARIO, e.getMessage());
		}
		assertEquals(1, sistema.criaCenario("Vitoria tirar 10 neste lab"));
		assertEquals(2, sistema.criaCenario("Vitoria passar em LP2 e P2"));	
	}

	@Test
	void testExibeCenario() {
		try {
			sistema.exibeCenario(0);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_EXIBE_CENARIO_INVALIDO, e.getMessage());
		}
		try {
			sistema.exibeCenario(1);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals(ERRO_EXIBE_CENARIO_NAO_CADASTRADO, e.getMessage());
		}
		sistema.criaCenario("Vitoria passar em LP2");
		assertEquals("1 - Vitoria passar em LP2 - Nao finalizado", sistema.exibeCenario(1));
	}

	@Test
	void testExibeCenarios() {
		assertEquals("", sistema.exibeCenarios());
		sistema.criaCenario("Bla");
		sistema.criaCenario("Ta-da");
		assertEquals("1 - Bla - Nao finalizado\n2 - Ta-da - Nao finalizado\n", sistema.exibeCenarios());
	}

	@Test
	void testCadastraAposta() {
		sistema.criaCenario("Bla");
		try {
			sistema.cadastraAposta(0, "Vitoria", 100, "VAI ACONTECER");
		} catch(IllegalArgumentException e) {
			assertEquals("Erro no cadastro de aposta: Cenario invalido", e.getMessage());
		}
		try {
			sistema.cadastraAposta(2, "Vitoria", 100, "VAI ACONTECER");
		} catch(IllegalArgumentException e) {
			assertEquals("Erro no cadastro de aposta: Cenario nao cadastrado", e.getMessage());
		}
		sistema.cadastraAposta(1, "Vitoria", 100, "VAI ACONTECER");
		assertEquals(1, sistema.totalApostas(1));
		sistema.cadastraAposta(1, "Vitoria", 100, "VAI ACONTECER");
		assertEquals(2, sistema.totalApostas(1));
		
	}

	@Test
	void testValorTotalApostas() {
		sistema.criaCenario("Bla");
		try {
			sistema.valorTotalApostas(2);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals("Erro na consulta do valor total de apostas: Cenario nao cadastrado", e.getMessage());
		}
		try {
			sistema.valorTotalApostas(-2);
			fail(MSG_FAIL);
		} catch(IllegalArgumentException e) {
			assertEquals("Erro na consulta do valor total de apostas: Cenario invalido", e.getMessage());
		}
		assertEquals(0, sistema.valorTotalApostas(1));
		sistema.cadastraAposta(1, "V", 100, "VAI ACONTECER");
		assertEquals(100, sistema.valorTotalApostas(1));
		sistema.cadastraAposta(1, "V", 150, "VAI ACONTECER");
		assertEquals(250, sistema.valorTotalApostas(1));	
	}

	@Test
	void testExibeApostas() {
		sistema.criaCenario("Bla");
		assertEquals("", sistema.exibeApostas(1));
		sistema.cadastraAposta(1, "V", 100, "VAI ACONTECER");
		sistema.cadastraAposta(1, "V", 100, "VAI ACONTECER");
		assertEquals("V - R$1.0 - VAI ACONTECER\nV - R$1.0 - VAI ACONTECER\n", sistema.exibeApostas(1));	
	}

	@Test
	void testFechaCenario() {
		sistema.criaCenario("Bla");
		
	}

	@Test
	void testGetCaixaCenario() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetTotalRasteioCenario() {
		//fail("Not yet implemented");
	}

}
