package classes;

import java.util.Arrays;

/**
 * Representação de uma conta em uma determinada cantina da UFCG. Cada conta
 * possui o nome da lanchonete, quantidade de itens vendido, o valor da divida e
 * também pode conter uma breve descrição dos ultimos 5 (cinco) lanches
 * vendidos.
 * 
 * @author Vitória Heliane
 */
public class ContaCantina {

	private String nome;
	private int qtdItens;
	private int valorDivida;
	private String[] descLanche;
	private int qtdDescricao;

	/**
	 * Constroi uma conta de cantina a partir do nome da lanchonete. Toda conta eh
	 * criada com os campos valor da divida e quantidade de itens vendidos zerados.
	 * E o conjunto das descrições dos ultimos 5 (cinco) lanches vazio.
	 *
	 * @param nome
	 *            string que representa o nome da cantina
	 */
	public ContaCantina(String nome) {
		this.nome = nome;
		descLanche = new String[5];
		qtdDescricao = 0;
		qtdItens = 0;
		valorDivida = 0;
	}

	/**
	 * Soma a quantidade de itens vendidos recebido ao atributo que representa essa
	 * quantidade na classe. Tambem soma o valor total da compra ao valor da divida
	 * total.
	 * 
	 * @param qtdItens
	 *            inteiro que representa a quantidade de itens vendidos
	 * @param valorCentavos
	 *            inteiro que represente, em cevetos, o valor total da compra
	 * @returns null
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		valorDivida += valorCentavos;
	}

	/**
	 * Soma a quantidade de itens vendidos recebido ao atributo que representa essa
	 * quantidade na classe. Tambem soma o valor total da compra ao valor da divida
	 * total e adiciona a descricao da compra ao array de descricoes.
	 * 
	 * @param qtdItens
	 *            inteiro que representa a quantidade de itens vendidos
	 * @param valorCentavos
	 *            inteiro que represente, em cevetos, o valor total da compra
	 * @param descricao
	 *            string que representa a descricao da compra
	 * @returns null
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String descricao) {
		this.qtdItens += qtdItens;
		valorDivida += valorCentavos;
		adicionaDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Adiciona a descricao recebida ao array de descricoes, colocando ela sempre no
	 * final do array e deslocando as anteriores uma posicao a esquerda
	 * 
	 * @param descricao
	 *            string que representa a descricao
	 * @returns null
	 */
	private void adicionaDescricao(String descricao) {
		if (qtdDescricao < 5) {
			descLanche[qtdDescricao] = descricao;
		} else {
			for (int i = 0; i < 4; i++) {
				descLanche[i] = descLanche[i + 1];
			}
			descLanche[4] = descricao;
		}
		qtdDescricao++;
	}

	/**
	 * Subtrai do valor da divida, a valor recebido por parâmetro
	 * 
	 * @param valorCentavos
	 *            inteiro que representa, em centavos, o valor que sera subtraido
	 * @returns null
	 */
	public void pagaConta(int valorCentavos) {
		valorDivida -= valorCentavos;
	}

	/**
	 * Retorna uma representacao em stirng do estado da conta
	 * 
	 * @returns uma string com o estado da conta
	 */
	public String toString() {
		return nome + " " + qtdItens + " " + valorDivida;
	}

	/**
	 * Retorna um array com as ultimas 5 descricoes de lanche
	 * 
	 * @returns uma string com a descricao dos ultimos cinco lanches
	 */
	public String listarDetalhes() {
		return Arrays.toString(descLanche);
	}
}