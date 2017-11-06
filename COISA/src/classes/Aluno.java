package classes;

import utils.ManipulacaoDeArray;

/**
 * Representação de um aluno da UFCG, especificamente do Curso Ciência da
 * Computação. Todo aluno tem um conjunto de disciplinas, contas em cantinas e
 * laboratórios, além de possuir um registro acerca da sua saúde física e
 * mental.
 *
 * @author Vitória Heliane
 */
public class Aluno {

	private Disciplina[] disciplinas;
	private ContaLaboratorio[] contasLab;
	private ContaCantina[] contasCantina;
	private Saude saude;
	private int qtdContasLab;
	private int qtdContasCantina;
	private int qtdDisciplinas;
	private ManipulacaoDeArray manipucalacaoArray;

	/**
	 * Constrói um aluno recebendo nenhuma informação por parâmetro. Todo aluno é
	 * criado com os conjuntos des disciplinas e contas de laboratório e cantina
	 * vazios. E o registro da sua saúde no padrão.
	 */
	public Aluno() {
		qtdContasLab = 0;
		qtdContasCantina = 0;
		qtdDisciplinas = 0;
		contasLab = new ContaLaboratorio[10];
		contasCantina = new ContaCantina[10];
		disciplinas = new Disciplina[10];
		saude = new Saude();
		manipucalacaoArray = new ManipulacaoDeArray();
	}

