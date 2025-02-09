package driver;
import vehicle.*;
import client.*;
public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Vehicle[] array = getRandomVehicleArray(50);
		
		Vehicle[] arrayDT = getArrayForType("EC");
		
		
	
	
	
	
	}//end of main

	
	public static Vehicle[] getRandomVehicleArray(int size) {
		
		//generate random vehicles.
		
				Vehicle[] randomArray = new Vehicle[size];
				
				//pick between 1-5
				for (int i = 0; i < randomArray.length; i++) {
				int random = (int)((Math.random()*5)+1);
				
					switch (random) {
					
					//DieselTruck
					case 1:
						randomArray[i] = new DieselTruck(randomMake(),"Super Duty", randomYear(), randomDouble(2000, 6000), randomDouble(10, 30));
						break;
					//ElectricTruck
					case 2:
						randomArray[i] = new ElectricTruck("Tesla", "CyberTruck", 2024, randomDouble(2000, 6000), randomDouble(100, 250));
						break;
					//GasTruck
					case 3:
						randomArray[i] = new GasTruck(randomMake(), "Pickup", randomYear(), randomDouble(2000, 6000));
						break;
					//GasCar
					case 4:
						randomArray[i] = new GasCar(randomMake(), "Sedan", randomYear(), ((int)randomDouble(3,1))*2);
						break;
					//ElectricCar
					case 5:
						randomArray[i] = new ElectricCar("Tesla", "X", 2022, ((int)randomDouble(3,1))*2, randomDouble(100, 250));
						break;
					
					}//end of switch
				
				
				}//end of loop
		return randomArray;
	}
	
	
	public static String randomMake() {
		
		int random = (int)((Math.random()*5)+1);
		String randomMake = null;
		
		switch (random) {
		
		case 1:
			randomMake = "Toyota";
			break;
		case 2:
			randomMake = "Ford";
			break;
		case 3:
			randomMake = "Honda";
			break;
		case 4:
			randomMake = "BMW";
			break;
		case 5:
			randomMake = "Nissan";
			break;
	
		}
		
		return randomMake;
	}
	
	public static int randomYear() {
		int random = (int)((Math.random()*20)+2005);
		return random;
	}
	
	public static double randomDouble(int range, int start) {
		 double random = (Math.random() * range) + start;
		 return Math.round(random * 100.0) / 100.0;
		}	
	
	public static Truck getLargestCapacityTruck(String type) {
		Vehicle[] array = Vehicle.getVehicleArray();
		Truck[] truckArray = new Truck[array.length];
		int truckArrayCount = 0;
		
		//sort Array for trucks
		for (int i = 0; i < array.length; i++) {
			//get license plate for type
			
			if (array[i] != null) {
			String tempPlate = array[i].getPlateNumber();
			tempPlate = tempPlate.substring(0, 2);
			
			//check for null and type of plate. Ex: "ET" electric truck
			if (tempPlate.equals(type)) {
				
				truckArray[truckArrayCount] = (Truck)array[i];
				truckArrayCount++;
				}
			}
		}
		//check new truck array, if empty return null. if not sort for largestCapacity
		if (truckArray[0] != null) {
		Truck largestCapacityTruck = truckArray[0];
		for (int i = 0; i < truckArray.length; i++) {
			//check for null
			if (truckArray[i] != null) {
				if (truckArray[i].getMaxWeightCapacity() > largestCapacityTruck.getMaxWeightCapacity())
				largestCapacityTruck = truckArray[i];
				}
			}
		return largestCapacityTruck;
		}
		else return null;
			
	}
	
	
	public static Vehicle[] getArrayForType(String type) {
		
		Vehicle[] array = Vehicle.getVehicleArray();
		Vehicle[] newArray = new Vehicle[array.length];
		int newArrayCount = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] != null) {
				
				String tempPlate  = array[i].getPlateNumber();
				tempPlate = tempPlate.substring(0, 2);
				
				if (tempPlate.equals(type)) {
					newArray[newArrayCount] = array[i];
					newArrayCount++;
				}
				
				
			}
			
		}//end of loop
		
		if (newArray[0] == null) {
			System.out.println("No vehicles to store");
			return null;
			}
		
		else {
		
			return newArray;
			
		}
	}
	
	
}
