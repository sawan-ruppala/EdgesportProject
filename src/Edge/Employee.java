package Edge;

public class Employee {
	 private String employeeID;
	 private String name;
	 private String cardID;
	 
	 public Employee(String employeeID, String name, String cardID) {
	        this.employeeID = employeeID;
	        this.name = name;
	        this.cardID = cardID;
	    }
	 
	 //returns employee card in arraylist database
	 public String returncard() {
		 return cardID;
	 }
}

