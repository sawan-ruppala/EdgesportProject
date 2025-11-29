package Edge;

public class CardReader extends Device {

	// initialize the CardReader
	public CardReader(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);

	}

	// checks the store's array list of employees
	public boolean validateEmployee(String key, Store store) {
		for (Employee emp : store.employeelist) {
			if (emp.returncard() == key) {
				return true;
			}
		}
		return false;
	}

}
