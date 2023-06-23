import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);

        Carro carros = new Carro ();

        String modelo;
        int anoFabricação, quilometrosRodados;


        System.out.println("===============================");
        System.out.println("\tCADASTRO DE VEICULOS");
        System.out.println("===============================");

        System.out.println("Informe o modelo do veiculo");
        modelo = leitor.nextLine();
        carros.setModelo(modelo);

        System.out.println("Informe o ano de fabricacao do veiculo");
        anoFabricação = leitor.nextInt();
        carros.setAnoFabricação(anoFabricação);

        System.out.println("Informe a quantidade de quilometros rodados do veiculo");
        quilometrosRodados = leitor.nextInt();
        carros.setQuilometrosRodados(quilometrosRodados);
  
    }

    String nomeArquivoDeTexto = new String();
    public ManipulaArquivoTxt(String nomeArquivo){
        this.nomeArquivoDeTexto = nomeArquivo;

            public Path caminhoArquivo(){
                Path arquivo = Paths.get("C:\\Users\\serej\\Desktop\\Carros"
                        + ""+this.nomeArquivoDeTexto+".txt");
                return (arquivo);
            }
            
            public void verificaArquivo(){
                Path arquivo = caminhoArquivo(); //recebe o caminho para o arquivo
                if (Files.exists(arquivo)){
                    System.out.println("CARRO JA CADASTRADO");
                }
                else{

                    System.out.println("Informe o fabricante do veiculo");


                    System.out.println("Informe o consumo do veiculo");

                    System.out.println("Inorme o valor do veiculo");
                    
                }
                
            }
            // Método que cria um arquivo de texto com o conteúdo de uma String recebida
            public void gravaArquivo(String meuTexto){
                // recebendo o caminho para o arquivo de texto a ser criado
                Path arquivo = caminhoArquivo();
                // Transformado o conteúdo do texto recebido em bytes
                byte[] textoBytes = meuTexto.getBytes();
                //Escrevendo no arquivo de texto o conteúdo recebido
                try{
                    Files.write(arquivo, textoBytes);
                }
                catch(Exception e){
                    System.out.println("Erro ao tentar escrever no arquivo: ");
                    System.out.println(e.getMessage());
                }         
            }
    
   
}
