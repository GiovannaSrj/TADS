package modelo;

import controle.AlunoC;

public class TrabAluno {
    public static void main(String[] args) throws Exception {

        /*
        gio.setRa(191542);
        gio.setCpf("082.201.061-58");
        gio.setNome("Giovanna");
        gio.setSexo('f');
        gio.setCodCurso(262);
        gio.setIdade(20);
         */


        AlunoM a = new AlunoM(191542, 20, "Giovanna", "08220106158", 'f', 262);
        AlunoM b = new AlunoM(15155, 0655, "ddddff", "dfefefef", 'm', 0544444);

       /*
        a.impAtributos();
        //b.impAtributos();
        //alterando idade
        a.setIdade(19);
        a.impAtributos();
       */ 
        //imprimindo campo específico
        System.out.println("\nCPF:"+a.getCpf());

        AlunoC controle = new AlunoC();
        controle.InsereAlunoM(a);
        controle.InsereAlunoM(b);
        controle.ListaGeralAlunoM();
        controle.BuscaPorRA(15155);
        controle.RemoveAlu(191542);
        

    }
}
