package Edge;

public class CentralSystem {
	
	//basic construction
	public String systemID;
	public int deviceCount = 4;

	//list of all devices in the system
	public CameraSystem camIn;
	public CameraSystem camOut;
	public CardReader reader;
	public Barrier barrier;
	
	//store for central system to access it
	private Store store;

	public CentralSystem(String systemID, Store store) {
		this.systemID = systemID;
		this.store = store;

		// create devices
		camIn = new CameraSystem("CamEnter", "10.1");
		camOut = new CameraSystem("CamExit", "10.2");
		reader = new CardReader("CR", "10.3");
		barrier = new Barrier("Barrier1", "10.4");

	}

	//updates customer count
	public void addCount() {
		int newValue = store.getCustomerCount() +  camIn.detect_person();
		store.setCustomerCount(newValue);
	}
	
	public void minusCount() {
		int newValue = store.getCustomerCount() - camOut.detect_person();
		store.setCustomerCount(newValue);
	}

	public void controlBarrier() {
		
		//if customers is now at capacity outputs message of display and closes or opens barrier
	
		if (store.getCustomerCount() >= store.getMaxCustomers()){
			barrier.closed();
			System.out.println("the barrier is " + barrier.display_notice() + " the customer did not enter");
		}
		else{
			barrier.open();
			System.out.println("The barrier is " + barrier.display_notice() + " the customer entered");
		}
	}

	
	
	public Boolean AllowEmployee() {
		return reader.validateEmployee(systemID, store);
	}

	//views store customer count
	public int viewCount() {
		return store.getCustomerCount();
	}
}
