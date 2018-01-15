package Final2015_2;
/**
 * Class which finds the time of the maximum voltage, implements arrival interface
 */
import java.util.*; 

public class ArrivalMaxVoltage implements ArrivalInterface {

	/**
	 * Method which finds the time of maximum voltage, implementing arrival interface
	 */
	public double arrivalTime(Signal s, double param1) {
		
		ArrayList<Double> data = s.dataAL; //grab arraylist of data
		double maxVolt = 0.0;
		
		for (Double d : data) { //loop through dataset
			
			if (d > maxVolt) { //condition to set max voltage
				
				maxVolt = d;
				
			}
			
		}
		
		return data.indexOf(maxVolt); //returns the arrivaltime
	}

}
