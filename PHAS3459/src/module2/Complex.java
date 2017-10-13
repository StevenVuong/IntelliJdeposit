package module2;

public class Complex {

	private double re;
	private double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	//Creating static Complex Numbers 
	public static final Complex ONE = new Complex(1,0);
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex I = new Complex(0,1);
	
	public double real() { // returns real part of complex number
		return re;
	}

	public double imag() { // returns imaginary part of complex number
		return im;
	}

	public double modulus() { // returns modulus of complex number
		return Math.sqrt((re * re) + (im * im));
	}

	public double angle() { // returns argument of complex number from positive real axis
		return Math.atan(im / re); //test, there's also 'atan2'
	}

	public Complex conjugate() { // returns the complex conjugate of the complex number
		Complex a = new Complex(re, -im);
		return a;
	}

	public Complex normalised() {
		double mod = modulus();
		return new Complex((re / mod), (im / mod));
	}

	public boolean equals(Complex c) {
		Complex test = new Complex(re, im);
		if (c == test) {
			return true;
		} else
			return false;
	}

	public String toString() {
		return ("re=" + re + ", im=" + im+ "i");
	}

	public Complex setFromModulusAngle(double mag, double ang) {
			double x1 = mag*Math.cos(ang);
			double y1 = mag*Math.sin(ang);
			Complex a = new Complex(x1,y1);
			return a;
	}

	public static Complex add(Complex a, Complex b) {
		return new Complex((a.re + b.re),(a.im+b.im));
	}

	public static Complex subtract(Complex a, Complex b) {
		return new Complex((a.re - b.re),(a.im - b.im));
	}
	
	public static Complex multiply(Complex a, Complex b) {
		double x1 = ((a.re*b.re)-(a.im*b.im));
		double y1 = ((a.re*b.im)+(a.im*b.re));
		return new Complex (x1,y1);
	}
	
	public static Complex divide(Complex a, Complex b) {
		double real = ((a.re*b.re)+(a.im*b.im));
		double imag = ((a.im*b.re)-(a.re*b.im));
		double mag = ((b.re*b.re)+(b.im*b.im));
		return new Complex((real/mag),(imag/mag));
	}
	
}


