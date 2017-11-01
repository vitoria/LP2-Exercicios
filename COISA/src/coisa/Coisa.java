package coisa;

/**
 * @author vitoriahpss
 */
public class Coisa {

    public static void main(String[] args) {
//            ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");
//            contaLCC2.consomeEspaco(1999);
//            System.out.println(contaLCC2.atingiuCota());
//            contaLCC2.consomeEspaco(2);
//            System.out.println(contaLCC2.atingiuCota());
//            contaLCC2.liberaEspaco(1);
//            System.out.println(contaLCC2.atingiuCota());
//            contaLCC2.liberaEspaco(1);
//            System.out.println(contaLCC2.atingiuCota());
//            System.out.println(contaLCC2.toString());
//           
//            double[] pesos = {6, 4};
//            Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2, pesos);
//            prog2.cadastraHoras(4);
//            prog2.cadastraNota(1, 5.0);
//            prog2.cadastraNota(2, 6.0);
//            System.out.println(prog2.aprovado());
//            System.out.println(prog2.aprovado());
//            System.out.println(prog2.toString());
//           
//            ContaCantina mulherDoBolo = new ContaCantina("Mulher do Bolo");            
//            mulherDoBolo.cadastraLanche(2, 500, "blabla");
//            mulherDoBolo.cadastraLanche(1, 500, "glugluglu");
//            mulherDoBolo.cadastraLanche(3, 500, "xixixixi");
//            mulherDoBolo.cadastraLanche(4, 500, "kakakakak");
//            mulherDoBolo.cadastraLanche(5, 500, "kkkkkkkkk");
//            System.out.println(mulherDoBolo.listarDetalhes());
//            mulherDoBolo.cadastraLanche(5, 500, "Matheus");
//            System.out.println(mulherDoBolo.listarDetalhes());
//            mulherDoBolo.pagaConta(200);
//            System.out.println(mulherDoBolo.toString());
            Aluno a = new Aluno();
            a.cadastraCantina("bla");
            a.cadastraCantina("sgsd");
            a.cadastraCantina("dfsdf");
            a.cadastraCantina("fdsdfs");
            System.out.println(a.cantinaToString("fzfd"));
            Saude saude = new Saude();
            System.out.println(saude.geral());
            saude.defineSaudeMental("boa");
            saude.defineSaudeFisica("boa");
            System.out.println(saude.geral());
            saude.defineSaudeMental("fraca");
            saude.defineSaudeFisica("fraca");
            saude.definirEmoji("<(^_^<)");
            System.out.println(saude.geral());
            saude.defineSaudeMental("boa");
            saude.defineSaudeFisica("fraca");
            System.out.println(saude.geral());
    }
    
}
