/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class DieselTruck extends Truck {

	private double fuelCapacity;
	//in liters
	
	public DieselTruck(String plate, String make, String model, int year, double maxWeightCapacity, double fuelCapacity) {
		
		super(plate, make, model, year, maxWeightCapacity);
		this.fuelCapacity = fuelCapacity;

	}
	
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
	
	public static void editDieselTruck(String plate, String make, String model, int year, double maxWeightCapacity, double fuelCapacity) {
		for (int i = 0; i < vehicleArray.length; i++) {
			
			//find the vehicle
			if (vehicleArray[i].plateNumber.equals(plate)){
					Vehicle.removeVehicle(plate);
					DieselTruck temp = new DieselTruck(plate, make, model, year, maxWeightCapacity, fuelCapacity);
					break;
				}
			}
	}
	
	@Override
	public String toString() {
		return super.toString() + "Fuel Capacity: " + this.fuelCapacity+" gallons\n";
	}
	
}
