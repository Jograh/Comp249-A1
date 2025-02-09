package vehicle;

public class Truck extends Vehicle{

	private double maxWeightCapacity;
	
	
	public Truck(String plateNumber, String make, String model, int year, double maxWeightCapacity) {
		super(plateNumber, make, model, year);
		this.maxWeightCapacity = maxWeightCapacity;
	}
	
	
	public Truck() {
		this(null, null, null, 0, 0);
	}
	
	public Truck(Truck obj) {
		super(obj);
		this.maxWeightCapacity = obj.maxWeightCapacity;
	}
	
	
	//getters and setters
	public double getMaxWeightCapacity() {
		return this.maxWeightCapacity;
	}
	
	public void setMaxWeightCapacity(double maxWeightCapacity) {
		this.maxWeightCapacity = maxWeightCapacity;
	}
	
	//toString
	
	@Override
	public String toString() {
		return super.toString() + "\nMax Weight Capacity: " + this.maxWeightCapacity +"lbs\n";
	}
	
	
	
	
	
	
}// end of class
