package module2;

public class FallingParticle {

	private final double m;
	private final double d;
	private double t;
	private double z;
	private double h;
	private double v;
	private static final double g = -9.81;

	public FallingParticle(double m, double d) {
		this.m = m;
		this.d = d;
		t = 0;
	}

	public void setH(double h) {
		this.h = h;
		this.z = h;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	public double getT() {
		return t;
	}

	public double getZ() {
		return z;
	}

	public double doTimeStep(double deltaT) {
		t += deltaT;
		double a = ((d * v * v / m) - g);
		double deltaV = a * t;
		v = v + deltaV;
		double deltaZ = v * t;
		z = z - deltaZ;
		if(z<0) {
			z=0;
			v=0;
		}
		return a;
	}

	public void drop(double deltaT) {
		int runAmount =0;
		while (z > 0) {
			doTimeStep(deltaT);
			System.out.println("we are now at : " + z);
			System.out.println("we going at " + v + "m/s");
			runAmount++;
			System.out.println("we've run this "+ runAmount);
			
		}
	}

}
