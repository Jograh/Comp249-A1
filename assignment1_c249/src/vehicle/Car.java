/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package vehicle;

public class Car extends Vehicle {

	private int maxPassengerCapacity;
	
	
	public Car(String plateNumber, String make, String model, int year, int maxPassengerCapacity) {
		super(plateNumber, make, model, year);
		this.maxPassengerCapacity = maxPassengerCapacity;
		
	}
	
	public Car() {
		this(null, null, null, 0, 0);
	}
	
	public Car(Car obj) {
		super(obj);
		this.maxPassengerCapacity = obj.maxPassengerCapacity;
	}
	
	//getters and setters
	public void setMaxPassengerCapacity(int maxPassengerCapacity) {
		this.maxPassengerCapacity = maxPassengerCapacity;
	}
	
	public int getMaxPassengerCapacity() {
		return this.maxPassengerCapacity;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nMax Passenger Capacity: " + this.maxPassengerCapacity+"\n";
	}
}
