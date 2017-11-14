package midTermExam;

//import necessary packages
import java.io.*;
import java.net.*;
import java.util.*;

public class year2013 {

	public static ArrayList<fourVector> dataFromURL(String urlName) throws IOException {

		// Create an ArrayList of fourVector objects from a URL

		//takes value from URL and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<fourVector> fourVectors = new ArrayList<fourVector>(); // Define ArrayList containing fourVector objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below
		
		//initialise variables
		double e = 0;
		int nTracks = 0;
		String triggerId = null;
		
		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			
			Scanner mult = new Scanner(line);
			
			if (line.startsWith("E")) {
				
				e = Double.parseDouble(mult.next());
				nTracks = Integer.parseInt(mult.next());
				triggerId = mult.next();
				
			}

				double charge = Double.parseDouble(mult.next());
				double px = Double.parseDouble(mult.next());
				double py = Double.parseDouble(mult.next());
				double pz = Double.parseDouble(mult.next());
	
				if (!line.startsWith("E")) { //ensures that no outputs are given for a line starting with energy values
					fourVector fourVectorObject = new fourVector(e, nTracks, triggerId, charge, px, py, pz);
					fourVectors.add(fourVectorObject);
					}
				
			mult.close();
		}
		return fourVectors;
	}

}
