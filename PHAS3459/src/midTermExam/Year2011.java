package midTermExam;

//import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class Year2011 {

	public static NeutrinoValues parseLineValues(String line) {
		// return a NeutrinoValue object

		Scanner mult = new Scanner(line); // scans each value

		// puts data into each variable
		String NameValues = mult.next();
		String InteractionValues = mult.next();
		double energy = Double.parseDouble(mult.next());

		mult.close(); // close scanner

		// output as new NeutrinoValue Object with all of the parsed data
		return new NeutrinoValues(NameValues, InteractionValues, energy);
	}

	public static NeutrinoPredicted parseLinePredicted(String line) {
		// return a NeutrinoPredicted object

		Scanner mult = new Scanner(line); // scans each value

		// puts data into each variable
		String NamePredicted = mult.next();
		String InteractionPredicted = mult.next();
		double frequencyPredicted = Double.parseDouble(mult.next());

		mult.close(); // close scanner

		// output as new NeutrinoPredicted Object with all of the parsed data
		return new NeutrinoPredicted(NamePredicted, InteractionPredicted, frequencyPredicted);
	}

	public static ArrayList<NeutrinoValues> dataFromURLNeutrinoValues(String urlName) throws Exception {
		// Create an ArrayList of NeutrinoValues

		// takes url and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<NeutrinoValues> neutrinoValues = new ArrayList<NeutrinoValues>(); // Define ArrayList containing
																					// Hitter objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			neutrinoValues.add(parseLineValues(line));
		}
		return neutrinoValues; // outputs arrayList
	}

	public static ArrayList<NeutrinoPredicted> dataFromURLNeutrinoPredicted(String urlName) throws Exception {
		// Create an ArrayList of NeutrinoValues

		// takes url and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<NeutrinoPredicted> neutrinoPredicted = new ArrayList<NeutrinoPredicted>(); // Define ArrayList
																								// containing Hitter
																								// objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			neutrinoPredicted.add(parseLinePredicted(line));
		}
		return neutrinoPredicted; // outputs arrayList
	}

	private static void getNeutrinoDataValues(ArrayList<NeutrinoValues> allNeutrinoValues,
			HashMap<String, ArrayList<NeutrinoValues>> NeutrinoValuesHashMap) {
		for (NeutrinoValues nv : allNeutrinoValues) { // loop over all experimental values

			// If the particle has not yet been put into the HashMap, create a new ArrayList
			// containing the current particle and put it into the HashMap.
			if (NeutrinoValuesHashMap.get(nv.NameValues) == null) {
				ArrayList<NeutrinoValues> NeutrinoValuesArray = new ArrayList<NeutrinoValues>();
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.NameValues, NeutrinoValuesArray);
			}
			// If the name is already registered as a key, scans hashmap for
			// corresponding key, add current particle to arraylist and update hashmap
			else {
				ArrayList<NeutrinoValues> NeutrinoValuesArray = NeutrinoValuesHashMap.get(nv.NameValues);
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.NameValues, NeutrinoValuesArray); // associates key to value
			}
		}
	}

	// creates another hashmap with interaction values as key
	private static void getNeutrinoDataValuesI(ArrayList<NeutrinoValues> allNeutrinoValues,HashMap<String, ArrayList<NeutrinoValues>> NeutrinoValuesHashMap) {
		for (NeutrinoValues nv : allNeutrinoValues) { // loop over all experimental values

			// If the particle has not yet been put into the HashMap, create a new ArrayList
			// containing the current particle and put it into the HashMap.
			if (NeutrinoValuesHashMap.get(nv.InteractionValues) == null) {
				ArrayList<NeutrinoValues> NeutrinoValuesArray = new ArrayList<NeutrinoValues>();
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.InteractionValues, NeutrinoValuesArray);
			}
			// If the name is already registered as a key, scans hashmap for
			// corresponding key, add current particle to arraylist and update hashmap
			else {
				ArrayList<NeutrinoValues> NeutrinoValuesArray = NeutrinoValuesHashMap.get(nv.InteractionValues);
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.InteractionValues, NeutrinoValuesArray); // associates key to value
			}
		}
	}

	private static void getNeutrinoDataPredicted(ArrayList<NeutrinoPredicted> allNeutrinoValues,
			HashMap<String, ArrayList<NeutrinoPredicted>> NeutrinoValuesHashMap) {
		for (NeutrinoPredicted nv : allNeutrinoValues) { // loop over all experimental values

			// If the particle has not yet been put into the HashMap, create a new ArrayList
			// containing the current particle and put it into the HashMap.
			if (NeutrinoValuesHashMap.get(nv.NamePredicted) == null) {
				ArrayList<NeutrinoPredicted> NeutrinoValuesArray = new ArrayList<NeutrinoPredicted>();
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.NamePredicted, NeutrinoValuesArray);
			}
			// If the name is already registered as a key, scans hashmap for
			// corresponding key, add current particle to arraylist and update hashmap
			else {
				ArrayList<NeutrinoPredicted> NeutrinoValuesArray = NeutrinoValuesHashMap.get(nv.NamePredicted);
				NeutrinoValuesArray.add(nv);
				NeutrinoValuesHashMap.put(nv.NamePredicted, NeutrinoValuesArray); // associates key to value
			}
		}
	}

	public static void main(String[] args) {
		try {

			// initialise hashmap of values, with name of experiment as key (for
			// Experimental Values)
			ArrayList<NeutrinoValues> allNeutrinoValues = dataFromURLNeutrinoValues(
					"http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/midterm/NeutrinoEvents.txt");
			HashMap<String, ArrayList<NeutrinoValues>> NeutrinoValuesHashMap = new HashMap<String, ArrayList<NeutrinoValues>>();
			getNeutrinoDataValues(allNeutrinoValues, NeutrinoValuesHashMap); // parses values into hashMap

			// initialise hashmap of values, with name of experiment as key (for Predicted)
			ArrayList<NeutrinoPredicted> allNeutrinoPredicted = dataFromURLNeutrinoPredicted(
					"http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/midterm/NeutrinoExperiments.txt");
			HashMap<String, ArrayList<NeutrinoPredicted>> NeutrinoPredictedHashMap = new HashMap<String, ArrayList<NeutrinoPredicted>>();
			getNeutrinoDataPredicted(allNeutrinoPredicted, NeutrinoPredictedHashMap); // parses values into hashMap

			for (String nameValues : NeutrinoValuesHashMap.keySet()) { // loop through each experiment name

				// creates arraylist of neutrinos for name considered
				ArrayList<NeutrinoValues> NeutrinoValuesKeyset = NeutrinoValuesHashMap.get(nameValues);
						
				// Initialises hashmap for interaction set
				HashMap<String, ArrayList<NeutrinoValues>> NeutrinoValueHashMapInteraction = new HashMap<String, ArrayList<NeutrinoValues>>();
				getNeutrinoDataValuesI(NeutrinoValuesKeyset, NeutrinoValueHashMapInteraction); // parses values into hashMap

		
				for (String nvi : NeutrinoValueHashMapInteraction.keySet()) { // loop through interaction names

					// initialise arraylist of namevalues & variable
					ArrayList<NeutrinoValues> NeutrinoValuesInteraction = NeutrinoValueHashMapInteraction.get(nvi); 
					int counter = NeutrinoValuesInteraction.size();
					double significance = 0;
					
				//	compare to predicted
					for (NeutrinoPredicted np : allNeutrinoPredicted) {
						if ((nameValues.equals(np.NamePredicted)) || (nvi.equals(np.InteractionPredicted))) {
							significance = (counter - np.getFrequencyPredicted())/(Math.sqrt(np.getFrequencyPredicted()));
							
						}
					}
					System.out.println("Experiment: " + nameValues + " || Interaction: "+nvi+" || Nm: " + counter +" || Significance: "+significance);
				}		
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
