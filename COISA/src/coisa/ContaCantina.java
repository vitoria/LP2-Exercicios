package coisa;

import java.util.Arrays;
/*
 * Representação de uma conta em uma determinada
 * cantina da UFCG. Cada conta possui o nome da lanchonete,
 * quantidade de itens vendido, o valor da dívida e também
 * pode conter uma breve descrição dos últimos 5 (cinco) 
 * lanches vendidos.
 * @author Vitória Heliane
 */
public class ContaCantina {
    
    private String nome;
    private int qtdItens;
    private int valorDivida;
    private String[] descLanche;
    private int qtdDescricao;
    /**
   * Constrói uma conta de cantina a partir do nome da lanchonete.
   * Toda conta é criada com os campos valor da dívida e quantidade 
   * de itens vendidos zerados. E o conjunto das descrições dos últimos
   * 5 (cinco) lanches vazio.
   *
    * @param nome nome da cantina no formato de String padrão
   */
    public ContaCantina(String nome){
        this.nome = nome;
        descLanche = new String[5];
        qtdDescricao = 0;
        qtdItens = 0;
        valorDivida = 0;
    }
    
    public void cadastraLanche(int qtdItens, int valorCentavos){
        this.qtdItens += qtdItens;
        valorDivida += valorCentavos;
    }
    
    public void cadastraLanche(int qtdItens, int valorCentavos, String descricao){
        this.qtdItens += qtdItens;
        valorDivida += valorCentavos;
        adicionaDescricao(descricao);
    }
    
    public String getNome(){
        return nome;
    }
    
    private void adicionaDescricao(String descricao){
        if (qtdDescricao < 5) {
            descLanche[qtdDescricao] = descricao;
        } else {
            for (int i = 0; i < 4; i++){
                descLanche[i] = descLanche[i+1];
            }
            descLanche[4] = descricao;
        }
        qtdDescricao++;
    }
    
    public void pagaConta(int valorCentavos){
        valorDivida -= valorCentavos;
    }
    
    public String toString(){
        return nome + " " + qtdItens + " " + valorDivida;
    }
    
    public String listarDetalhes(){
        return Arrays.toString(descLanche);
    }
}