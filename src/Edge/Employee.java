package Edge;

public class Employee {
	 private String employeeID;
	 public String name;
	 private String cardID;
	 
	 public Employee(String employeeID, String name, String cardID) {
	        this.employeeID = employeeID;
	        this.name = name;
	        this.cardID = cardID;
	    }
	 
	 //returns employee card
	 //stored in the employeelist arraylist
	 public String returnCard() {
		 return cardID;
	 }
}

