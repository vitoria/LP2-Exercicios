package controladores;

import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Fachada {
	private Sistema sistema;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ArrayList<String> testes = new ArrayList<>();
        testes.add("testes_de_aceitacao/us1_test.txt");
        testes.add("testes_de_aceitacao/us2_test.txt");
        testes.add("testes_de_aceitacao/us3_test.txt");
        testes.add("testes_de_aceitacao/us4_test.txt");

        EasyAccept.executeEasyAcceptTests("controladores.Fachada", testes);
    }
	
	public void inicializa(int caixa, double taxa) {
		this.sistema = new Sistema(caixa, taxa);
	}
	
	public int getCaixa() {
		return this.sistema.getValorCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.sistema.criaCenario(descricao);
	} 
	
	public String exibirCenario(int cenario) {
		return this.sistema.exibeCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.sistema.exibeCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	public void cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custoSeguro) {
		this.sistema.cadastraAposta(cenario, apostador, valor, previsao, valorSeguro, custoSeguro);
	}
	
	public void cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxaSeguro, int custoSeguro) {
		this.sistema.cadastraAposta(cenario, apostador, valor, previsao, taxaSeguro, custoSeguro);
	}
	
	public void alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		this.sistema.alteraSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public void alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		this.sistema.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.sistema.valorTotalApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return this.sistema.totalApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.sistema.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.sistema.fechaCenario(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return this.sistema.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return this.sistema.getTotalRasteioCenario(cenario);
	}
	
}