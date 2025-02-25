/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class Vehicle {

	
	
	protected String plateNumber, make, model;
	
	protected int year;
	
	protected static Vehicle[] vehicleArray = new Vehicle[100];
	protected static int vehicleCount = 0;
	
	
	public Vehicle(String plateNumber, String make, String model, int year) {
		this.plateNumber = plateNumber;
		this.make = make;
		this.model = model;
		this.year = year;
		
		if (vehicleCount < vehicleArray.length) {
			vehicleArray[vehicleCount] = this;
			vehicleCount++;
		}
	}
	
	public Vehicle() {
		this(null, null, null, 0);
	}
	
	public Vehicle(Vehicle obj) {
		this(obj.plateNumber, obj.make, obj.model, obj.year);
	}
	
	
	//getters
	public String getPlateNumber() {
		return this.plateNumber;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getYear() {
		return this.year;
	}
	
	
	public static int getVehicleCount() {
		return vehicleCount;
	}
	
	//setters
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
	
	//removing vehicle
	
	
	public static void removeVehicle(String plate) {
		
		for (int i = 0; i < vehicleArray.length; i++) {
			
			//find the vehicle
			if (vehicleArray[i].plateNumber.equals(plate)){
				
				//shifts every value passed the desired vehicle to the left
				//which will remove the desired vehicle
				for (int k = i; k < (vehicleArray.length - 1); k++) {
					
				vehicleArray[k] = vehicleArray[k+1];

				}
				//clear last element
				vehicleArray[vehicleArray.length - 1] = null;
				vehicleCount--;
				break;
			}
		}	
	}//end of method
	
	
	public static String nextPlate(char a, char b) {
		//checks vehicle array
		
		int smallestAvailable = 1001;
		int itterations = 0;
		
		//Iterates for as many times as there is space in the array
		do {
			//cycles through array
		for (int i = 0; i < vehicleArray.length; i++) {
				if (vehicleArray[i] != null) {
				String tempPlate1 = vehicleArray[i].plateNumber;
				//checks for license plate type
				if (tempPlate1.charAt(0) == a && tempPlate1.charAt(1) == b)
				{	
					//converts the proper license plate into integer
					int plateNumber = Integer.valueOf(tempPlate1.substring(2));
					
					if (plateNumber == smallestAvailable)
						smallestAvailable++;
				}//end of license plate met conditions	
		
				}
				itterations++;
		}//end of main loop
	
		} while (itterations < vehicleArray.length);
		
		String nextPlate = "" + a + b + Integer.toString(smallestAvailable);
		return nextPlate;
		
	}//end of method
	
	
	//toString
	public String toString() {
		
		String vehicleType = this.plateNumber.substring(0, 2);
		
		switch(vehicleType) {
		
		case "EC":
			vehicleType = "Electric Car";
			break;
		
		case "DT":
			vehicleType = "Diesel Truck";
			break;
		
		case "ET":
			vehicleType = "Electric Truck";
			break;
		
		case "GC":
			vehicleType = "Gas Car";
			break;
		
		case "GT":
			vehicleType = "Gas Truck";
			break;
		
		default:
			vehicleType = "Vehicle";
		}
		
		return "Type: " + vehicleType +"\nMake: " + make + "\nModel: " + this.model + "\nYear: " + this.year + "\nPlate Number: " + this.plateNumber;
	}
	
	//equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Vehicle V = (Vehicle) obj;
		return this.year == V.year  && this.make == V.make && this.model == V.model;
		
	}
	
	//default for checking vehicle array
	public static void checkArray() {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (vehicleArray[i] != null)
			System.out.println(vehicleArray[i]);
		}
		System.out.println("Vehicle count: " + vehicleCount);
	}
	
	//overloaded method to check a specific type of car
	public static void checkArray(String type) {
		
		int vehicleCount2 = 0;
		for (int i = 0; i < vehicleArray.length; i++) {
			if (vehicleArray[i] != null) {
				
				String vehicleType = vehicleArray[i].plateNumber.substring(0, 2);
				
			if (vehicleType.equals(type))
			{	
			System.out.println(vehicleArray[i]);
			vehicleCount2++;
			}
			}
		}
		System.out.println(" count: " + vehicleCount2);
	}
	
	//used in predefined scenario
	public static Vehicle[] getVehicleArray() {
		
		Vehicle[] tempArray = new Vehicle[100];
		
		for (int i = 0; i < vehicleArray.length; i++) {
			tempArray[i] = vehicleArray[i];
		}
		
		return tempArray;
	}
	
	
	
	//Used in the driver to check if a plate number is used.
	public static boolean vehicleExists(String plateNumber) {
		for (int i = 0; i < vehicleArray.length; i++) {
			if (vehicleArray[i]!= null && vehicleArray[i].plateNumber.equals(plateNumber))
				return true;
		}
		return false;
	}

}
