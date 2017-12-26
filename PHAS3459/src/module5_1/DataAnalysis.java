package module5_1;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Class with Main method to compare data from URL with theoretical functions
 * 
 * @author Steven Vuong
 * @version: 26-12-2017
 */

public class DataAnalysis {
	
	/**
	 * Method to read values from URL and return as an arrayList
	 * @param url
	 * @return ArrayList of DataPoint objects
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<DataPoint> dataFromURL(String url) throws FileNotFoundException, IOException {
		URL u = new URL(url); // creates URL object
		InputStream is = u.openStream(); // searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); // sets the buffered reader as the inputStreamReader
		
		ArrayList<DataPoint> point = new ArrayList<DataPoint>(); //Initialises arraylist
		String empty = new String(""); //initialises String
		while ((empty = b.readLine()) != null) {
			point.add(DataPoint.parselines(empty)); // object to string with parseline then adds to ArrayList
		}
		return point;
	}
	
	/**
	 * Method to calculate goodness of fit for a set of values
	 * @param theorical object arguments
	 * @param datapoint arraylist objects
	 * @return chi-squared value for data
	 */
	public static double goodnessOfFit(Theory th, ArrayList<DataPoint> dp) {
		
		//Initialise variables and arrayList
		double chiSq = 0;
		ArrayList<Double> xPoints = new ArrayList<Double>();
		ArrayList<Double> yPoints = new ArrayList<Double>();
		ArrayList<Double> eyPoints = new ArrayList<Double>();
		
		//Loops through DataPoint array and adds to corresponding value arrays
		for (int i=0; i<dp.size(); i++) {
			xPoints.add(dp.get(i).getX());
			yPoints.add(dp.get(i).getY());
			eyPoints.add(dp.get(i).getEy());
		}
		ArrayList<Double> yPointsTh = th.thYpoints(xPoints); //calculates theoretical yPoints
		
		for (int i=0; i<dp.size(); i++) { //loops through arraylist
			chiSq += (Math.pow(yPointsTh.get(i)-yPoints.get(i), 2))/(Math.pow(eyPoints.get(i),2)); //calculates individual chi-square values and sums 
		}
		
		return chiSq;
	}
	
	public static void main(String[] args) {
		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
		try {
			points = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"); //Takes data from URL
			
			//Create theory objects
			Theory t2 = new Theory(2);
			Theory t4 = new Theory(4);
			
			//Test goodness-of-fit
			System.out.println("for n=2, Chi-Sq total = " + goodnessOfFit(t2,points));
			System.out.println("for n=4, Chi-Sq total = " + goodnessOfFit(t4,points));
			
		}
		catch (IOException e) {
			System.out.println("The URL was not found!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("The Chi-Sq total is much less for n=4, therefore this is a better fit");
	}
}
