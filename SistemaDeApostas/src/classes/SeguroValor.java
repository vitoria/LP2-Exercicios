package classes;

import uteis.Validacao;

/**
 * Esta classe representa um seguro por valor
 * @author vitoria
 *
 */
public class SeguroValor implements Seguro{
	
	private int valor;

	/**
	 * Cria um novo seguro de acordo com o valor recebido
	 * @param valor valor do seguro
	 */
	public SeguroValor(int valor) {
		Validacao.validaInteiroPositivo("VALOR ASSEGURADO INVÁLIDO!", valor);
		this.valor = valor;
	}

	/**
	 * Acessador do valor
	 * @return valor do seguro
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Alterador do valor
	 * @param valor novo valor do valor do seguro
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public int valorAssegurado(int valorAposta) {
		return valor;
	}
	
	@Override
	public String toString() {
		return "(VALOR) - R$ " + String.format("%1$,.2f", (valor/100.00));
	}

}
