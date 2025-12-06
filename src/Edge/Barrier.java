package Edge;

//Extends the abstract class of Device
public class Barrier extends Device {
	
	//current boolean status for barrier
	public boolean isOpen = true;
	
	//message that can be used to return the opening status
	public String notice_message = "Open for business"; 
	public boolean automaticControl = true;
	
	//initializes with the deviceID and ipaddress
	public Barrier(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);
	}

	//barrier set to open
	public void open() {
		isOpen = true;
		notice_message = "Barrier is Open for business.";
	}

	//checks if the barrier is open
	public boolean isOpen(){
		return isOpen;
	}

	//barrier set to close
	public void closed() {
		isOpen = false;
		notice_message = "Barrier is closed. Store occupancy limit reached.";
	}

	//displays the notice
	public String displayNotice() {
		return notice_message;
	}
}
