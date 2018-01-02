package Final2015;
/**
 * Class which implements ArrivalInterface and returns first time threshold voltage set is passed
 * @author Steven Vuong
 * @version 03-01-2018
 */

/**
 * Import necessary packages
 */
import java.util.ArrayList;

public class FirstVoltageAboveThreshold implements ArrivalInterface{

	/**
	 * Method which returns first time the threshold voltage has been passed
	 * @param Pulse object
	 * @param double threshold voltage
	 * @return first time the threshold voltage has been passed (nS)
	 */
	public double calculateArrival(Pulse p, double thresholdVoltage) {
		
		ArrayList<Double> data = p.Voltages; //create arraylist of data values
		ArrayList<Double> timesArray = new ArrayList<Double>(); //initialise arraylist and time
		double time = 0;
		
		for (double d : data) { //loop through voltages
			if (d > thresholdVoltage) { //condition for being above threshold voltage
				time = data.indexOf(d);
				timesArray.add(time);
			}
		}
		
		return timesArray.get(0); //obtain first value added
		
	}

}
