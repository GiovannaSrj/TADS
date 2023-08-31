package encadeamento;
public class fila{
	
    public tipoNo cabeca;
    fila(){
        System.out.println("Criando fila...(construtor fila)");
    }
	
    
    public void insereInicio(int info){
        tipoNo novo;
        novo = new tipoNo();
        novo.setInfo(info);
        novo.setProx(cabeca);
        cabeca=novo;
    }

    public void insereFinal(int info){
        if(cabeca == null){
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        }else{
            tipoNo aux,novo;
			
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
	    }
		
		System.out.println("Elemento "+info+" inserido com sucesso! ");
    }
	
    
	
    public void removeInicio(){
        if(cabeca!=null){
            int valor=cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=cabeca.getProx();
	    }
    }
    
    public void removeFinal(){
        tipoNo aux=cabeca;
        
        if(aux==null){ //nao ha elemento
            System.out.println("Fila Vazia!");
        }else if(aux.getProx()==null){//um elemento
            cabeca=null; 
        }else{//mais de um elemento na fila
            while (aux.getProx().getProx() != null) 
                aux = aux.getProx();
            
            aux.setProx(null);
        }
        
    }

    public void removeEsc(int esc){
        tipoNo aux = cabeca;
        int cont=0;
        
        if(cabeca == null){
            System.out.println("Fila Vazia, operação inválida!");
            menu();
        }
        while (aux.getProx() != null) {
                aux = aux.getProx();
                cont++;
        }

        if(esc == 1){
            removeInicio();
        }else if(esc > cont){
            System.out.println("Posição Inválida!");
            menu();
        }else{
            for (int i=0; i<esc -2; i++){
                aux = aux.getProx();
           
             }
            if(aux.getProx() == null){

                System.out.println("Posição inválida!");
            }else{

                aux.setProx(aux.getProx().getProx());
                

            }
        }
    }


    public void insereEsc(int esc){
        tipoNo aux = cabeca;
        tipoNo aux2 = cabeca;
        int cont = 0;

        if(cabeca == null){
            System.out.println("Fila Vazia, operação inválida!");
            menu();
        }
        while (aux.getProx() != null) {
                aux = aux.getProx();
                cont++;
        }

        tipoNo valor = new tipoNo();
        int vlr = Input.readInt("Valor a inserir: ");
        valor.setInfo(vlr);
        if(esc == 1){
            insereInicio(vlr);

        }else if(esc > cont){
            
            System.out.println("Posição Inválida!");

        }else{
            for (int i=0; i<esc -2; i++){
                aux = aux.getProx();
            }
            if(aux.getProx() == null){
                System.out.println("Posição inválida!");
            }else{
                
                aux2 = aux.getProx();
                aux.setProx(valor);
                aux.getProx().setProx(aux2);

            }
        }

    }
	
    public void imprime(){
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }
	
    public void menu(){
        int valor,opcao=0, esc;
	    System.out.print("\n------------ Menu ------------\n");
	    while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Insere na posição esolhida \n(7) Remove a posição escolhida \n(-1) Sair \nOpcao: ");
            switch(opcao){
			
                case 1: //insereInicio
                    valor = Input.readInt("Valor: ");
                    insereInicio(valor);
                    break;
                    
                case 2: //insereFinal
                    valor = Input.readInt("Valor: ");
                    insereFinal(valor);
                    break;
                        
                case 3: //removeInicio
                    removeInicio();
                    break;
                        
                case 4: //removeFinal
                    removeFinal();
                    break;
                        
                case 5: //imprime
                    imprime();
                    break;

                case 6:
                    esc = Input.readInt("Informe a posição escolhida para adcionar:");
                    insereEsc(esc);
                    
                    break;

                case 7:
                    esc = Input.readInt("Informe a posição escolhida ppara remover:");
                    removeEsc(esc);
                    break;
                        
                case -1: //sair
                    System.out.println("Saindo!");
                    break;
                        
                default:
                    System.out.println("Opcao invalida!");
                    break;
                
            }
		
	    }
    }

    public static void main(String args[]){
        System.out.println("\n************ Lista Encadeada Din�mica ************\n");
	    fila F = new fila();
	    F.menu();
	    System.out.println("\n************ Fim programa ************\n");
    }
}