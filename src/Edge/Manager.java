package Edge;

public class Manager extends Employee {
private String adminpass;
	
//manager has to create his own adminpass
	public Manager(String employeeID, String name, String cardID, String password, String adminpass) {
		super(employeeID, name, cardID, password);
		this.adminpass = adminpass;
	}
	
	//returns adminpass for verification
	public String returnAdminPass() {
		return adminpass;
	}
 
}
