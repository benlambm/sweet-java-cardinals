package cardinals_project;

import java.util.ArrayList;

public abstract class AbstractUser implements User {	
	protected String username;
	protected String password;
	
    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
	
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public String checkPassword() {
        return this.password;
    }
    
    @Override
    public void viewInventory(ArrayList<Inventory> items) {
        for (Inventory item : items) {
            System.out.println(item.toString());
        }
        
    }
    
    @Override
    public void searchInventory(String searchString, ArrayList<Inventory> items) {
        for (Inventory item : items) {
            if (item.getName().indexOf(searchString) >= 0) {
                System.out.println(item.toString());
            }
        }
    }
    
    
        
}

