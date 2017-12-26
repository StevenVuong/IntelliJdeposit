package module5_1;

/**
 * Class which finds smallest and largest mass samples and prints out corresponding details
 * 
 * @author Steven Vuong
 * @version: 26-12-2017
 */

import java.io.*;
import java.util.*;
import java.net.*;

public class Minerals {
	
	//Initialise member objects
	Integer key;
	Double mass;
	String location;
	
	/**
	 * Constructor for one URL dataset containing key and mass
	 * @param key
	 * @param mass
	 */
	public Minerals(Integer key, Double mass) {
		this.key = key;
		this.mass = mass;
	}
	
	/**
	 * Constructor for one URL dataset containing location and key
	 * @param location
	 * @param key
	 */
	public Minerals(String location, Integer key) {
		this.location = location;
		this.key = key;
	}
	
	/**
	 * Method which creates Mineral objects from string of data
	 * @param String of data-values
	 * @return Minerals object of key and mass
	 */
	public static Minerals parseMass(String line) {
		
		Scanner sn = new Scanner(line);
		
		Integer Key = Integer.parseInt(sn.next());
		Double Mass = Double.parseDouble(sn.next());
		
		sn.close();
		
		return new Minerals(Key,Mass);
	}
	
	/**
	 * Method which creates Mineral objects from string of data
	 * @param String of data-values
	 * @return Minerals object of location and key
	 */
	public static Minerals parseLocation(String line) {
		
		Scanner sn = new Scanner(line);
		
		String Location = sn.next();
		Integer Key = Integer.parseInt(sn.next());
		
		sn.close();
		
		return new Minerals(Location,Key);
	}
	
	/**
	 * Converts URL into buffered Reader object
	 * @param url string
	 * @return buffererd reader object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static BufferedReader urlData(String url) throws MalformedURLException, IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		return b;
	}
	
	/**
	 * Method which scans through URL data set and sorts values into hashmap with id as key and mass as value
	 * @param url
	 * @return hashmap of masses and their respective keys
	 * @throws IOException
	 */
	public static HashMap<Integer, Double> massFromURL(String url) throws IOException{
		
		BufferedReader b = urlData(url); //creates buffered reader object
		
		HashMap<Integer,Double> massHashMap = new HashMap<Integer, Double>(); //Initialise hash map
		String line = "";
		
		while ((line = b.readLine()) != null) {
			Minerals mineral = parseMass(line);
			massHashMap.put(mineral.key, mineral.mass);
		}
		
		return massHashMap;
	}
	
	/**
	 * Method which scans through URL data set and sorts values into hashmap with id as key and location as value
	 * @param url
	 * @return hashmap of masses and their respective keys
	 * @throws IOException
	 */
	public static HashMap<String, Integer> locationFromURL(String url) throws IOException{
		
		BufferedReader b = urlData(url); //creates buffered reader object
		
		HashMap<String,Integer> locationHashMap = new HashMap<String, Integer>(); //Initialise hash map
		String line = "";
		
		while ((line = b.readLine()) != null) {
			Minerals mineral = parseLocation(line);
			locationHashMap.put(mineral.location, mineral.key);
		}
		
		return locationHashMap;
	}
	
	public static void main(String[] args) {
		try {
			//Import Data
			HashMap<Integer,Double> massHM = new HashMap<Integer,Double>(massFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt"));
			HashMap<String,Integer> locationHM = new HashMap<String,Integer>(locationFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt"));
			
			ArrayList<Double> massAL = new ArrayList<Double>();
			for (double k : massHM.values()) { //loop through mass hashmap and add values
				massAL.add(k);
			}
			//finds max and min mass values
			double maxMass = 0;
			double minMass = 100000;
			for (int i=0; i<massAL.size();i++) {
				if (massAL.get(i) > maxMass) {
					maxMass = massAL.get(i);
				}
				if (massAL.get(i) < minMass) {
					minMass = massAL.get(i);
				}
			}
			
			//obtaining keys from mass hashmap corresponding to values
			int maxKey=0;
			int minKey=0;
			for (Map.Entry<Integer, Double> entry : massHM.entrySet()) {
				if (entry.getValue() == maxMass) {
					maxKey = entry.getKey();
				}
				if (entry.getValue() == minMass) {
					minKey = entry.getKey();
				}
			}
			System.out.println(maxKey);
			
			String minLoc = null;
			Integer maxLoc = null;
			System.out.println(locationHM.keySet());
			int i=1;
			locationHM.
			for (Map.Entry<String,Integer> entryTwo : locationHM.()()) {
				System.out.println(i);
				System.out.println(entryTwo.getValue());
				if (entryTwo.getValue() == maxKey) {
					System.out.println("abc");
					maxLoc = entryTwo.getValue();
				}
				if (entryTwo.getValue() == minKey) {
					minLoc = entryTwo.getKey();
				}
				i++;
			}
			System.out.println("maxmass = "+maxMass+", key: "+maxKey + ", location: "+ maxLoc);
			//System.out.println("minmass = "+minMass+", key: "+minKey + ",location: "+minLoc);
			
		}
		catch (IOException d) {
			System.out.println("URL is not found!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/**
		 * Problem: Do keyset first next time!
		 */
	}
}
