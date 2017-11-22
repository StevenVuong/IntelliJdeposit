package module6;

import java.util.Scanner;

public class DataPoint {
	
	// setting variables
	double x;
	double y;
	double ey;

	// Constructor to input values to member variables
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}

	public static DataPoint parseline(String empty) {
		// Method to take in a string of data and parse it into X, Y and error, outputting
		// a DataPoint object

		Scanner sn = new Scanner(empty);

		Double X = Double.parseDouble(sn.next());
		Double Y = Double.parseDouble(sn.next());
		Double EY = Double.parseDouble(sn.next());

		sn.close(); // close scanner
		return new DataPoint(X, Y, EY);
	}

	// getter methods for member variables of objects
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getEy() {
		return this.ey;
	}
	
	public String toString() {
		return ("x = "+this.x+", y = "+this.y+" +/- "+this.ey);
	}
	
}
