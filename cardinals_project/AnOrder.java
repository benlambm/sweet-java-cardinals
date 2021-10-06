package cardinals_project;

import java.time.LocalDate;

public class AnOrder {
	Customer customer;
	Inventory item;
	int quantity;
	LocalDate date;

	public AnOrder(Customer customer, Inventory item, int quantity) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        this.date = LocalDate.now();
    }

    public String toString() {
		return date + " : " + customer.username + " bought " + quantity + item.getName() + "(s) for cost of " + quantity * item.getCost();
	}

}
