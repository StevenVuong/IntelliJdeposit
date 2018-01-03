package Practice;

import java.util.ArrayList;

/**
 * Java module 5 practice
 * @author Steven Vuong
 * @version 03-01-2018
 */
public class Theory {

	/**
	 * Initialise variable n
	 */
	double n;

	/**
	 * Constructor class that sets the value of n
	 * @param n
	 */
	public Theory(double n) { 
		this.n = n;
	}
	
	/**
	 * Method which returns the value of y to the power of n for a given value of x
	 * @param x
	 * @return x^n
	 */
	public double y(double x) {
		return Math.pow(x, n);
	}
	
	/**
	 * Calculates theoretical yPoint values for an array of input x values
	 * @param xpoints
	 * @return array of yPoint theoretical values ArrayList
	 */
	double yPoints;
	public ArrayList<Double> thYpoints(ArrayList<Double> xpoints) {
		
		this.yPoints = new ArrayList<Double>(); //Initialise arraylist
		for (int i=0; i<xpoints.size(); i++) { //loops through xpoints array
			this.yPoints.add(y(xpoints.get(i))); //calculates x^n and inputs values into array
		}
		return yPoints;
		
	}
	
}
