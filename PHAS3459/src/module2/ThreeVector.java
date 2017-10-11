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
		double b = Math.sqrt(((x * x) + (y * y) + (z * z)));
		return b;
	}

	public ThreeVector unitVector() {
		double magntitude = magnitude();
		return new ThreeVector(x/magntitude, y/magntitude, z/magntitude);
	}

	public static void main(String[] args) {
		ThreeVector threevector1 = new ThreeVector(1.0, 2.0, 3.0);
	}

}
