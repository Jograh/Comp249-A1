package vehicle;

public class ElectricCar extends Car{

	private double maxAutonomyRange;
	
	
	
	public ElectricCar(String make, String model, int year, int maxPassengerCapacity, double maxAutonomyRange) {
		super(Vehicle.nextPlate('E', 'C'), make, model, year, maxPassengerCapacity);
		this.maxAutonomyRange = maxAutonomyRange;
	
	}

	
	public ElectricCar() {
		this(null, null, 0, 0, 0);
	}
	
	public ElectricCar(ElectricCar obj) {
		super(obj);
		this.maxAutonomyRange = obj.maxAutonomyRange;
	}
	
	//getters and setters
	
	public double getMaxAutonomyRange() {
		return this.maxAutonomyRange;
	}
	
	public void setMaxAutonomyRange(double maxAutonomyRange) {
		this.maxAutonomyRange = maxAutonomyRange;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Max Autonomy Range: " + this.maxAutonomyRange+"km\n";
	}
	

	
}
