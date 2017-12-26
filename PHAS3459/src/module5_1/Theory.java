package module5_1;

import java.util.ArrayList;

/**
 * Represents function y=x^n to compare to data in form of DataPoint objects
 * 
 * @author Steven Vuong
 * @version: 26-12-2017
 */

public class Theory {

	/**
	 * Set variables
	 */
	double n;
	double y;
	double x;
	private ArrayList<Double> yPoints;
	
	/**
	 * Constructor methods to set value of n and y
	 * @param n, y
	 */
	public Theory(double n) {
		super();
		this.n = n;
	}
	
	public double y(double x) {
		return y=Math.pow(x, this.n);
	}
	
	/**
	 * Calculates theoretical yPoint values for an array of input x values
	 * @param xpoints
	 * @return array of yPoint theoretical values ArrayList
	 */
	public ArrayList<Double> thYpoints(ArrayList<Double> xpoints) {
		
		this.yPoints = new ArrayList<Double>(); //Initialise arraylist
		for (int i=0; i<xpoints.size(); i++) { //loops through xpoints array
			this.yPoints.add(y(xpoints.get(i))); //calculates x^n and inputs values into array
		}
		return yPoints;
		
	}
	
}
