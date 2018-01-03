package Practice;

/**
 * Import necessary packages
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Minerals {
	
	/**
	 * Grabs data from URL and puts into hashmap with code as key and mass as values
	 * @param url string
	 * @return hashmap<Integer, Double>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<Integer, Double> getMass(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line = "";
		HashMap<Integer, Double> massHM = new HashMap<Integer, Double>(); //Initialise hashmap
		
		while ((line = br.readLine()) != null) { //loop through each line
			
			Scanner sn = new Scanner(line);
			
			//parse values
			Integer key = Integer.parseInt(sn.next());
			Double mass = Double.parseDouble(sn.next());
			
			massHM.put(key, mass); //add to hashmap
			
		}
		
		return massHM;
	}
	
	/**
	 * Grabs data from URL and puts into hashmap with code as key and location as values
	 * @param url string
	 * @return hashmap<Integer, String>
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<Integer, String> getLocation(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line = "";
		HashMap<Integer, String> locationHM = new HashMap<Integer, String>(); //Initialise hashmap
		
		while ((line = br.readLine()) != null) {
			
			Scanner sn = new Scanner(line); //Create scanner object
			
			//parse values
			String location = sn.next();
			Integer keycode = Integer.parseInt(sn.next());
			
			locationHM.put(keycode, location); //add to hashMap
		}
		
		return locationHM;
	}
	
	public static void main(String[] args) {
		try {
			
			//Get hashmap from URLs
			HashMap<Integer, Double> massHashMap = getMass("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			HashMap<Integer, String> locationHashMap = getLocation("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
			
			//Initialise values
			double maxValue = 0.0;
			int maxValueKey = 0;
			String maxLocation = null;
			double minValue = 10000000000.0;
			int minValueKey = 0;
			String minLocation = null;
				
			for (Integer key : massHashMap.keySet()) { //loops through keyset of hashmap
				
				double mass = massHashMap.get(key); //sets key according to the mass
				
				if (mass > maxValue) { //condition to set the maximum value
					maxValue = mass;
					maxValueKey = key;
					maxLocation = locationHashMap.get(key);
				}
				if (mass < minValue) { //condition to set the minimum value
					minValue = mass;
					minValueKey = key;
					minLocation = locationHashMap.get(key);
				}
				
			}
			
			System.out.println("Maximum mass: "+maxValue+", Key: "+maxValueKey+", Location: "+maxLocation);
			System.out.println("Minimum mass: "+minValue+", Key: "+minValueKey+", Location: "+minLocation);
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}

}
