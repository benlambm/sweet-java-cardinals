package cardinals_project;

import java.sql.Connection;
import java.util.ArrayList;

public interface User {

    String getUsername();
    
    String checkPassword();
    
    ArrayList<AnOrder> showMenu(ArrayList<Inventory> inventory, ArrayList<AnOrder> orders, Connection con);
    
    void viewInventory(ArrayList<Inventory> inventory);
    
    void searchInventory(String searchString, ArrayList<Inventory> items);

    
}
