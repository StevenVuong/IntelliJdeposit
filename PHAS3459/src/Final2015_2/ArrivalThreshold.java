package Final2015_2;
/**
 * Class which finds the time which the voltage first crosses a given threshold for a signal
 */
import java.util.*; 
public class ArrivalThreshold implements ArrivalInterface {
	
	public double arrivalTime(Signal s, double thresholdVoltage) {
		
		ArrayList<Double> data = s.dataAL; //grab arraylist of data
		double timeThresholdCrossed = 0.0;
		Integer oneOff = 0;
		
		for (Double d : data) {
			
			if ((d >= thresholdVoltage) && (oneOff.equals(0))) { //condition if threshold crossed for the first time
				
				timeThresholdCrossed = data.indexOf(d);
				oneOff++; //adds one so this isn't repeated
				
			}
			
		}
		
		
		return timeThresholdCrossed;
	}

}
