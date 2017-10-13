package module2;

public class Complex {
	
	private double re;
	private double im;
	
	//Creates complex object, y will be the imaginary component, x will be the real. With this, we can copy, relabel & manipulate
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double real() { //returns real part of complex number
		return re;
	}
	
	public double imag() { //returns imaginary part of complex number
		return im;
	}
	
	public double modulus() { //returns modulus of complex number
		return Math.sqrt((re*re)+(im*im));
	}

	public double angle() { //returns argument of complex number from positive real axis
		return Math.atan(im/re);
	}
	
	public double conjugate() { //returns the complex conjugate of the complex number
		double a = new Complex(re,-im);
		return a;
	}
}



//Question: Will I actually input i as a letter when I put in my vectors?

	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
