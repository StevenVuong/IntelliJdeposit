package Practice;
/**
 * Class to parse Earthquake details into Earthquake object
 * @author Steven Vuong
 * @version 29-12-2017
 */
import java.util.Scanner;

public class EarthquakeParseLine {
	/**
	 * Method to create Earthquake object, having parsed the line details from URL
	 * @param string of earthquake details
	 * @return Earthquake object
	 */
	public static Earthquake parseLine(String line) {
		
		//Create scanner object to break the line into multiple parts, separated by spaces
		Scanner sn = new Scanner(line); 
		
		Integer Year = Integer.parseInt(sn.next());
		Integer Month = Integer.parseInt(sn.next());
		Integer Day = Integer.parseInt(sn.next());
		Integer Hour = Integer.parseInt(sn.next());
		Integer Minute = Integer.parseInt(sn.next());
		Double Second = Double.parseDouble(sn.next());
		Double Lat = Double.parseDouble(sn.next());
		Double Long = Double.parseDouble(sn.next());
		Double Depth = Double.parseDouble(sn.next());
		Double EH1 = Double.parseDouble(sn.next());
		Double EH2 = Double.parseDouble(sn.next());
		Integer Az = Integer.parseInt(sn.next());
		Double Ez = Double.parseDouble(sn.next());
		Double Mag = Double.parseDouble(sn.next());
		Integer Id = Integer.parseInt(sn.next());
		
		sn.close();
		
		return new Earthquake(Year, Month, Day, Hour, Minute, Second, Lat, Long, Depth, EH1, EH2, Az, Ez, Mag, Id);
	}
}
