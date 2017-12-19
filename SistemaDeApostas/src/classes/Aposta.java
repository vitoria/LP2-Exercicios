package classes;

public class Aposta {
	private String nome;
	private double valor;
	private String previsao;
	
	public Aposta(String nome, double valor, String previsao) {
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

	public String getPrevisao() {
		return previsao;
	}

	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
		
	public String toString() {
		return this.getNome() + " - R$" + this.getValor()/100 + " - " + this.getPrevisao();  
	}
}