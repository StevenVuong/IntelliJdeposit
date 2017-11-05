package module5;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
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
		Minerals out = new Minerals(Key,Mass);
		
		sn.close();
		return out;
	}
	
	public static HashMap<Integer, Double> massFromURL(String urlName) throws IOException {
		// Creates HashMap object for masses input url name
		
		//turns url string into buffered reader object
		URL u = new URL(urlName); //Creates url object
		InputStream is = u.openStream(); 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		HashMap<Integer,Double> masses = new HashMap<Integer,Double>(); //Dfine Hashmap containing mass and code of sample
		String empty = ("");
		while ((empty = b.readLine()) != null) { //take object from each line and store as hashmap
			Minerals sample = parseMassLine(empty);
			masses.put(sample.key,sample.mass);
		}
		return masses;
	}
	
	
}
