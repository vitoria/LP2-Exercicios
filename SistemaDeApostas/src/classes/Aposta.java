package classes;

public class Aposta {
	private String nome;
	private double valor;
	private boolean previsao;
	
	public Aposta(String nome, double valor, boolean previsao) {
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean getPrevisao() {
		return previsao;
	}

	public void setPrevisao(boolean previsao) {
		this.previsao = previsao;
	}
		
	public String toString() {
		return this.getNome() + " - R$" + this.getValor()/100 + " - " + ((this.getPrevisao()) ? "VAI ACONTECER" : "N VAI ACONTECER");  
	}
}