package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		//Creates complex numbers
		Complex c1 = new Complex (1,2);
		
		 Complex a = Complex.divide(c1,Complex.ZERO);
		 System.out.println("a is: "+a);
		 
//How do I carry on with running the script?
		 Complex b = new Complex(0.0,0.0);
		 b = Complex.ZERO.normalised();
		 System.out.println("b is: "+b);
		 
		 //Creates three vectors
		 ThreeVector v1 = new ThreeVector (0.0,0.0, 0.0);
		 ThreeVector v2 = new ThreeVector (1.0,2.0,3.0);
		 
		 ThreeVector v3 = v1.unitVector();
		 System.out.println("v3 unit vector is: "+v3);
		 
		 double v4 = v1.angle(v2); //USE THIS
		 
	}

}
