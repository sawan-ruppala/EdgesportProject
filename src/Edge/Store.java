
//NOT DONE YET
//STILL EXPIREMENTAL 
package Edge;

import java.util.ArrayList;

public class Store {

	//set to default as 5 for testing
	private int maxCustomers = 5;
	private int customerCount;

	// assuming there is only one manager
	public Manager manager;

	// list of employees
	ArrayList<Employee> employeelist = new ArrayList<Employee>();

	// integrated class systems
	// man_console has the manager console system
	// system has all the class systems like barrier
	// cardreader, and cameras
	public ManagerConsole man_console;
	public CentralSystem system;

	public Store(int maxCustomers) {

		this.maxCustomers = maxCustomers;
		this.customerCount = 0;

		// found something interesting from internet
		// systems and console can link directly to this store
		// https://stackoverflow.com/questions/17441871/is-passing-this-in-a-method-call-accepted-practice-in-java
		// basically you can have a system object in a store, and a store have a system
		// object
		this.man_console = new ManagerConsole(this);
		this.system = new CentralSystem("S-1", this);

		// PRETEND THAT THIS IS THE DATABASE
		// SYSTEM WOULD PULL UP LIST OF EMPLOYEES FROM DATABASE
		// FINDS THE EMPLOYEE SAWAN & FELIX THE MANAGER

		// database.load();
		Employee Sawan = new Employee("123", "Sawan Ruppala", "456");
		Manager Felix = new Manager("234", "Felix", "234", "234");

		// database.add() to employeelist
		employeelist.add(Sawan);
		employeelist.add(Felix);

		// finds the sole manager in the "database", assuming one for each store
		// https://www.w3schools.com/java/ref_keyword_instanceof.asp
		for (Employee e : employeelist) {
			if (e instanceof Manager)
				this.manager = (Manager) e;
		}
	}

	// basic gets and sets
	public int getcustomerCount() {
		return customerCount;
	}

	// sets the current customer count
	public void setcustomerCount(int count) {
		this.customerCount = count;
	}

	public int getMaxCustomers() {
		return maxCustomers;
	}

	// method that the manager uses to set the barrier limit
	public void setMaxCustomers(int newLimit) {
		this.maxCustomers = newLimit;
	}

	// adds employee to the employee list
	// likely for future implementations
	// for manager e
	public void AddEmployee(Employee e) {
		employeelist.add(e);
	}
}
