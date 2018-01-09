package Final2013;
/**
 * Class which contains methods for 2013 final exam
 * @author Steven Vuong
 * @version 09-01-2018
 */
/**
 * Import necessary modules
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Methods {

	/**
	 * Method which parses line into details and returns a Specimen object
	 * @param line string 
	 * @return Specimen object
	 */
	public static Specimen parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Create scanner object
		
		//Parse values
		Double Latitude = Double.parseDouble(sn.next());
		Double Longitude = Double.parseDouble(sn.next());
		String ID = sn.next();
		
		if (sn.hasNext()) {
			
		Integer Height = Integer.parseInt(sn.next());
		
		return new Specimen(Latitude, Longitude, ID, Height);
		
		}
		
		sn.close(); //Close scanner
		
		//Part 3, for no height given, return null for specimen height
		return new Specimen(Latitude, Longitude, ID, null); 

	}
	
	/**
	 * Method which returns arrayList of Specimen from URL input
	 * @param url string
	 * @return ArrayList of Specimen objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Specimen> arrayListFromURL(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<Specimen> specimenArrayList = new ArrayList<Specimen>(); //Initialise ArrayList
		String empty = ""; //Initialise string
		
		while ((empty = br.readLine()) != null) {
			specimenArrayList.add(parseLine(empty));
		}
		
		return specimenArrayList;
	}
	
	/**
	 * Method which creates HashMap with ID as key and specimen ArrayList corresponding to id as values
	 * @param url
	 * @return HashMap<String, ArrayList<Specimen>>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, ArrayList<Specimen>> speciesAsKeyHashMap(String url) throws MalformedURLException, IOException{
		
		ArrayList<Specimen> allSpecimens = arrayListFromURL(url); //grab specimen data
		
		//Initialise hashmap with ID as key 
		HashMap<String, ArrayList<Specimen>> speciesHM = new HashMap<String, ArrayList<Specimen>>(); 
		
		for (Specimen s : allSpecimens) {
			
			if (speciesHM.get(s.ID) == null) { //If keyset doesn't exist, create it
				
				ArrayList<Specimen> specimenByID = new ArrayList<Specimen>();
				specimenByID.add(s);
				speciesHM.put(s.ID, specimenByID);
				
			}
			else {
				
				ArrayList<Specimen> specimenByID = speciesHM.get(s.ID); //if keyset exists, grabs corresponding arrayList
				specimenByID.add(s);
				speciesHM.put(s.ID, specimenByID);
				
			}
			
		}
		
		return speciesHM;
	}
	
	/**
	 * Method for the index, returns HashMap with ID as key and scientific name as values
	 * @param url string
	 * @return HashMap<String, String>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, String> hashMapFromURLDetails(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		HashMap<String, String> speciesDetailHashMap = new HashMap<String, String>(); //Initalise HashMap
		int i = 6;
		while (i > 0) { //loop through lines
			
			Scanner sn = new Scanner(br.readLine());
			
			//parse values
			String ID = sn.next();
			String firstName = sn.next();
			String lastName = sn.next();
			String fullName = firstName + " "+lastName;
			
			//Hashmap with ID as key and scientific name as values
			speciesDetailHashMap.put(ID, fullName);
			i--;
			
		}
		
		return speciesDetailHashMap;
		
	}
}
