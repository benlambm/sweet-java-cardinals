package cardinals.javasweets;

public class Customer {
	
	/*
	 * The Customer, at a minimum, should be able to:
		•	View the inventory
		•	search for an item by name or partial name
		•	place an order
		•	Pay for an order
		•	Return to the main menu		
		
		*/		

private String idCust;

	public Customer() {
		super();
		
	}
	
	public Customer(String idCust) {
		super();
		this.idCust = idCust;
	}

	public String getIdCust() {
		return idCust;
	}

	public void setIdCust(String idCust) {
		this.idCust = idCust;
	}
	





}
