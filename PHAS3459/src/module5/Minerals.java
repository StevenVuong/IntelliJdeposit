package module5;

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
	
	
}
