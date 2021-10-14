package cardinals_project;

public class LineItem {
    private Inventory lineItem;
    private int quantity;
    
    public LineItem(Inventory lineItem, int quantity) {
        this.lineItem = lineItem;
        this.quantity = quantity;
    }

    public Inventory getLineItem() {
        return lineItem;
    }

    public void setLineItem(Inventory lineItem) {
        this.lineItem = lineItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LineItem: " + lineItem + ", quantity=" + quantity + "\n";
    }
    
    
    
}
