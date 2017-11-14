package midTermExam;

//import necessary packages
import java.io.*;
import java.net.*;
import java.util.*;

public class year2013 {

	public static ArrayList<fourVector> dataFromURL(String urlName) throws IOException {

		// Create an ArrayList of fourVector objects from a URL

		// takes value from URL and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		// Define ArrayList containing fourVector objects
		ArrayList<fourVector> fourVectors = new ArrayList<fourVector>(); 
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		// initialise variables
		String e = null;
		int nTracks = 0;
		String triggerId = null;

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList

			Scanner mult = new Scanner(line);

			if (line.startsWith("E")) {

				e = mult.next();
				nTracks = Integer.parseInt(mult.next());
				triggerId = mult.next();

			}

			if (!line.startsWith("E")) { // ensures that no outputs are given for a line starting with energy values
				double charge = Double.parseDouble(mult.next());
				double px = Double.parseDouble(mult.next());
				double py = Double.parseDouble(mult.next());
				double pz = Double.parseDouble(mult.next());
				fourVector fourVectorObject = new fourVector(e, nTracks, triggerId, charge, px, py, pz);
				fourVectors.add(fourVectorObject);
			}

			mult.close();
		}
		return fourVectors;
	}

	public static void main(String[] args) {
		try {
			ArrayList<fourVector> allFourVectors = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/particles.txt"); // Retrieve data from URL
			System.out.println(allFourVectors.size());
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
