package driver;
import vehicle.*;
import java.util.Scanner;
import client.*;
public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Vehicle[] vehicleArray;
	
	
	System.out.println("Welcome to the Royal Rentals repository!");
	System.out.print("\nSelect the scenario you would like to run"
			+"\n\t 1: Standard with random vehicles"
			+ "\n\t 2: Predefined Scenario"
			+ "\n\t 3: Standard empty"
			+ "\nYour choice (1-3): ");
	
	int choiceInt = verifyInt(1,3);
	
	//switch to initialize scenario
	switch (choiceInt) {
	
	case 1:
	//random vehicles
		System.out.print("Enter number of vehicles you would like to generate (0-100): ");
		
		choiceInt = verifyInt(1,100);
		vehicleArray = getRandomVehicleArray(choiceInt);
		break;
	
	case 2:
	//predefined	
		
		//create predefined vehicles
		DieselTruck dT1 = new DieselTruck("Ford","Super Duty", 2015, 3000.50, 40);
		DieselTruck dT2 = new DieselTruck("Subaru","Super Duty", 2023, 4000.5, 25);
		DieselTruck dT3 = new DieselTruck("Dodge","Super Duty", 2008, 3500, 15);
		
		GasTruck gT1 = new GasTruck("Ford","Super Duty", 2001, 2500);
		GasTruck gT2 = new GasTruck("Ram","Super Duty", 1995, 3500);
		GasTruck gT3 = new GasTruck("Dodge","Super Duty", 2010, 3050);
		
		ElectricTruck eT1 = new ElectricTruck("Tesla","Cybertruck", 2024, 3050, 250);
		ElectricTruck eT2 = new ElectricTruck("Tesla","Cybertruck", 2025, 2500, 300);
		ElectricTruck eT3 = new ElectricTruck("Tesla","Cybertruck", 2025, 2500, 300);
		
		GasCar gC1 = new GasCar("Subaru", "Outback", 2020, 4);
		GasCar gC2 = new GasCar("Hundai", "hatchback", 2015, 2);
		GasCar gC3 = new GasCar("Honda", "Accord", 2005, 4);
		
		ElectricCar eC1 = new ElectricCar("Tesla", "X", 2017, 4, 200);
		ElectricCar eC2 = new ElectricCar("Tesla", "Y", 2020, 4, 250);
		ElectricCar eC3 = new ElectricCar("Tesla", "Z", 2021, 4, 225);
	
		
		Client c1 = new Client("Ray Manchester");
		Client c2 = new Client("Henry Hart");
		Client c3 = new Client("Jasper Dunlop");
		
		
		//display toString of each vehicle
		Vehicle.checkArray();
		
		//display clients
		Client.readArray();
		
		//test equals
		System.out.println("\nCompare two objects of different class \nResults: " + dT1.equals(eC1));
		System.out.println("\nCompare two objects of same class with different attributes \nResults: " + dT1.equals(dT2));
		System.out.println("\nCompare two objects of same class with same attributes \nResults: " + eT2.equals(eT3));
		
		//the getArrayForType calls upon the master array that all vehicles are stored into
		//within the vehicle class. The method parses the array and creates a copy array for the 
		//specified type
		Vehicle[] dieselTruckArray = getArrayForType("DT");
		Vehicle[] ElectricTruckArray = getArrayForType("ET");
		Vehicle[] gasTruckArray = getArrayForType("GT");
		Vehicle[] gasCarArray = getArrayForType("GC");
		Vehicle[] electricCarArray = getArrayForType("EC");
		
		//prove arrays function
		System.out.println("First vehicle in each array: ");
		System.out.println(dieselTruckArray[0]);
		System.out.println(ElectricTruckArray[0]);
		System.out.println(gasTruckArray[0]);
		System.out.println(gasCarArray[0]);
		System.out.println(electricCarArray[0]);
		
		//get largest truck
		System.out.println("\nGet largest truck method:\n" +
				getLargestCapacityTruck("DT").toString());
		
		break;
	
	case 3:
	break;
	
	}
	
	
	
	
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
	//for input verification
		public static int verifyInt(){
			Scanner kb = new Scanner(System.in);
			int result;
			
			while (true){
			if (kb.hasNextInt()) {
				result = kb.nextInt();
				kb.close();
				return result;
				}
			else {
				System.out.println("Input must be an Integer");
				kb.next();
				}
				
			} 
		
		}//end of method
		
		public static int verifyInt(int start, int end) {
			Scanner kb = new Scanner(System.in);
			int result;
			
			while (true){
			if (kb.hasNextInt()) {
				result = kb.nextInt();
				
				if (result >= start && result <= end) {
					return result;
				}
				else
					System.out.print("Must pick between (" + start +"-"+ end + "): ");
			
				}
			else {
				System.out.print("Input must be proper!"
						+ "\nYour choice (" + start +"-"+ end + "): ");
				kb.next();
				}
				
			} 

		}//end of method
	
		
}
