package module6_1;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Main Class, reads data from url and creates list of DataPoint objects
 * @author Steven Vuong
 * @version 26-12-2017
 */
public class TestDataPoints {
	
	/**
	 * Method to obtain Buffered Reader object from URL
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		URL u = new URL(url); // creates URL object
		InputStream is = u.openStream(); // searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); // sets the buffered reader as the inputStreamReader
		return b;
	}
	
	/**
	 * Method to create DataPoint objects, including LabelledDataPoint Objects
	 * @param line
	 * @return DataPoint object
	 */
	public static DataPoint parseLine(String line) {

		Scanner sn = new Scanner(line);
		//Initialise objects for constructors
		Double X = Double.parseDouble(sn.next());
		Double Y = Double.parseDouble(sn.next());
		Double Ey = Double.parseDouble(sn.next());
		
		if (sn.hasNext()) { //condition if there is a line at the end of the data value
			String label = sn.next();
			sn.close();
			return new LabelledDataPoint(label, X, Y, Ey);
		}
		
		else {
			sn.close();
			return new DataPoint(X, Y, Ey);
		}
		
	}
	
	/**
	 * Method to read values from URL and return as an arrayList
	 * @param url
	 * @return ArrayList of DataPoint objects
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<DataPoint> dataFromURL(String url) throws FileNotFoundException, IOException {
		BufferedReader b = brFromURL(url);
		
		ArrayList<DataPoint> point = new ArrayList<DataPoint>(); //Initialises arraylist
		String empty = new String(""); //initialises String
		while ((empty = b.readLine()) != null) {
			point.add(parseLine(empty)); // object to string with parseline then adds to ArrayList
		}
		return point;
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> data = new ArrayList<DataPoint>(dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
			for (DataPoint dp : data) {
				System.out.println(dp.toString());
			}
		}
		catch(IOException e) {
			System.out.println("Cannot find URL!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
