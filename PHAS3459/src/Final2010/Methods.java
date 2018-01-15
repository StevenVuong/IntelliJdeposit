package Final2010;
/**
 * Class to hold methods used
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class Methods {
	
	/**
	 * Extracts buffered reader object from input url
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	/**
	 * Method to read values from dataset and create reading objects
	 * @param line
	 * @return reading objects
	 */
	public static Reading parseReading(String line) {
		
		Scanner sn = new Scanner(line); 
		
		//Parse values
		String Id = sn.next();
		Integer Year = Integer.parseInt(sn.next());
		Integer Month = Integer.parseInt(sn.next());
		String MeasurementType = sn.next();
		
		ArrayList<Double> dataArrayList  = new ArrayList<Double>(); //Initialise arraylist	
		
		while (sn.hasNext()) {
			String empty = sn.next();

			Double data = Double.parseDouble(empty); //parse value
			
			if (data != -9999.0) {
				dataArrayList.add(data);
			}

		}
		sn.close();
		
		return new Reading(Id, Year, Month, MeasurementType, dataArrayList);
		
	}

	/**
	 * Creates ArrayList of Readings Objects from the values from the URL
	 * @param url
	 * @return ArrayList<Reading
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Reading> readingsFromURL(String url) throws MalformedURLException, IOException {

		BufferedReader br = brFromURL(url);
		
		String empty = ""; //initialise string
		ArrayList<Reading> dataArrayList = new ArrayList<Reading>(); //Initialise arraylist
		
		while ((empty = br.readLine()) != null) { //loop through lines and add to arraylist
			dataArrayList.add(parseReading(empty));
		}
		
		return dataArrayList;
		
	}
	
	/**
	 * Creates HashMap from the Readings array with the key as the data type and values as the readings corresponding to that datatype
	 * @param readingsArray
	 * @return HashMap<String, ArrayList<Reading>>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, ArrayList<Reading>> readingsHashMap (ArrayList<Reading> readingsArray) throws MalformedURLException, IOException {
		
		//Initialise hashmap with data type as key and arraylist of values as the corresponding reading sets
		HashMap<String, ArrayList<Reading>> dataTypeHashMap = new HashMap<String, ArrayList<Reading>>();
		
		for (Reading r : readingsArray) {
			
			if (dataTypeHashMap.get(r.MeasurementType) == null) { //if keyset doesn't exist, create it
				
				ArrayList<Reading> dataAL = new ArrayList<Reading>();
				dataAL.add(r);
				dataTypeHashMap.put(r.MeasurementType, dataAL);
				
			}
			else {
				
				ArrayList<Reading> dataAL = dataTypeHashMap.get(r.MeasurementType);
				dataAL.add(r);
				dataTypeHashMap.put(r.MeasurementType, dataAL);
				
			}
			
		}
		
		return dataTypeHashMap; 
	}
	
	/**
	 * Method which creates hashmap of country codes and their corresponding names
	 * @return hashmap
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, String> countryHashMap() throws MalformedURLException, IOException {
		
		BufferedReader countryLine = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/final/countries.txt");
		HashMap<String, String> countriesHM = new HashMap<String, String>(); //initialise hashmap
		String empty = "";
		
		while ((empty = countryLine.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String countryCode = sn.next();
			String countryName = empty.substring(2);
			
			sn.close();
			countriesHM.put(countryCode, countryName);
			
		}
		
		return countriesHM;
	}
	
	/**
	 * Given the weatherStation input string, it returns the country corresponding to the weatherstation from other URL
	 * @param weatherStation
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String returnCountryCrossReference(String weatherStation) throws MalformedURLException, IOException {
		
		String countryID = weatherStation.substring(0, 2); //Grabs countryID
		
		HashMap<String,String> countriesHM = countryHashMap();
		
		String countryName = countriesHM.get(countryID);
		
		return countryName;
	}
	
	/**
	 * Creates ArrayList of Station objects from URL
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Station> stationsArrayList(String url) throws MalformedURLException, IOException {
		
		BufferedReader br = brFromURL(url);
		String empty = "";
		ArrayList<Station> stationAL = new ArrayList<Station>();
		
		while ((empty = br.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String stationID = sn.next();
			String StationName = empty.substring(11);
			
			sn.close();
			
			stationAL.add(new Station(stationID, StationName)); //add station to arraylist
			//System.out.println(empty);
		}
	
		return stationAL;
	}

	/** 
	 * Create HashMap to sort data with country as key and data as values
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static HashMap<String, ArrayList<Reading>> countryAsKey(ArrayList<Reading> readingsAL) throws MalformedURLException, IOException {
		
		HashMap<String, ArrayList<Reading>> countriesHM = new HashMap<String, ArrayList<Reading>>(); //Initialise hashmap
		
		for (Reading r : readingsAL) {
			String country = returnCountryCrossReference(r.Id);

			if (countriesHM.get(country) == null) {
				ArrayList<Reading> countryAL = new ArrayList<Reading>();
				countryAL.add(r);
				countriesHM.put(country, countryAL);
				
			}
			else {
				
				ArrayList<Reading> countryAL = countriesHM.get(country);
				countryAL.add(r);
				countriesHM.put(country, countryAL);
				
			}
			
		}
		return countriesHM;
	}
	
	/**
	 * Method which calculates the lowest meanMax temperature and prints the country it corresponds to
	 * @param maxTempMeasurements
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void calcLowestMeanMaxTemp(ArrayList<Reading> maxTempMeasurements)
			throws MalformedURLException, IOException {
		HashMap<String, ArrayList<Reading>> countryAsKeyHM = Methods.countryAsKey(maxTempMeasurements);//Initialise hashmap
		
		Double lowestMeanMaxTemperature = 10000000000000.0;
		String lowestMeanMaxCountry = "";
		Integer year = 0;
		Reading yearR = null;
		
		for (String country : countryAsKeyHM.keySet()) { //loop over countries
			
			ArrayList<Reading> readingsForCountry = countryAsKeyHM.get(country); //get values for that country
			Double sumMaxTemp = 0.0;
			Double counter = 0.0;
			
			for (Reading r : readingsForCountry) { //loop through readings
				
				for (Double d : r.data) { //loop through max temperature dataset
					sumMaxTemp += d;
					counter++;
					yearR = r;
				}
				
			}
			
			Double meanMaxTemp = sumMaxTemp / counter;
			
			if (meanMaxTemp < lowestMeanMaxTemperature) {
				lowestMeanMaxTemperature = meanMaxTemp;
				lowestMeanMaxCountry = country;
				year = yearR.Year;
			}
			
		}
		System.out.println("For Year: "+ year);
		System.out.println("Country with lowest mean max temperature: "+lowestMeanMaxCountry+", with average max temperature: "+lowestMeanMaxTemperature);
	}
	
	/** 
	 * Create HashMap to sort data with Year as key and data as values
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static HashMap<Integer, ArrayList<Reading>> YearAsKey(ArrayList<Reading> readingsAL) throws MalformedURLException, IOException {
		
		HashMap<Integer, ArrayList<Reading>> yearsHM = new HashMap<Integer, ArrayList<Reading>>(); //Initialise hashmap
		
		for (Reading r : readingsAL) {
			Integer year = r.Year;

			if (yearsHM.get(year) == null) {
				ArrayList<Reading> yearAL = new ArrayList<Reading>();
				yearAL.add(r);
				yearsHM.put(year, yearAL);
				
			}
			else {
				
				ArrayList<Reading> yearAL = yearsHM.get(year);
				yearAL.add(r);
				yearsHM.put(year, yearAL);
				
			}
			
		}
		return yearsHM;
	}
	
}
