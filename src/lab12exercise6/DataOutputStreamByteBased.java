package lab12exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamByteBased
{
	public static void main (String [] args)
		{
			String txtFile = "dosDataDailyRainfall.txt";
			String DSR [][]= {{"Melaka Tengah", "0300061RF", "Bukit Katil", "63", "0", "0", "0", "0", "37"},
				             {"Melaka Tengah", "2222006", "Cheng", "20", "0", "0", "3", "0", "42"},
					         {"Alor Gajah", "0310281RF", "Durian Tunggal", "2", "0", "0", "3", "0", "8"},
					         {"Alor Gajah", "2421003", "Simpang Ampat", "0", "0", "4", "1", "0", "6"},
					         {"Jasin", "2225044", "Chohong", "6", "0", "0", "21", "0", "39"},
					         {"Jasin", "2125002", "Telok Rimba", "13", "0", "0", "1", "1", "69"}};
			
			try
			{
				DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(txtFile));
				
				for (String[] dsr : DSR)
				{
					String stationID = dsr[1];
					String stationName = dsr[2];
					String districtName = dsr[0];
					String rainfall[] = {dsr[3], dsr[4], dsr[5], dsr[6], dsr[7], dsr[8]};
		
					dataOutputStream.writeUTF(stationID);
					dataOutputStream.writeUTF(stationName);
					dataOutputStream.writeUTF(districtName);
					
					for (String RainFall : rainfall)
					{
						dataOutputStream.writeInt(Integer.parseInt(RainFall));
					}
				}
				
				// Flush for each writing
				dataOutputStream.flush();
	
				// Close stream
				dataOutputStream.close();
				
				System.out.println("Rainfall data has been written to the file: " + txtFile);
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
				
		}
}