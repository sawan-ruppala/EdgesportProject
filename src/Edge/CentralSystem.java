package Edge;

public class CentralSystem {

	// basic construction
	public String systemID;
	public int deviceCount = 4;

	// list of all devices in the system
	public CameraSystem camIn;
	public CameraSystem camOut;
	public CardReader reader;
	public Barrier barrier;

	// store for central system to access it
	private Store store;

	public CentralSystem(String systemID, Store store) {
		this.systemID = systemID;
		this.store = store;

		// create the devices
		//creates the "ip-addresses" for all devices
		camIn = new CameraSystem("CamEnter", "10.1");
		camOut = new CameraSystem("CamExit", "10.2");
		reader = new CardReader("CR", "10.3");
		barrier = new Barrier("Barrier1", "10.4");

	}

	// entrance camera detects a person
	// store updates the total and sets the customer count
	public void addCount() {

		// camera detects a singular person
		int entry = camIn.detectPerson();

		// system updates the total amount
		int total = store.getcustomerCount() + entry;

		// sets a new total count of customers
		store.setcustomerCount(total);
	}

	// exit camera detects a person leaving
	// store minus one person and updates customer count
	public void minusCount() {
		
		// camera detects a person
		int exit = camIn.detectPerson();

		// system updates the total amount
		int total = store.getcustomerCount() - exit;

		// sets a new total count of customers
		store.setcustomerCount(total);
	}

	// does an autocontrol of the Barrier
	// uses the barrier object, doesnt do it central system directly
	public void controlBarrier() {

		// if customers is now at capacity outputs message of display and closes or
		// opens barrier
		if (store.getcustomerCount() >= store.getMaxCustomers()) {
			barrier.closed();
			System.out.println(barrier.displayNotice());
		}

		else {
			barrier.open();
			System.out.println(barrier.displayNotice());
		}
	}

	// checks if the employee is allowed in the store
	// uses the cardreader to handle the logic, not directly
	// in the system
	public Boolean AllowEmployee(String cardID) {
		return reader.validateEmployee(cardID, store);
	}

	// views store customer count
	public int viewCount() {
		return store.getcustomerCount();
	}
}
