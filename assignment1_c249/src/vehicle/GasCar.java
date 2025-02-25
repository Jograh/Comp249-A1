/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class GasCar extends Car {

	public GasCar(String plate, String make, String model, int year, int maxPassengerCapacity) {
		super(plate, make,model, year, maxPassengerCapacity);
		
	}
	
	public GasCar(String make, String model, int year, int maxPassengerCapacity) {
		super(Vehicle.nextPlate('G', 'C'), make,model, year, maxPassengerCapacity);
		
	}
	
	
	public GasCar() {
		this(null,null,0,0);
	}
	
	public GasCar(GasCar obj) {
		super(obj);
	}
	
	public static void editGasCar(String plate, String make, String model, int year, int maxPassengerCapacity) {
		for (int i = 0; i < vehicleArray.length; i++) {
			
			//find the vehicle
			if (vehicleArray[i].plateNumber.equals(plate)){
					Vehicle.removeVehicle(plate);
					GasCar temp = new GasCar(plate, make, model, year, maxPassengerCapacity);
					break;
				}
			}
	}
	
}
