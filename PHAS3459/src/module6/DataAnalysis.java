package module6;

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
		//returns chi^2 value for a set of x, y and y uncertainty values
		
		ArrayList<Double> xpoints = new ArrayList<Double>(); //creates a new set of array lists for analysis
		ArrayList<Double> ypoints = new ArrayList<Double>();
		ArrayList<Double> eypoints = new ArrayList<Double>();
		
		for (int i = 0; i < dataPoint.size(); i++) {
			xpoints.add(dataPoint.get(i).getX()); // Put original data into ArrayList objects defined above
			ypoints.add(dataPoint.get(i).getY());
			eypoints.add(dataPoint.get(i).getEy());
		}
		ArrayList<Double> yPointsTh = t.theoreticalYPoints(xpoints); //calculate theoretical y-points
		
		double chiSqTotal = 0; //initialise chi square
		
		for (int i=0; i < dataPoint.size(); i++) {
			chiSqTotal += Math.pow(yPointsTh.get(i)-ypoints.get(i),2)/(Math.pow(eypoints.get(i), 2)); //calculate chi-sq values for each component
		}
		
		return chiSqTotal;
	}
	
	public static void main(String[] args) {
		ArrayList<DataPoint> points;
		try {
			points = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"); //import data
			Theory t2 = new Theory(2); //Creates theory object of n=2
			Theory t4 = new Theory(4); //Creates new theory object of n=4
			System.out.println("for n=2, the chiSqTotal is: " + goodnessOfFit(t2,points));
			System.out.println("for n=4, the chiSqTotal is: " + goodnessOfFit(t4,points));
		}
		catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("The chiSq Total for n=4 is much less than n=2 so is more likely to fit the data, hence better describes it.");
	}
}