package cardinals_project;

import java.time.LocalDate;

public class Payment {
	LocalDate date;
	private double amount;
	AnOrder order;

	public Payment() {
		super();

	}

	public Payment(LocalDate date, double amount, AnOrder order) {
		super();
		this.date = date;
		this.amount = amount;
		this.order = order;
	}

		
	
	
	@Override
	public String toString() {
		return "Payment [date=" + date + ", amount=" + amount + ", order=" + order + "]";
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
