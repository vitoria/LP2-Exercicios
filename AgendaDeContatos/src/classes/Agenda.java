package classes;

public class Agenda {
	private Contato[] contatos;
	
	public Agenda() {
		contatos = new Contato[100];
	}
	
	public void cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {
		validaPosicao(posicao);
		contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}
	
	public String toString() {
		String listaContatos = "";
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null)
				listaContatos = listaContatos + "\n" + 
								(i+1) + " - " + contatos[i].getNome() + " " +
								contatos[i].getSobrenome();
		}
		return listaContatos + "\n";
	}
	
	public String contatoToString(int posicao) {
		validaPosicao(posicao);
		if(contatos[posicao-1] == null)
			throw new NullPointerException("POSIÇÃO INVÁLIDA!\n");
		return contatos[posicao-1].toString() + "\n";
	}
	
	private void validaPosicao(int posicao) {
		if(posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!\n");
		}
	}
}