package controladores;

import java.util.ArrayList;

import easyaccept.EasyAccept;

public class Fachada {
	private Sistema sistema;
	
	public Fachada() {

	}

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ArrayList<String> testes = new ArrayList<>();
        testes.add("testes_de_aceitacao/us1_test.txt");
        testes.add("testes_de_aceitacao/us2_test.txt");

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
		return null;
	}
	
	public String exibirCenarios() {
		return null;
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		
	}
	
	public int valorTotalDeApostas(int cenario) {
		return 0;
	}
	
	public int totalDeApostas(int cenario) {
		return 0;
	}
	
	public String exibeApostas(int cenario) {
		return null;
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		
	}
	
	public int getCaixaCenario(int cenario) {
		return 0;
	}
	
	public int getTotalRateioCenario(int cenario) {
		return 0;
	}
	
	
}