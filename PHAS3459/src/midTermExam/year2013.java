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
		int i = 0;

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList

			Scanner mult = new Scanner(line);

			if (line.startsWith("E")) {

				e = mult.next(); // skips the E
				nTracks = Integer.parseInt(mult.next());
				triggerId = mult.next();

			}

			if (!line.startsWith("E")) { // ensures that no outputs are given for a line starting with energy values

				// set variables
				double charge = Double.parseDouble(mult.next());
				double momentumMag = Double.parseDouble(mult.next());
				double E = momentumMag;
				double theta = Double.parseDouble(mult.next());
				double phi = Double.parseDouble(mult.next());
				double px = momentumMag * Math.sin(theta) * Math.cos(phi);
				double py = momentumMag * Math.sin(theta) * Math.sin(phi);
				double pz = momentumMag * Math.cos(theta);

				// creates fourvector object
				fourVector fourVectorObject = new fourVector(E, nTracks, triggerId, charge, px, py, pz);

				// adds to fourvector array
				fourVectors.add(fourVectorObject);
			}

			mult.close();
		}
		return fourVectors;
	}
	
	

	public static void main(String[] args) {
		try {
			ArrayList<fourVector> allFourVectors = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/particles.txt"); // Retrieve data from URL
			System.out.println("there are " + allFourVectors.size() + " number of datapoints");
			
			//initialise variables
			double invariantMass = 0;
			

			// Initialise HashMap to hold trigger ids as keys and an ArrayList of players in each team as the values.
						HashMap<String, ArrayList<fourVector>> vectorsByTrigger = new HashMap<String, ArrayList<fourVector>>(); 
			
			for (fourVector fv: allFourVectors) { //loops over all fourVectors
				
			
			

			// Sort fourvectors by triggerId and put into the  HashMap. 
			if (vectorsByTrigger.get(fv.triggerId) == null) { // If the fourvector has not yet been put into the HashMap, create a new ArrayList containing the current player and put it into the HashMap.
				ArrayList<fourVector> temp = new ArrayList<fourVector>();   
				temp.add(fv); //insert value into hashmap
				vectorsByTrigger.put(fv.triggerId, temp);  //associate key to value
			}
			else { // The HashMap already contains the trigger id. Retrieve the ArrayList of all fourvectors to the list and put the updated list back into the HashMap.
				ArrayList<fourVector> currentId = vectorsByTrigger.get(fv.triggerId); //retrieve key
				currentId.add(fv); //fix fourvector to value
				vectorsByTrigger.put(fv.triggerId, currentId);
			}
			}
			
			
			double particlePairsTotalCount = 0;
			double signalPairsCountTotal = 0;
			double backgroundPairsCountTotal = 0;
			double highestRatio = 0;
			for (String Id : vectorsByTrigger.keySet()) { // Do the following for each Id
				
				

				
				
				ArrayList<fourVector> vectorNow = vectorsByTrigger.get(Id); // Retrieve the ArrayList of values for the ID currently being considered. 
				for (fourVector fv2 : vectorNow) { //loop through each fourvector in the ID list
					double signalPairsCount = 0;
					double backgroundPairsCount = 0;
					for (fourVector fv3 : vectorNow) { //check through fourvectors, crosscheck with each other
						
						if ((fv2.px == fv3.px) && (fv2.charge != -fv3.charge)) {
							fourVector fv4 = new fourVector (fv2.E + fv3.E, fv2.nTracks, fv2.getTriggerId(), 0, fv2.px+fv3.px, fv2.py+fv3.py, fv2.pz+fv3.pz);
				
							double invMass = Math.sqrt(Math.pow(fv4.E,2));  // - Math.pow(fv4.getP(), 2));
							//System.out.println(invMass);
							if ((8 <= invMass) && (invMass <= 10)) {
								signalPairsCount++;
								signalPairsCountTotal++;
								
							}
							if ((11 <= invMass) && (invMass <= 15)) {
								backgroundPairsCount++;
								backgroundPairsCountTotal++;
							}
						}
					}
					System.out.println("for trigger ID: " + fv2.triggerId + ", the signal/background ratio is: " + (signalPairsCount/backgroundPairsCount));
					if ((signalPairsCount/backgroundPairsCount) > highestRatio) {
						highestRatio = (signalPairsCount/backgroundPairsCount);
					}
				}		
			
			}
			
			System.out.println("total number of signal pairs: " + signalPairsCountTotal);
			System.out.println("total number of background pairs: " + backgroundPairsCountTotal);
			System.out.println("signal/background ratio for all : " + signalPairsCountTotal/backgroundPairsCountTotal);
		
	}
		
		

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
