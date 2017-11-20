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
	
	public Telefone(String ddd, String numero, String codigo, String tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.codigo = codigo;
		this.tipo = tipo;
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
	
}
