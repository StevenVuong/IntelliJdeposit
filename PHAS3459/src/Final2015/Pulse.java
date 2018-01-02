package Final2015;

/**
 * Class which contains Pulse constructor and method to find amplitude and time of amplitude
 * @author Steven Vuong
 * @version 02-01-2018
 */

//Import necessary classes
import java.util.*;

public class Pulse {
	
	//Initialise Object variables
	String Identifier;
	ArrayList<Double> Voltages;
	Double Amplitude;
	Integer time;
	
	/**
	 * Constructor for pulse object with name of object and the data, including method to find amplitude and amplitude time
	 * @param identifier
	 * @param voltages
	 */
	public Pulse(String identifier, ArrayList<Double> voltages) {
		Identifier = identifier;
		Voltages = voltages;
		this.getAmplitude();
		this.getAmplitudeTime();
	} 
	
	/**
	 * Method to find the amplitude (maximum voltage) from the input of voltages
	 */
	public void getAmplitude() {
		
		Double maxAmp = 0.0; //Initialise variable
		
		for (Double amp : this.Voltages) { //Loops through voltage array
			if (amp > maxAmp) {
				maxAmp = amp;
			}
		}
		
		this.Amplitude = maxAmp;
		
	}
	
	/**
	 * Method to find the time of amplitude (nS)
	 */
	public void getAmplitudeTime() {
		
		Double maxAmp = 0.0; //Initialise variable

		for (Double amp : this.Voltages) { //Loops through voltage array
			if (amp > maxAmp) {
				maxAmp = amp;
			}
		}
		
		this.time = this.Voltages.indexOf(maxAmp); //Finds index corresponding to max amplitude
	}

}
