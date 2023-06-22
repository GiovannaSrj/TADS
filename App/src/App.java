import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);
        Random aleatorio = new Random();
        ArrayList<Integer> sorteio = new ArrayList<>();
        Random aleatorioSorteio = new Random();
        List<List<Integer>> TdsJogos = new ArrayList<>();
        int nJogos, j;
        int numTemp;

        System.out.println("================================================");
        System.out.println("\t\tMEGA SENA");
        System.out.println("================================================\n\n");
        
        

        System.out.println("================================================");
        System.out.println("\t\tMENU LANÇAR JOGOS");
        System.out.println("================================================");
        System.out.println("\nInforme quantos jogos serão lançados:");
        nJogos = leitor.nextInt();

        System.out.println("Informe a forma que deseja realizar o preenchimento dos números:");
        System.out.println("1 - Modo Manual");
        System.out.println("2 - Modo Aleatório e Automático");
        int opc01 = leitor.nextInt();

        switch(opc01){
            case 1:
                for(int i=0; i<nJogos; i++){
                    ArrayList<Integer> Num = new ArrayList<>();

                    System.out.printf("\nInforme os números a serem lançados no jogo %d\n\n",i+1);
                    for(j =0; j<6; j++){
                        System.out.printf("\nInforme o %d número: ", j+1);
                        numTemp = leitor.nextInt();
                        if(numTemp > 60 || numTemp < 0){
                            System.out.println("Número inválido! São permitidos apenas valores inteiros do 1 ao 60.");
                            j--;
                            continue;
                        }
                        if(Num.contains(numTemp)){
                            System.out.println("Número repetido! Informe um novo valor.");
                            j--;
                            continue;  
                        }
                        //add numero jogado depois de verificado
                        Num.add(numTemp);
                    }
                    Collections.sort(Num);
                    TdsJogos.add(Num);

                }
            break;
            case 2:
            for(int i=0; i<nJogos; i++){
                ArrayList<Integer> Num = new ArrayList<>();

                for(j = 0; j<6; j++){
                    numTemp = aleatorio.nextInt(60) + 1;
                    if(Num.contains(numTemp)){
                        j--;
                        continue;  
                    }
                    Num.add(numTemp);
                }
                Collections.sort(Num);
                TdsJogos.add(Num);
            }
            break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
            break;
            
        }
    
        //gerando os valores do sorteio
        for(int i=0; i<6; i++){
           int numSorteio = aleatorioSorteio.nextInt(60) + 1;
           if(sorteio.contains(numSorteio)){
            i--;
           }
           sorteio.add(numSorteio);
        }

    }

    
    public static void ArqTxt(){
        try {
            BufferedWriter Escrever = new BufferedWriter(new FileWriter("Lancados.txt"));
            for (int num : listanum) {
                Escrever.write(elemento);
                Escrever.newLine();
            }

            //FOR JOGOS E FOR NUMEROS
            Escrever.close();
            System.out.println("ArrayList gravado com sucesso no arquivo.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }

}
