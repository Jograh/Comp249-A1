package vehicle;

public class GasCar extends Car {

	
	
	public GasCar(String make, String model, int year, int maxPassengerCapacity) {
		super(Vehicle.nextPlate('G', 'C'), make,model, year, maxPassengerCapacity);
		
	}
	
	
	public GasCar() {
		this(null,null,0,0);
	}
	
	public GasCar(GasCar obj) {
		super(obj);
	}
	
	
	
}
