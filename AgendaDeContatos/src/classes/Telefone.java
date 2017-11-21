package classes;

/**
 * 
 * Classe que cria um telefone com ddd, numero e condigo do país
 * @author Vitória Heliane P. S. Sobrinha
 *
 */
public class Telefone {
	private String ddd;
	private String numero;
	private String codigo;
	private String tipo;
	/**
	 * Cria um novo objeto da classe Telefone a partir do ddd, numeor, codigo e tipo
	 * @param ddd ddd do telefone
	 * @param numero numero do telefone
	 * @param codigo codigo do pais do telefone
	 * @param tipo tipo do telefone
	 */
	public Telefone(String codigo, String ddd, String numero, String tipo) {
		validarEntradas(numero, tipo);
		this.ddd = ddd;
		this.numero = numero;
		this.codigo = codigo;
		this.tipo = tipo;
	}
	/**
	 * Verifica se o numero e tipo são diferentes de null e não vazios, se sim, uma exceção é lançada
	 * @param numero numeor do telefone
	 * @param tipo tipo do telefone
	 */
	private void validarEntradas(String numero, String tipo) {
		if(numero == null || tipo == null)
			throw new NullPointerException("Numero ou tipo de Telefone não podem ser nulo.");
		if(numero.trim().equals("") || tipo.trim().equals("")) {
			throw new IllegalArgumentException("Numero ou tipo de Telefone não pode ser vazio.");
		}
		tipo = tipo.toUpperCase();
		if(!tipo.equals("CELULAR") && !tipo.equals("TRABALHO") && !tipo.equals("CASA")) {
			throw new IllegalArgumentException("Tipo de Telefone precisa ser CELULAR, TRABALHO ou CASA.");
		}
	}

	/**
	 * @return o ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * @param ddd o ddd para ser alterado
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	/**
	 * @return o numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero o numero para ser alterado
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return o codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo o codigo para ser alterado
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return o tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo o tipo a ser atualizado
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tipo + " : " + codigo + " " + ddd + " " + numero;
	}

}
