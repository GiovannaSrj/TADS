package Aluno;

import controle.AlunoC;
import modelo.AlunoM;
import modelo.CursoM;
import modelo.AlunoPosGradeM;

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
        CursoM tads = new CursoM("tads", 'n', 6,1000,200);
        CursoM engC = new CursoM("EngComput", 'M', 8, 3000, 300);


        AlunoM a = new AlunoM(191542, 20, "Giovanna", "08220106158", 'f', 262, tads);
        AlunoM b = new AlunoM(1514455, 55, "ddddff", "dfefefef", 'm', 054, engC);

        AlunoPosGradeM aluno1 = new AlunoPosGradeM (5555, 20, "joao", "016656565654", 'm', 88, engC, "maria", 's', 2023, 2025, 'f');

        //a.impAtributos();
        //b.impAtributos();
        //alterando idade
        //a.setIdade(19);
        //a.impAtributos();
       
        //imprimindo campo específico
        //System.out.println("\nCPF:"+a.getCpf());

        AlunoC controle = new AlunoC();
        //controle.InsereAlunoM(a);
        //controle.InsereAlunoM(b);
        //controle.ListaGeralAlunoM();
        aluno1.ImprimiPosGradeM();
        

    }
}
