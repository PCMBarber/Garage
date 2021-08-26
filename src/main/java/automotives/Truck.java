package automotives;

public class Truck extends Vehicle {
	
	private int capacity;
	private double height;
	
	public Truck(String maker, String colour, int capacity, double height) {
		super(0, "Truck", maker, colour);
		this.capacity = capacity;
		this.height = height;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 200;
	}
	
	
}
