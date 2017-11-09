package midTermExam;

//import necessary classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class year2015p1 {

	public static Earthquake parseLine(String line) {
		// Return a Earthquake object containing all the data of one Earthquake.
		Scanner mult = new Scanner(line);
		//mult.useDelimiter("\t"); // Set up new scanner to analyse multiple numbers in the same line of the input
									// file

		// Put the data in each column of the input file into each of these variables.
		int year = Integer.parseInt(mult.next());
		int month = Integer.parseInt(mult.next());
		int day = Integer.parseInt(mult.next());
		int hour = Integer.parseInt(mult.next());
		int minute = Integer.parseInt(mult.next());
		double second = Double.parseDouble(mult.next());
		double lat = Double.parseDouble(mult.next());
		double lon = Double.parseDouble(mult.next());
		double depth = Double.parseDouble(mult.next());
		double eh1 = Double.parseDouble(mult.next());
		double eh2 = Double.parseDouble(mult.next());
		int az = Integer.parseInt(mult.next());
		double ez = Double.parseDouble(mult.next());
		double mag = Double.parseDouble(mult.next());
		int id = Integer.parseInt(mult.next());

		mult.close(); // Close scanner
		//output as a new object containing all of the data, filtering out error data
		if (az == -1) { //error condition, as when az is an error, the entire row is an error (including eh1, eh2 and ez)
		//throw new Exception ("bad data");
		return null; 
		}

		return new Earthquake(year, month, day, hour, minute, second, lat, lon, depth, eh1, eh2, az, ez, mag, id); 

	}
	
	public static ArrayList <Earthquake> dataFromURL(String urlName) throws Exception{
		//creates an ArrayList of Earthquake from earthquake data
		
		//grabs URL and converts information to buffered reader form
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		
		//define array list, creating array for each object
		ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
		ArrayList fileInMonth = new ArrayList<Earthquake>();
		String line = ""; //initialise string so it is not null for the loop below
		b.readLine(); // Ignore the first two lines
		b.readLine();
		//while (Character.isDigit(line.charAt(0));
		while ((line = b.readLine()) != null) {
			// Take an object created from each line and store in the ArrayList
			//if(earthquake!= null){} //checks if earthquake has null data-point
			earthquakes.add(parseLine(line));
		}
		
		return earthquakes;
		
	}
	
    public static ArrayList<Earthquake> getEarthquakesInMonth(int month) throws Exception{ //method which creates arraylist for each month

        ArrayList<Earthquake> eqInMonth = new ArrayList<Earthquake>();
        ArrayList<Earthquake> allEarthquakes = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt"); //retrieve URL data
        double depth = 0;
		String detailsEarthquakesMonth= "";
		String errorEarthquakeMonth = "";
		Earthquake greatestDepthEq = null;
        for (Earthquake eq : allEarthquakes) {
        	if (eq != null) {
        		if (eq.Month ==  month) {
        			eqInMonth.add(eq);
        		}
        		if (eq.Dep > depth) {
        			greatestDepthEq = eq;
					depth = eq.Dep;
					detailsEarthquakesMonth = eq.getDetails();
					errorEarthquakeMonth = eq.getErrors();
        		}
        	}
        	
        }
        System.out.println("Month: "+month);
        System.out.println("There are " + eqInMonth.size() +" number of earthquakes.");
		System.out.println("The earthquake with the greatest depth has details: " + detailsEarthquakesMonth);
		System.out.println("The errors for the greatest depth earthquake has details: " + errorEarthquakeMonth);
		System.out.println("");
		
		return eqInMonth; //returns array list for specific month
    }
	
	
	public static void main(String[] args) {
		try {
		ArrayList<Earthquake> allEarthquakes = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt"); //retrieve URL data
		System.out.printf("The total number of earthquakes recorded in the file is %d. %n", allEarthquakes.size()); // Output total number of Earthquakes
		
		//Initialises Hashmap to hold depth as key and array of earthquakes as variable to sort through
		HashMap<Double, ArrayList<Earthquake>> earthquakesByDepth = new HashMap<Double, ArrayList<Earthquake>>(); 
		//Initialise variable to hold Earthquake with greatest magnitude
		Earthquake greatestMagEarthquake = null;
		double magnitude = 0;
		String detailsGreatestMagnitude = "";
		String errorGreatestMagnitude = "";
		for (Earthquake eq: allEarthquakes) { //loops over all earthquakes
			if (eq != null) { //ignores null datapoints
	
				if (eq.Mag > magnitude) { // Update variables if this player had more home runs than the currently held MostHRs
					greatestMagEarthquake = eq;
					magnitude = eq.getMag();
					detailsGreatestMagnitude = eq.getDetails();
					errorGreatestMagnitude = eq.getErrors();
					//System.out.println("mag is: "+magnitude+" and ID is: "+eq.Id);
					}
			}
		}
		
		System.out.println("");
		System.out.println("The earthquake with the greatest magnitude has details: " + detailsGreatestMagnitude);
		System.out.println("The errors for the greatest magnitude earthquake has details: " + errorGreatestMagnitude);
		System.out.println("");
		for (Earthquake eq2: allEarthquakes) { //loops over all earthquakes
			
		}
	
		for (int i=1; i<=12; i++) {
			ArrayList EarthquakesForMonth = getEarthquakesInMonth(i);
			}
		
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
