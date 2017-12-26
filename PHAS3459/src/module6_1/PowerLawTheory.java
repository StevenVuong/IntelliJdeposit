package module6_1;
/**
 * Class which implements Theory, contains function y=x^n
 * @author Steven Vuong
 * @version 26-12-2017
 */
public class PowerLawTheory implements Theory {

	//initialise variables
	double n;
	double x;
	double y;
	
	//constructor to set n
	public PowerLawTheory(double n) {
		
		super();
		this.n = n;
		
	}

	//calculates function
	public double y(double x) {
		
		return (Math.pow(x, n));
		
	}
	
	public String toString() {
		return ("x^" + n);
	}


}
