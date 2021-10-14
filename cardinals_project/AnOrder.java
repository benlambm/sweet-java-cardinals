package cardinals_project;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnOrder {
	ArrayList<LineItem> lineItems;
	LocalDate date;
	Payment payment;


    public AnOrder(ArrayList<LineItem> lineItems, LocalDate date, Payment payment) {
        this.lineItems = lineItems;
        this.date = date;
        this.payment = payment;
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

}
