import java.util.Scanner;

public class Menus {

    Scanner leitor = new Scanner(System.in);
    
    int num;
    boolean mesass [] = new boolean [11];
    String [][] pratos = new String[27][1];
    float [][] infPratos = new float [27][12];
    float [] Total = new float [11];
    int mesa, cont, opc, soma = 0, mesaEscolhida, codigoEscolhido, quantDesejada, i;
    void MenuInicial(){
        System.out.println("============================================");
        System.out.println("\t\tMENU INICIAL");
        System.out.println("============================================");
        System.out.println("1. Abrir mesa\n2. Verificar mesa\n3. Fechar mesa\n4. Finalizar programa");
        System.out.println("Informe uma opção:");
        num = leitor.nextInt();
        
        
        switch (num) {
            case 1:
                ConsultMesas();
                break;
            case 2:
                MenuVerificarMesa();
                break;
            case 3:
                MenuFecharMesa();
                break; 
            case 4:
                leitor.close();      
        }
    }
    void ConsultMesas(){
        System.out.println("\n============================================");
        System.out.println("\n\n\tMESAS DISPONIVEIS:\n");
        for(i=1;i<11;i++){
            if (mesass[i] == false){
                System.out.printf("%d - ", i);
            }

          if(mesass[i] == true){
            soma += 1;
          }

          if(soma == 10){
            System.out.println("Nenhuma mesa disponível");
            MenuInicial();
          }  
        }
        MenuAbrirMesa();
    }

    
    void MenuAbrirMesa(){
        leitor.nextLine();
        System.out.println("\n============================================");
        System.out.println("\t1. MENU ABRIR MESA");
        System.out.println("============================================");
        System.out.println("1. Indicar uma mesa para ser aberta\n2. Retornar ao Menu Incial");
        System.out.println("Informe uma opção:");
        num = leitor.nextInt();

        switch (num) {
            case 1:
                System.out.println("Informe o número da mesa que deseja abrir:");
                mesaEscolhida = leitor.nextInt();
                if (mesass[mesaEscolhida] == true){
                    System.out.println("MESA INDISPONÍVEL!");
                    ConsultMesas();
                }
                if (mesass[mesaEscolhida] == false){
                    mesass[mesaEscolhida] = true;
                    System.out.printf("MESA %d ABERTA!\n", mesaEscolhida);
                    MenuInicial();
                }
                break;
            case 2:
                MenuInicial();
                break;
        }
    }
    void MenuVerificarMesa(){
        System.out.println("============================================");
        System.out.println("\t2. MENU VERIFICAR MESA");
        System.out.println("============================================");
        System.out.println("1. Informe o número da mesa\n2. Retornar ao Menu inicial");
        System.out.println("Informe uma opção:");
        num = leitor.nextInt();
        
        switch(num){
            case 1:
                System.out.println("Mesas Abertas: ");
                for(int i=1; i<11; i++){
                    if(mesass[i] == true){
                        System.out.print(i + " - ");
                    }
                }
                System.out.println("\n\nInforme o número da mesa ou digite 0 para retornar ao menu anterior.");
                mesaEscolhida = leitor.nextInt();
                
                if (mesass[mesaEscolhida] == false){
                    System.out.println("MESA INVÁLIDA");
                    MenuVerificarMesa();
                }
                if (mesaEscolhida == 0){
                    MenuVerificarMesa();
                }

                if(mesass[mesaEscolhida] == true){
                    MenuInfNumMesa();
                }
                break;
            
            case 2:
                MenuInicial();
                break;    
        }
            
    }
    
