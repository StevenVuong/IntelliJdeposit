package module5;

import java.util.ArrayList;

public class Theory {

	//set member variables
	private double n;
	private double x;
	private double y;
	private ArrayList<Double> yPoints;

	//constructor for variables
	public Theory(double n) {
		
		this.n = n;
	
	}

	public double y(double x) {
		
		double Y = Math.pow(x, this.n);
		return Y;
	
	}

	public ArrayList<Double> theoreticalYPoints(ArrayList<Double> xpoints){
		//creates an array of theoretical y points for the method above
		
		this.yPoints = new ArrayList<Double>();
		for (int i=0; i<xpoints.size(); i++) { //calc x^n and put into yPoints array
			this.yPoints.add(y(xpoints.get(i)));
		}
		return yPoints;
	}
}
