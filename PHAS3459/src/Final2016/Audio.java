package Final2016;
/**
 * Class which contains Audio File constructor and method to calculate root mean square
 * @author Steven Vuong
 * @version 30-12-2017
 */
import java.util.ArrayList;

public class Audio {
	
	//Initialise member objects
	Integer SampleCount; Integer MaxAmp;
	ArrayList<Integer> Data; 
	String FileName;
	Double aRMS;
	
	/**
	 * Constructor for AudioFile object
	 * @param frequency
	 * @param Number of samples
	 * @param max amplitude
	 * @param data
	 * @param instrument name
	 */
	Integer Freq; public Audio(Integer freq, Integer sampleCount, Integer maxAmp, ArrayList<Integer> data, String fileName) {
		Freq = freq;
		SampleCount = sampleCount;
		MaxAmp = maxAmp;
		Data = data;
		FileName = fileName;
		this.calculateRMS();
	}
	
	/**
	 * Method to calculate the root mean squared value for signals in a file and place in an object
	 */
	public void calculateRMS() {
		
		double total = 0;
		for (Integer i: this.Data) {
			total += Math.pow(i, 2); //Calculate square to add to total
		}
		this.aRMS = Math.sqrt(total / this.Data.size());
	}

}
