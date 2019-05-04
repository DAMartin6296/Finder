//Team ATS. Author: Hector Rios.

import java.util.Random;

public class Device 
{
	private String device_User = "";
	
	//ID of the device or device's tag.
	private int device_ID = 0000;
	
	boolean status_lost = false; //False = not Lost, True = is Lost.
	
	/*
	 * Registering Device? Enter ID
	*/
	public Device(String user, int deviceID)
	{
		//Start off the device with User and ID.
		device_User = user;
		device_ID = deviceID;
		status_lost = false; //Set device to 'not lost' - false.
	}
	
	//Return the device ID
	public int get_device_ID()
	{
		return device_ID;
	}
	
	//Return the user name.
	public String get_device_User()
	{
		return device_User;
	}
	
	//Function to get lost status of device.
	public boolean get_device_status()
	{
		//return device status. true = lost / false = not lost.
		return status_lost;
	}
	
	//Sets the status_lost boolean to opposite. Item lost or Item Found
	public boolean set_device_status()
	{
		return !status_lost;
	}
	
	//Purpose is to return location to the server.
	//Location is a size 2 array of the Latitude, and Longitude
	public double [] returnlocation()
	{
		Random random  = new Random();
		int Latitude1  = random.nextInt(100), 
			Longitude1 = random.nextInt(100);
		
		double Latitude2  = random.nextDouble(),
		       Longitude2 = random.nextDouble();
		
		double [] location = {0.0, 0.0};
		
		location[0] = Latitude1 + Latitude2;
		location[1] = Longitude1 + Longitude2;
		
		return location;
	}

}
