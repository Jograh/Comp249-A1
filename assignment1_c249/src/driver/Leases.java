/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package driver;


public class Leases {
	
	//leases stored in this static array
	private static Leases[] leaseArray = new Leases[50];
	private static int leasesCount = 0;
	
	private String clientID;
	private String plate;
	
	public Leases(String clientID, String plate) {
		this.clientID = clientID;
		this.plate = plate;
		
		if (leasesCount < leaseArray.length) {
			leaseArray[leasesCount] = this;
			leasesCount++;
		}
		else
			System.out.println("Lease limit reached");
		
	}
	
	//returns vehicle from client
	public static void removeLease(String clientID, String plate) {
		
		//checks array for client
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i].clientID.equals(clientID) && leaseArray[i].plate.equals(plate)){
				
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
		return "Client Id: " + this.clientID + "\nLicense Plate: " + this.plate;

	}
	
	public static void showAllLeases() {
		
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i] != null)
			System.out.println(leaseArray[i].toString());
		}
	}
	
	public static void showLeases(String clientID) {
		
		for (int i = 0; i < leaseArray.length; i++) {
			
			if (leaseArray[i] != null && leaseArray[i].clientID.equals(clientID))
			System.out.println(leaseArray[i].toString());
		}
	
	}
	}