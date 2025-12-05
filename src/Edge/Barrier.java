package Edge;

public class Barrier extends Device {
	public boolean isOpen;
	public String notice_message;

	public Barrier(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);
	}

	//barrier set to open
	public void open() {
		isOpen = true;
		notice_message = "Open";
	}

	public boolean isOpen(){
		return isOpen;
	}

	//barrier set to close
	public void closed() {
		isOpen = false;
		notice_message = "Closed";
	}

	//displays the notice
	public String display_notice() {
		return notice_message;
	}
}
