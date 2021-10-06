package cardinals_project;

public class LineItem {
	private int number; 
	private double costEach;
	Inventory invent;
	
	public LineItem() {
		super();
		
	}
	
	
	public LineItem(int number, double costEach, Inventory invent) {
		super();
		this.number = number;
		this.costEach = costEach;
		this.invent = invent;
	}
	

}
