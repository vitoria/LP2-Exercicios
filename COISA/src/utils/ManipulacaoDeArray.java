package utils;

import classes.ContaCantina;
import classes.ContaLaboratorio;
import classes.Disciplina;

/**
 * Classe que trabalha com a manipulacao de arrays em suas operacoes de busca e expensao
 * de tamanho
 *
 * @author Vitória Heliane
 */
public class ManipulacaoDeArray {
	/**
	 * Procura a conta no array de contas que tenha o nome igual ao recebido.
	 * 
	 * @param nomeCantina
	 *            string que representa o nome da cantina.
	 * @returns retorna a conta da cantina, senão encontrar, retorna null.
	 */
	public ContaCantina buscarCantina(ContaCantina[] contas, String nomeCantina) {
		for (ContaCantina conta : contas) {
			if (conta == null)
				break;
			if (conta.getNome().equals(nomeCantina))
				return conta;
		}
		return null;
	}
	
	/**
	 * Procura a disciplina do array de disciplinas que tenha o mesmo nome do
	 * recebido;
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @returns retorna o objeto que tem o mesmo nome do recebido, senão retorna
	 *          null.
	 */
	public Disciplina buscarDisciplina(Disciplina[] disciplinas, String nomeDisciplina) {
		for (Disciplina disciplina : disciplinas) {
			if (disciplina == null)
				break;
			if (disciplina.getNome().equals(nomeDisciplina)) {
				return disciplina;
			}
		}
		return null;
	}
	
	/**
	 * Procura no array de contas de laboratório uma conta que tenha o mesmo nome
	 * que o recebido por parâmetro.
	 * 
	 * @param nomeLab
	 *            string que representa o nome do laboratorio da conta.
	 * @returns se encontrar a conta retorna ela, senão retorna null.
	 */
	public ContaLaboratorio buscarLab(ContaLaboratorio[] contas, String nomeLab) {
		for (ContaLaboratorio conta : contas) {
			if (conta == null)
				break;
			if (conta.getNome().equals(nomeLab))
				return conta;
		}
		return null;
	}
	
	/**
	 * Cria um novo array de disciplinas com o tamanho do array atual mais uma
	 * posição e passa todos os elementos do array antigo para o recém criado.
	 * 
	 * @returns null
	 */
	public Disciplina[] aumentarArrayDisciplina(Disciplina[] disciplinas) {
		Disciplina[] newContas = new Disciplina[disciplinas.length + 1];
		for (int i = 0; i < disciplinas.length; i++) {
			newContas[i] = disciplinas[i];
		}
		return newContas;
	}
	
	/**
	 * Cria um novo array de contas de laboratório com o tamanho do array atual mais
	 * uma posição e passa todos os elementos do array antigo para o recém criado.
	 * 
	 * @returns null
	 */
	public ContaCantina[] aumentarArrayCantina(ContaCantina[] contasCantina) {
		ContaCantina[] newContas = new ContaCantina[contasCantina.length + 1];
		for (int i = 0; i < contasCantina.length; i++) {
			newContas[i] = contasCantina[i];
		}
		return newContas;
	}
	
	/**
	 * Cria um novo array de contas de lab com o tamanho do array atual mais uma
	 * posição e passa todos os elementos do antigo para o recém criado.
	 * 
	 * @returns null
	 */
	public ContaLaboratorio[] aumentarArrayLab(ContaLaboratorio[] contasLab) {
		ContaLaboratorio[] newContas = new ContaLaboratorio[contasLab.length + 1];
		for (int i = 0; i < contasLab.length; i++) {
			newContas[i] = contasLab[i];
		}
		return newContas;
	}
}
