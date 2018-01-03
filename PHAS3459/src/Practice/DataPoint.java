package Practice;
/**
 * Class with DataPoint constructor containing values x, y and ey
 * @author Steven Vuong
 * @version 03-01-2018
 */
public class DataPoint {
	

	/**
	 * Initialise variables
	 */
	double x; double y; double ey;

	/**
	 * Constructor method for the variables
	 * @param x
	 * @param y
	 * @param ey
	 */
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}
	
	/**
	 * Generate getter methods for each parameter
	 */
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getEy() {
		return ey;
	}

}
