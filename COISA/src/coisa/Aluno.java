/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisa;

/*
 * Representação de um aluno da UFCG, especificamente
 * do Curso Ciência da Computação. Todo aluno tem um
 * conjunto de disciplinas, contas em cantinas e laboratórios,
 * além de possuir um registro acerca da sua saúde física e mental.
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
    /**
   * Constrói um aluno recebendo nenhuma informação por parâmetro.
   * Todo aluno é criado com os conjuntos des disciplinas e contas de
   * laboratório e cantina vazios. E o registro da sua saúde no padrão.
   */
    public Aluno(){
        qtdContasLab = 0;
        qtdContasCantina = 0;
        qtdDisciplinas = 0;
        contasLab = new ContaLaboratorio[10];
        contasCantina = new ContaCantina[10];
        disciplinas = new Disciplina[10];
        saude = new Saude();
    }	
    /**
    * Retorna a String que representa o aluno. 
    *
   * @returns a representação em String de um aluno.
   */
    public void cadastraLaboratorio(String nomeLaboratorio){
        if(qtdContasLab >= contasLab.length)
            aumentarArrayLab();
        contasLab[qtdContasLab++] = new ContaLaboratorio(nomeLaboratorio);
    }
    
    public void cadastraLaboratorio(String nomeLaboratorio, int cota){
        if(qtdContasLab >= contasLab.length)
            aumentarArrayLab();
        contasLab[qtdContasLab++] = new ContaLaboratorio(nomeLaboratorio, cota);
    }

    private void aumentarArrayLab(){
        ContaLaboratorio[] newContas = new ContaLaboratorio[contasLab.length+1];
        for (int i = 0; i < contasLab.length; i++){
            newContas[i] = contasLab[i];
        }
        contasLab = newContas;
    }

    private void aumentarArrayCantina(){
        ContaCantina[] newContas = new ContaCantina[contasCantina.length+1];
        for (int i = 0; i < contasCantina.length; i++){
            newContas[i] = contasCantina[i];
        }
        contasCantina = newContas;
    }
    
    private void aumentarArrayDisciplina(){
        Disciplina[] newContas = new Disciplina[disciplinas.length+1];
        for (int i = 0; i < disciplinas.length; i++){
            newContas[i] = disciplinas[i];
        }
        disciplinas = newContas;
    }
        
    public void consomeEspaco(String nomeLaboratorio, int mbytes){
        ContaLaboratorio conta = buscarLab(nomeLaboratorio);
        if(conta != null){
            conta.consomeEspaco(mbytes);
        }
    }
    
    public void liberaEspaco(String nomeLaboratorio, int mbytes){
        ContaLaboratorio conta = buscarLab(nomeLaboratorio);
        if(conta != null){
            conta.liberaEspaco(mbytes);
        }
    }
    
    public boolean atingiuCota(String nomeLaboratorio){
        ContaLaboratorio conta = buscarLab(nomeLaboratorio);
        if(conta != null){
            return conta.atingiuCota();
        }
        return false;
    }
    
    public String laboratorioToString(String nomeLaboratorio){
        ContaLaboratorio conta = buscarLab(nomeLaboratorio);
        if(conta != null) return conta.toString();
        return "Laboratorio nao encontrado! :(";
    }
    
    public ContaLaboratorio[] getContasLaboratorio(){
        return contasLab;
    }
    
    private ContaLaboratorio buscarLab(String nomeLab){
        for(ContaLaboratorio conta : contasLab){
            if(conta == null) break;
            if(conta.getNome().equals(nomeLab)) return conta;
        }
        return null;
    }
    
    public void cadastraDisciplina(String nomeDisciplina){
        if(qtdDisciplinas >= disciplinas.length){
            aumentarArrayDisciplina();
        }
        disciplinas[qtdDisciplinas++] = new Disciplina(nomeDisciplina);
    }
    
    public void cadastraHoras(String nomeDisciplina, int horas){
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        disciplina.cadastraHoras(horas);
    }
    
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota){
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        disciplina.cadastraNota(nota, valorNota);
    }
    
    public boolean aprovado(String nomeDisciplina){
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        return disciplina.aprovado();
    }
    
    public String disciplinaToString(String nomeDisciplina){
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);
        return disciplina.toString();
    }
    
    private Disciplina buscarDisciplina(String nomeDisciplina){
        for(Disciplina disciplina : disciplinas){
            if(disciplina == null) break;
            if(disciplina.getNome().equals(nomeDisciplina)){
                return disciplina;
            }
        }
        return null;
    }
    
    public void cadastraCantina(String nomeDisciplina){
        if(qtdContasCantina >= contasCantina.length){
            aumentarArrayCantina();
        }
        contasCantina[qtdContasCantina++] = new ContaCantina(nomeDisciplina);
    }
    
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos){
        ContaCantina conta = buscarCantina(nomeCantina);
        conta.cadastraLanche(qtdItens, valorCentavos);
    }
    
    public void pagarConta(String nomeCantina, int valorCentavos){
        ContaCantina conta = buscarCantina(nomeCantina);
        conta.pagaConta(valorCentavos);
    }
    
    public String cantinaToString(String nomeCantina){
        ContaCantina conta = buscarCantina(nomeCantina);
        if(conta != null) return conta.toString();
        return "Cantina nao encontrada! :(";
    }
    
    private ContaCantina buscarCantina(String nomeCantina){
        for(ContaCantina conta : contasCantina){
            if (conta == null) break;
            if(conta.getNome().equals(nomeCantina)) return conta;
        }
        return null;
    }
    
    public void defineSaudeMental(String valor){
        saude.defineSaudeMental(valor);
    }
    
    public void defineSaudeFisica(String valor){
        saude.defineSaudeFisica(valor);
    }
    
    public void defineSaudeEmoji(String valor){
        saude.definirEmoji(valor);
    }
    public String geral(){
        return saude.geral();
    }   
}