package MidTerm2009_10;
/**
 * Mid Term 2009-10. Class with main method
 * @author SID: 15011252
 * @version 14-01-2018
 */
/**
 * Import necessary modules
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			//Grabs data from URL
			HashMap<Location, ArrayList<Measurement>> dataHashMap = Methods.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/midterm/x.txt");
			
			//Second bulletpoint
			ArrayList<Measurement> allMeasurements = Methods.allMeasurementsArrayList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/midterm/x.txt");
			
			//Initialise arraylists
			ArrayList<Measurement> twoThousandPlus = new ArrayList<Measurement>();
			ArrayList<Measurement> twoThousandMinus = new ArrayList<Measurement>();
			ArrayList<Measurement> posLat = new ArrayList<Measurement>();
			ArrayList<Measurement> negLat = new ArrayList<Measurement>();
		
			for (Measurement m : allMeasurements) { //loop through arraylist
				double year =(double) m.Year;
				
				if (year >= 2000.0) { //add to arraylist of positive if past 2000 or in 2000
					twoThousandPlus.add(m);
				}
				if (year < 2000.0) { //add to arraylist if pre 2000
					twoThousandMinus.add(m);
				}
				if (year >= 0.0) { //add to arraylist if post 2000
					posLat.add(m);
				}
				if (year < 0.0) { //add to arraylist if pre 2000
					negLat.add(m);
				}
				
			}
			
			System.out.println("");
			System.out.println("Mean of measurements made before 2000:");
			Methods.calculateMean(twoThousandMinus);
			
			System.out.println("Mean of measurements made in 2000 and after:");
			Methods.calculateMean(twoThousandPlus);

			
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}


}
