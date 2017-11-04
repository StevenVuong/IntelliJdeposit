package module5;

import java.util.ArrayList;

public class Theory {

	//set member variables
	private double n;
	private double x;
	private double y;

	//constructor for variables
	public Theory(double n) {
		
		this.n = n;
	
	}

	public double y(double x) {
		
		double Y = Math.pow(x, this.n);
		return Y;
	
	}

}
