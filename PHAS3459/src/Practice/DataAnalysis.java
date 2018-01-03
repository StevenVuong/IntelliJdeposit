package Practice;

import java.util.*;

import module5_1.DataPoint;
import module5_1.Theory;

import java.io.*;
import java.net.*;

public class DataAnalysis {
	
	/**
	 * Method to parse data from line into datapoint object
	 * @param line
	 * @return datapoint object
	 */
	public static DataPoint parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Create new scanner object
		
		//Parses details into object variables
		double x = Double.parseDouble(sn.next());
		double y = Double.parseDouble(sn.next());
		double ey = Double.parseDouble(sn.next());
		
		sn.close(); //Closes scanner
		
		return new DataPoint(x, y, ey);
	}
	
	/**
	 * Method to return arraylist of datapoint objects from URL
	 * @param url string
	 * @return arraylist of datapoint objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<DataPoint> dataFromURL(String url) throws MalformedURLException, IOException {
		
		//Creates URL object from url string and converts into bufferedReader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line = ""; //initialise string
		ArrayList<DataPoint> dataPointArrayList = new ArrayList<DataPoint>(); //Initialise arraylist
		
		while ((line=br.readLine())!=null) {
			dataPointArrayList.add(parseLine(line));
		}

		return dataPointArrayList;
		
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
		try {
			
			//Grab values from URL
			ArrayList<DataPoint> dpArray = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			
			//Create theory objects
			Theory th2 = new Theory(2.0);
			Theory th4 = new Theory(4.0);
			
			//Calculate goodness of fit
			double gof2 = goodnessOfFit(th2, dpArray); 
			double gof4 = goodnessOfFit(th4, dpArray);
			
			System.out.println("n = 2.0 has goodness of fit: "+gof2);
			System.out.println("n = 4.0 has goodness of fit: "+gof4);
			System.out.println("so n = 4.0 has a greater fit");
			
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}

}
