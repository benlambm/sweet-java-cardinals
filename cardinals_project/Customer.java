package cardinals_project;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends AbstractUser {
		
	public Customer(String username, String password) {
        super(username, password);
        
    }

    public void placeOrder(AnOrder o) {		
	}
	
	public void pay() {	
	}

    @Override
    public ArrayList<AnOrder> showMenu(ArrayList<Inventory> inventory) {
        System.out.println("\nWelcome \" + username + \"!");
        while (true) {       
            System.out.println("\nPlease select and enter a number from the following choices:\n");
            System.out.println("1. View Sweets");
            System.out.println("2. Search for Item");
            System.out.println("3. Place an Order");
            System.out.println("4. Pay for Order");
            System.out.println("5. Return to Main Menu");
            ArrayList<AnOrder> orders = new ArrayList<>();
            Inventory oneItem = null;
            int q = 0;
            
            
            Scanner scan = new Scanner(System.in);
            int menuChoice = scan.nextInt();
            switch(menuChoice) {
                case 1:
                    viewInventory(inventory);
                    break;
                case 2:
                    Scanner input = new Scanner(System.in);
                    System.out.println("What are you looking for?");
                    String ss = input.nextLine();
                    searchInventory(ss, inventory);
                    break;
                case 3:
                    Scanner inp_t = new Scanner(System.in);
                    NumberFormat nf = NumberFormat.getCurrencyInstance();
                    System.out.println("\nNote: Order one item at a time please. If you'd like to order more, place another order!\n");
                    System.out.println("Enter the item ID number: ");
                    int id = inp_t.nextInt();

                    for (Inventory item : inventory) {
                        if (id == item.getItemId()) {
                            oneItem = item;
                        } 
                    }
                    System.out.println("How many would you like to order?");
                    q = inp_t.nextInt();
                    double subtotal = 0;
                    for (Inventory item : inventory) {
                        if (id == item.getItemId()) {
                            subtotal = item.getCost() * q;
                        }
                    }
                    System.out.println("\nYour total today is " + nf.format(subtotal) + ". Please pay at the window!");
                 
                case 4:
                    System.out.println("\n[You are herded toward the cashier. You see no option but to pay at this point.]\n");
                    orders.add(new AnOrder(this, oneItem, q));
                    System.out.println("Thank you for your business and come again!");
                    break;
                default:
                    return orders;
                 
            }
        }    
    }

}