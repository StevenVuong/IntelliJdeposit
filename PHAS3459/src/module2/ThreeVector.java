package module2;

public class ThreeVector {

	private double x;
	private double y;
	private double z;

	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double magnitude() {
		return Math.sqrt(((x * x) + (y * y) + (z * z)));
	}

	public ThreeVector unitVector() {
		double mag = magnitude();
		return new ThreeVector(x / mag, y / mag, z / mag);
	}

	@Override
	public String toString() {
		String c = "the x value is: " + x + ", the y value is: " + y + ", and the z value is: " + z;
		return c;
	}

	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		return ((vector1.x * vector2.x) + (vector1.y * vector2.y) + (vector1.z * vector2.z));
	}

	public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) {
		double vpi = ((vector1.y * vector2.z) - (vector1.z * vector2.y));
		double vpj = ((vector1.x * vector2.z) - (vector1.z * vector2.x));
		double vpk = ((vector1.x * vector2.y) - (vector1.y * vector2.x));
		ThreeVector vp = new ThreeVector(vpi, vpj, vpk);
		return vp;
	}

	public static ThreeVector add(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector vectorAdd = new ThreeVector((vector1.x + vector2.x), (vector1.y + vector2.y),
				(vector1.z + vector2.z));
		return vectorAdd;
	}

	public static double angle(ThreeVector vector1, ThreeVector vector2) {
		double dot = scalarProduct(vector1, vector2);
		double mag1 = vector1.magnitude();
		double mag2 = vector2.magnitude();
		return Math.acos(dot / (mag1 * mag2)); // calculates angle

	}

	public double scalarProduct(ThreeVector vector) {
		return ThreeVector.scalarProduct(this, vector);
	}
	
	public ThreeVector vectorProduct(ThreeVector vector) {
		return ThreeVector.vectorProduct(this,vector);
	}
	
	public ThreeVector add(ThreeVector vector) {
		return ThreeVector.add(this,vector);
	}
	
	public double angle(ThreeVector vector) {
		return ThreeVector.angle(this, vector);
	}
	

	public static void main(String[] args) {
		ThreeVector testVector = new ThreeVector(1.0, 2.0, 3.0);
		ThreeVector testVector2 = new ThreeVector(1.0, 2.0, 3.0);
		ThreeVector.scalarProduct(testVector, testVector2);
		testVector.scalarProduct(testVector2); // non static calling. Belongs to object
		// System.out.println(v);
	}

}
