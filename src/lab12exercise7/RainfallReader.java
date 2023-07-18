package lab12exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

public class RainfallReader
{
	public static void main (String [] args)
	{
		String txtFile = "writerDailyRainfallData.txt";
		System.out.println ("Reading data from " + txtFile + "\n");
		
		try
		{
			BufferedReader dataInputStream = new BufferedReader(new FileReader(txtFile));
			
			// Variables for processing byte-based data
			int totalDailyRainfall = 0;
			int count = 0;
			
			String data;
			String saveData[] = {};
			
			
			while ((data = dataInputStream.readLine()) != null)
			{
			   saveData = data.split(",");
			}
			
			String stationName = saveData[0];
			System.out.println(stationName);
			System.out.print("Rainfall Data: ");
			for (int i=1; i<saveData.length; i++)
			{
			   System.out.print(saveData[i] + ", ");
			   totalDailyRainfall += Integer.parseInt(saveData[i]);
			   count++;
			}
			
			dataInputStream.close();
			
			int averageRainfall = totalDailyRainfall / count;
			System.out.print("\nAverage daily rainfall for " + count + " day in " + stationName + ": " + averageRainfall);
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}