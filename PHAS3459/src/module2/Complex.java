package module2;

public class Complex {
	
	//Creates real and imaginary variables for this class
	private double real;
	private double imagine;

	public Complex(double re, double im) { //Creates a constructor in order to set complex numbers
		this.real = re;
		this.imagine = im;
	}

	//Creating static Complex Numbers (Note that they are also final, so that they are set and unchangeable)
	public static final Complex ONE = new Complex(1,0);
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex I = new Complex(0,1);
	
	public double real() { // returns real part of complex number
		return real;
	}

	public double imag() { // returns imaginary part of complex number
		return imagine;
	}

	public double modulus() { // returns modulus of complex number
		return Math.sqrt((real * real) + (imagine * imagine));
	}

	public double angle() { // returns argument of complex number from positive real axis
		return Math.atan(imagine / real); //test, there's also 'atan2'
	}

	public Complex conjugate() { // returns the complex conjugate of the complex number
		Complex a = new Complex(real, -imagine);
		return a;
	}

	public Complex normalised() { //returns the normalised complex number
		double mod = modulus(); //calculates the modulus and assigns it to a 'mod' variable to divide by
		return new Complex((real / mod), (imagine / mod));
	}

	public boolean equals(Complex c) { //creates a boolean which returns 'true' if and only if the complex argument is equal to the current real and imaginary number
		Complex test = new Complex(real, imagine);
		if (c == test) {
			return true;
		} else
			return false;
	}

	public String toString() { //method returning complex number in string form
		return ("re=" + real + ", im=" + imagine+ "i");
	}

	public Complex setFromModulusAngle(double mag, double ang) { //method returning complex number from modulus and angle
			double x1 = mag*Math.cos(ang);
			double y1 = mag*Math.sin(ang);
			Complex a = new Complex(x1,y1);
			return a;
	}

	public static Complex add(Complex a, Complex b) { //method adding two complex numbers together
		return new Complex((a.real + b.real),(a.imagine+b.imagine));
	}

	public static Complex subtract(Complex a, Complex b) { //method subtracting one complex number from another
		return new Complex((a.real - b.real),(a.imagine - b.imagine));
	}
	
	public static Complex multiply(Complex a, Complex b) { //method multiplying two complex numbers together
		double x1 = ((a.real*b.real)-(a.imagine*b.imagine));
		double y1 = ((a.real*b.imagine)+(a.imagine*b.real));
		return new Complex (x1,y1);
	}
	
	public static Complex divide(Complex a, Complex b) { //method dividing one complex number by another
		double real = ((a.real*b.real)+(a.imagine*b.imagine));
		double imag = ((a.imagine*b.real)-(a.real*b.imagine));
		double mag = ((b.real*b.real)+(b.imagine*b.imagine));
		return new Complex((real/mag),(imag/mag));
	}
	
}


