package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		// Creates complex numbers
		Complex c1 = new Complex(1, 2);

		// Creates three vectors
		ThreeVector v1 = new ThreeVector(0.0, 0.0, 0.0);
		ThreeVector v2 = new ThreeVector(1.0, 2.0, 3.0);

		try {
			Complex a = Complex.divide(c1, Complex.ZERO);
		} catch (Exception e) {
			System.out.println("divide err :" + e);
		}

		try {
			Complex b = Complex.ZERO.normalised();
		} catch (Exception e) {
			System.out.println("complex normising err :" + e);
		}

		try {
			ThreeVector v3 = v1.unitVector();
		} catch (Exception e) {
			System.out.println("unit vector err :" + e);
		}

		try {
			double v4 = v1.angle(v2);
		} catch (Exception e) {
			System.out.println("angle calc err :" + e);
		}

		try {
			FallingParticle fallingObject = new FallingParticle(-5.0, 2);
			fallingObject.drop(0.1);
		} catch (Exception e) {
			System.out.println("falling particle err, negative mass :" + e);
		}

		// FallingParticle fallingObject2 = new FallingParticle(5.3, 3.6); //creates the
		// 'falling particle' object
		//
		// fallingObject2.setH(-5.0); //no error is thrown?
		// fallingObject2.getZ();
		//

	}

}
