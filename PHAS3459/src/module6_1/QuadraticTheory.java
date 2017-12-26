package module6_1;
/**
 * Class which implements Theory, contains quadratic function
 * @author Steven Vuong
 * @version 26-12-2017
 */
public class QuadraticTheory implements Theory {

	//initialise variables
	double x;
	double y;
	double a;
	double b;
	double c;
	
	//Constructor to create Quadratic Theory Object
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	//calculates function
	public double y(double x) {
		return ((a*Math.pow(x, 2)) + (b*x) + c);
	}

	public String toString() {
		return (a + " * x^2 + " + b + " * x + " + c);
	}


}
