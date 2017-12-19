package controladores;

import java.util.ArrayList;
import classes.Cenario;
import uteis.Validacao;

public class Sistema {
	private int valorCaixa;
	private double taxaRetirada;
	private ArrayList<Cenario> listaCenarios;
	
	public Sistema(int valorCaixa, double taxaRetirada) {
		Validacao.validaInteiroNaoNegativo("Erro na inicializacao: Caixa nao pode ser inferior a 0", valorCaixa);
		Validacao.validarPercentage("Erro na inicializacao: Taxa nao pode ser inferior a 0", taxaRetirada);
		this.valorCaixa = valorCaixa;
		this.taxaRetirada = taxaRetirada;
		this.listaCenarios = new ArrayList<>();
	}
	
	public int getValorCaixa() {
		return this.valorCaixa;
	}
	
	public int criaCenario(String descricao) {
		try {
			verificaStringNaoVazio(descricao);
			Cenario cenario = new Cenario(listaCenarios.size() + 1, descricao);
			listaCenarios.add(cenario);
			return listaCenarios.size();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + e.getMessage());
		}
	}
	
	public String exibeCenario(int idCenario) {
		try {
			verificaCenarioInvalido(idCenario);
			Cenario c = listaCenarios.get(idCenario - 1);
			return c.toString();
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de cenario: " + e.getMessage());
		}
	}
	
	public String exibeCenarios() {
		String cenarios = "";
		for(Cenario c : listaCenarios) {
			cenarios += c.toString() + "\n";
		}
		return cenarios;
	}
	
	public void cadastraAposta(int idCenario, String nomeApostador, int valorAposta, String previsao) {
		try {
			verificaCenarioInvalido(idCenario);
			listaCenarios.get(idCenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao);
		} catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e.getMessage());
		}
	}
	
	public int valorTotalApostas(int idCenario) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		return c.totalValorApostas();
	}
	
	public int totalApostas(int idCenario) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		return c.getTotalApostas();
	}
	
	public String exibeApostas(int idCenario) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		return c.listaApostas();
	}
	
	public void fechaCenario(int idCenario, boolean ocorreu) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		c.finalizaCenario(ocorreu); 
	}
	
	public int getCaixaCenario(int idCenario) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		return (int) Math.floor(listaCenarios.get(idCenario - 1).somaValorApostasPerdedoras() * taxaRetirada);
	}
	
	public int getTotalRasteioCenario(int idCenario) {
		Cenario c = listaCenarios.get(idCenario - 1);
		if(c == null) throw new NullPointerException("Cenario não cadastrado");
		int total = listaCenarios.get(idCenario - 1).somaValorApostasPerdedoras();
		return total - (int) Math.floor(total * taxaRetirada);
	}
	
	private void verificaCenarioInvalido(int idCenario) {
		if(idCenario < 1) throw new IllegalArgumentException("Cenario invalido");
		if(idCenario > listaCenarios.size()) throw new IllegalArgumentException("Cenario nao cadastrado");
	}
	
	private void verificaStringNaoVazio(String str) {
		if(str.trim().equals("")) throw new IllegalArgumentException("Descricao nao pode ser vazia");
	}
}
