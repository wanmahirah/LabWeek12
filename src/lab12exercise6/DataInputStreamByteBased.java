package lab12exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamByteBased
{
	public static void main (String [] args)
	{
		String txtFile = "dosDataDailyRainfall.txt";
		System.out.println ("Reading data from " + txtFile + "\n");
		
		try
		{
			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(txtFile));
			
			// Variables for processing byte-based data
			int totalDailyRainfall = 0;
			int dailyRainfall = 0;
			
			String stationID = "";
			String stationName = "";
			String districtName = "";
			int count = 0;
			
			while (dataInputStream.available() > 0)
			{
				stationID = dataInputStream.readUTF();
				System.out.println ("Station ID: " + stationID);
				
				stationName = dataInputStream.readUTF();
				System.out.println ("Station Name: " + stationName);
				
				districtName = dataInputStream.readUTF();
				System.out.println ("Name of District: " + districtName);
				
				System.out.println("6-days Reading of Daily Rainfall: ");
				for (int i=0 ; i<6 ; i++)
				{
					dailyRainfall = dataInputStream.readInt();
					System.out.print(dailyRainfall + " ");
					totalDailyRainfall += dailyRainfall;
					count++;
				}
				
				int averageRainfall = totalDailyRainfall / count;
				System.out.print("\nAverage daily rainfall for " + count + " day in " + stationName + ": " + averageRainfall);
				System.out.println("\n\n");
				
				dailyRainfall = 0;
				count = 0;
				totalDailyRainfall = 0;
			}
		
			dataInputStream.close();
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}