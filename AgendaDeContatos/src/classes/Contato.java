package classes;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato(String nome, String sobrenome, String telefone){
		validaEntradas(nome, sobrenome, telefone);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	private void validaEntradas(String nome, String sobrenome, String telefone) {
		if(nome == null || sobrenome == null || telefone == null)
			throw new NullPointerException("Parâmetros do construtor de Contato não podem ser nulos");
		if (nome.equals("") || sobrenome.equals("") || telefone.equals(""))
			throw new IllegalArgumentException("Nenhum parametro do construtor de Contato pode ser vazio");
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String toString() {
		return nome + " " + sobrenome + " - " + telefone;
	}
	
	public boolean equals(Contato contato) {
		if(nome.equals(contato.getNome()))
			return true;
		return false;
	}
	
}