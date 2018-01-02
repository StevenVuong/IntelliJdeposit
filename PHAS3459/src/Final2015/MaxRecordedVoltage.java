package Final2015;
/**
 * Class which implements ArrivalInterface and returns maximum voltage
 * @author Steven Vuong
 * @version 03-01-2018
 */
public class MaxRecordedVoltage implements ArrivalInterface{

	/**
	 * Method which returns the maximum given voltage (amplitude) for a given pulse
	 * @param Pulse object
	 * @return Amplitude (double
	 */
	public double calculateArrival(Pulse p, double d) {
		return p.Amplitude; 
	}

}
