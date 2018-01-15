package Final2015_2;
/**
 * Interface to represent calculating the arrival time of a pulse
 * @author SID: 15011252
 * @version 15/01/2018
 */
public interface ArrivalInterface {
	
	/**
	 * Method to return a double (time) for an input of the signal
	 * @param signal s
	 * @return arrivalTime double
	 */
	public double arrivalTime(Signal s, double param1); 

}
