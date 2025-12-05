package Edge;

//abstract class
//has ipaddress and device ID
public abstract class Device {

	public String deviceID;
	public String ipAddress;

	
	public Device(String deviceID, String ipAddress) {
        this.deviceID = deviceID;
        this.ipAddress = ipAddress;
        
    }

    
}
