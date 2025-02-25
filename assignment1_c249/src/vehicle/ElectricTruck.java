/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class ElectricTruck extends Truck {
	
	private double maxAutonomyRange;
	
	public ElectricTruck(String plate, String make, String model, int year, double maxWeightCapacity, double maxAutonomyRange) {
		super(plate, make, model, year, maxWeightCapacity);
		this.maxAutonomyRange = maxAutonomyRange;
		
	}
	
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
	
	public static void editElectricTruck(String plate, String make, String model, int year, double maxWeightCapacity, double maxAutonomyRange) {
		for (int i = 0; i < vehicleArray.length; i++) {
			
			//find the vehicle
			if (vehicleArray[i].plateNumber.equals(plate)){
					Vehicle.removeVehicle(plate);
					ElectricTruck temp = new ElectricTruck(plate, make, model, year, maxWeightCapacity, maxAutonomyRange);
					break;
				}
			}
	}
	
	@Override
	public String toString() {
		return super.toString() + "Max Autonomy Range: " + this.maxAutonomyRange+"km\n";
	}
	
	
	
}
