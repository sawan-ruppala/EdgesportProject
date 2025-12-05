package Edge;

public class Barrier extends Device {
	public boolean isOpen = true; // Sets default state to open
	public String notice_message = "Open for business"; // Sets default value
	public boolean automaticControl = true;
	
	public Barrier(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);
	}

	//barrier set to open
	public void open() {
		isOpen = true;
		notice_message = "Open for business.";
	}

	public boolean isOpen(){
		return isOpen;
	}

	//barrier set to close
	public void closed() {
		isOpen = false;
		notice_message = "Barrier is closed. Store occupancy limit reached.";
	}

	//displays the notice
	public String display_notice() {
		return notice_message;
	}
}
