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
	 * Cria um novo contato com um telefone e o adiciona no conjunto de contatos na posicao escolhida
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @param posicao posicao a ser inserido no conjunto de contatos da agenda
	 * @return boolean que indica se o cadastro foi efetuado ou não
	 */
	public boolean cadastraContato(String nome, String sobrenome, int nivel_amizade, String tipo, String codigo, String ddd, String numero, int posicao) {
		if(validaPosicao(posicao)) {
			contatos[posicao-1] = new Contato(nome, sobrenome, nivel_amizade, codigo, ddd, numero, tipo);
			return true;
		}
		return false;
	}
	/**
	 * Cria um novo contato com dois telefones e o adiciona no conjunto de contatos na posicao escolhida
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @param posicao posicao a ser inserido no conjunto de contatos da agenda
	 * @return boolean que indica se o cadastro foi efetuado ou não
	 */
	public boolean cadastraContato(String nome, String sobrenome, int nivel_amizade, String tipo1, String codigo1, String ddd1, String numero1, String tipo2, String codigo2, String ddd2, String numero2, int posicao) {
		if(validaPosicao(posicao)) {
			contatos[posicao-1] = new Contato(nome, sobrenome, nivel_amizade, 
												codigo1, ddd1, numero1, tipo1,
												codigo2, ddd2, numero2, tipo2);
			return true;
		}
		return false;
	}
	/**
	 * Cria um novo contato com três telefones e o adiciona no conjunto de contatos na posicao escolhida
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 * @param posicao posicao a ser inserido no conjunto de contatos da agenda
	 * @return boolean que indica se o cadastro foi efetuado ou não
	 */
	public boolean cadastraContato(String nome, String sobrenome, int nivel_amizade, String tipo1, String codigo1, String ddd1, String numero1, String tipo2, String codigo2, String ddd2, String numero2, String tipo3, String codigo3, String ddd3, String numero3, int posicao) {
		if(validaPosicao(posicao)) {
			contatos[posicao-1] = new Contato(nome, sobrenome, nivel_amizade, 
												codigo1, ddd1, numero1, tipo1,
												codigo2, ddd2, numero2, tipo2,
												codigo3, ddd3, numero3, tipo3);
			return true;
		}
		return false;
	}
	/**
	 * Retorna o contato do posicao recebida
	 * Se a posicao for invalidade, uma exceção será lançada
	 * Se o elemento da posicao for nulo, tambem será lançada uma exceção
	 * @param posicao posicao do contato no conjunto
	 * @return representação em string do contato da posicao
	 */
	public String pesquisaContato(int posicao) {
		if(!validaPosicao(posicao))
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!\n");
		if(contatos[posicao-1] == null)
			throw new NullPointerException("POSIÇÃO INVÁLIDA!\n");
		return "\n" + contatos[posicao-1].toString() + "\n";
	}
	/**
	 * Pesquisa o contato que tem o nome igual aorecebido
	 * Se nãoteve contato com o nome, retorna a msg "Contato não encontrado!"
	 * @param nome nome do contato
	 * @return representação em string do contato encontrado
	 */
	public String pesquisaContatoPorNome(String nome) {
		for(Contato c : contatos)
			if(c != null && c.getNome().equals(nome))
				return c.toString();
		return "Contato não encontrado!";
	}
	/**
	 * Pesquisa o contato que seja igual ao recebido
	 * Se não houver um contato igual, retorna null
	 * @param contato contato a ser procurado
	 * @return o contato encontrado
	 */	
	public Contato pesquisaContatoPorContato(Contato contato) {
		if(contato == null) return null;
		for(Contato c : contatos)
			if(c != null && contato.equals(c))
				return c;
		return null;
	}
	/**
	 * Procura um contato que tenha o nivle de amizade igual ao recebido
	 * @param nivel_amizade nivel de amizade a ser procurado
	 * @return o primeiro contato que tem o nível de amizade igual ao recebido
	 */
	public Contato pesquisaContatoPorNivelAmizade(int nivel_amizade) {
		for(Contato c : contatos)
			if (c != null && c.getNivelAmizade() == nivel_amizade)
				return c;
		return null;
	}
	/**
	 * Gera uma string com posicao, nome e sobrenome dos contatos cadastrados na agenda
	 * @return representação em string dos contatos cadastrados na agenda
	 */
	public String listaContatos() {
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
	 * Verifica se o object recebido é igual a agenda
	 * @param object object a ser comparado com a agenda atual
	 * @return true se forem igual e false, diferentes
	 */
	public boolean equals(Object object) {
		if(object != null 
				&& this.getClass() == object.getClass() 
				&& this.listaContatos().equals(((Agenda)object).listaContatos())) {
			return true;
		}
		return false;
	}
	/**
	 * Verifica se a posição recebida é maior ou igual a 1 e menor ou igual a 100
	 * @param posicao posicao a ser analisada
	 * @return valor boolean que representa se a posicao é valida ou não
	 */
	private boolean validaPosicao(int posicao) {
		if(posicao < 1 || posicao > 100)
			return false;
		return true;
	}
	/**
	 * Conta quantos contatos tem o mesmo nivel de amizade do que o recebido
	 * @param nivel_amizade nivel de amizade a ser comparado
	 * @return a quantidade de contatos com determinado nivel de amizade
	 */
	public int contaContatosDoTipo(int nivel_amizade) {
		int quantidade = 0;
		for(Contato contato : contatos) {
			if(contato != null && contato.getNivelAmizade() == nivel_amizade)
				quantidade++;
		}
		return quantidade;
	}
	/**
	 * Calcula a media do nivel de amizade dos contatos cadastrados
	 * @return a media do nivel de amizade dos contatos
	 */
	public double mediaDoNivelDeAmizade() {
		double soma = 0;
		int quantidade = 0;
		for(Contato c: contatos) {
			if(c != null) {
				soma += c.getNivelAmizade();
				quantidade++;
			}
		}
		return (quantidade != 0) ? (soma/quantidade) : 0;
	}
}