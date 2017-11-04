package module5;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class DataAnalysis {

	// creates static method for returning arraylist from URL string
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws FileNotFoundException, IOException {
		URL u = new URL(urlName); // creates URL object
		InputStream is = u.openStream(); // searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); // sets the buffered reader as the inputStreamReader
		
		ArrayList<DataPoint> point = new ArrayList<DataPoint>();
		String empty = new String(""); //initialises String
		while ((empty = b.readLine()) != null) {
			point.add(DataPoint.parseline(empty)); // object to string with parseline then adds to ArrayList
		}
		return point;
	}
	
	public static double goodnessOfFit(Theory t, ArrayList<DataPoint> dataPoint) {
		
		
		return (Double) null; //
	}
}
