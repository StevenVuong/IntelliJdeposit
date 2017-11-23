package module6;

public class PowerLawTheory implements Theory {
	//class holding mathematical relation between x and y value (powerOf relationship)
	
	//define member variables (n is the power)
	double n;
	double x;
	double y;
	
	//constructor for PowerLawTheory object, setting parameters of function
	public PowerLawTheory(double n) {
		this.n = n;
	}
	
	//returns Y = x^n
	public double y(double x) {
		return Math.pow(x, n);
	}
	
	// toString method stating the function
	public String toString() {
		return ("x^" + n);
	}
	
}
