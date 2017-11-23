package module6;

public class QuadraticTheory implements Theory {
	// class holding mathematical relation between x and y values (quadratic
	// relationship)

	// define member variables (a and b are the coefficients and c is a constant)
	double x;
	double y;
	double a;
	double b;
	double c;

	// constructor for QuadraticTheory object, setting parameters of function
	public QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// returns Y = ax^2 + bx + c
	public double y(double x) {
		return ((a * Math.pow(x, 2)) + (b * x) + c);
	}

	// toString method stating the function
	public String toString() {
		return (a+ " * x^2 + " + b + " * x + " + c);
	}

}
