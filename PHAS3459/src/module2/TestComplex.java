package module2;

public class TestComplex {

	public static void main(String[] args) {
		
		//Creating the complex numbers to test
		Complex c1 = new Complex (1,2);
		Complex c2 = new Complex (-2,-1);

		//Taking the product of the classes
		Complex c1xc2 = Complex.multiply(c1, c2);
		System.out.println("c1*c2 = "+ c1xc2);
		
	}

}
