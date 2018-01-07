package module6_2;
/**
 * Class with main method to test DataPoint and Labelled DataPoint
 * @author Steven Vuong
 * @version 06/01/2018
 */
/**
 * Import necessary modules
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class TestDataPoints {

	/**
	 * Method which takes in line and parses into dataPoint or LabelledDTaPoint objects
	 * @param line
	 * @return DataPoint object
	 */
	public static DataPoint parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Create scanner object 
		
		//Parse values
		double x = Double.parseDouble(sn.next());
		double y = Double.parseDouble(sn.next());
		double ey = Double.parseDouble(sn.next());
		
		if (sn.hasNext()) {
			String empty = sn.next();
			return new LabelledDataPoint(empty, x, y, ey); //Condition to return Labelled DataPoint
		}
		
		sn.close(); //close scanner object
		
		return new DataPoint(x, y, ey); //Return datapoint if no label
		
	}
	
	
	
	/**
	 * Method which takes in a url string and outputs an array of DataPoint variables
	 * @param url string
	 * @return ArrayList Datapoint
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<DataPoint> dataFromURL(String url) throws MalformedURLException, IOException{
		
		//Convert URL into buffered reader object
		URL u = new URL(url); 
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line = ""; //Initialise line
		ArrayList<DataPoint> dataPointArrayList = new ArrayList<DataPoint>(); //Initialise array list
		
		while ((line = br.readLine()) != null) { //Loop through values
			
			dataPointArrayList.add(parseLine(line)); //parse values into line
			
		}
		
		return dataPointArrayList;
	}
	
	public static void main(String[] args) {
		
		try {
			
			ArrayList<DataPoint> dpArrayList = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"); //Grabs data from URL
			
			for (DataPoint dp : dpArrayList) { //loop through arraylist and print values
				System.out.println(dp.toString());
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}
}
