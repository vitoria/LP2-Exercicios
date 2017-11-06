package classes;

/**
 * Representação de uma conta de algum laboratório de computação da UFCG. Cada
 * laboratório possui um nome, uma cota de armazenamento de dados e a informação
 * de quanto espaço está sendo utilizado.
 * 
 * @author vitoriahpss
 */
public class ContaLaboratorio {
	private String nomeLab;
	private int espacoOcupado;
	private int cota;

	/**
	 * Constrói uma conta de laboratório a partir do nome do lab. Toda conta é
	 * criada com o campo espaco ocupado setado com valor nulo e cota , por padrão,
	 * igual 2000mb (aproximadamente 2gb)
	 *
	 * @param nome
	 *            nome do laboratório no formato de String padrão
	 */
	public ContaLaboratorio(String nomeLab) {
		this.nomeLab = nomeLab;
		cota = 2000;
		espacoOcupado = 0;
	}

	/**
	 * Constrói uma conta de laboratório a partir do nome do lab e valor da cota
	 * personalizado. Toda conta é criada com o campo espaco ocupado setado com
	 * valor nulo.
	 *
	 * @param nome
	 *            nome do laboratório no formato de String padrão
	 * @param cota
	 *            cota de armazenamento no formato inteiro em mb.
	 */
	public ContaLaboratorio(String nomeLab, int cota) {
		this.nomeLab = nomeLab;
		this.cota = cota;
		espacoOcupado = 0;
	}

	public String getNome() {
		return nomeLab;
	}

	public void setNomeLab(String nomeLab) {
		this.nomeLab = nomeLab;
	}

	public int getEspacoOcupado() {
		return espacoOcupado;
	}

	public void setEspacoOcupado(int espacoOcupado) {
		this.espacoOcupado = espacoOcupado;
	}

	public int getCota() {
		return cota;
	}

	public void setCota(int cota) {
		this.cota = cota;
	}

	/**
	 * Incrementa ao espaco ocupado o valor recebido por parametro
	 * 
	 * @param mbytes
	 *            inteiro que representa o valor que sera incrementado no espaco
	 *            ocupado
	 * @returns null
	 */
	public void consomeEspaco(int mbytes) {
		espacoOcupado += mbytes;
	}

	/**
	 * Decrementa ao espaco ocupado o valor recebido por parametro
	 * 
	 * @param mbytes
	 *            inteiro que representa o valor que sera decrementado no espaco
	 *            ocupado
	 * @returns null
	 */
	public void liberaEspaco(int mbytes) {
		espacoOcupado -= mbytes;
	}

	/**
	 * Verifica se a cota de armazenamento foi atingida, isto é, se o espaco ocupado
	 * eh maior ou igual a cota
	 * 
	 * @returns um boolean que indica se a cota foi atingida ou nao
	 */
	public boolean atingiuCota() {
		if (espacoOcupado >= cota)
			return true;
		return false;
	}

	/**
	 * Retorna uma string que representa o estado atual da conta
	 * 
	 * @returns uma string com o estado atual do objeto
	 */
	public String toString() {
		return getNome() + " " + getEspacoOcupado() + "/" + getCota();
	}

}
