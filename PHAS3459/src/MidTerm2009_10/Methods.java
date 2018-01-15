package MidTerm2009_10;

/**
 * class containing methods for MidTerm 2009-10
 * @author SID: 15011252
 * @version 14-01-2018
 */
/**
 * Import necessary packages
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class Methods {

	/**
	 * Method which reads location line and returns a corresponding location object
	 * @param line String
	 * @return Location Object
	 */
	public static Location parseLocation(String line) {
		
		Scanner sn = new Scanner(line);
		
		String Location = sn.next();
		Double Latitude = Double.parseDouble(sn.next());
		Double Longitude = Double.parseDouble(sn.next());
		
		sn.close();
		
		return new Location(Latitude, Longitude);
	}
	
	/**
	 * Method which reads measurement line and returns measurement object with details encapsulated
	 * @param String line
	 * @return Measurement object
	 */
	public static Measurement parseMeasurement(String line) {
		
		Scanner sn = new Scanner(line);
		
		Integer Year = Integer.parseInt(sn.next());
		Integer Month = Integer.parseInt(sn.next());
		Integer Day = Integer.parseInt(sn.next());
		String Time = sn.next();
		Double Concentration = Double.parseDouble(sn.next());
		
		sn.close();
		
		return new Measurement(Year, Month, Day, Time, Concentration);
		
	}
	
	/**
	 * 
	 */
	
	/**
	 * Method which reads data from URL and returns a HashMap with the location as the key and arraylist of 
	 * measurements corresponding to that location (Include duplicates..)
	 */
	public static HashMap<Location, ArrayList<Measurement>> dataFromURL(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		BufferedReader br = brFromURL(url);
		
		//Initialise hashmap and variables
		HashMap<Location, ArrayList<Measurement>> locationsKeyHM = new HashMap<Location, ArrayList<Measurement>>();
		String empty = ""; 
		ArrayList<Measurement> measurementAL = new ArrayList<Measurement>(); //Initialise arraylist
		int counter = 0; //sets counter
		Location loc = null;
		Double maxConcentrationNorth = 0.0;
		String maxConcentrationNorthString = null;
		Double maxConcentrationSouth = 0.0;
		String maxConcentrationSouthString = null;
		
		
		while ((empty = br.readLine()) != null) { //loop through each line
			
			if (empty.startsWith("Location:")) { //parse location if begins with that7
				
					if (counter >= 1) {  //to skip the first recording set 
					locationsKeyHM.put(loc, measurementAL); //adds to hashmap, mapping the measurements value to location
					System.out.println(loc.getDetailsLoc());
					calculateMean(measurementAL); //calculates mean and prints to screen
					measurementAL.clear(); //empties arraylist for new set of measurements		
					
				}
					
				loc = parseLocation(empty); //grabs location	
				counter++; //adds to counter
				
			}
			else {
				/**
				 * Calculates max concentration for northern and southern hemispheres
				 */
				Measurement mm = parseMeasurement(empty);
				mm.Latitude = loc.Latitude; //add conditions of northern and southern hemisphere
				mm.Longitude = loc.Longitude;
				measurementAL.add(mm); //adds to arraylist
				
				//check max concentrations for north and south hemisphere
				if (mm.Latitude >= maxConcentrationNorth) {
					maxConcentrationNorth = mm.Latitude;
					maxConcentrationNorthString = loc.getDetailsLoc();
				}
				if (mm.Latitude <= maxConcentrationSouth) {
					maxConcentrationSouth = mm.Latitude;
					maxConcentrationSouthString = loc.getDetailsLoc();
				}
				
			}
			
		}
		System.out.println("Largest Concentration for North Hemisphere location: "+maxConcentrationNorthString);
		System.out.println("Largest Concentration for South Hemisphere location: "+maxConcentrationSouthString);
		return locationsKeyHM;
	}

	/**
	 * Method which obtains bufferedReader object from URL string
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	/**
	 * Method which calculates mean concentration of X
	 * @param measurementAL
	 */
	public  static void calculateMean(ArrayList<Measurement> measurementAL) {
		
		Double sumConcentration = 0.0;
		
		for (Measurement m: measurementAL) {
			
			sumConcentration += m.Concentration;
			
		}
		
		Double mean = sumConcentration / measurementAL.size();
		System.out.println("Mean concentration is: "+mean);
		System.out.println("");
	}
	
	/**
	 * Method which obtains arraylist of all measurements from URL string
	 * @param url string
	 * @return ArrayList<Measurement>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Measurement> allMeasurementsArrayList (String url) throws MalformedURLException, IOException {
		
		BufferedReader br = brFromURL(url);
		ArrayList<Measurement> measurementAL = new ArrayList<Measurement> (); //Initialise arraylist
		String empty = ""; //initialise string
		
		while ((empty = br.readLine()) != null) {
			
			if (empty.startsWith("Location")) {
				// do nothing
			}
			else {
				measurementAL.add(parseMeasurement(empty));
			}
			
		}
		
		return measurementAL;
	}
	
}
