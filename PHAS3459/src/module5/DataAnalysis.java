package module5;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	// creates static method for returning buffered reader from URL string
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws FileNotFoundException, IOException {
		URL u = new URL(urlName); // creates URL object
		InputStream is = u.openStream(); // effectively searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		ArrayList b = new ArrayList(isr); // sets the buffered reader as the inputStreamReader
		return null;
	}
}
