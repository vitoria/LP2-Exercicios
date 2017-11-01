package coisa;

/*
 * Representação do registro de saúde de um
 * estudante do curso de CC da UFCG. Este registro
 * contém a situação da saúde mental e física do aluno e
 * também pode conter o estado de espírito atual dele, 
 * representado por um emoji.
 *
 * @author vitoriahpss
 */
public class Saude {
    
    private String saudeMental;
    private String saudeFisica;
    private String emoji;
    
  /*
   * Constrói um registro da saúde do aluno.
   * Todo registro começa com os campos saude mental e física
   * setados com o valor "boa".
   */
    public Saude(){
        saudeMental = "boa";
        saudeFisica = "boa";
        emoji = "";
    }
    
    public void defineSaudeMental(String valor){
        saudeMental = valor.toLowerCase();
        emoji = "";
    }
    
    public void defineSaudeFisica(String valor){
        saudeFisica = valor.toLowerCase();
        emoji = "";
    }
    
    public void definirEmoji(String emoji){
        this.emoji = emoji;
    }
    
    public String geral(){
        if (saudeMental.equals("fraca") && saudeFisica.equals("fraca"))
            return "fraca " + emoji;
        if (saudeMental.equals("boa") && saudeFisica.equals("boa"))
            return "boa " + emoji;
        return "ok " + emoji;
    }
}
