package midTermExam;

//import necessary classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

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
		String line = ""; //initialise string so it is not null for the loop below
		b.readLine(); // Ignore the first two lines
		b.readLine();
		while ((line = b.readLine()) != null) {
			// Take an object created from each line and store in the ArrayList
			earthquakes.add(parseLine(line));
		}
		
		return earthquakes;
		
	}
	
	public static void main(String[] args) throws Exception {
		ArrayList<Earthquake> allEarthquakes = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt"); //retrieve URL data
		System.out.printf("The total number of valid earthquakes recorded in the file is %d. %n", allEarthquakes.size()); // Output total number of Earthquakes
	}
}
