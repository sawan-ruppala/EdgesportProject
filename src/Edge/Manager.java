package Edge;

public class Manager extends Employee {
private String adminpass;
	
//manager has to create his own adminpass
	public Manager(String employeeID, String name, String cardID, String adminpass) {
		super(employeeID, name, cardID);
		this.adminpass = adminpass;
	}
	
	//returns adminpass
	public String return_adminpass() {
		return adminpass;
	}
 
}
