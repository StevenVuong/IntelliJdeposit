package Practice;
/**
 * Class with method to grab data from url and parse into arraylist
 * @author Steven Vuong
 * @version 29-12-2017
 */
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class EarthquakeDataFromUrl {
	
	/**
	 * Method to obtain all Earthquakes from URL and sort into Earthquakes objects before adding to arraylist.
	 * @param url string
	 * @return arraylist of earthquakes
	 * @throws IOException
	 */

	public static ArrayList<Earthquake> dataFromUrl(String url) throws IOException {
		
		//Turn URL String into bufferedreader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Initialise arraylist to fill
		ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
		String line = "";
		
		//Ignore first line
		br.readLine();
		br.readLine();
		
		while ((line=br.readLine()) != null) {
			earthquakes.add(EarthquakeParseLine.parseLine(line));
		}
		
		return earthquakes;
		
	}
	
}
