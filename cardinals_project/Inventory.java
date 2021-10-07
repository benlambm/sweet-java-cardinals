package cardinals_project;

import java.text.NumberFormat;
import java.time.LocalDate;

public class Inventory {
    
    private int itemId;
    private String name;
    private double cost;
    private int numInStock;
    private LocalDate expDate;
    static int autoId = 101;
    
    public Inventory(String n, double c, int num, LocalDate e) {
        itemId = autoId++;
        name = n;
        cost = c;
        numInStock = num;
        expDate = e;    
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return "#" + itemId + " - " + name + ": " + nf.format(cost) + " (" + numInStock + " in stock, expiration date: " + expDate + ")";
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
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

    public void setNumInStock(int numPurchased) {
        this.numInStock -= numPurchased;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public void addToStock(int q) {
        this.numInStock += q;       
    }

    public void changePrice(double newCost) {
        this.cost = newCost;
        
    }

}
/*
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




