package module5_1;

import java.util.*;

/**
 * Class which sets values for x,y and y error for data-set
 * With constructor and getters and method to set dataPoint objects from a line of values
 * 
 * @author Steven Vuong
 * @version: 26-12-2017
 */

public class DataPoint {

	/**
	 * Initialising Variables
	 */
	double x;
	double y;
	double ey;
	
	/**
	 * Constructor creating DataPoint object 
	 * @param x,y,ey
	 */
	public DataPoint(double x, double y, double ey) {
		super();
		this.x = x;
		this.y = y;
		this.ey = ey;
		
	}
	
	
	/**
	 * Turns line of data into DataPoint object, setting the X, Y and Ey values
	 * @param String of data-points
	 * @return DataPoint object
	 */
	public static DataPoint parselines(String empty) {
		
		Scanner sn = new Scanner(empty);
		
		Double X = Double.parseDouble(sn.next());
		Double Y = Double.parseDouble(sn.next());
		Double Ey = Double.parseDouble(sn.next());
		
		sn.close(); //Close Scanner
		return new DataPoint(X,Y,Ey);
	}

	
	/**
	 * Getter methods to return values of x, y and ey
	 * @return x, y and ey
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
