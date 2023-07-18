package lab12exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DailyRainFallOutput
{
	public static void main (String [] args)
	{
		String txtFile = "dailyRainfallInputData.txt";
		String station = "Simpang Ampat";
		int rainfall[] = {5,0,0,4,1,0};
		
		try
		{
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(txtFile));
			
			// Write data into data stream
			dataOutputStream.writeUTF(station);
		
			// Process data
			for (int rainFallData : rainfall)
			{
				// Write data into data stream
				dataOutputStream.writeInt(rainFallData);
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