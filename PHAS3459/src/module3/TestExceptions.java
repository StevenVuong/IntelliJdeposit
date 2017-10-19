package module3;

public class TestExceptions {

	public static void main(String[] args) throws Exception {

		// Creates complex numbers which are unmodifiable so new objects have to be
		// created around these in the event that the complex number is required to be
		// used twice, it isn't modified
		final Complex c1 = new Complex(1, 2);

		// Creates three vectors which are unmodifiable
		final ThreeVector v1 = new ThreeVector(0.0, 0.0, 0.0);
		final ThreeVector v2 = new ThreeVector(1.0, 2.0, 3.0);

		try {
			Complex testComplex1 = Complex.divide(c1, Complex.ZERO);
		} catch (Exception e) {
			System.out.println("divide error :" + e);
		}

		try {
			Complex b = Complex.ZERO.normalised();
		} catch (Exception e) {
			System.out.println("complex normalising :" + e);
		}

		try {
			ThreeVector v3 = v1.unitVector();
		} catch (Exception e) {
			System.out.println("unit vector error :" + e);
		}

		try {
			double v4 = v1.angle(v2);
		} catch (Exception e) {
			System.out.println("angle calculation error :" + e);
		}

		try {
			FallingParticle fallingObject = new FallingParticle(-5.0, 2);
			fallingObject.drop(0.1);
		} catch (Exception e) {
			System.out.println("falling particle err due to negative mass :" + e);
		}

		// FallingParticle fallingObject2 = new FallingParticle(5.3, 3.6); //creates the
		// 'falling particle' object
		//
		// fallingObject2.setH(-5.0); //no error is thrown?
		// fallingObject2.getZ();
		//

	}

}
