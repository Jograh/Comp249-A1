package vehicle;

public class ElectricTruck extends Truck {
	
	private double maxAutonomyRange;
	
	
	
	public ElectricTruck(String make, String model, int year, double maxWeightCapacity, double maxAutonomyRange) {
		super(Vehicle.nextPlate('E', 'T'), make, model, year, maxWeightCapacity);
		this.maxAutonomyRange = maxAutonomyRange;
		
	}
	
	public ElectricTruck() {
		this(null, null, 0, 0, 0);
	}
	
	public ElectricTruck(ElectricTruck obj) {
		super(obj);
		this.maxAutonomyRange = obj.maxAutonomyRange;
	}
	
	//getters and setters
	
	public double getMaxAutonomyRange() {
		return maxAutonomyRange;
	}
	
	public void setMaxAutonomyRange(double maxAutonomyRange) {
		this.maxAutonomyRange = maxAutonomyRange;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Max Autonomy Range: " + this.maxAutonomyRange+"km\n";
	}
	
	
}
