package module6;

public class LabelledDataPoint extends DataPoint {
	// class to hold datapoints: x, y, ey and label

	// initialise data member
	String label;

	// initialise member variables specific to subclass
	public LabelledDataPoint(String label, double x, double y, double ey) { // inherits variables from DataPoint class
		super(x, y, ey);
		this.label = label;
	}

	public String toString() {
		return ("label: " + label + ":" + " x = " + this.x + ", y = " + this.y + " +/- " + this.ey);
	}
}
