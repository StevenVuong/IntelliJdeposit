package module9;

/**
 * Class representing orbiting body, containing location
 * and calculates centripetal acceleration from inverse 
 * square law
 * 
 * @author Steven Vuong
 * @version 09-12-18
 *
 */
public class Rock {
	
	/**
	 * Initialising variables
	 */
	
	private static final double G = 6.67E-11; //Gravitational constant
	private static final double M = 1.98E30; //Mass of sun
	private static final double pi = Math.PI;
	
	//orbital velocity and displacement in x and y components
	double vx = 0;
	double vy = 0;
	double x = 0;
	double y = 0;
	
	int radius; 
	double ax;
	double ay;
	double angle;
	
	/**
	 * Constructs an object with relevant parameters to calculate orbits
	 * @param r Displayed radius of the body
	 * @param v Initial orbit speed
	 * @param d Initial distance from Sun
	 */

	public Rock(int r, int v, double d) {
		this.radius = r;
		this.vx = v;
		this.y = d;
	}
	
	/**
	 * Calculate acceleration towards Sun and update position of the body
	 * @param t Time elapsed since last simulation in seconds
	 */
	public void increment(int t) {
		double accel = G * M / (x*x + y*y);
		
		//Workaround for tan discontinuities
		angle = Math.atan(x/y); 
		if (angle < 0 ) angle += pi;
		if (x<0 && y<0) angle += pi;
		if (x<0 && y<0) angle += pi;
		
		//Update position components
		x = x + (vx * t); 
		y = y + (vy * t);
		
		//Update acceleration components
		ax = accel * Math.sin(angle);
		ay = accel * Math.cos(angle);
		
		//Update velocity components
		vx = vx - (ax * t);
		vy = vy - (ay * t);
	}
}
