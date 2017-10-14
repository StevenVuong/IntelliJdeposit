package module2;

public class Complex {

	private double real;
	private double imagine;

	public Complex(double re, double im) {
		this.real = re;
		this.imagine = im;
	}

	//Creating static Complex Numbers 
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

	public Complex normalised() {
		double mod = modulus();
		return new Complex((real / mod), (imagine / mod));
	}

	public boolean equals(Complex c) {
		Complex test = new Complex(real, imagine);
		if (c == test) {
			return true;
		} else
			return false;
	}

	public String toString() {
		return ("re=" + real + ", im=" + imagine+ "i");
	}

	public Complex setFromModulusAngle(double mag, double ang) {
			double x1 = mag*Math.cos(ang);
			double y1 = mag*Math.sin(ang);
			Complex a = new Complex(x1,y1);
			return a;
	}

	public static Complex add(Complex a, Complex b) {
		return new Complex((a.real + b.real),(a.imagine+b.imagine));
	}

	public static Complex subtract(Complex a, Complex b) {
		return new Complex((a.real - b.real),(a.imagine - b.imagine));
	}
	
	public static Complex multiply(Complex a, Complex b) {
		double x1 = ((a.real*b.real)-(a.imagine*b.imagine));
		double y1 = ((a.real*b.imagine)+(a.imagine*b.real));
		return new Complex (x1,y1);
	}
	
	public static Complex divide(Complex a, Complex b) {
		double real = ((a.real*b.real)+(a.imagine*b.imagine));
		double imag = ((a.imagine*b.real)-(a.real*b.imagine));
		double mag = ((b.real*b.real)+(b.imagine*b.imagine));
		return new Complex((real/mag),(imag/mag));
	}
	
}