    void MenuInfNumMesa(){
        System.out.println("============================================");
        System.out.println("\t\t MENU MESA "+mesaEscolhida);
        System.out.println("============================================");
        System.out.println("1. Fazer pedido de item do cardápio\n2. Cancelar pedido de item do cardápio\n3. Verificar itens pedidos\n4. Retornar ao Menu Inicial");
        System.out.println("Informe uma opção:");
        num = leitor.nextInt();

        switch(num){
            case 1:
                FazerPedido();
                break;
            case 2:
                CancelarPedido();
                break;
            case 3:
                VerificarPedido();
                System.out.println("\n\nPressione uma tecla para  retornar ao Menu Inicial");
                leitor.nextLine();
                leitor.nextLine();
                MenuInicial();

                break;
            case 4:
                MenuInicial();
            break;
        }
    }
    void FazerPedido(){
        System.out.println("Digite o código do item do cardápio ou informe 0 para retornar ao menu anterior:");
        codigoEscolhido = leitor.nextInt();
            if(codigoEscolhido == 0){
                MenuInfNumMesa();
            }
            else{
                Cardápio();
                FazerPedido();
            }

      
    }
    void Pedido(){
        System.out.println("------------------------------------");
        System.out.println("Este é o item que deseja?");
        System.out.println("1. Sim\n2. Não");
        num = leitor.nextInt();
        switch (num){
            case 1:
                System.out.println("Informe a quantidade desejada:");
                quantDesejada = leitor.nextInt();
                Quantidade();
            break;
            
            case 2:
                FazerPedido();
            break;
        }       
    }
    float ValorTotal;
    void VerificarPedido(){
        Total[mesaEscolhida] = 0;
        System.out.println("============================================");
        System.out.println("\tITENS PEDIDOS MESA "+ mesaEscolhida);
        System.out.println("============================================");                
        System.out.println("Código                Prato                Quant                Valor          Total Item");
        for(i=0; i<27; i++){
            if(infPratos[i][mesaEscolhida + 2] != 0){
            ValorTotal = infPratos[i][1] * infPratos[i][(mesaEscolhida + 2)];
            Total[mesaEscolhida] += ValorTotal;
            System.out.printf("\n%.0f                %27s               %10.0f               %10.2f               R$%10.2f", infPratos[i][0], pratos[i][0], infPratos[i][(mesaEscolhida + 2)], infPratos[i][1], ValorTotal);
            }

        } 
        System.out.printf("\n\nTotal: R$%.2f", Total[mesaEscolhida]);

    }

    void MenuFecharMesa(){
        System.out.println("============================================");
        System.out.println("\t3. MENU FECHAR MESA");
        System.out.println("============================================");
        System.out.println("1.Informar mesa que deseja fechar.\n2. Retornar ao Menu Inicial");
        num = leitor.nextInt();
        
        switch(num){
            case 1:
            System.out.println("Mesas Abertas: ");
            for(int i=1; i<11; i++){
                if(mesass[i] == true){
                    System.out.print(i + " - ");
                 }
             }
                System.out.println("\n\nInforme o número da mesa que deseja fechar ou informe 0 para retornar ao menu anterior");
                mesaEscolhida = leitor.nextInt();
                if (mesaEscolhida == 0){
                    MenuFecharMesa();
                }
                if(mesass[mesaEscolhida] == false){
                    System.out.println("Mesa inválida");
                    MenuFecharMesa();
                }
                if(mesass[mesaEscolhida]==true){
                    System.out.printf("Tem certeza que deseja fechar a mesa %d?", mesaEscolhida);
                    System.out.println("\n1. Sim\n2. Não");
                    int opFechar = leitor.nextInt();
                    switch(opFechar){
                        case 1:
                        System.out.printf("Mesa %d Fechada!\n\n", mesaEscolhida);
                        mesass[mesaEscolhida] = false;
                        VerificarPedido();
                        MenuInicial();

                        LimpaMesa();
                    }
                }
                
            break;
        }
    }

    void LimpaMesa(){
        for(i = 0; i<27; i++){
            infPratos[i][mesaEscolhida +2] = 0;
        }
        Total[mesaEscolhida] = 0;

    }
 
