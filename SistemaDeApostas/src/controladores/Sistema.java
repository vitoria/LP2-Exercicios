package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import classes.Aposta;
import classes.Cenario;

public class Sistema {
	private int valorCaixa;
	private double taxaRetirada;
	private ArrayList<HashSet<Aposta>> listaApostas;
	private ArrayList<Cenario> listaCenarios;
	
	public Sistema(int valorCaixa, double taxaRetirada) {
		this.valorCaixa = valorCaixa;
		this.taxaRetirada = taxaRetirada;
		this.listaApostas = new ArrayList<>();
		this.listaCenarios = new ArrayList<>();
	}
	
	public int getValorCaixa() {
		return this.valorCaixa;
	}
	
	public int criaCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		listaCenarios.add(cenario);
		listaApostas.add(new HashSet<Aposta>());
		return cenario.getId();
	}
	
	public String exibeCenario(int idCenario) {
		//if()
	}
	
	public boolean cadastraAposta(int idCenario, String nomeApostador, int valorAposta, boolean previsao) {
		if(listaApostas.get(idCenario - 1) != null) {
			Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
			mapaIdApostas.get(idCenario).add(aposta);
			return true;
		}
		return false;
	}
		
}
