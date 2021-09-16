package cardinals.javasweets;



public class Owner extends User{
	
	

private String id;
//private Inventory inventory; 

// empty constructor

	public Owner() {
		super();
		
	}	
	
// full constructor
	
		public Owner(String id) {
		super();
		this.id = id;
	}
		
		// toString 
		
@Override
		public String toString() {
			return "Owner [id=" + id + ", password=" + password + "]";
					}

/*
 * view the inventory// has instance of the Inventory class once inventory is complete update I will update this
•	search for an item by name or partial name// this should be a method in the driver
•	add more stock to the inventory// What is a stock? Possibly a class. Is it Inventory? I think this can be done in the inventory.
•	add items// this possibly in the stock / inventory should be written in inventory driver 
•	delete an item// should be written in the inventory driver
•	change prices
•	Run a summary of all orders and/or payments processed
 Return to the main menu 
 * 
 */
	// getters and setters 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
   


}
