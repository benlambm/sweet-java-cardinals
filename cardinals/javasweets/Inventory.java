package cardinals.javasweets;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Inventory {
    
    private String itemId;
    private String name;
    private double cost;
    private int numInStock;
    private LocalDate expDate;
    
    public Inventory () {
        
    }
    
    public Inventory(String id, String na, double c, int nu, LocalDate e) {
        itemId = id;
        name = na;
        cost = c;
        numInStock = nu;
        expDate = e;
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return name + ": " + nf.format(cost) + " (" + numInStock + " in stock, expiration date: " + expDate + ")";
    }
    
    /*TO DO LATER ON
    public void compareTo(AnOrder item, String itemID) { 
         
        if(item.getItemObject().equals(itemID)){
            return item.;
        }
        else if(item.getItemObject().equals(itemID)){
            return;
        }
        else
            return;
    }
    
    public double InvTotalPrice(double cost, double num) {
        double total = cost * num;
        return total;
    }*/
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    
    
}
