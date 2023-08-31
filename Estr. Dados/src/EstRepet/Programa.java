package EstRepet;


public class Programa {
    
    public static void menu(){    
        System.out.println("\n*** Menu ***");
        System.out.println("1 - Inserir na Fila");
        System.out.println("2 - Remover da Fila pelo modelo FIFO");
        System.out.println("3 - Remover da Fila pelo modelo LIFO");
        System.out.println("4 - Remover a partir de um num especifico");
        System.out.println("5 - Imprimir");    
        System.out.println("-1 - Sair\n");
    }
    
    public static void main(String[] args) {
        int opcao=0;
        Fila F = new Fila();
                
        while(opcao != -1){
            menu();
            opcao = Input.readInt("Digite a opcao: ");
            
            switch(opcao){
                case 1 -> F.insere();
                
                case 2 -> F.removefifo();

                case 3 -> F.removefilo();

                case 4 -> F.removeespc();
                
                case 5 -> F.imprime();
                
                case -1 -> System.out.println("\nSaindo...\n");            
            }            
        }
    }    
    
}
