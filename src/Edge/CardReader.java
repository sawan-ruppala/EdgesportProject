package Edge;

public class CardReader extends Device {

	//initialize it with the super() deviceID and ipAddress
	public CardReader(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);

	}

	//boolean status that checks if the user's input exists
	//in the employeelist aka the database. 
	public boolean validateEmployee(String cardID, Store store) {
		for (Employee e : store.employeelist) {
			
			//Note: use equals() instead of == to correctly verify string
			if (e.returnCard().equals(cardID)) {
				System.out.println( e.name + " is verified. Continue Working at Edgesport");
				return true;
			}
		}
		System.out.println("EmployeeID was not found");
		return false;
	}

}