	/**
	 * Cria uma nova conta de laboratorio e adiciona ela no array de contas de lab.
	 * Caso o array já esteja cheio, é chamado um método que aumenta o tamanho dele
	 * e assim poder adicionar a nova conta.
	 * 
	 * @param nome
	 *            - uma string que representa o nome do laboratorio onde a conta
	 *            será criada.
	 * @returns null
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		if (qtdContasLab >= contasLab.length)
			contasLab = manipucalacaoArray.aumentarArrayLab(contasLab);
		contasLab[qtdContasLab++] = new ContaLaboratorio(nomeLaboratorio);
	}

	/**
	 * Cria uma nova conta de laboratorio e adicona ela no array de contas de lab.
	 * Caso o array já esteja cheio, é chamado um método para aumentar tamanho dele
	 * e assim poder adicionar a nova conta.
	 * 
	 * @param nome
	 *            string que representa o nome do laboratorio onde a conta será
	 *            criada.
	 * @param cota
	 *            representa a cota de armazenamento da conta em megabyte.
	 * @returns null
	 */
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		if (qtdContasLab >= contasLab.length)
			contasLab = manipucalacaoArray.aumentarArrayLab(contasLab);
		contasLab[qtdContasLab++] = new ContaLaboratorio(nomeLaboratorio, cota);
	}

	/**
	 * Procura uma conta de laboratório que tenha o nome recebido por parâmetro,
	 * caso a encontre, atualiza o espaço de armazenamento ocupado.
	 * 
	 * @param nomeLaboratorio
	 *            string que representa o nome do laboratorio da conta.
	 * @param mbytes
	 *            inteiro que representa o espaço ocupado
	 * @returns null
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = manipucalacaoArray.buscarLab(contasLab, nomeLaboratorio);
		if (conta != null) {
			conta.consomeEspaco(mbytes);
		}
	}

	/**
	 * Procura uma conta de laboratório que tenha o nome recebido por parâmetro,
	 * caso a encontre, libera espaço de armazenamento da conta de acordo com o
	 * valor recebido.
	 * 
	 * @param nomeLaboratorio
	 *            string que representa o nome do laboratorio da conta.
	 * @param mbytes
	 *            inteiro que representa o espaço que será liberado
	 * @returns null
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = manipucalacaoArray.buscarLab(contasLab, nomeLaboratorio);
		if (conta != null) {
			conta.liberaEspaco(mbytes);
		}
	}

	/**
	 * Procura uma conta de lab que tenha um nome recebido por parâmetro, caso a
	 * ache verifica se o espaço ocupado é maior ou igual a cota de armazenamento.
	 * 
	 * @param nomeLaboratorio
	 *            string que representa o nome do laboratorio da conta.
	 * @returns boolean que indica se atingiu ou não a conta de armazenamento.
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio conta = manipucalacaoArray.buscarLab(contasLab, nomeLaboratorio);
		if (conta != null) {
			return conta.atingiuCota();
		}
		return false;
	}

	/**
	 * Retorna a representação em string do estado da conta do laboratorio que tenha
	 * o nome recebido por parâmetro.
	 * 
	 * @param nomeLaboratorio
	 *            string que representa o nome do laboratorio da conta.
	 * @returns a string com a representação do estado da conta do lab
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		ContaLaboratorio conta = manipucalacaoArray.buscarLab(contasLab, nomeLaboratorio);
		if (conta != null)
			return conta.toString();
		return "Laboratorio nao encontrado! :(";
	}

	/**
	 * Cria uma nova disciplina com o nome recebido e adiciona ela no array de
	 * disciplinas. Caso o array esteja cheio, chama uma metodo para aumentar o
	 * tamanho dele e depois adiciona ela.
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @returns null
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		if (qtdDisciplinas >= disciplinas.length) {
			disciplinas = manipucalacaoArray.aumentarArrayDisciplina(disciplinas);
		}
		disciplinas[qtdDisciplinas++] = new Disciplina(nomeDisciplina);
	}

	/**
	 * Adiciona a quantidade de horas gasta na disciplina, cujo o nome é igual ao
	 * recebido.
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @returns null
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		Disciplina disciplina = manipucalacaoArray.buscarDisciplina(disciplinas, nomeDisciplina);
		disciplina.cadastraHoras(horas);
	}

	/**
	 * Adiciona uma nova nota na posição desejada no array de notasda disciplina,
	 * cujo o nome é igual ao recebido.
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @param estagio
	 *            valor inteiro que representa a posição da nota no array de notas
	 *            da disciplina.
	 * @param valorNota
	 *            valor double que representa a nota obtida e que será cadastrada.
	 * @returns null
	 */
	public void cadastraNota(String nomeDisciplina, int estagio, double valorNota) {
		Disciplina disciplina = manipucalacaoArray.buscarDisciplina(disciplinas, nomeDisciplina);
		disciplina.cadastraNota(estagio, valorNota);
	}

	/**
	 * Verifica se o aluno foi aprovado na disciplina cujo nome é igual ao recebido.
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @returns valor boolean que indica se foi aprovado ou não na disiciplina.
	 */
	public boolean aprovado(String nomeDisciplina) {
		Disciplina disciplina = manipucalacaoArray.buscarDisciplina(disciplinas, nomeDisciplina);
		return disciplina.aprovado();
	}

	/**
	 * Retorna uma representação em string do estado da disciplina com o nome igual
	 * ao recebido;
	 * 
	 * @param nomeDisciplina
	 *            string que representa o nome da disciplina.
	 * @returns uma string que representado o estado da disciplina
	 */
	public String disciplinaToString(String nomeDisciplina) {
		Disciplina disciplina = manipucalacaoArray.buscarDisciplina(disciplinas, nomeDisciplina);
		return disciplina.toString();
	}

	/**
	 * Cria uma nova conta de contina com o nome recebido e adiciona ela no array de
	 * contas de contina. Se o array estiver cheio, chama um método para aumentar
	 * seu tam e depois add a nova conta;
	 * 
	 * @param nomeCantina
	 *            string que representa o nome da cantina.
	 * @returns null
	 */
	public void cadastraCantina(String nomeCantina) {
		if (qtdContasCantina >= contasCantina.length) {
			contasCantina = manipucalacaoArray.aumentarArrayCantina(contasCantina);
		}
		contasCantina[qtdContasCantina++] = new ContaCantina(nomeCantina);
	}

	/**
	 * Cadastra um novo lanche na conta de cantina que tem o nome igual ao recebido;
	 * 
	 * @param nomeCantina
	 *            string que representa o nome da cantina.
	 * @param qtdItens
	 *            representa a quantidade de itens comprados
	 * @param valorCentavos
	 *            representa o valor total da compra
	 * @returns null
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		ContaCantina conta = manipucalacaoArray.buscarCantina(contasCantina, nomeCantina);
		conta.cadastraLanche(qtdItens, valorCentavos);
	}

	/**
	 * Atualiza o valor da dívida da conta na cantina que tem o nome igual ao
	 * recebido.
	 * 
	 * @param nomeCantina
	 *            string que representa o nome da cantina.
	 * @param valorCentavos
	 *            representa o valor que será pago
	 * @returns null
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		ContaCantina conta = manipucalacaoArray.buscarCantina(contasCantina, nomeCantina);
		conta.pagaConta(valorCentavos);
	}

	/**
	 * Retorna uma representacao em string do estado da conta da cantina que tem
	 * nome igual ao recebido;
	 * 
	 * @param nomeCantina
	 *            string que representa o nome da cantina.
	 * @returns uma string com o estado da conta
	 */
	public String cantinaToString(String nomeCantina) {
		ContaCantina conta = manipucalacaoArray.buscarCantina(contasCantina, nomeCantina);
		if (conta != null)
			return conta.toString();
		return "Cantina nao encontrada! :(";
	}

	/**
	 * Atualiza o estado de saude mental do aluno.
	 * 
	 * @param valor
	 *            stirng que representa o estado atual da saude do aluno
	 * @returns null
	 */
	public void defineSaudeMental(String valor) {
		saude.defineSaudeMental(valor);
	}

	/**
	 * Atualiza o estado de saude fisica do aluno.
	 * 
	 * @param valor
	 *            stirng que representa o estado atual da saude do aluno
	 * @returns null
	 */
	public void defineSaudeFisica(String valor) {
		saude.defineSaudeFisica(valor);
	}

	/**
	 * Atualiza o emoji que representa o estado de espirito atual do aluno
	 * 
	 * @param valor
	 *            string que representa o emoji
	 * @returns null
	 */
	public void defineSaudeEmoji(String valor) {
		saude.definirEmoji(valor);
	}

	/**
	 * Retorna o estado da saude geral do aluno
	 * 
	 * @returns uma string que representa a saude geral do aluno
	 */
	public String geral() {
		return saude.geral();
	}
}