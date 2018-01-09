package Final2016_2;
/**
 * Java Final Exam 2016 AudioFile Object
 * @author Steven Vuong
 * @version 09-01-18
 */
/**
 * Import necessary classes
 */
import java.util.*;

public class AudioFile {
	
	//Initialise variables
	String Filename;
	Integer SampleFrequency; Integer NumberOfSamples; Integer MaxAmplitude;
	ArrayList<Integer> AmplitudeData;
	Double AmplitudeRMS;
	
	/**
	 * Constructor with each variable for an AudioFile object and includes method to calculate amplitude RMS
	 * @param filename
	 * @param sampleFrequency
	 * @param numberOfSamples
	 * @param maxAmplitude
	 * @param amplitudeData
	 */
	public AudioFile(String filename, Integer sampleFrequency, Integer numberOfSamples, Integer maxAmplitude,
			ArrayList<Integer> amplitudeData) {
		Filename = filename;
		SampleFrequency = sampleFrequency;
		NumberOfSamples = numberOfSamples;
		MaxAmplitude = maxAmplitude;
		AmplitudeData = amplitudeData;
		this.calculateRMS();
	}

	/**
	 * Void method which calculates the RMS value 
	 */
	public void calculateRMS() {
		
		double total = 0;
		
		for (Integer i : this.AmplitudeData) {
			total += Math.pow(i, 2); 
		}
		
		this.AmplitudeRMS = Math.sqrt(total / this.AmplitudeData.size());
		
	}
	
}
