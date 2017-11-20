package classes;

/**
 * 
 * Classe que gerencia os contatos de uma agenda de telefones
 * @author Vitoria Heliane P. S. Sobrinha
 *
 */
public class Agenda {
	private Contato[] contatos;
	
	/**
	* Cria uma agenda com um conjunto de 100 contatos nulos
	*/
	public Agenda() {
		contatos = new Contato[100];
	}
	/**
	 * Cria um novo contato e o adiciona no conjunto de contatos na posicao escolhida
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @param posicao posicao a ser inserido no conjunto de contatos da agenda
	 */
	public void cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {
		validaPosicao(posicao);
		contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}
	/**
	 * Verifica se o conjunto de contatos da agenda é igual ao da recebida
	 * @param agenda agenda a ser comparado com a atual
	 * @return true se forem igual e false, diferentes
	 */
	public boolean equals(Agenda agenda) {
		if(toString().equals(agenda.toString())) return true;
		return false;
	}
	/**
	 * Retorna o contato do posicao recebida
	 * Se a posicao for invalidade, uma exceção será lançada
	 * Se o elemento da posicao for nulo, tambem será lançada uma exceção
	 * @param posicao posicao do contato no conjunto
	 * @return representação em string do contato da posicao
	 */
	public String pesquisarContato(int posicao) {
		validaPosicao(posicao);
		if(contatos[posicao-1] == null)
			throw new NullPointerException("POSIÇÃO INVÁLIDA!\n");
		return "\n" + contatos[posicao-1].toString() + "\n";
	}
	/**
	 * Gera uma string com posicao, nome e sobrenome dos contatos cadastrados na agenda
	 * @return representação em string dos contatos cadastrados na agenda
	 */
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
	/**
	 * Verifica se a posição recebida é maior ou igual a 1 e menor ou igual a 100
	 * Se não for é lançada uma exceção
	 * @param posicao posicao a ser analisada
	 */
	private void validaPosicao(int posicao) {
		if(posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!\n");
		}
	}
}