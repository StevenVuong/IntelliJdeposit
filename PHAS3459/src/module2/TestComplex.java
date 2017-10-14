package module2;

public class TestComplex {

	public static void main(String[] args) {
		
		//Creating the complex numbers to test
		Complex c1 = new Complex (1,2);
		Complex c2 = new Complex (-2,-1);

		//Taking the product of the classes
		Complex c1xc2 = Complex.multiply(c1, c2);
		System.out.println("c1*c2 = "+ c1xc2);
		
		//Taking the ratio of c1 & c2
		Complex c1Divc2 = Complex.divide(c1,c2);
		System.out.println("c1/c2 = " + c1Divc2);
		
		//Taking the product of c1 & I
		Complex c1xI = Complex.multiply(c1,Complex.I);
		System.out.println("c1xI = " + c1xI);
		
		//Taking the ratio of c1 & ZERO
		Complex c1DivZERO = Complex.divide(c1, Complex.ZERO);
		System.out.println("c1/ZERO = " + c1DivZERO);
		
		//Taking the product of c1 with conjugate of c1
		Complex c1Conjugate = c1.conjugate();
		Complex c1xc1Conjugate = Complex.multiply(c1,c1Conjugate);
		System.out.println("The product of c1 with c1 conjugate is: " + c1xc1Conjugate);
		
		//Taking the product of c2 with conjugate of c2
		Complex c2Conjugate = c2.conjugate();
		Complex c2xc2Conjugate = Complex.multiply(c2,c2Conjugate);
		System.out.println("The product of c2 with c2 conjugate is: " + c2xc2Conjugate);
	}

}
