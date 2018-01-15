package Final2015_2;
/**
 * Class which contains constructor for Signal object
 * @author SID: 15011252
 * @version 15-01-2018
 */
import java.util.*;
public class Signal {
	
	//Initialise variables
	String Identifier;
	ArrayList<Double> dataAL;
	double amplitude;
	double arrivalTime;
	
	/**
	 * constructor class for signal object
	 * @param identifier
	 * @param dataAL
	 */
	public Signal(String identifier, ArrayList<Double> dataAL) {
		Identifier = identifier;
		this.dataAL = dataAL;
		this.findAmplitude(dataAL); //allows for calculation of amplitude and arrival time for each signal
	}
	
	/**
	 * Method which finds the amplitude for each signal and returns the arrival time
	 * @param dataAL
	 */
	private void findAmplitude(ArrayList<Double> dataAL) {
		
		double maxVolt = 0.0;

		for (Double d : dataAL) {
			
			if (d > maxVolt) {
				
				maxVolt = d;
				
			}
		}
		double counter = dataAL.indexOf(maxVolt);
		
		this.amplitude = maxVolt;
		this.arrivalTime = counter;
		
	}

	
}
