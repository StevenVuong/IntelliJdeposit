package MidTerm2008_9;
/**
 * Utilities type class which stores methods to be used in the main method
 * @author SID: 15011252
 * @version 14-02-2018
 */
/**
 * Import necessary packages
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Method {
	
	/**
	 * Class which converts URL string to bufferedReader object
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static BufferedReader brFromUrl(String url) throws MalformedURLException, IOException {
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	/**
	 * Class which uses higgs data and puts into string with name of experiment as key and arraylist of masses as values
	 * @param String url
	 * @return HashMap
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, ArrayList<Double>> higgsDataFromURL(String url) throws MalformedURLException, IOException {
		
		BufferedReader br = brFromUrl(url); //grab br object
		HashMap<String, ArrayList<Double>> higgsHM = new HashMap<String, ArrayList<Double>>(); //Initialise arraylist
		String empty = ""; //initialise string
		
		while ((empty = br.readLine()) != null) { //loop through values
			
			Scanner sn = new Scanner(empty);
			
			//Parse values
			String Name = sn.next();
			Double Mass = Double.parseDouble(sn.next());
			
			if (higgsHM.get(Name) == null) { //condition if keyset for hashmap doesn't exist
				
				ArrayList<Double> exptAL = new ArrayList<Double>(); //Initialise arraylist
				exptAL.add(Mass); 
				higgsHM.put(Name, exptAL);
				
			}
			else { //keyset already exists, so simply get arraylist, add and add back into hashmap
				 
				ArrayList<Double> exptAL = higgsHM.get(Name); //Grab arraylist otherwise corresponding to name
				exptAL.add(Mass);
				higgsHM.put(Name, exptAL);
				
			}
			
			sn.close();
			
		}
		
		return higgsHM;
	}
	
	/**
	 * Method which parses data from a line and returns as a data object, private as only used by other methods in this class
	 * @param line string
	 * @return Data object
	 */
	private static Data parseData(String line) {
		
		Scanner sn = new Scanner(line); //create new scanner object
		
		String Name = sn.next();
		Double MinMass = Double.parseDouble(sn.next());
		Double MaxMass = Double.parseDouble(sn.next());
		Double ExpectedCount = Double.parseDouble(sn.next());
		
		return new Data(Name, MinMass, MaxMass, ExpectedCount);
	}
	
	/**
	 * Method which creates ArrayList for experimental data (second url) with the data in an arraylist
	 * @param url
	 * @return ArrayList of Data objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Data> experimentDataFromURL(String url) throws MalformedURLException, IOException {
		
		BufferedReader br = brFromUrl(url);
		ArrayList<Data> dataAL = new ArrayList<Data>();
		String empty = "";
		
		while ((empty = br.readLine()) != null) {
			
			dataAL.add(parseData(empty)); //parse data accordingly
			
		}
		
		return dataAL;
	}
	
	/**
	 * Method which prints out the number of higgs events within a mass range for that data
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void numberHiggsCalculation() throws MalformedURLException, IOException {
		
		//Grab hashmap of datasets according to each experiment
		HashMap<String, ArrayList<Double>> experimentsHM = higgsDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2008-09/HiggsData.txt");
		
		//Grab data arraylist
		ArrayList<Data> dataAL = experimentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2008-09/ExperimentData.txt");
		
		for (String expt : experimentsHM.keySet()) { //loop through keyset
			
			//Initialise variables (these are variables and not objects as calculations is faster)
			double maxMass = 0;
			double minMass = 0;
			double expectedCount = 0;
			Data exptData;
			int counter = 0;
			
			for (Data d : dataAL) { //loop through arraylist to set maxmass, minmass and expected count
				
				if (d.Name.equals(expt)) { //condition of the names are equal, sets the max mass, the min mass etc..
					
					exptData = d;
					maxMass = d.MaxMass;
					minMass = d.MinMass;
					expectedCount = d.ExpectedCount;
					
				}
				
			}
			
			ArrayList<Double> higgsDataAL = experimentsHM.get(expt); //grab arraylist of values for keyset
			
			for (Double value : higgsDataAL) { //loop through arraylist of points for that particular experiment
				
				if ((value < maxMass) && (value > minMass)) { //condition if it lies within databounds
					counter++;
				}
				
			}
			
			double significance = (counter - expectedCount) / (Math.sqrt(expectedCount));
			
			System.out.println("");
			System.out.println("Experiment: "+expt);
			System.out.println("Number of Higgs events that fall within range: "+counter);
			System.out.println("Significance: "+significance);
			
			if (significance > 5.0) { //Print statement for claim of higgs boson
				System.out.println("This experiment can claim the discovery of the Higgs Boson!");
			}
			
		}
		
	}



}
