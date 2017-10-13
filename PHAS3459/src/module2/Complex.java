package module2;

public class Complex {

	private double re;
	private double im;

	@Override
	public String toString() {
		return "Complex [re=" + re + ", im=" + im + "i]";
	} // Check if I need to do for all items..

	// Creates complex object, y will be the imaginary component, x will be the
	// real. With this, we can copy, relabel & manipulate
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

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
		return Math.atan(im / re);
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
		Complex test =new Complex(re,im);
			if (c==test) { 
				return true;
			}
			else return false;
		}

	public tostring() {
		return "[re="+re+", im="+im+"i]";
	}
	
}

// public static void main(String[] args) {
// // TODO Auto-generated method stub
//
// }
//
// }
