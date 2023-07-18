package lab12exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DailyRainFallInput
{
	public static void main (String [] args)
	{
		String txtFile = "dailyRainfallInputData.txt";
		System.out.println ("Reading data from " + txtFile + "\n");
		
		try
		{
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(txtFile));
			
			// Variables for processing byte-based data
			int totalDailyRainfall = 0;
			int dailyRainFall = 0;
			String station = "";
			int count = 0;
			
			station = dataInputStream.readUTF();
			
			while (dataInputStream.available() > 0)
			{
				dailyRainFall = dataInputStream.readInt();
				totalDailyRainfall += dailyRainFall;
				count++;
			}
			
			dataInputStream.close();
			
			int averageRainfall = totalDailyRainfall / count;
			System.out.print("\nAverage daily rainfall for " + count + " day in " + station + ": " + averageRainfall);
		}
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
}