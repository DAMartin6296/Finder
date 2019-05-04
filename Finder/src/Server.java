import java.util.*;

public class Server {
	private Scanner s;
	
	public void ask()
	{
		System.out.println("Is your device lost?\nPlease enter Y/N");
		s = new Scanner(System.in);
		String in = s.next();
		boolean isLost = false;
		
		if (in.equals("Y") || in.equals("y"))
		{	 
			double [] location;
			isLost = true;
			String pathname = "C:\\Users\\Hobbes\\git\\Finder\\Finder\\src\\fileInfo.txt";
			
			System.out.println("Please enter your username and device ID:");
			String user1 = s.next();
			int userID = s.nextInt();
			
			Device hrios = new Device(user1, userID);  //Class from Device perspective.
			ReadData user = new ReadData(pathname, user1); //Read data perspective.
			
			user.getUserData();
			user.writeDeviceLost(isLost); //Setting device to LOST.
			
			location = hrios.returnlocation();
			
			System.out.println("Device User: ");
			for (int count = 0; count < location.length; count++)
			{
				System.out.println("Location Num: " + location[count]);
			}
			
			s.close();

		}
		else if (in.equals("N") || in.equals("n"))
		{
			System.out.println("Then get lost");
			s.close();
			return;
		}
	}
}
