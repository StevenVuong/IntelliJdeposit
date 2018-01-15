package Final2009;
/**
 * Class containing methods to be used in 2009 Final
 * @author SID: 15011252
 * @version 15-01-18
 */
/**
 * Import necessary modules
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Method {
	
	/**
	 * Method which returns a single number representing the total energy of two electrons. Using Gaussian smearing
	 * @param mean double
	 * @param standard deviation double
	 * @return double energy
	 */
	private static double generateEnergy(double mean, double sd) {
		
		Random r = new Random(); //create random object
		 //generate random distributed number with mean 0 and s.d. 1.0
		
		return (sd * r.nextGaussian() + mean);
	}

	/**
	 * Method which calculates the energy and prints to a file
	 * @throws IOException
	 */
	public static void writeToFile() throws IOException {
		    
	    File fout = new File("C:\\files\\signal.txt"); //creates a new file and saves in this particular location
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); //creates bufferedwriter object
	 
		for (int i = 0; i < 100; i++) { //loops through 100 times
			
			double energy = generateEnergy(2.5, 0.25); //gets energy from other method, setting mean to 2.5 and standard dev to 0.25
			String energyString = String.valueOf(energy);
			bw.write(energyString); //writes the bytes to file
			bw.newLine(); //reads to a new line each time
			
		}
	 
		bw.close();
	
	}
	
	/**
	 * Create bufferedReader object from URL String
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		return br;
	}
	
	/**
	 * Method which uses the file of signal events and returns the number of energies within a particular range
	 * @param url
	 * @param lowerBoundary
	 * @param upperBoundary
	 * @return double number of values in range
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static double getCounter(String url, double lowerBoundary) throws MalformedURLException, IOException {
		
		BufferedReader br = brFromURL(url); //create bufferedReader
		String empty = ""; //create empty string
		int counter = 0; //initialise counter
		
		while ((empty = br.readLine()) != null) { //loop through values
			
			Double energy = Double.parseDouble(empty); //turn value into double
			
			if (energy >= lowerBoundary) { //if value greater than min, increase counter increment
				counter++;
			}
			
		}
		
		return counter;
	}
	
	/** 
	 * method which returns signal to background ratio for a minimum energy
	 * @param urlSignal
	 * @param urlBackground
	 * @param lowerBoundary
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private static double sbRatio(String urlSignal, String urlBackground, double lowerBoundary) throws MalformedURLException, IOException {
		
		//grab counters
		double counterSignal = getCounter(urlSignal, lowerBoundary);
		double counterBackground = getCounter(urlBackground, lowerBoundary);
		
		return (counterSignal / counterBackground); //calculates signal to background ratio and returns this
	}

	/**
	 * Method which calculates signal to background ratio and finds the maxmimum 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void maximumSbRatio() throws MalformedURLException, IOException {
		
		//set url for signal and background
		String urlSignal = ("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/final/eox-signal.txt");
		String urlBackground = ("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/final/eox-background.txt");
		
		//initialise values
		double maxSbRatio = 0.0;
		double maxSbRatioEnergy = 0.0;
		
		double minEnergy = 1.0; //set minimum energy
		
		while (minEnergy <= 3.0) {
			
			double sbRatio = sbRatio(urlSignal, urlBackground, minEnergy); //calculates signal to background ratio
			
			if (sbRatio > maxSbRatio) { //find X that maximuses S/B
				
				maxSbRatio = sbRatio;
				maxSbRatioEnergy = minEnergy;
				
			}
			
			minEnergy = minEnergy + 0.1; //increase by increment of 0.1
		}
		
		System.out.println("Max Signal to Background Ratio: "+maxSbRatio);
		System.out.println("Occurs at energy: "+maxSbRatioEnergy+" MeV");
	}
	
}
