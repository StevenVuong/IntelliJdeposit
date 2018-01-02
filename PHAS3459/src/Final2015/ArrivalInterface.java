package Final2015;
/**
 * Interface which defines method for classes to implement
 * @author Steven Vuong
 * @version 03-01-2018
 */
public interface ArrivalInterface {

	/**
	 * Represents algorithm for calculating arrivaltime
	 * @param Pulse object
	 * @return double representing classification of calculation
	 */
	double calculateArrival(Pulse p, double thresholdVoltage);
	
}
