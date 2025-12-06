package Edge;

public class Employee {
	 private String employeeID;
	 public String name;
	 private String cardID;
	 private String password;
	 
	 public Employee(String employeeID, String name, String cardID, String password) {
	        this.employeeID = employeeID;
	        this.name = name;
	        this.cardID = cardID;
	        this.password = password;
	    }
	 
	 //returns employee card
	 //stored in the employeelist arraylist
	 public String returnCard() {
		 return cardID;
	 }

	 public String getId() {
		return employeeID;
	 }
	 public String getPassword() {
		return password;
	 }
	 
}

