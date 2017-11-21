package classes;

public class Contato {
	private String nome;
	private String sobrenome;
	private Telefone[] telefones;
	private int nivel_amizade;
	private static final int CELULAR = 0;
	private static final int TRABALHO = 1;
	private static final int CASA = 2;
	private static final int INVALIDA = -1;
	/**
	 * Cria um novo contato com nome, sobrenome, nivel de amizade e um numero de tleefone
	 * Se nome ou sobrenome forem nulos ou vazios, lança um exceção
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato 
	 * @param nivel_amizade nivel de amizade do contato
	 * @param codigo codigo do pais do telefone
	 * @param ddd ddd do telefone
	 * @param numero numero do telefone
	 * @param tipo tipo do telefone (CELULAR, TRABALHO ou CASA)
	 */
	public Contato(String nome, String sobrenome, int nivel_amizade, String codigo, String ddd, String numero, String tipo){
		validaEntradas(nome, sobrenome, nivel_amizade);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = new Telefone[3];
		this.nivel_amizade = nivel_amizade;
		adicionarTelefone(codigo, ddd, numero, tipo);
	}
	/**
	 * Cria um contato com seus dados básicos e dois telefones
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param nivel_amizade nivel de amizade do contato
	 * @param codigo1 codigo do pais do primeiro telefone
	 * @param ddd1 ddd do primeiro telefone
	 * @param numero1 numero do primeiro telefone
	 * @param tipo1 tipo do primeiro telefone
	 * @param codigo2 codigo do pais do segundo telefone
	 * @param ddd2 ddd do segundo telefone
	 * @param numero2 numero do segundo telefone
	 * @param tipo2 tipo do segundo telefone
	 */
	public Contato(String nome, String sobrenome, int nivel_amizade, String codigo1, String ddd1, String numero1, String tipo1, 
			String codigo2, String ddd2, String numero2, String tipo2){
		this(nome, sobrenome, nivel_amizade, codigo1, ddd1, numero1, tipo1);
		adicionarTelefone(codigo2, ddd2, numero2, tipo2);
	}
	/**
	 * Cria um contato com três telefones
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param nivel_amizade nivel de amizade do contato
	 * @param codigo1 codigo do pais do primeiro telefone
	 * @param ddd1 ddd do primeiro telefone
	 * @param numero1 numero do primeiro telefone
	 * @param tipo1 tipo do primeiro telefone
	 * @param codigo2 codigo do pais do segundo telefone
	 * @param ddd2 ddd do segundo telefone
	 * @param numero2 numero do segundo telefone
	 * @param tipo2 tipo do segundo telefone
	 * @param codigo3 codigo do pais do terceiro telefone
	 * @param ddd3 ddd do terceiro telefone
	 * @param numero3 numero do terceiro telefone
	 * @param tipo3 tipo do terceiro telefone
	 */
	public Contato(String nome, String sobrenome, int nivel_amizade, String codigo1, String ddd1, String numero1, String tipo1, 
			String codigo2, String ddd2, String numero2, String tipo2,
			String codigo3, String ddd3, String numero3, String tipo3){
		this(nome, sobrenome, nivel_amizade, codigo1, ddd1, numero1, tipo1, codigo2, ddd2, numero2, tipo2);
		adicionarTelefone(codigo3, ddd3, numero3, tipo3);
	}
	/**
	 * Verifica se nome e sobrenome são diferentes de null ou vazio
	 * Se forem, uma exceção será lançada
	 * @param nome nome
	 * @param sobrenome sobrenome
	 */
	private void validaEntradas(String nome, String sobrenome, int nivel_amizade) {
		if (nome == null || sobrenome == null)
			throw new NullPointerException("Parâmetros do construtor de Contato não podem ser nulos");
		if (nome.trim().equals("") || sobrenome.trim().equals(""))
			throw new IllegalArgumentException("Nenhum parametro do construtor de Contato pode ser vazio");
		if (nivel_amizade < 1 || nivel_amizade > 5)
			throw new IllegalArgumentException("Nivel de amizade precisa ser um inteiro no intervalo [1, 5].");
	}
	/**
	 * Acessador do atributo nome
	 * @return retorna o nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Acessador do atributo sobrenome
	 * @return retorna o sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * Modificado do atributo nivel de amizade
	 * @param nivel_amizade nivel de amizade a ser modificado
	 */
	public void setNivelAmizade(int nivel_amizade) {
		this.nivel_amizade = nivel_amizade;
	}
	/**
	 * Acessador do atributo nivel de amizade
	 * @return retorna o nivel de amizade
	 */
	public int getNivelAmizade() {
		return nivel_amizade;
	}
	/**
	 * Calcula o nivel de amizade
	 * @return retorna uma representação em string do nivel de amizade
	 */
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
	/**
	 * Adiciona um novo telefone no contato
	 * @param codigo codigo do pais do telefone
	 * @param ddd ddd do telefone
	 * @param numero numero do telefone
	 * @param tipo tipo do teleofne
	 */
	public boolean adicionarTelefone(String codigo, String ddd, String numero, String tipo) {
		int posicao = converterTipoPosicao(tipo);
		if(posicao != INVALIDA) {
			telefones[posicao] = new Telefone(codigo, ddd, numero, tipo);
			return true;
		}
		return false;
	}
	/**
	 * Calcula a posição do teleofne a partir do tipo
	 * @param tipo tipo a partir do qual será calculada a posição
	 * @return retorna a posição do contato
	 */
	private int converterTipoPosicao(String tipo) {
		if(tipo == null) return INVALIDA;
		switch(tipo.toUpperCase()) {
		case "CELULAR":
			return CELULAR;
		case "TRABALHO":
			return TRABALHO;
		case "CASA":
			return CASA;
		default:
			return INVALIDA;
		}
	}
	/**
	 * Representação em Stirng do objeto
	 */
	public String toString() {
		return nome + " " + sobrenome + " - Nivel de amizade: " + verNivelAmizade() + " " + listarTelefones();
	}
	/**
	 * Compara o objeto atual com o recebido, verificando se têm o recebido é diferente de null,é da classe contato e se o nome e sobrenome
	 * do recebido são iguais ao do objeto atual
	 * @param contato conta
	 * @return boolean que indica se são iguais ou não
	 */
	public boolean equals(Object object) {
		if(object != null &&
				this.getClass() == object.getClass() &&
				this.getNome().equals(((Contato) object).getNome()) &&
				this.getSobrenome().equals(((Contato) object).getSobrenome()))
			return true;
		return false;
	}
	/**
	 * Cria um representação em String de todos os telefones cadastrados
	 * @return String com os telefones diferentes de null
	 */
	public String listarTelefones() {
		String telefones_string = "-";
		for(Telefone t : telefones) {
			if(t != null) {
				telefones_string += " " + t.toString() + " -"; 
			}
		}
		return telefones_string;
		
	}
}