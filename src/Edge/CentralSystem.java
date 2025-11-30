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
	public void updateCount(int count) {
		int newValue = store.getCustomerCount() + count;
		store.setCustomerCount(newValue);
	}

	public void controlBarrier() {
		
		//if customers is now at capacity
		if (store.getCustomerCount() == store.getMaxCustomers())
			barrier.closed();
		
		else
			barrier.open();
	}
	
	public Boolean AllowEmployee() {
		return reader.validateEmployee(systemID, store);
	}

	//views store customer count
	public int viewCount() {
		return store.getCustomerCount();
	}
}
