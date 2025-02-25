/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class GasTruck extends Truck {

	
	public GasTruck(String plate, String make, String model, int year, double maxWeightCapacity) {
		super(plate, make, model, year, maxWeightCapacity);
		
	}
	
	public GasTruck(String make, String model, int year, double maxWeightCapacity) {
		super(Vehicle.nextPlate('G', 'T'), make, model, year, maxWeightCapacity);
		
	}
	
	public GasTruck() {
		this(null,null,0,0);
	}
	
	public GasTruck(GasTruck obj) {
		super(obj);
	}
	
	
	public static void editGasTruck(String plate, String make, String model, int year, double maxWeightCapacity) {
		for (int i = 0; i < vehicleArray.length; i++) {
			
			//find the vehicle
			if (vehicleArray[i].plateNumber.equals(plate)){
					Vehicle.removeVehicle(plate);
					GasTruck temp = new GasTruck(plate, make, model, year, maxWeightCapacity);
					break;
				}
			}
	}
	
	
}
