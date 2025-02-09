package vehicle;

public class DieselTruck extends Truck {

	private double fuelCapacity;
	//in liters
	
	
	
	public DieselTruck(String make, String model, int year, double maxWeightCapacity, double fuelCapacity) {
	
		super(Vehicle.nextPlate('D', 'T'), make, model, year, maxWeightCapacity);
		this.fuelCapacity = fuelCapacity;

	}
	
	public DieselTruck() {
		this(null, null, 0, 0, 0);
	}
	
	public DieselTruck(DieselTruck obj) {
		super(obj);
		this.fuelCapacity = obj.fuelCapacity;
	}
	
	//getters and setters
	public double getFuelCapacity() {
		return this.fuelCapacity;
	}
	
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Fuel Capacity: " + this.fuelCapacity+" gallons\n";
	}
	
}
