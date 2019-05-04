//Hector Rios. File for TESTING


public class testingFile {
	
	public static void main(String [] args)
	{
		double [] location;
		boolean isLost = false;
		String pathname = "/Users/hectorrios/git/Lab-02/Lab 02/src/fileInfo.txt";
		
		Device hrios = new Device("hrios", 8492);  //Class from Device perspective.
		ReadData user = new ReadData(pathname, "hrios"); //Read data perspective.
		
		isLost = true;
		user.getUserData();
		user.writeDeviceLost(isLost); //Setting device to LOST.
				
		System.out.println("Testing Files for CSC 131 Project ...");
		System.out.println("Device Class ...");
		
		location = hrios.returnlocation();
		
		System.out.println("Device User: ");
		for (int count = 0; count < location.length; count++)
		{
			System.out.println("Location Num: " + location[count]);
		}
	}
}
