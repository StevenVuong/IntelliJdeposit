package module6_2;
/**
 * Class which implements theory interface to define method (power law theory)
 * @author Steven Vuong
 * @version 06/01/2018
 */
public class PowerLawTheory implements Theory {

	double n; //initialise variable
	
	/**
	 * constructor for n
	 * @param n
	 */
	public PowerLawTheory(double n) {
		this.n = n;
	}

	/**
	 * Method which implements function y=x^n
	 * @param double x
	 * @return y=x^n
	 */
	public double y(double x) {
		return Math.pow(x, n);
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return ("x^"+n);
	}

}
