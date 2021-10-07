package cardinals_project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaSweetsDriver {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Inventory> inventory = new ArrayList<>();
        ArrayList<AnOrder> orders = new ArrayList<>();
        boolean dataLoaded = false;
        
        
        while(true) {
            loadMainMenu();
            String str = scan.nextLine();
            int menuOption = validateMenuInput(str);
                      
            switch(menuOption) {
            case 9:
                continue;
            case 1:
                if (dataLoaded) {
                    System.out.println("Data has already been loaded.");
                    break;
                }
                users = loadSampleUsers();
                inventory = loadSampleSweets();
                dataLoaded = true;
                break;
            case 2:
                if (!dataLoaded) {
                    System.out.println("Error: Please load sample data first.");
                    break;
                }
                User currentUser = initiateLogin(users);
                if (currentUser == null) {
                    break;
                }
                currentUser.showMenu(inventory, orders);
                break;
            case 3:
                if (!dataLoaded) {
                    System.out.println("Error: Please load sample data first.");
                    break;
                }
                Scanner input = new Scanner(System.in);
                System.out.println("\nWelcome New Customer!\n");
                System.out.println("Please enter a new username: ");
                String name = input.nextLine();
                System.out.println("Please enter a password: ");
                String pswd = input.nextLine();
                users.add(new Customer(name, pswd));
                System.out.println("SYSTEM CONFIRMATION: New Customer Account Created. Please go to Login next.");
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

    private static ArrayList<Inventory> loadSampleSweets() {
        ArrayList<Inventory> items = new ArrayList<>();
        items.add(new Inventory("Pumpkin Pie", 12.95, 5, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Apple Cider Donut", 2.25, 35, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Pecan Roll", 5.00, 8, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Maple-syrup Candies", 2.00, 12, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Caramel-dipped Apple", 1.50, 13, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Pumpkin-banana Bread", 5.50, 4, LocalDate.of(2021, 10, 31)));
        return items;
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

    private static ArrayList<User> loadSampleUsers() {
        ArrayList<User> user = new ArrayList<>();
        user.add(new Owner("cardinal", "cardinal"));
        user.add(new Customer("guest", "guest"));
        user.add(new Customer("Ben", "Lamb"));
        System.out.println("\nSample data successfully loaded!\n");
        return user;
    }

    private static void loadMainMenu() {
        System.out.println("\n\tWELCOME TO THE CARDINALS JAVA-SWEETS SHOP");
        System.out.println("\nPlease select and enter a number from the following choices (just the number please):");
        System.out.println("\n1. Load sample data");
        System.out.println("2. Login");
        System.out.println("3. New Customer - Create Account");
        System.out.println("4. Exit the application");
    }
    
}

