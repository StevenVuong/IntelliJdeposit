package module6_2;
/**
 * Class which extends dataPoint class, has label included
 * @author Steven Vuong
 * @version 06-01-18
 */
public class LabelledDataPoint extends DataPoint{

	 /** Initialise variables
	 */
	String Label;
	
	/**
	 * Constructor for LabelledDataPoint object
	 * @param label
	 * @param x
	 * @param y
	 * @param ey
	 */
	public LabelledDataPoint(String Label, double x, double y, double ey) {
		super(x, y, ey);
		this.Label = Label;
	}
	
	/**
	 * toString method for LabelledDataPoint
	 */
	public String toString() {
		return ("Data point label: x= "+x+", y= "+y+" +/- "+ey);
	}

}
