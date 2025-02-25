/*
--------------------------------------------------------------
Assignment 1
Joshua Graham 40285958
--------------------------------------------------------------
*/
package client;

public class Client {

	private String clientID, name;
	private static Client[] clientArray = new Client[50];
	private static int clientCount = 0;
	
	

	
	public Client(String name) {
		
		String tempID = "";
		
		boolean isValid = false;
		
		while (isValid == false) {
		
			for (int i = 0; i < 8; i++) {
			
			//generates random character
			int random = (int) (Math.random() * 62);  //62 possible characters (26 lowercase, 26 uppercase, 10 digits)
	        char randomChar;

	        if (random < 10) {
	            randomChar = (char) (random + 48);  //Digits 0 to 9 (ASCII 48-57)
	        } else if (random < 36) {
	            randomChar = (char) (random - 10 + 65);  //Uppercase 'A' to 'Z' (ASCII 65-90)
	        } else {
	            randomChar = (char) (random - 36 + 97);  //Lowercase 'a' to 'z' (ASCII 97-122)
	        }
	        
	        tempID = tempID + randomChar;
			}
			//second loop to verify the generate id is not already in use.
			//loop checks for a duplicate id and breaks if done
			//if broken isValid2 will be set to false and the while loop will run again
			boolean isValid2 = true;
				
			for (int i = 0; i < clientArray.length; i++) {
					
					if (clientArray[i]!=null) {
						if (tempID.equals(clientArray[i].clientID)) {
							isValid2 = false;
							break;
						}

					}		
				}
			if (isValid2)
				isValid = true;
		}
		
		this.clientID = tempID;
		this.name = name;
		
		if (clientCount < clientArray.length) {
			clientArray[clientCount] = this;
			clientCount++;
		}
		else
			System.out.println("Client count limit reached");	
	}
	
	//for manual ID
	public Client(String name, String clientID) {
	
		this.clientID = clientID;
		this.name = name;
		
		if (clientCount < clientArray.length) {
			clientArray[clientCount] = this;
			clientCount++;
		}
		else
			System.out.println("Client count limit reached");
	}
	
	
	public Client(Client client) {
		this(client.name, client.clientID);
	}
	
	public static void editClient(String ID, String name) {
		//finds client
		for (int i = 0; i < clientArray.length; i++) {
			if (clientArray[i] != null && clientArray[i].getCliendID().equals(ID)) {
				removeClient(ID);
				Client client = new Client(name, ID);
				break;
			}
		}
	}
	
	
	public static void removeClient(String ID) {
		
		//checks array for client
		for (int i = 0; i < clientArray.length; i++) {
			
			if (clientArray[i].getCliendID().equals(ID)){
				
				//shifts every value passed the desired client to the left
				//which will remove the desired client
				for (int k = i; k < (clientArray.length - 1); k++) {
					
					clientArray[k] = clientArray[k+1];

				}
				//clear last element
				clientArray[clientArray.length - 1] = null;
				clientCount--;
				break;

			}
					
		}
	}
	
	
	
	//getters
	public String getCliendID() {
		return this.clientID;
	}
	
	public String getName() {
		return this.name;
	}
	
	//setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	public String toString() {
		return "Client ID: " + this.clientID + " Name: " + this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Client c = (Client)obj;
		return this.clientID.equals(c.clientID) && this.name.equals(c.name);
	}
	
	//read array
	public static void readArray() {
		
		for (int i = 0; i < clientArray.length; i++)
			if (clientArray[i] != null)
			System.out.println(clientArray[i]);
	}
	
	//method
	public static boolean clientExists(String clientID) {
		
		for (int i =0; i < clientArray.length; i++) {
			if (clientArray[i] != null && clientArray[i].clientID.equals(clientID))
				return true;
		}
		return false;
	}
	
}
