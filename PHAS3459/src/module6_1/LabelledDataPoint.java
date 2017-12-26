package module6_1;
/**
 * Class which extends DataPoint containing toString method and Constructor with label
 * @author Steven Vuong
 * @version 26-12-2017
 */
public class LabelledDataPoint extends DataPoint{

	String label;

	/*
	 * Constructor implementing label
	 * @param x,y,ey
	 */
	public LabelledDataPoint(String label, double x, double y, double ey) {
		super(x, y, ey);
		this.label = label;
	}
	
	//toString method with label indicator
	public String toString() {
		return ("data point label: x = "+this.x+", y = "+this.y+", ey = "+this.ey);
	}
}
