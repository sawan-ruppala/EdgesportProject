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
			if (e.returnCard() == cardID) {
				return true;
			}
		}
		return false;
	}

}
