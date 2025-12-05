package Edge;

//extends to device
public class CameraSystem extends Device{

	//adds ip address and deviceID
	public CameraSystem(String deviceID, String ipAddress) {
		super(deviceID, ipAddress);
		
	}
	
	//detects a singular person
	//simulates detecting a person one
	//at a time
	public int detectPerson() {
	        return 1;
	  }
	
	
}
