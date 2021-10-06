package cardinals.javasweets;

import java.util.Scanner;

public class JavaSweetsDriver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        while(true) {
            loadMainMenu();
            int menuOption = scan.nextInt();
            
            switch(menuOption) {
            case 1:
                //Load sample data from txt file
                break;
            case 2:
                // Log in as owner
                break;
            case 3:
                //Log in as customer
                break;
            case 4:
                scan.close();
                System.exit(0);

            }
        }    
        
           

    }

    private static void loadMainMenu() {
        System.out.println("\tWELCOME TO THE CARDINALS JAVA-SWEETS SHOP");
        System.out.println("\nPlease select and enter a number from the following choices:");
        System.out.println("\n1. Load sample data");
        System.out.println("2. Log in as an owner");
        System.out.println("3. Log in as customer");
        System.out.println("4. Exit the application");
    }
    
    
}
