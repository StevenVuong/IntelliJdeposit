package module3;

public class ThreeVector {

	//Creates double variables, x, y and z (components of our 3 vector)
	private double x;
	private double y;
	private double z;

	//This creates a 3d vector using the x,y and z variables we set, simply re-assigning them
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double magnitude() { //Calculates the magnitude of a 3d vector
		return Math.sqrt(((x * x) + (y * y) + (z * z)));
	}

	public ThreeVector unitVector() { //Finds the unit vector of the vector by dividing by the magnitude
		double mag = magnitude();
		return new ThreeVector(x / mag, y / mag, z / mag);
	}

	@Override
	public String toString() { //Creates a string which outputs the vector co-ordinates
		String c = "the x value is: " + x + ", the y value is: " + y + ", and the z value is: " + z;
		return c;
	}

	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) { //Takes the scalar product of two vectors, returning a double (Static)
		return ((vector1.x * vector2.x) + (vector1.y * vector2.y) + (vector1.z * vector2.z));
	}

	public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) { //Takes the vector product of two vectors (Static)
		double vpi = ((vector1.y * vector2.z) - (vector1.z * vector2.y));
		double vpj = ((vector1.x * vector2.z) - (vector1.z * vector2.x));
		double vpk = ((vector1.x * vector2.y) - (vector1.y * vector2.x));
		ThreeVector vp = new ThreeVector(vpi, vpj, vpk); //Creates a new vector, using the results of the vector product calculations as its components
		return vp;
	}

	public static ThreeVector add(ThreeVector vector1, ThreeVector vector2) { //Finds the sum of two vectors (Static)
		ThreeVector vectorAdd = new ThreeVector((vector1.x + vector2.x), (vector1.y + vector2.y),
				(vector1.z + vector2.z));
		return vectorAdd;
	}

	public static double angle(ThreeVector vector1, ThreeVector vector2) { //Finds the angle between two vectors (Static method)
		double dot = scalarProduct(vector1, vector2);
		double mag1 = vector1.magnitude();
		double mag2 = vector2.magnitude();
		return Math.acos(dot / (mag1 * mag2)); // calculates angle

	}

	public double scalarProduct(ThreeVector vector) {  //Finds the scalar product of two vectors, using the previous static method. This method is non-static
		return ThreeVector.scalarProduct(this, vector);
	}

	public ThreeVector vectorProduct(ThreeVector vector) { //Finds the vector product of two vectors (non static), using the previous static method
		return ThreeVector.vectorProduct(this, vector);
	}

	public ThreeVector add(ThreeVector vector) { //Calculates the added sum of two vectors (non-static) using the previous static method
		return ThreeVector.add(this, vector);
	}

	public double angle(ThreeVector vector) { //Calculates the angle between two vectors (non-static), using the previous static method
		return ThreeVector.angle(this, vector);
	}

}
