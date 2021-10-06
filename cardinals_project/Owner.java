package cardinals_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Owner extends AbstractUser {	
	
	public Owner(String username, String password) {
        super(username, password);
        
    }

    public String toString() {
		return "Owner id=" + username + 
				"Owner password=" + password;						
	}

    @Override
    public ArrayList<AnOrder> showMenu(ArrayList<Inventory> inventory, ArrayList<AnOrder> orders) {    
        while(true) {
            System.out.println("\nWelcome back Owner! Please select and enter a number from the following choices:\n");
            System.out.println("1. View Inventory");
            System.out.println("2. Search for Item");
            System.out.println("3. Add More Stock");
            System.out.println("4. Add New Item");
            System.out.println("5. Remove Item from Inventory");
            System.out.println("6. Update Item's Price");
            System.out.println("7. View All Orders");
            System.out.println("8. Return to Main Menu");
            
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
                    System.out.println("Enter the item ID number: ");
                    int id = inp_t.nextInt();

                    for (Inventory item : inventory) {
                        if (id == item.getItemId()) {
                            oneItem = item;
                        } 
                    }
                    System.out.println("Enter quantity of items being added to stock: ");
                    q = inp_t.nextInt();
                    oneItem.addToStock(q);
                    System.out.println("System Confirmation: Item Quantity has been updated.");
                    break;
                case 4:
                    Scanner itemScan = new Scanner(System.in);
                    System.out.println("What is the name of the new item?");
                    String name = itemScan.nextLine();
                    System.out.println("What is the price of the new item?");
                    double cost = scan.nextDouble();
                    System.out.println("What is the quantity in stock?");
                    int num = scan.nextInt();
                    System.out.println("What is the expiration year?");
                    int year = scan.nextInt();
                    System.out.println("What is the expiration month?");
                    int mo = scan.nextInt();
                    System.out.println("What is the expiration day?");
                    int day = scan.nextInt();
                    inventory.add(new Inventory(name, cost, num, LocalDate.of(year, mo, day)));
                    System.out.println("System Confirmation: New Item has been added.");
                    break;
                case 5:
                    System.out.println("What is the ID# of the item to be removed? ");
                    int idNum = scan.nextInt();
                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getItemId() == idNum) {
                            System.out.println("System Confirmation: Item removed from Inventory.");
                            inventory.remove(i);
                            break;
                        }
                    }
                    System.out.println("Item has been removed from inventory");
                    break;
                case 6:
                    System.out.println("Enter the item ID number: ");
                    int idNo = scan.nextInt();

                    for (Inventory item : inventory) {
                        if (idNo == item.getItemId()) {
                            oneItem = item;
                        } 
                    }
                    System.out.println("What is the new price of the item? ");
                    double newCost = scan.nextDouble();
                    oneItem.changePrice(newCost);
                    System.out.println("System Confirmation: Item Price has been updated.");
                    break;
                case 7:
                    for (AnOrder order : orders) {
                        System.out.println(order);
                    }
                    break;
                default:
                    return null;
                 
            }
    
        }
    }
	
}


