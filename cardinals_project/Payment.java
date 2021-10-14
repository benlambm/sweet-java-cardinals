package cardinals_project;

public class Payment {
	Customer customer;
	double totalCost;
	String paymentType;
	
    public Payment(Customer customer, double totalCost, String paymentType) {
        this.customer = customer;
        this.totalCost = totalCost;
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
		
}
