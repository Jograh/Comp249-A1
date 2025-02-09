package vehicle;

public class GasTruck extends Truck {

	
	
	public GasTruck(String make, String model, int year, double maxWeightCapacity) {
		super(Vehicle.nextPlate('G', 'T'), make, model, year, maxWeightCapacity);
		
	}
	
	
	public GasTruck() {
		this(null,null,0,0);
	}
	
	public GasTruck(GasTruck obj) {
		super(obj);
	}
	
	
}
