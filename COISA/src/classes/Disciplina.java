package classes;

import java.util.Arrays;

/**
 * Representação de uma disciplina. Cada disciplina
 * possui um nome, um conjunto de notas e horas trabalhadas
 * nessa cadeira. Além disso, pode conter os valores de peso
 * para cada uma das notas da disciplina.
 *
 * @author vitoriahpss
 */
public class Disciplina {

	private String nome;
	private double[] notas;
	private int horasTrabalhadas;
	private double[] pesos;

	/**
	 * Constrói uma disciplina a partir do nome dela. Toda disciplina começa com 0
	 * (zero) horas trabalhadas e com o conjunto de notas com 4 (quatro) elementos.
	 *
	 * @param nome
	 *            nome da disciplina no formato de String padrão
	 */
	public Disciplina(String nome) {
		this.nome = nome;
		horasTrabalhadas = 0;
		notas = new double[4];
	}

	/**
	 * Constrói uma disciplina a partir do nome dela e da quantidade de notas que
	 * ela irá conter. Toda disciplina começa com 0 (zero) horas trabalhadas
	 *
	 * @param nome
	 *            nome da disciplina no formato de String padrão
	 * @param quantidadeNotas
	 *            quantidade de notas do tipo inteiro
	 */
	public Disciplina(String nome, int quantidadeNotas) {
		this.nome = nome;
		horasTrabalhadas = 0;
		notas = new double[quantidadeNotas];
	}

	/**
	 * Constrói uma disciplina a partir do nome dela, da quantidade de notas que ela
	 * irá conter e do conjunto de pesos para cada uma das notas. Toda disciplina
	 * começa com 0 (zero) horas trabalhadas
	 *
	 * @param nome
	 *            nome da disciplina no formato de String padrão
	 * @param quantidadeNotas
	 *            quantidade de notas do tipo inteiro
	 * @param pesos
	 *            pesos que serão atribuidos para cada nota respectivamente.
	 */
	public Disciplina(String nome, int numNotas, double[] pesos) {
		this.nome = nome;
		horasTrabalhadas = 0;
		notas = new double[numNotas];
		this.pesos = pesos;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * Incrementa o valor recebido ao atributo que armazena a qtd de horas
	 * trabalhadas na disciplina
	 * 
	 * @param horas
	 *            inteiro que representa o valor que sera incrementado na qtd de
	 *            horas trabalhadas
	 * @returns null
	 */
	public void cadastraHoras(int horas) {
		horasTrabalhadas += horas;
	}

	/**
	 * Atualiza a nota na posicao indicada do array de notas
	 * 
	 * @param nota
	 *            inteiro que representa a posicao do array onde a nota sera
	 *            adicionada
	 * @param valorNota
	 *            double que representa a nota que sera adicionada no array de notas
	 * @returns null
	 */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota - 1] = valorNota;
	}

	/**
	 * Chama o metodo que calcula a media das notas e verifica se ela eh menor que
	 * sete, se for o aluno esta reprovado, caso contrario nao;
	 * 
	 * @returns um boolean que indica se foi aprovado ou nao
	 */
	public boolean aprovado() {
		if (calculaMedia() < 7)
			return false;
		return true;
	}

	/**
	 * Calcula a media das notas. Se os pesos das notas foram atribuidos, calcula a
	 * media ponderada. Senao, calcula uma media aritmetica simples.
	 * 
	 * @returns um double com o valor da media calculada
	 */
	public double calculaMedia() {
		double soma = 0;
		double media;
		if (pesos == null) {
			for (double nota : notas) {
				soma += nota;
			}
			media = soma / notas.length;
		} else {
			for (int i = 0; i < notas.length; i++) {
				soma += (notas[i] * pesos[i]);
			}
			media = soma / 10;
		}
		return media;
	}

	/**
	 * retorna uma string que representa o estado atual da disciplina
	 * 
	 * @returns uma string com o estado atual da disciplina
	 */
	public String toString() {
		return nome + " " + horasTrabalhadas + " " + calculaMedia() + " " + Arrays.toString(notas);
	}
}