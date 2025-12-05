package Edge;

public class ManagerConsole {
	
	//store so manager can access it
	private Store store;

    public ManagerConsole(Store store) {
        this.store = store;
    }

    //checks if manager is allowed to go inside
    public boolean accessCentralSystem(String pass, Manager manager) {
        return manager.returnAdminPass() == pass;
    }

    //manager sets the store's capacity limit
    //uses an object store to access it
    public void setCapacityLimit(int newLimit) {
        store.setMaxCustomers(newLimit);
    }
}

