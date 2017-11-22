package module6;

//import necessary packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TestDataPoints {
	
	private static DataPoint parseLine(String line) {
		// Static method to take in line of data and parse into x, y and yerr objects outputting a datapoint with these objects
		
		Scanner sc = new Scanner(line); //initialise scanner to analyse values on the same line
		
		Double X = Double.parseDouble(sc.next());
		Double Y = Double.parseDouble(sc.next());
		Double EY = Double.parseDouble(sc.next());
		
		if (sc.hasNext()) { //if there is a label at the end of the line, return LabelledDataPoint object
			String Label = sc.next();
			sc.close();
			return new LabelledDataPoint(Label, X, Y, EY);
		}
		else {
			sc.close();
			return new DataPoint(X, Y, EY);
		}
		
	}
	
	// Static method which reads data from URL file and returns arrayList of datapoint variables
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws FileNotFoundException, IOException {
		URL u = new URL(urlName); // creates URL object
		InputStream is = u.openStream(); // searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); // sets the buffered reader as the inputStreamReader
		
		ArrayList<DataPoint> point = new ArrayList<DataPoint>(); //initialises arrayList of datapoint objects
		String empty = new String(""); //initialises String
		while ((empty = b.readLine()) != null) {
			point.add(parseLine(empty)); // Add the data from each line in the BufferedReader to the output ArrayList
		}
		return point;
	}

	public static void main(String[] args) {
		
		try {
			
			ArrayList<DataPoint> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			for (DataPoint dp : data) { //loops over each line, printing each data point
				System.out.println(dp.toString());
			}
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
