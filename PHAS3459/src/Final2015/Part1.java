package Final2015;
/**
 * Java Final Exam 2015
 * @author Steven Vuong
 * @version 02-01-2018
 */


/**
 * Import necessary packages
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Part1 {
	
	/**
	 * Method which parses data from URL line and returns a ArrayList of pulse object with identifier and data
	 * @param url strung
	 * @return ArrayList of Pulse object containing identifier string and ArrayList of data(double)
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Pulse> getPulseFromUrl(String url) throws MalformedURLException, IOException {
		
		//Turn URL String into bufferedReader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Initialise variables
		String line = "";
		ArrayList<Pulse> pulseArrayList = new ArrayList<Pulse>();
		
		while ((line=br.readLine()) != null) {
			
		//Create scanner object to break the line into multiple parts, separated by spaces
		Scanner sn = new Scanner(line); 
		
		//Parse details
		String identifier = sn.next();
		
		ArrayList<Double> data = new ArrayList<Double>(); //Initialise arraylist
		while(sn.hasNext()) {
			data.add(Double.parseDouble(sn.next())); //add the of the data into arraylist
		}
		
		sn.close(); //close scanner
		Pulse p = new Pulse(identifier, data); //Create new pulse object
		pulseArrayList.add(p); //add pulse object to array list
		}
		
		return pulseArrayList;
		
	}
	
	/**
	 * Method which obtains data from URL and parses into pulse objects, then uses pulse objects to create hashmap with identifiers as values
	 * @return hashmap with pulse identifier as key and pulse array corresponding to identifier as values
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, ArrayList<Pulse>> organisePulseArray() throws MalformedURLException, IOException {
		
		//Obtain pulse arrayList
		ArrayList<Pulse> pulseArrayList = getPulseFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt");
		
		HashMap<String, ArrayList<Pulse>> pulseHashMap = new HashMap<String, ArrayList<Pulse>>(); //Initialise hashMap
		
		for (Pulse p : pulseArrayList) { //Loop through pulses
			
			if (pulseHashMap.get(p.Identifier) == null) { //if key doesn't exist, create new hashmap and add 
				
				ArrayList<Pulse> pulseArray = new ArrayList<Pulse>();
				pulseArray.add(p);
				pulseHashMap.put(p.Identifier, pulseArray);
				
			}
			
			else { //if key exists, obtain arraylist of pulses and add to it
				ArrayList<Pulse> pulseArray = pulseHashMap.get(p.Identifier);
				pulseArray.add(p);
				pulseHashMap.put(p.Identifier, pulseArray);
			}
			
		}
		
		return pulseHashMap;
	}
	
	/**
	 * Method which uses detector URL to create hashmap using identifier as key and distance as value
	 * @param url String
	 * @return HashMap containing identifier as key and distance as values
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, Double> detectorsDistance(String url) throws MalformedURLException, IOException {
		
		//Turn URL String into bufferedReader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		HashMap<String, Double> indexHM = new HashMap<String, Double>();
		
		String Line = "";
		
		while (((Line=br.readLine()) != null)) { //Loop through each line

			//Create scanner object to break the line into multiple parts, separated by spaces
			Scanner sn = new Scanner(Line); 
			
			//Parse values
			String identifier = sn.next();
			Double distance = Double.parseDouble(sn.next());

			sn.close(); //close scanner
			
			indexHM.put(identifier, distance); //add key and values to hashmap
		}
		
		return indexHM;
	}

	public static void main(String[] args) {
		try {
			
			//Obtain ArrayList of pulses
			ArrayList<Pulse> pulses = getPulseFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt");
			
			double sumPulseAmplitude = 0.0; //Initialise variable
			
			for (Pulse p : pulses) {
				sumPulseAmplitude += p.Amplitude;
			}
			
			double meanPulsesAmplitude = sumPulseAmplitude / pulses.size(); //Calculates mean amplitude
			
			System.out.println("There are "+pulses.size()+" number of pulses");
			System.out.println("The mean amplitude is: "+meanPulsesAmplitude);
			
			HashMap<String, ArrayList<Pulse>> pulsesHM = organisePulseArray(); //Obtain hashmaps
			HashMap<String, Double> indexHM = detectorsDistance("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt");
			
			double maxSpeedDifference = 0.0;
			String maxSpeedDifferenceIdentifier = null;
			
			for (String identifier : pulsesHM.keySet()) { //Loop through detectors
				
				ArrayList<Pulse> pulsesAL = pulsesHM.get(identifier); //Create arraylist of pulse objects corresponding to keyset
				
				double sumPulseAmplitudeDetector = 0.0; //Initialise variable
				double sumArrivalTime = 0.0;
				double sumArrivalTimeThreshold = 0.0;
				
				for (Pulse p : pulsesAL) {
					sumPulseAmplitudeDetector += p.Amplitude;
					sumArrivalTime += p.time;
					double thresholdTime = (new FirstVoltageAboveThreshold()).calculateArrival(p, 1.0); //obtains threshold time for each value of p
					sumArrivalTimeThreshold += thresholdTime; //adds to sum of threshold time
				}
				double meanPulsesAmplitudeDetector = sumPulseAmplitudeDetector / pulsesAL.size(); //Calculates mean amplitude
				double meanTime = sumArrivalTime / pulsesAL.size(); //Calculate mean time
				double meanTimeThreshold = sumArrivalTimeThreshold / pulsesAL.size();//calculates mean threshold time
				
				Double distance = indexHM.get(identifier);
				double speed = (double) distance / meanTime;
				double thresholdSpeed = (double) distance / meanTimeThreshold;
				
				double speedDifference = Math.abs(speed-thresholdSpeed); //finds magnitude of difference between two speed values
				
				if (speedDifference > maxSpeedDifference) { //condition to set max speed difference
					maxSpeedDifference = speedDifference;
					maxSpeedDifferenceIdentifier = identifier;
				}
				
				System.out.println("");
				System.out.println("Detector: "+identifier);
				System.out.println("Number of Pulses: "+pulsesAL.size());
				System.out.println("Mean amplitudes: "+meanPulsesAmplitudeDetector);
				System.out.println("Mean Time: "+meanTime);
				System.out.println("Speed: "+speed);
				System.out.println("Threshold Speed: "+thresholdSpeed);
				
			}
			
			System.out.println("");
			System.out.println("Greatest speed difference between arrival time between two methods is "+maxSpeedDifference+""
					+ " from detector "+maxSpeedDifferenceIdentifier+" and so has the greatest time difference also");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
