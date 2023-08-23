package EstRepet;


import java.util.Scanner;

public class Fila {
    public Pessoa vPessoa[];
    public int qtdPessoa;
    public static int i;
    public static int vet [] = new int [12];

        static Scanner leitor = new Scanner(System.in);

    
    public Fila(){
        int tam = Input.readInt("Digite o tamanho do vetor: ");
        vPessoa = new Pessoa[tam];
    }

    public void insere(){
        if(qtdPessoa<vPessoa.length){
            vPessoa[qtdPessoa++]= new Pessoa();            
            System.out.println("Inserção concluída");
        }
        else
            System.out.println("Vetor sem espaço!");
    }

    public void removefifo(){
        if(qtdPessoa>0){
            for(int i=0;i<qtdPessoa;i++){
                vPessoa[i] = vPessoa[i+1];   
            }
            i--;
            System.out.println("Remoção Concluída!");
        }else{
            System.out.println("Vetor vazio!");
        }
    }

    public void removefilo(){
        if(qtdPessoa>0){
            qtdPessoa--;
            System.out.println("Remoção concluída");
        }else{
            System.out.println("Vetor vazio!");
        }
    }

    public void removeespc(){
        System.out.println("Informe a posição que deseja remover:");
        int pos = leitor.nextInt();
        if(qtdPessoa>0){
            for(int i = pos;i<qtdPessoa;i++)
                vPessoa[i-1] = vPessoa[i];   
            qtdPessoa--;
            System.out.println("Remoção concluída!");
        }else{
            System.out.println("Vetor vazio!");
        }
    }

    public void imprime(){
        for(int i=0;i<qtdPessoa;i++){
            vPessoa[i].imprime();
        }            
    }
}
