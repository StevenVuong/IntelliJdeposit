package module3;

import module2.FallingParticle;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		//Creates complex numbers
		Complex c1 = new Complex (1,2);
		
		 //Creates three vectors
		 ThreeVector v1 = new ThreeVector (0.0,0.0, 0.0);
		 ThreeVector v2 = new ThreeVector (1.0,2.0,3.0);
		
//		 Complex a = Complex.divide(c1,Complex.ZERO);
//		 
//////How do I carry on with running the script? after an error
//	//I need to create 'catch' which prints out the error onto the screen? Using try and catch?
//
//		 Complex b = Complex.ZERO.normalised();
//		 
//		 ThreeVector v3 = v1.unitVector();
//
//		 double v4 = v1.angle(v2); //USE THIS	
//		 
//		 FallingParticle fallingObject = new FallingParticle (-1.0,2);
		 
		 FallingParticle fallingObject2 = new FallingParticle(5.3, 3.6); //creates the 'falling particle' object
		 
		 fallingObject2.setH(-5.0); //no error is thrown?
		 fallingObject2.getZ();
		 

		 
	}

}
