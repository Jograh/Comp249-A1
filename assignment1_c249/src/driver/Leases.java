package driver;
import client.*;
import vehicle.*;

public class Leases {

	private static Leases[] leaseArray = new Leases[50];
	private static int leasesCount = 0;
	
	private Client client;
	private Vehicle vehicle;
	
	public Leases(Client client, Vehicle vehicle) {
		this.client = client;
		this.vehicle = vehicle;
		
		if (leasesCount < leaseArray.length) {
			leaseArray[leasesCount] = this;
			leasesCount++;
		}
		else
			System.out.println("Lease limit reached");
		
	}
	
	//returns vehicle from client
	public static void removeLease(Client client, Vehicle vehicle) {
		
		//checks array for client
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i].client.equals(client) && leaseArray[i].vehicle.equals(vehicle)){
				
				//shifts every value passed the desired client to the left
				//which will remove the desired client
				for (int k = i; k < (leaseArray.length - 1); k++) {
					
					leaseArray[k] = leaseArray[k+1];

				}
				//clear last element
				leaseArray[leaseArray.length - 1] = null;
				break;

			}
					
		}
	}
	
	public String toString() {
		return this.client.toString() + "\n" + this.vehicle.toString();
	}
	
	public static void showAllLeases() {
		
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i] != null)
			System.out.println(leaseArray[i].client.toString() + "\n" + leaseArray[i].vehicle.toString());
		}
	}
	
	public static void showLeases(Client client) {
		
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i] != null && leaseArray[i].client.equals(client))
			System.out.println(leaseArray[i].client.toString() + "\n" + leaseArray[i].vehicle.toString());
		}
	}
	
}
