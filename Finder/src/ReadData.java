//Team ATS. Author: Hector Rios.
// 'Where are we landing bois !!'

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.io.FileWriter;

import java.io.IOException;
public class ReadData {
	
	private String User;
	private String UserPassword;
	private int Device_ID;    
	public String filename;        //File name to read from. 
	public boolean isLost = false; // FALSE = 0 / TRUE = 1
	 
	public String user_line;       //Line to update the line in the data.
	
	public ReadData(String pathname, String userInput)
	{
		User = userInput;
		filename = pathname; //Records the path filename.
	}
	
	//Method will read and set user information to the class. 
	public void getUserData()
	{
		int count;                 //Loop counter
		String pathname = filename;
		
		String div = ",";    //Used to divide info.
		String [] userArray; //To hold divided info.
		
		try {
            FileReader reader = new FileReader(pathname);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            //While getting each line of the data file, BUT stops when USER data found.
            //Loop through each line and determine which user data to choose.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("User Data in file: " + line);
                
                System.out.println("Checking User name in line of data ...");
                
                //This divides the info in the data file into an array.
                userArray = line.split(div);  
                
                
                if (User.equals(userArray[0]))
            	{
            		System.out.println("User Found?: " + User);
            		user_line = line;
            		//Assigning data to class variables.
            		UserPassword = userArray[1].trim(); //Assigning the password.
            		Device_ID = Integer.parseInt(userArray[2].trim());  //Assigning device ID.
            		isLost = (Integer.parseInt(userArray[3].trim()) == 0) ? false : true;
            		
            		//This reads out information.
            		for (count = 0; count < userArray.length; count++)
                    {
            			System.out.println("INFO: " + userArray[count]);
                    }
            		break;
            	}
                System.out.println("========================================");
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Used to write the user into the file to set device to LOST/FOUND.
	//Needs: password, phone ID, and status.
	public void writeDeviceLost(boolean status)
	{
		String writeStatement = (User + ", " +
							     UserPassword + ", " +
							     Device_ID + ", ");
		
		//System.out.println("\nWRITE Statement: " + writeStatement);
		writeStatement += (status) ? 1 : 0;
		//System.out.println("\nline count: "+ lineUser + "\nWRITE Statement: " + writeStatement);
		
		//Write Area Below Start
		try {
			
			//THIS WORKS DONT TOUCH IT. or at least save copies.
			File fileToBeModified = new File(filename);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	        
	        FileWriter writer = null;
	         
            reader = new BufferedReader(new FileReader(fileToBeModified));
                          
            String line = reader.readLine();
            
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(user_line, writeStatement);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
            reader.close();
            
            writer.close();
 
        } catch (IOException e) 
		{
            e.printStackTrace();
        }
	}
	
}


