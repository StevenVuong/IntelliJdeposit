package module6_2;
/**
 * Class which implements theory and contains method for quadratic calculation of y
 * @author Steven Vuong
 * @version 06-01-2018
 */
public class QuadraticTheory implements Theory {
	
	//Initialise variables
	double a;
	double b;
	double c;
	
/**
 * Constructor for Quadratic Theory class
 * @param a
 * @param b
 * @param c
 */
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Returns quadratic values for inputs
	 * @param double x
	 * @return quadratic equation for y
	 */
	public double y(double x) {
		return ((a*Math.pow(x, 2))+(b*x)+c);
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return (a+"x^2 + "+b+"x + "+c);
	}
	
}
