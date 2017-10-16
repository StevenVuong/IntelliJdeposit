package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		Complex c1 = new Complex (1,2);
		
		 Complex a = Complex.divide(c1,Complex.ZERO);
		 System.out.println("a is: "+a);

		 Complex b = new Complex(0.0,0.0);
		 b = Complex.ZERO.normalised();
		 System.out.println("b is: "+b);
	}

}
