package classes;

public class Contato {
	private String nome;
	private String sobrenome;
	private Telefone[] telefone;
	private int nivel_amizade;
	
	public Contato(String nome, String sobrenome, String telefone){
		validaEntradas(nome, sobrenome, telefone);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = new Telefone[3];
		//this.telefone = telefone;
	}
	
	//verificar se é composta apenas por espaços, se sim, a exceção também deve ser lançada para esse caso
	private void validaEntradas(String nome, String sobrenome, String telefone) {
		if(nome == null || sobrenome == null || telefone == null)
			throw new NullPointerException("Parâmetros do construtor de Contato não podem ser nulos");
		if (nome.trim().equals("") || sobrenome.trim().equals("") || telefone.trim().equals(""))
			throw new IllegalArgumentException("Nenhum parametro do construtor de Contato pode ser vazio");
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
//	
//	public String getTelefone() {
//		return telefone;
//	}
	
	public void setNivelAmizade(int nivel_amizade) {
		this.nivel_amizade = nivel_amizade;
	}
	
	public String verNivelAmizade() {
		switch(nivel_amizade) {
		case 1:
			return "distante";
		case 2:
			return "colega";
		case 3:
			return "amigo";
		case 4:
			return "amigão";
		default:
			return "irmão";
		}
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