package MidTerm2014_15;

/**
 * Class containing methods to be used to analyse Exoplanet data
 * @author Steven Vuong
 * @version 01/01/2018
 */

/**
 * Import necessary classes
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ExoplanetMethods {

	/**
	 * Method to parse data from string of text details on planet and create Exoplanet object
	 * @param String line
	 * @return Exoplanet object
	 */
	public static Exoplanet parseLine(String line) {
		
		Scanner sn = new Scanner(line).useDelimiter(","); //Create scanner object from input line using comma as delimiter
		
		String Name = sn.next();
		int Year = Integer.parseInt(sn.next());
		String Method = sn.next();
		double Mass = Double.parseDouble(sn.next());
		double Separation = Double.parseDouble(sn.next());
		double Distance = -1.0; //For distance is not given, the value is set to -1.0, this will have to be known to the user
		
		if (sn.hasNext()) { //Condition to provide distance if the value is given
			Distance = Double.parseDouble(sn.next());
		}
		
		sn.close(); //Close scanner object

		return new Exoplanet(Name, Year, Method, Mass, Separation, Distance);
		
	}
	
	/**
	 * Method to loop through URL and create exoplanet objects with details and return arrayList
	 * @param String url
	 * @return ArrayList of exoplanet objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Exoplanet> dataFromUrl(String url) throws MalformedURLException, IOException {
		
		//Turn URL String into bufferedreader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		br.readLine(); //Ignore the first line
		
		ArrayList<Exoplanet> exoplanetArray = new ArrayList<Exoplanet>(); //Initialise arraylist
		String line = "";
		
		//Loops through data and adds to arraylist
		while ((line = br.readLine()) != null) { 
			exoplanetArray.add(parseLine(line));
		}
		
		return exoplanetArray;
		
	}
	
	/**
	 * Method to sort through exoplanets and put in hashmap with method as key and exoplanet array as values corresponding to the method
	 * @param exoplanetsArrayList
	 * @return HashMap with method as key and arraylist of exoplanets as values
	 */
	public static HashMap planetHashMap(ArrayList<Exoplanet> exoplanetsArrayList) {
		//Initialise exoplanet hashmap
		HashMap<String, ArrayList<Exoplanet>> exoplanetsHashMap = new HashMap<String, ArrayList<Exoplanet>>();
		
		for (Exoplanet exp : exoplanetsArrayList) {
			
			if ((exoplanetsHashMap.get(exp.Method)) == null) { //Check if key already exists within hashmap
				ArrayList<Exoplanet> exoArrayList = new ArrayList<Exoplanet>();
				exoArrayList.add(exp);
				exoplanetsHashMap.put(exp.Method, exoArrayList);
			}
			else {
				ArrayList<Exoplanet> exoArrayList = exoplanetsHashMap.get(exp.Method);
				exoArrayList.add(exp);
				exoplanetsHashMap.put(exp.Method, exoArrayList);
			}
			
		}
		
		return exoplanetsHashMap;
	}
	
}