    void Quantidade(){

        switch(codigoEscolhido){
            case 101:
                infPratos[0][mesaEscolhida + 2] += quantDesejada;
                FazerPedido();
                break;
            case 102:
            infPratos[2][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 103:
            infPratos[3][mesaEscolhida + 2] += quantDesejada;                
            FazerPedido();
            break;
            case 104:
            infPratos[4][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 105:
            infPratos[4][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 106:
            infPratos[5][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 107:
            infPratos[6][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 108:
            infPratos[7][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 109:
            infPratos[8][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 110:
            infPratos[9][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 201:
            infPratos[10][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 202:
            infPratos[11][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 203:
            infPratos[12][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 204:
            infPratos[13][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 205:
            infPratos[14][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 206:
            infPratos[15][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 207:
            infPratos[16][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 301:
            infPratos[17][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 302:
            infPratos[18][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 303:
            infPratos[19][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 401:
            infPratos[20][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 402:
            infPratos[21][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 403:
            infPratos[22][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 404:
            infPratos[23][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 405:
            infPratos[24][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 406:
            infPratos[25][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
            case 407:
            infPratos[26][mesaEscolhida + 2] += quantDesejada;
            FazerPedido();
                break;
        }
    }

    void Cardápio(){
        pratos[0][0] = "Filé de frango grelhado";
        pratos[1][0] = "Iscas de frango";
        pratos[2][0] = "Iscas de carne ";
        pratos[3][0] = "Bife acebolado";
        pratos[4][0] = "Filé de frango grelhado";
        pratos[5][0] = "Filé de frango a milanesa";
        pratos[6][0] = "Caesar salad";
        pratos[7][0] = "Espaguete ao alho e óleo";
        pratos[8][0] = "Panqueca de carne";
        pratos[9][0] = "Panqueca de queijo";
        pratos[10][0] = "Suco de laranja (500 ml)";
        pratos[11][0] = "Suco de abacaxi (500 ml)";
        pratos[12][0] = "Suco de maracujá (500 ml)";
        pratos[13][0] = "Água (500 ml)";
        pratos[14][0] = "Coca-Cola (350 ml)";
        pratos[15][0] = "Guaraná Antártica (350 ml)";
        pratos[16][0] = "Fanta (350 ml)";
        pratos[17][0] = "Fatia de pudim";
        pratos[18][0] = "Fatia cheesecake";
        pratos[19][0] = "Bola de sorvete";
        pratos[20][0] = "Calabresa acebolada";
        pratos[21][0] = "Frango a passarinho";
        pratos[22][0] = "Batata frita";
        pratos[23][0] = "Porção extra de arroz ";
        pratos[24][0] = "Porção extra de feijão";
        pratos[25][0] = "Adicional de ovo frito";
        pratos[26][0] = "Adicional de fatia de bacon";
        
        infPratos[0][0] = 101f;
        infPratos[1][0] = 102f;
        infPratos[2][0] = 103f;
        infPratos[3][0] = 104f;
        infPratos[4][0] = 105f;
        infPratos[5][0] = 106f;
        infPratos[6][0] = 107f;
        infPratos[7][0] = 108f;
        infPratos[8][0] = 109f;
        infPratos[9][0] = 110f;
        infPratos[10][0] = 201f;
        infPratos[11][0] = 202f;
        infPratos[12][0] = 203f;
        infPratos[13][0] = 204f;
        infPratos[14][0] = 205f;
        infPratos[15][0] = 206f;
        infPratos[16][0] = 207f;
        infPratos[17][0] = 301f;
        infPratos[18][0] = 302f;
        infPratos[19][0] = 303f;
        infPratos[20][0] = 401f;
        infPratos[21][0] = 402f;
        infPratos[22][0] = 403f;
        infPratos[23][0] = 404f;
        infPratos[24][0] = 405f;
        infPratos[25][0] = 406f;
        infPratos[26][0] = 407f;

        infPratos[0][1] = 16.50f;
        infPratos[1][1] = 22.35f;
        infPratos[2][1] = 22.35f;
        infPratos[3][1] = 26.99f;
        infPratos[4][1] = 28.99f;
        infPratos[5][1] = 35.50f;
        infPratos[6][1] = 16.50f;
        infPratos[7][1] = 15.00f;
        infPratos[8][1] = 19.99f;
        infPratos[9][1] = 19.99f;
        infPratos[10][1] = 7.00f;
        infPratos[11][1] = 7.00f;
        infPratos[12][1] = 7.00f;
        infPratos[13][1] = 4.50f;
        infPratos[14][1] = 5.50f;
        infPratos[15][1] = 5.50f;
        infPratos[16][1] = 5.50f;
        infPratos[17][1] = 8.90f;
        infPratos[18][1] = 12.00f;
        infPratos[19][1] = 5.50f;
        infPratos[20][1] = 35.00f;
        infPratos[21][1] = 40.00f;
        infPratos[22][1] = 22.50f;
        infPratos[23][1] = 5.00f;
        infPratos[24][1] = 5.00f;
        infPratos[25][1] = 3.99f;
        infPratos[26][1] = 3.99f;


        switch(codigoEscolhido){
            case 101:
                System.out.println("- "+pratos[0][0]);
                Pedido();
                break;
            case 102:
                System.out.println("- "+pratos[1][0]);
                Pedido();
                break;
            case 103:
                System.out.println("- "+pratos[2][0]);
                Pedido();
                break;
            case 104:
                System.out.println("- "+pratos[3][0]);
                Pedido();
                break;
            case 105:
                System.out.println("- "+pratos[4][0]);
                Pedido();
                break;
            case 106:
                System.out.println("- "+pratos[5][0]);
                Pedido();
                break;
            case 107:
                System.out.println("- "+pratos[6][0]);
                Pedido();
                break;
            case 108:
                System.out.println("- "+pratos[7][0]);
                Pedido();
                break;
            case 109:
                System.out.println("- "+pratos[8][0]);
                Pedido();
                break;
            case 110:
                System.out.println("- "+pratos[9][0]);
                Pedido();
                break;
            case 201:
                System.out.println("- "+pratos[10][0]);
                break;
            case 202:
                System.out.println("- "+pratos[11][0]);
                Pedido();
                break;
            case 203:
                System.out.println("- "+pratos[12][0]);
                Pedido();
                break;
            case 204:
                System.out.println("- "+pratos[13][0]);
                Pedido();
                break;
            case 205:
                System.out.println("- "+pratos[14][0]);
                Pedido();
                break;
            case 206:
                System.out.println("- "+pratos[15][0]);
                Pedido();
                break;
            case 207:
                System.out.println("- "+pratos[16][0]);
                Pedido();
                break;
            case 301:
                System.out.println("- "+pratos[17][0]);
                Pedido();
                break;
            case 302:
                System.out.println("- "+pratos[18][0]);
                Pedido();
                break;
            case 303:
                System.out.println("- "+pratos[19][0]);
                Pedido();
                break;
            case 401:
                System.out.println("- "+pratos[20][0]);
                Pedido();
                break;
            case 402:
                System.out.println("- "+pratos[21][0]);
                Pedido();
                break;
            case 403:
                System.out.println("- "+pratos[22][0]);
                Pedido();
                break;
            case 404:
                System.out.println("- "+pratos[23][0]);
                Pedido();
                break;
            case 405:
                System.out.println("- "+pratos[24][0]);
                Pedido();
                break;
            case 406:
                System.out.println("- "+pratos[25][0]);
                Pedido();
                break;
            case 407:
                System.out.println("- "+pratos[26][0]);
                Pedido();
                break;  
            default:
                System.out.println("CÓDIGO INVÁLIDO!");
                MenuInfNumMesa();
                break;     
        }
    }

    int CancelarItem, quantidade;
    void CancelarPedido(){
        for(i=0; i<27; i++){
            if(infPratos[i][(mesaEscolhida + 2)] != 0){
                System.out.printf("\n%10.0f                %25s                %10.0f", infPratos[i][0], pratos[i][0], infPratos[i][(mesaEscolhida + 2)] );
            }        
        }
        System.out.println("\nQual o código do item que deseja excluir?");
        CancelarItem= leitor.nextInt(); 
        Cancelar();

    }

    void Cancelar(){
        switch(CancelarItem){
            case 101:
                if(infPratos[0][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[0][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[0][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO");
                            MenuInfNumMesa();     
                        }
                        infPratos[0][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[0][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 102:
                if(infPratos[1][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[1][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[1][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[1][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[1][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 103:
                if(infPratos[2][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[2][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[2][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[2][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[2][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 104:
                if(infPratos[3][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[3][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[3][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[3][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[3][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 105:
                if(infPratos[4][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[4][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[4][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[4][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[4][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 106:
                if(infPratos[5][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[5][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[5][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[5][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[5][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 107:
                if(infPratos[6][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[6][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[6][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[6][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[6][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 108:
                if(infPratos[7][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[7][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[7][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[7][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[7][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 109:
                if(infPratos[8][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[8][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[8][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[8][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[8][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 110:
                if(infPratos[9][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[9][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[9][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[9][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[9][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 201:
                if(infPratos[10][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[10][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[10][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[10][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[10][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 202:
                if(infPratos[11][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[11][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[11][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[11][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[11][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 203:
                if(infPratos[12][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[12][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[12][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[12][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[12][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 204:
                if(infPratos[13][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[13][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[13][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[13][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[13][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 205:
                if(infPratos[14][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[14][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[14][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[14][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[14][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 206:
                if(infPratos[15][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[15][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[15][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[15][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[15][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 207:
                if(infPratos[16][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[16][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[16][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[16][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[16][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 301:
                if(infPratos[17][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[17][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[17][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[17][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[17][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 302:
                if(infPratos[18][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[18][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[18][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[18][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[18][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 303:
                if(infPratos[19][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[19][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[19][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[19][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[19][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 401:
                if(infPratos[20][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[20][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[20][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[20][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[20][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 402:
                if(infPratos[21][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[21][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[21][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[21][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[21][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 403:
                if(infPratos[22][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[22][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[22][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[22][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[22][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 404:
                if(infPratos[23][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[23][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[23][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[23][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[23][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 405:
                if(infPratos[24][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[24][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[24][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[24][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[24][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 406:
                if(infPratos[25][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[25][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[25][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[25][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[25][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            case 407:
                if(infPratos[26][(mesaEscolhida + 2)] > 1){      
                    System.out.printf("Quantos pedidos de %s deseja cancelar?", pratos[26][0]);
                    quantidade = leitor.nextInt();
                        if(quantidade > infPratos[26][mesaEscolhida + 2]){
                            System.out.print("VALOR INVÁLIDO!");
                            MenuInfNumMesa();     
                        }
                        infPratos[26][(mesaEscolhida + 2)] -= quantidade;
                        MenuInfNumMesa();
                }
                infPratos[26][(mesaEscolhida + 2)] -= 1;
                MenuInfNumMesa();
            break;
            
        }
    }
}

