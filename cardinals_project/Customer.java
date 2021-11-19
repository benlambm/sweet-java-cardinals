package cardinals_project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends AbstractUser {
    
	public Customer(String username, String password) {
        super(username, password);        
    }
	


    @Override
    public ArrayList<AnOrder> showMenu(ArrayList<Inventory> inventory, ArrayList<AnOrder> orders, Connection con) {
        System.out.println("\nWelcome " + username + "!");
        while (true) {       
            System.out.println("\nPlease select and enter a number from the following choices:\n");
            System.out.println("1. View Sweets");
            System.out.println("2. Search for Item");
            System.out.println("3. Place an Order");
            System.out.println("4. Pay for Order");
            System.out.println("5. Return to Main Menu");
            
            
            
            Scanner inp_t = new Scanner(System.in);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            ArrayList<LineItem> lineItems = new ArrayList<>();
            double subtotal = 0;   
            Payment payDetails;
            Inventory oneItem = null;
            int q = 0;
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            int menuChoice = JavaSweetsDriver.validateMenuInput(str);
            
            
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
                    boolean hasMoreToOrder = true;    
                    while (hasMoreToOrder) {
                        q = 0;
                        System.out.println("Enter the item ID number (or you can enter 0 to go back): ");
                        int id = inp_t.nextInt();
                        if (id == 0) {
                            break;
                        }
                        for (Inventory item : inventory) {
                            if (id == item.getItemId()) {
                                oneItem = item;
                            } 
                        }
                        if (oneItem==null) {
                            System.out.println("Id# not recognized. Please try again.");
                            break;
                        }
                        if (oneItem.getNumInStock() == 0) {
                            System.out.println("Sorry, we sold out of those! Please try again.");
                        }
                        System.out.println("How many would you like to order?");
                        q = inp_t.nextInt();
                        inp_t.nextLine();
                        if (q > oneItem.getNumInStock()) {
                            System.out.println("Sorry, we only have " + oneItem.getNumInStock() + " of those left. Please try again.");
                            continue;
                        }
                        subtotal += oneItem.getCost() * q;
                        lineItems.add(new LineItem(oneItem, q));
                        System.out.println("Would you like to order anything else? (y/n)");
                        String moreToOrder = inp_t.nextLine();
                        if (moreToOrder.charAt(0)=='n') {
                            hasMoreToOrder = false;
                        }
                    }
                    if(oneItem != null) {
                        System.out.println("Thank you for this order. Please pay at the window!");    
                    }
                        
                case 4:
                    if (oneItem == null) {
                        break;
                    }
                    System.out.println("\n[You are herded toward the cashier. You see no option but to pay at this point.]\n");
                    System.out.println("Hi! Your total charge is " + nf.format(subtotal) + 
                        ". How would you like to pay today? (We accept pretty much anything including IOUs! Just tell us what you prefer)");
                    String paymentType = inp_t.next();  
                    //database version
                    AnOrder newOrder = new AnOrder(lineItems, LocalDate.now(), new Payment(this, subtotal, paymentType));
                    try {
                        CallableStatement ca;
                        String storedProcedure = "call sp_addorder(\'" + newOrder.getOrderId() + "\', \'" + this.username + "\', \'" + LocalDate.now() + "\')";
                        ca = con.prepareCall(storedProcedure);
                        ca.executeQuery();
                        System.out.println("Placing order...");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    for (LineItem lineItem : lineItems) {
                        try {
                            CallableStatement ca;
                            String storedProcedure = "call sp_addlineitem(\'" + oneItem.getItemId() + "\', \'" + newOrder.getOrderId() + "\', \'" + q + "\')";
                            ca = con.prepareCall(storedProcedure);
                            ca.executeQuery();
                            System.out.println("Recording order details...");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }                    
                    //update console memory
                    orders.add(newOrder);
                    oneItem.setNumInStock(q);
                    System.out.println("Thank you for your business and come again!");
                    break;
                default:
                    return orders;       
            }
        }    
    }

}