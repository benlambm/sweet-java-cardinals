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
        
        while(true) {
            loadMainMenu();
            int menuOption = 0;
            try {
                menuOption = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Just the number please! Try again from the beginning");
                System.exit(0);
            }
            switch(menuOption) {
            case 1:
                if (users.size() > 0) {
                    System.out.println("Data has already been loaded.");
                    break;
                }
                users = loadSampleUsers();
                inventory = loadSampleSweets();
                break;
            case 2:
                User currentUser = initiateLogin(users);
                if (currentUser == null) {
                    break;
                }
                currentUser.showMenu(inventory, orders);
                break;
            case 3:
                scan.close();
                System.exit(0);
            }
        }       
    }

    private static ArrayList<Inventory> loadSampleSweets() {
        ArrayList<Inventory> items = new ArrayList<>();
        items.add(new Inventory("Pumpkin Pie", 12.00, 5, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Pecan Rolls", 5.00, 8, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Maple-syrup Cookies", 2.00, 12, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Caramel-dipped Apple", 2.50, 13, LocalDate.of(2021, 10, 31)));
        items.add(new Inventory("Pumpkin-banana Bread", 6.50, 4, LocalDate.of(2021, 10, 31)));
        return items;
    }

    private static User initiateLogin(ArrayList<User> users) {
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;
        boolean owner = false;
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
                if (user.getClass().getSimpleName().equals("Owner")) {
                    owner = true;
                }
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
        user.add(new Customer("Ben", "Lamb"));
        System.out.println("\nSample data successfully loaded!\n");
        return user;
    }

    private static void loadMainMenu() {
        System.out.println("\n\tWELCOME TO THE CARDINALS JAVA-SWEETS SHOP");
        System.out.println("\nPlease select and enter a number from the following choices (just the number please):");
        System.out.println("\n1. Load sample data");
        System.out.println("2. Login");
        System.out.println("3. Exit the application");
    }
    
    
}

