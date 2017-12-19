package classes;

import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private EstadoCenario estado;
	private ArrayList<Aposta> listaApostas;
	private int id;
	
	public Cenario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		estado = EstadoCenario.NAO_FINALIZADO;
		listaApostas = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado.getNome();
	}
	
	public void finalizaCenario(boolean estado) {
		this.estado = (estado) ? EstadoCenario.FINALIZADO_OCORREU : EstadoCenario.FINALIZADO_NAO_OCORREU; 
	}

	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		listaApostas.add(aposta);
	}
	
	public int totalValorApostas() {
		int total = 0;
		for(Aposta a : listaApostas) {
			total += a.getValor();
		}
		return total;
	}
	
	public int getTotalApostas() {
		return listaApostas.size();
	}
	
	public String listaApostas() {
		String apostas = "";
		for(Aposta a : listaApostas) {
			apostas += a.toString();
		}
		return apostas;
	}
	
	public int somaValorApostasPerdedoras() {
		int total = 0;
		for(Aposta a : listaApostas) {
			if(a.getPrevisao().equals("VAI ACONTECER") && estado.getNome().equals("Finalizado (n ocorreu)") ||
					a.getPrevisao().equals("N VAI ACONTECER") && estado.getNome().equals("Finalizado (ocorreu)"))
				total += a.getValor();
		}
		return total;
	}
	
	public String toString() {
		return this.getId() + " - " + this.getDescricao() + " - " + this.getEstado();
	}
}