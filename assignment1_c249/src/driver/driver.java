/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958

--------------------------------------------------------------
*/

package driver;
import vehicle.*;
import java.util.Scanner;
import client.*;
public class driver {

	static Scanner kb = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
	
	
	System.out.println("Welcome to the Royal Rentals repository!"
			+ "\nCEO and benificiary: Joshua Graham\n");
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
		
		int choiceInt2 = verifyInt(1,100);
		System.out.println();
		Vehicle[] vehicleArray = getRandomVehicleArray(choiceInt2);
		Vehicle.checkArray();
		System.out.println("\nVehicle information above ^");
		break;
	
	case 2:
	//predefined	
		predefinedScenario();
		break;
	}
	
	//code menu in here
	if (choiceInt == 1 || choiceInt == 3) {
		
		int choiceInt2; 
		
		do {
			System.out.print("\n\tRepository Menu: "
					+ "\n1) Vehicle Management"
					+ "\n2) Client Management"
					+ "\n3) Leasing Options"
					+ "\n4) Additional Operations"
					+ "\n5) Exit");
			System.out.print("\nEnter choice (1-5): ");
			choiceInt2 = verifyInt(1,5);
			
			int choiceInt3;
			switch (choiceInt2) {
		
			case 1:
				do {
					System.out.print("\n\tManagment options:"
							+ "\n1) Add a vehicle"
							+ "\n2) Delete a vehicle"
							+ "\n3) Update vehicle information"
							+ "\n4) List all vehicles by catagory"
							+ "\n5) Return to menu"
							+ "\nChoice: ");
					choiceInt3 = verifyInt(1,5);
					
					switch(choiceInt3) {
					case 1:
						addVehicleDriver();
						break;
					case 2:
						deleteVehicleDriver();
						break;
					case 3:
						editVehicleDriver();
						break;
					case 4:
						listVehiclesByCatagory();
						break;
					}
					
				} while (choiceInt3 != 5);
				
				//end of case 1
				break;
				
			case 2:
				do {
					System.out.print("\n\tClient managment options"
							+ "\n1) Add a client"
							+ "\n2) Edit a client"
							+ "\n3) Delete a client"
							+ "\n4) Display all clients"
							+ "\n5) Return to menu"
							+ "\nChoice: ");
					choiceInt3 = verifyInt(1,5);
					
					switch (choiceInt3) {
				
					case 1:
						addClientDriver();
						break;
					case 2:
						editClientDriver();
						break;
					case 3:
						removeClientDriver();
						break;
					case 4:
						System.out.print("\nAll clients: \n");
						Client.readArray();
						break;
				
					}
					
				} while (choiceInt3 != 5);
				
				break;
			
			case 3:
				do {
					System.out.print("\n\tLease managment options"
							+ "\n1) Lease a vehicle to a client"
							+ "\n2) Return a vehicle from a client"
							+ "\n3) Show all vehicles leased by a client"
							+ "\n4) Show all leased vehicles (by all clients)"
							+ "\n5) Return to menu"
							+ "\nChoice: ");
					choiceInt3 = verifyInt(1,5);
					
					switch (choiceInt3) {
						case 1:
							addLease();
							break;
						case 2:
							returnVehicle();
							break;
						case 3:
							showLeasesClient();
							break;
						case 4:
							System.out.print("\nLeases: ");
							Leases.showAllLeases();
							break;
					}
					
				} while (choiceInt3 != 5);
				
				break;
			
			case 4:
				do {
					System.out.print("\n\tAdditional Opperations"
							+ "\n1) Display truck with the largest capacity"
							+ "\n2) Create copy of the electric truck array"
							+ "\n3) Return to menu"
							+ "\nChoice: ");
				choiceInt3 = verifyInt(1,3);
				
				switch (choiceInt3) {
				case 1:
					showLargestCapacityTruck();
					break;
				case 2:
					Vehicle[] electricTruckArray = copyVehicles("ET");
					
					System.out.print("\nArray created!"
							+ "\nWould you like to print the array? "
							+ "\n1) Yes"
							+ "\n2) No"
							+ "\nChoice:\n ");
					int choiceInt4 = verifyInt(1,2);
					if (choiceInt4 == 1) {
						
						if (electricTruckArray != null) {
							for (int i = 0; i < electricTruckArray.length; i++) {
								if (electricTruckArray[i] != null)
								System.out.println(electricTruckArray[i]);
								}
							}
							else
								System.out.println("\nNo electric trucks to store");
					}
					
					break;
				}
				
				} while (choiceInt3 != 3);
					
				break;
			}
			
			
		} while (choiceInt2 != 5);
		
		System.out.println("\nThank you for using the royal rentals repository!");
		
		}//end of if statement/menu
	kb.close();
	}//end of main

	
	
	
	
	
	
	
	
	
	
	//METHODES FOR GENERATING RANDOM VEHICLES
	
	
	public static Vehicle[] getRandomVehicleArray(int size) {
		
		//generate random vehicles.
		
				Vehicle[] randomArray = new Vehicle[100];
				
				//pick between 1-5
				for (int i = 0; i < size; i++) {
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
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	//INPUT VERIFICATION MEHODES
	
	//for input verification

		
		
		public static int verifyInt(int start, int end) {
			
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
			} 
			
		public static double verifyDouble(int start, int end) {
	
				double result;
				
				while (true){
				if (kb.hasNextDouble()) {
					result = kb.nextDouble();
					
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
	
			
			
			
			
			
			
			
			
			
			
			
			
		//VEHICLE MANAGEMENT METHODES
		
		public static void addVehicleDriver() {
			
			System.out.print("\n\tChoose type of vehicle:"
					+ "\n1)Gas Car"
					+ "\n2)Electric Car"
					+ "\n3)Gas Truck"
					+ "\n4)Diesel Truck"
					+ "\n5)Electric Truck"
					+ "\nChoice (1-5): ");
			int choiceInt = verifyInt(1,5);
			
			kb.nextLine(); //reset new line
			System.out.print("\nEnter make: ");
			String make = kb.nextLine();
			
			System.out.print("\nEnter model: ");
			String model = kb.nextLine();
			
			System.out.print("\nEnter year: ");
			int year = verifyInt(1900,2025);
			
			int choiceInt2;
			int choiceInt3;
			
			double choiceDouble;
			double choiceDouble2;
			
			switch(choiceInt) {
			case 1:
				System.out.print("\nEnter max passenger capacity: ");
				choiceInt2 = verifyInt(1,10);
		
				GasCar gasCar = new GasCar(make, model, year, choiceInt2);
				break;
			case 2:
				System.out.print("\nEnter max passenger capacity: ");
				choiceInt2 = verifyInt(1,10);
				System.out.print("\nEnter max autonomy range (km): ");
				choiceDouble = verifyDouble(1,1000);
				
				ElectricCar electricCar = new ElectricCar(make, model, year, choiceInt2, choiceDouble);
				break;
			case 3:
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				
				GasTruck gasTruck = new GasTruck(make,model,year, choiceDouble);
				break;
			case 4:
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				System.out.print("\nEnter Fuel capacity (gallons): ");
				choiceDouble2 = verifyDouble(1,100);
				
				DieselTruck dieselTruck = new DieselTruck(make,model,year, choiceDouble, choiceDouble2);
				break;
			case 5:
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				System.out.print("\nEnter max autonomy range (km): ");
				choiceDouble2 = verifyDouble(1,1000);
				
				ElectricTruck electrickTruck = new ElectricTruck(make,model,year, choiceDouble, choiceDouble2);
				break;
			}
					
		}//end of method
		
		public static void deleteVehicleDriver() {
			
			System.out.print("Enter license plate: ");
			kb.nextLine(); //reset new line
			String plate = kb.nextLine();
			
			Vehicle.removeVehicle(plate);
		}
		
		public static void editVehicleDriver() {
			
			
			System.out.print("\nEnter existing vehicle plate: ");
			kb.nextLine(); //reset new line
			String plate = kb.nextLine();
			String plateChoice = plate.substring(0, 2);
			
			System.out.print("\nEnter new make: ");
			String make = kb.nextLine();
			
			System.out.print("\nEnter new model: ");
			String model = kb.nextLine();
			
			System.out.print("\nEnter new year: ");
			int year = verifyInt(1900,2025);
			
			int choiceInt2;
			double choiceDouble;
			double choiceDouble2;
			
			switch (plateChoice) {
			case "GC":
				System.out.print("\nEnter new max passenger capacity: ");
				choiceInt2 = verifyInt(1,10);
		
				GasCar.editGasCar(plate, make, model, year, choiceInt2);
				break;
				
			case "EC":
				System.out.print("\nEnter new max passenger capacity: ");
				choiceInt2 = verifyInt(1,10);
				
				System.out.print("\nEnter new max autonomy range (km): ");
				choiceDouble = verifyDouble(1,1000);
				ElectricCar.editElectricCar(plate, make, model, year, choiceInt2, choiceDouble);
				break;
		
			case "GT":
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				
				GasTruck.editGasTruck(plate, make, model, year, choiceDouble);
				break;
			case "DT":
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				System.out.print("\nEnter Fuel capacity (gallons): ");
				choiceDouble2 = verifyDouble(1,100);
				
				DieselTruck.editDieselTruck(plate, make, model, year, choiceDouble, choiceDouble2);
				break;
			case "ET":
				System.out.print("\nEnter max weight capacity (kg): ");
				choiceDouble = verifyDouble(1,50000);
				System.out.print("\nEnter max autonomy range (km): ");
				choiceDouble2 = verifyDouble(1,1000);
				
				ElectricTruck.editElectricTruck(plate, make, model, year, choiceDouble, choiceDouble2);
				break;
			}
		}
		

		public static void listVehiclesByCatagory() {
			
			String choice;
			
			boolean valid = false;
			do {
				System.out.print("\nEnter type of vehicle"
						+ "\nChoose from (ET,GT,DT,GC,EC): ");
				kb.nextLine(); //reset new line
				choice = kb.nextLine();
				if (choice.equals("ET")||choice.equals("GT")||choice.equals("DT")||choice.equals("GC")||choice.equals("EC"))
					valid = true;
				else
					System.out.println("\nInvalid input, try again.");
				
			} while (valid == false);
			
			//method in the vehicle class to print all plates beginning with a certain type
			Vehicle.checkArray(choice);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//ClIENT MANAGEMENT METHODES
		
		public static void addClientDriver() {
			kb.nextLine();
			System.out.print("\nEnter client name: ");
			String name = kb.nextLine();
			Client client = new Client(name);
			System.out.println("\nNew client created: "
					+ "\n" + client);
		}
		
		public static void editClientDriver() {
			
			kb.nextLine();
			System.out.print("\nEnter client id: ");
			String id = kb.nextLine();
			System.out.print("\nEnter desired name: ");
			String name = kb.nextLine();
			
			Client.editClient(id, name);
		}
		
		public static void removeClientDriver() {
			
			kb.nextLine(); //reset new line
			System.out.print("\nEnter client id to remove: ");
			String id = kb.nextLine();
			
			Client.removeClient(id);
		}
		
		
		
		
		
		
		
		
		
		
		//LEASE MANAGMENT OPTIONS
		
		public static void addLease() {
			
				kb.nextLine(); //reset new line
				System.out.print("\nEnter client ID: ");
				String clientId = kb.nextLine();
		
				System.out.print("\nEnter vehicle plate: ");
				String plate = kb.nextLine();
			
			if (Vehicle.vehicleExists(plate)&&Client.clientExists(clientId)) {
				Leases lease = new Leases(clientId, plate);
				}
			else
				System.out.print("Client/Vehicle does not exist in our database\n");
		}
		
		public static void returnVehicle() {
			
			kb.nextLine(); //reset new line
			System.out.print("\nEnter client ID: ");
			String clientId = kb.nextLine();
		
			System.out.print("\nEnter vehicle plate: ");
			String plate = kb.nextLine();
			
			if (Vehicle.vehicleExists(plate)&&Client.clientExists(clientId)) {
				Leases.removeLease(clientId, plate);
				}
			else
				System.out.print("Client/Vehicle does not exist in our database\n");
			
		}
		
		public static void showLeasesClient() {
		
			kb.nextLine(); //reset new line
			System.out.print("\nEnter client ID: ");
			String clientId = kb.nextLine();
			
			if (Client.clientExists(clientId)) {
				System.out.println("Leases:");
				Leases.showLeases(clientId);
			}
			else
				System.out.println("Client not in our database");
		}
		
		
		
		
		
		
		
		
		//ADDITIONAL OPPERATIONS
		
		public static void showLargestCapacityTruck() {
		
			String choice;
			
			boolean valid = false;
			do {
				System.out.print("\nEnter type of vehicle"
						+ "\nChoose from (ET,GT,DT): ");
				kb.nextLine(); //reset new line
				choice = kb.nextLine();
				if (choice.equals("GT")||choice.equals("DT")||choice.equals("ET"))
					valid = true;
				else
					System.out.println("\nInvalid input, try again.");
				
			} while (valid == false);
			
			if (getLargestCapacityTruck(choice) != null)
			System.out.println("\nLargest Capacity Truck:\n" + getLargestCapacityTruck(choice));
			else
				System.out.println("\nThis type of vehicle is not in our database");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//ADDITIONAL METHODES FOR PREDEFINED SCENARIO
		
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
		
		//PSEUDO COPY VEHICLES METHOD
		//my code does not run on driver side vehicle arrays.
		//but I can create new arrays for any type of vehicle.
		
		
		public static Vehicle[] copyVehicles(String type) {
			
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
		
		
		
		
		
		
		
		
		
		
		//PREDEFINED SCENARIO
		
		public static void predefinedScenario() {
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
			
			//the copyVehicles() calls upon the master array that all vehicles are stored into
			//within the vehicle class. The method parses the array and creates a deep copy array for the 
			//specified type
			Vehicle[] dieselTruckArray = copyVehicles("DT");
			Vehicle[] ElectricTruckArray = copyVehicles("ET");
			Vehicle[] gasTruckArray = copyVehicles("GT");
			Vehicle[] gasCarArray = copyVehicles("GC");
			Vehicle[] electricCarArray = copyVehicles("EC");
			
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
			
			System.out.println("\nCopy Vehicles method on electric trucks");
			Vehicle[] electricTruckArray = copyVehicles("ET");
			
			//read the array recieved by the getArrayForType method.
			if (electricTruckArray != null) {
			for (int i = 0; i < electricTruckArray.length; i++) {
				if (electricTruckArray[i] != null)
				System.out.println(electricTruckArray[i]);
				}
			}
			else
				System.out.println("No electric trucks to store");
			
		}//end of predefinedScenario method
		
		
	
		
}
