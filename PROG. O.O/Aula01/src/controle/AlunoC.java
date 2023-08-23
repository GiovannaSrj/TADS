package controle;

import java.util.ArrayList;
import modelo.AlunoM;

public class AlunoC {
    public ArrayList<AlunoM> vetAluno;

    //metodo construtor
    public AlunoC(){
        //AO criar Objeto AlunoC, instancia a proxima posição para armazenar um novo objeto
        vetAluno = new ArrayList<AlunoM>();

    }

    //CADASTRO DE OBJETOS AlunoM
    public void InsereAlunoM(AlunoM aluno){
        vetAluno.add(aluno);
    }
    public void ListaGeralAlunoM(){
        for(AlunoM dados: vetAluno){
            dados.impAtributos();
        }
    }

    public void BuscaPorRA(int ra){
        for(int i=0; i < vetAluno.size(); i++){
            if(ra == vetAluno.get(i).getRa()){

                System.out.println(" "+vetAluno.get(i).getRa());
            }
        }
    }

    public void RemoveAlu (int ra){
        for(int i=0; i < vetAluno.size(); i++){
            if(ra == vetAluno.get(i).getRa()){
                vetAluno.remove(i);
            }
        }
    }

    
    
}
