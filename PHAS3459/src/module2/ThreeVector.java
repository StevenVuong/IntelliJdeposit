package module2;

public class ThreeVector {

	private double x;
	private double y;
	private double z;

	public ThreeVector(double point, double y, double point3) {
		x = point;
		this.y = y;
		this.z = point3;
	}

	public double magnitude() {
		double b = Math.sqrt(((x * x) + (y * y) + (z * z)));
		return b;
	}

	public double magnitude(double x1, double y1, double z1) {
		double b = Math.sqrt(((x1 * x1) + (y1 * y1) + (z1 * z1)));
		return b;
	}

	public static void main(String[] args) {
		ThreeVector threevector1 = new ThreeVector(1.0, 2.0, 3.0);
	}

}
