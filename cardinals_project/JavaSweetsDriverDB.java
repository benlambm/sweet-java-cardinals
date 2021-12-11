package cardinals_project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JavaSweetsDriverDB {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Inventory> inventory = new ArrayList<>();
        ArrayList<AnOrder> orders = new ArrayList<>();
        boolean dataLoaded = false;        
        JavaSweetsMethodsDB db = new JavaSweetsMethodsDB();
        Connection con = null;
        
        while(true) {                       
            loadMainMenu();
            String str = scan.nextLine();
            int menuOption = validateMenuInput(str);
                      
            switch(menuOption) {
            case 9:
                continue;
            case 1:
                if (dataLoaded) {
                    System.out.println("Database is already connected.");
                    break;
                }
                con = db.createConnection();   
                users = db.loadSampleUsers(con);
                inventory = db.loadSampleSweets(con);
                dataLoaded = true;
                break;
            case 2:
                if (!dataLoaded) {
                    System.out.println("Error: Please connect to database first.");
                    break;
                }
                User currentUser = initiateLogin(users);
                if (currentUser == null) {
                    break;
                }
                currentUser.showMenu(inventory, orders, con);
                break;
            case 3:
                if (!dataLoaded) {
                    System.out.println("Error: Please connect to database first.");
                    break;
                }
                Scanner input = new Scanner(System.in);
                System.out.println("\nWelcome New Customer!\n");
                System.out.println("Please enter a new username: ");
                String name = input.nextLine();
                System.out.println("Please enter a password: ");
                String pswd = input.nextLine();
                try {
                    Customer newCustomer = new Customer(name, pswd);      
                    users.add(newCustomer);
                    db.createNewCustomer(name, pswd);
                    System.out.println("SYSTEM CONFIRMATION: New Customer Account Created. Please go to Login next.");
                } catch(Exception e) {
                    System.out.println("Unknown error: please try again in a few minutes.");
                }
                break;
            default:
                scan.close();
                System.out.println("Thank you and come again!");
                System.exit(0);
            }
        }       
    }

    public static int validateMenuInput(String str) {
        String str_dup = "" + str.charAt(0);
        try {
            Integer.parseInt(str_dup);
        } catch (Exception e) {
            System.out.println("Error: not a number. Please try again.");
            str = "9";
        }
        int menuOption = Integer.parseInt("" + str.charAt(0));
        return menuOption;
    }

    private static User initiateLogin(ArrayList<User> users) {
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;
        User currentUser = null;
        System.out.println("\nTHE LOGIN SCREEN:\n");
        System.out.println("Please enter your username: ");
        String name = scan.nextLine();
        System.out.println("Please enter your password: ");
        String pswd = scan.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(name) && user.checkPassword().equals(pswd)) {
                System.out.println("...Login successful...");
                loggedIn = true;
                currentUser = user;
            }
        }
        if (!loggedIn) {
            System.out.println("Sorry, this username or password was not recognized. Please try again.");
            return null;
        }
        return currentUser;
    }

    private static void loadMainMenu() {
        System.out.println("\n\tWELCOME TO THE CARDINALS JAVA-SWEETS SHOP");
        System.out.println("\nPlease select and enter a number from the following choices (just the number please):");
        System.out.println("\n1. Connect to database");
        System.out.println("2. Login");
        System.out.println("3. New Customer - Create Account");
        System.out.println("4. Exit the application");
    }
    
}
