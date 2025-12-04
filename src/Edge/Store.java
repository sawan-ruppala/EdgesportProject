

//NOT DONE YET
//STILL EXPIREMENTAL 
package Edge;

import java.util.ArrayList;

public class Store {

    private int maxCustomers;
    private int customerCount;
    
    //assuming there is only one manager
    public Manager manager;
    
    //list of employees
    ArrayList<Employee> employeelist = new ArrayList<Employee>(); 

    public ManagerConsole man_console;
    public CentralSystem system;

    public Store(int maxCustomers) {

        this.maxCustomers = maxCustomers;
        this.customerCount = 0;

        //found something interesting from internet
        //systems and console can link directly to this store
        //https://stackoverflow.com/questions/17441871/is-passing-this-in-a-method-call-accepted-practice-in-java
        //basically you can have a system object in a store, and a store have a system object
        this.man_console = new ManagerConsole(this);
        this.system = new CentralSystem("S-1", this);
    }


    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int count) {
        this.customerCount = count;
    }

    public void setMaxCustomers(int newLimit) {
        this.maxCustomers = newLimit;
    }

    public int getMaxCustomers() {
        return maxCustomers;
    }
}
