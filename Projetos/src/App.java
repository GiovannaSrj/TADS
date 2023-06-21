import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in); 
        int num;
        Menus menu = new Menus();
        for(menu.i=0;menu.i<10;menu.i++){

            menu.mesass[menu.i] = false;
  
        }
        System.out.println("============================================");
        System.out.println("\t\tRESTAURANTE");
        System.out.println("============================================");
        
            menu.MenuInicial();
                
    }
    
}
