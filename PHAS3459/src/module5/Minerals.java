package module5;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Minerals {

	// Setting variables to be put into objects
	int key;
	double mass;
	String location;

	public Minerals(String location, int key) { // variables to be put into locations (constructor)
		this.key = key;
		this.location = location;
	}

	public Minerals(int key, double mass) { // variables to be put into masses (constructor)
		this.key = key;
		this.mass = mass;
	}

	public static Minerals parseLocationLine(String line) {
		// Returns a Minerals object with a key and it's location

		Scanner sn = new Scanner(line); // scans multiple numbers in the same line

		String Loc = sn.next();
		int Key = Integer.parseInt(sn.next());
		Minerals out = new Minerals(Loc, Key); // creates constructor with location and key

		sn.close(); // Close Scanner
		return out;
	}

	public static Minerals parseMassLine(String line) {
		// Return a Minerals object containing a key and it's mass

		Scanner sn = new Scanner(line); // scans over the values in the same line

		int Key = Integer.parseInt(sn.next());
		double Mass = Double.parseDouble(sn.next());
		Minerals out = new Minerals(Key, Mass);

		sn.close();
		return out;
	}

	public static HashMap<Integer, Double> massFromURL(String urlName) throws IOException {
		// Creates HashMap object for masses input url name

		// turns url string into buffered reader object
		URL u = new URL(urlName); // Creates url object
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		HashMap<Integer, Double> masses = new HashMap<Integer, Double>(); // Define Hashmap containing mass and code of
																			// sample
		String empty = "";
		while ((empty = b.readLine()) != null) { // take object from each line and store as hashmap
			Minerals sample = parseMassLine(empty);
			masses.put(sample.key, sample.mass);
		}
		return masses;
	}

	public static HashMap<String, Integer> locFromURL(String urlName) throws IOException {
		// Creates Hashmap object for locations from text input URL

		// turns url string into buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);

		HashMap<String, Integer> loc = new HashMap<String, Integer>(); // Defines Hashmap containing sample locations
		String empty = "";
		while ((empty = b.readLine()) != null) { // take object from each line and store inside hashmap
			Minerals sample = parseLocationLine(empty);
			loc.put(sample.location, sample.key);
		}
		return loc;
	}

	public static void mail(String[] args) {
		try {

			// Import URL data
			HashMap<Integer, Double> masses = new HashMap<Integer, Double>(
					massFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt"));
			HashMap<String, Integer> locations = new HashMap<String, Integer>(
					locFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt"));

			double[] hashMasses = new double[masses.size()]; // Initialise array containing masses
			int index = 0; // Index of elements in the above array
			for (int ID : masses.keySet()) { // Store masses from "masses" HashMap in hashMasses array
				hashMasses[index] = masses.get(ID);
				index++;
			}

			// initialise variables for analysis
			double max = 0.;
			double min = 1E9;
			for (int i = 0; i < hashMasses.length; i++) {
				if (hashMasses[i] > max) {
					max = hashMasses[i];
				}
				if (hashMasses[i] < min) {
					min = hashMasses[i];
				}
			}

			// Initialise key references
			int maxKey = 0;
			int minKey = 0;
			for (Map.Entry<Integer, Double> entry : masses.entrySet()) { // take each entry from the Hashmap
				if (entry.getValue() == max) { // set the maxkey and minkey references for max and min
					maxKey = entry.getKey();
				}
				if (entry.getValue() == min) { //entry values are matched to min and max keys above
					minKey = entry.getKey();
				}
			}
			
			System.out.println("The largest mass sample has code number: " + maxKey+" with mass: "+masses.get(maxKey) +", found at location: " +locations.get(maxKey));

		} catch (IOException e) {
			System.out.println("Bad URL");
		}
	}
}
