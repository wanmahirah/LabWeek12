package lab12exercise7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RainfallWriter
{
	public static void main (String [] args)
	{
		String txtFile = "writerDailyRainfallData.txt";
		String stationName = "Simpang Ampat";
		String coma = ",";
		int rainfall[] = {5,0,0,4,1,0};
		
		try
		{
			BufferedWriter dataOutputStream = new BufferedWriter(new FileWriter(txtFile));
			PrintWriter print = new PrintWriter(dataOutputStream);
			
			// Write data into data stream
			print.print(stationName);
			
			// Process data
			for (int rainFallData : rainfall)
			{
				// Write data into data stream
				print.print(coma);
				print.print(rainFallData);	
			}
			
			// Flush for each writing
			dataOutputStream.flush();
			
			// Close stream
			dataOutputStream.close();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}			
	}

}