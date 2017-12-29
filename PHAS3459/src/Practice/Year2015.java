package Practice;
/**
 * Class with main method to analyse earthquake object array
 * @author Steven Vuong
 * @version 29-12-1996
 */
//Import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class Year2015 {
	
	public static void main(String[] args) {

		try {
			
			//sort data into earthquake objects and put into array of earthquake objects
			ArrayList<Earthquake> earthquakes = EarthquakeDataFromUrl.dataFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/earthquakesCA1989.txt");
			
			System.out.println("There are "+earthquakes.size()+" number of earthquakes");
			System.out.println("");
			
			Double largestMag = 0.0; //Initialise variables
			String largestMagDetails = null;
			
			//Loop through earthquakes and finds largest magnitude
			for (Earthquake eq : earthquakes) { 
				if (eq.Mag >= largestMag) {
					largestMag = eq.Mag;
					largestMagDetails = eq.getDetails();
				}
			}
			System.out.println("Earthquake with largest magnitude: "+largestMagDetails);
			System.out.println("");
			
			//Initialise hashmap with Month as key and earthquake array objects as values
			HashMap<Integer, ArrayList<Earthquake>> earthquakesHM = new HashMap<Integer, ArrayList<Earthquake>>();
			
			//Loop through earthquakes and fills hashmap accordingly
			for (Earthquake eq : earthquakes) {
				if (earthquakesHM.get(eq.Month) == null) { //Check if month already exists as a key
					ArrayList<Earthquake> earthquakeAL = new ArrayList<Earthquake>();
					earthquakeAL.add(eq);
					earthquakesHM.put(eq.Month, earthquakeAL);
				}
				else { //Grab month if already exists and adds to arraylist
					ArrayList<Earthquake> earthquakeAL = earthquakesHM.get(eq.Month);
					earthquakeAL.add(eq);
					earthquakesHM.put(eq.Month, earthquakeAL);
				}
			}
			
			//Loop through months to analyse data
			for (Integer month : earthquakesHM.keySet()) { 
				
				ArrayList<Earthquake> eqArray = earthquakesHM.get(month); //Create arraylist of earthquakes for specific month
				
				Double MaxDepth = 0.0; //Initialise variables
				String MaxDepthDetails = null;
				Double minDepth = 1000000.0;
				String minDepthDetails = null;
				
				for (Earthquake eq : eqArray) {
					
					if (eq.Depth > MaxDepth) {
						MaxDepth = eq.Depth;
						MaxDepthDetails = eq.getDetails();
					}
					
					if ((eq.Az != -1) && (eq.Az != 0)) { //Condition for a non-missing error measurement
						if (eq.Ez <= minDepth) {
							minDepth = eq.Ez;
							minDepthDetails = eq.getDetails();
						}
					}
					
				}
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("For Month: "+month);
				System.out.println("There were "+eqArray.size()+" earthquakes");
				System.out.println("Max Depth Details: "+MaxDepthDetails);
				System.out.println("Smallest Depth Error Earthquake: "+minDepthDetails);
			}
		} 
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
