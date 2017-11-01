package coisa;

import java.util.Arrays;

/*
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
   * Constrói uma disciplina a partir do nome dela.
   * Toda disciplina começa com 0 (zero) horas trabalhadas e
   * com o conjunto de notas com 4 (quatro) elementos.
   *
    * @param nome nome da disciplina no formato de String padrão
   */
    public Disciplina(String nome){
        this.nome = nome;
        horasTrabalhadas = 0;
        notas = new double[4];
    }
    
   /**
   * Constrói uma disciplina a partir do nome dela e da
   * quantidade de notas que ela irá conter.
   * Toda disciplina começa com 0 (zero) horas trabalhadas
   *
    * @param nome nome da disciplina no formato de String padrão
    * @param quantidadeNotas quantidade de notas do tipo inteiro
   */
    public Disciplina(String nome, int quantidadeNotas){
        this.nome = nome;
        horasTrabalhadas = 0;
        notas = new double[quantidadeNotas];
    }

   /**
   * Constrói uma disciplina a partir do nome dela, da
   * quantidade de notas que ela irá conter e do conjunto de
   * pesos para cada uma das notas.
   * Toda disciplina começa com 0 (zero) horas trabalhadas
   *
    * @param nome nome da disciplina no formato de String padrão
    * @param quantidadeNotas quantidade de notas do tipo inteiro
    * @param pesos pesos que serão atribuidos para cada nota respectivamente.
   */
    public Disciplina(String nome, int numNotas, double[] pesos){
        this.nome = nome;
        horasTrabalhadas = 0;
        notas = new double[numNotas];
        this.pesos = pesos;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void cadastraHoras(int horas){
        horasTrabalhadas += horas;
    }
    
    public void cadastraNota(int nota, double valorNota){
        notas[nota-1] = valorNota;
    }
    
    public boolean aprovado(){
        if(calculaMedia() < 7) return false;
        return true;
    }
    
    public double calculaMedia(){
        double soma = 0;
        double media;
        if (pesos == null){
            for(double nota : notas){
                soma += nota;
            }
            media = soma/notas.length;
        } else {
            for(int i = 0; i < notas.length; i++){
                soma += (notas[i] * pesos[i]);
            }
            media = soma/10;
        }
        return media;
    }
    
    public String toString(){
        return nome + " " + horasTrabalhadas +
                " " + calculaMedia() +
                " " + Arrays.toString(notas);
    }
}