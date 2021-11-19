package cardinals_project;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnOrder {
	private int orderId;
    private ArrayList<LineItem> lineItems;
	private LocalDate date;
	private Payment payment;
	private static int orderStartNum = 105;


    public AnOrder(ArrayList<LineItem> lineItems, LocalDate date, Payment payment) {
        this.lineItems = lineItems;
        this.date = date;
        this.payment = payment;
        this.orderId = ++orderStartNum;
    }


    public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String purchased = "";
		for (LineItem li : lineItems) {
		    purchased += li.toString();
		}
		
        return date + " : " + payment.getCustomer().getUsername() + " spent a total of " + nf.format(payment.getTotalCost()) + " on \n"
            + purchased; 
	}


    public int getOrderId() {
        return this.orderId;
    }

}
