package Final2015_2;
/**
 * Final 2015, Class which holds methods to be implemented
 */
/**
 * Import necessary modules
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Method {
	
	/**
	 * Method which converts string of url into bufferedReader object
	 * @param url
	 * @return bufferedReader
	 * @throws IOException
	 */
	private static BufferedReader brFromUrl(String url) throws IOException {
		
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
		
	}
	
	/**
	 * Method which creates hashmap from detectors URL using identifier as key and distance as the value
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private static HashMap<String, Double> detectorsHM(String url) throws IOException {
		
		BufferedReader br = brFromUrl(url);
		String empty = "";
		HashMap<String, Double> detectorHM = new HashMap<String, Double>(); //initialise hashmap
		
		while ((empty = br.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String Identifier = sn.next();
			Double Distance = Double.parseDouble(sn.next());
			
			sn.close();
			
			detectorHM.put(Identifier, Distance); //add keyset and value to hashmap
			
		}
		return detectorHM;
	}
	
	/**
	 * Method which grabs hashmap from URL, creates signal objects and returns signals corresponding to their identifier
	 * @param url string
	 * @return HashMap<String, ArrayList<Signal>>
	 * @throws IOException
	 */
	private static HashMap<String, ArrayList<Signal>> signalsHM(String url) throws IOException {
		
		BufferedReader br = brFromUrl(url);
		String empty = "";
		HashMap<String, ArrayList<Signal>> signalsHM = new HashMap<String, ArrayList<Signal>>(); //Initialise hashmap for datapoints
		
		while ((empty = br.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String Identifier = sn.next(); //parse name
			ArrayList<Double> dataAL = new ArrayList<Double>(); //Initialise arraylist
			
			while (sn.hasNext()) { //add all the data points to create signal object
				
				Double data = Double.parseDouble(sn.next());
				dataAL.add(data);
				
			}
			
			Signal sig = new Signal(Identifier, dataAL); //Create new signal object
			
			if (signalsHM.get(Identifier) == null) { //if keyset doesn't exist, create one with identifier as key and arraylist of signal objects as value
				
				ArrayList<Signal> signalAL = new ArrayList<Signal>(); //initialise hashmap for signal objects
				signalAL.add(sig);
				signalsHM.put(Identifier, signalAL);
				
			}
			else {
				
				ArrayList<Signal> signalAL = signalsHM.get(Identifier); //keyset already exists, so get value from the hashmap
				signalAL.add(sig);
				signalsHM.put(Identifier, signalAL);
				
			}
			sn.close();
		}
		return signalsHM;
	}
	
	/**
	 * Method which creates an arraylist of all the signals, and prints the total amount of pulses and the mean amplitude
	 * @throws IOException 
	 */
	public static void allPulsesAnalysis() throws IOException {
		
		BufferedReader br = brFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt"); //grab br from url
		String empty = "";
		ArrayList<Signal> allSignalAL = new ArrayList<Signal>(); //initialise arraylist
		double sumAmplitude = 0.0;
		
		while ((empty = br.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String Identifier = sn.next(); //parse name
			ArrayList<Double> dataAL = new ArrayList<Double>(); //Initialise arraylist
			
			while (sn.hasNext()) { //add all the data points to create signal object
				
				Double data = Double.parseDouble(sn.next());
				dataAL.add(data);
				
			}
			sn.close();
			
			Signal sig = new Signal(Identifier, dataAL); //Create new signal object
			sumAmplitude += sig.amplitude; 
			
			allSignalAL.add(sig); //add to arraylist
			
		}
		
		double pulseCount = allSignalAL.size();
		double meanAmplitude = sumAmplitude / pulseCount ;
		
		System.out.println("Total number of pulses: "+pulseCount);
		System.out.println("Mean amplitude of pulses: "+meanAmplitude);
		
	}

	/**
	 * Method which analyses HashMaps that occur in the data with identifier as key and signal object array list as the values
	 * @throws IOException
	 */
	public static void detectorsAnalysis() throws IOException {
		
		//grabs hashmap
		HashMap<String, ArrayList<Signal>> signalsHM = signalsHM("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt"); 
		double maxArrivalTimeDifference = 0.0;
		String maxArrivalDetector = null;
		
		for (String detector : signalsHM.keySet()) { //loop through detectors
			
			double sumAmplitude = 0.0; //initialise
			double sumTimes = 0.0;
			
			double sumTimesArrival = 0.0;
			
			ArrayList<Signal> signalsAL = signalsHM.get(detector); //grab arraylist of signal objects corresponding to detector
			
			for (Signal s : signalsAL) {
				
				sumAmplitude += s.amplitude;
				sumTimes += s.arrivalTime;
				
				sumTimesArrival += (new ArrivalThreshold()).arrivalTime(s, 1.0);
				
			}
			double meanAmplitude = sumAmplitude / signalsAL.size(); //calculate mean amplitudes and times
			double meanTime = sumTimes / signalsAL.size();
			
			HashMap<String, Double> detectorsHM = detectorsHM("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/detectors.txt"); //grab hashmap of detectors
			double distance = detectorsHM.get(detector); //grab corresponding distance for detector
			double speed = distance / meanTime ; //calculate speed
			
			double meanThresholdTime = sumTimesArrival / signalsAL.size();
			double thresholdSpeed = distance / meanThresholdTime;
			
			double arrivalTimeDifference = Math.abs(meanTime - meanThresholdTime); //calculates time difference
			if (arrivalTimeDifference > maxArrivalTimeDifference) {
				
				maxArrivalTimeDifference = arrivalTimeDifference;
				maxArrivalDetector = detector;
				
			}
			
			System.out.println("");
			System.out.println("Detector: "+detector);
			System.out.println("Number of Signals: "+signalsAL.size());
			System.out.println("Mean Amplitude: "+meanAmplitude);
			System.out.println("Mean Time: "+meanTime);
			System.out.println("Speed: "+speed);
			System.out.println("Threshold speed: "+ thresholdSpeed);
			
		}
		System.out.println("");
		System.out.println("The detector with the greatest arrival time difference is: "+ maxArrivalDetector+" with a difference of "+maxArrivalTimeDifference);
		
	}
	
}
