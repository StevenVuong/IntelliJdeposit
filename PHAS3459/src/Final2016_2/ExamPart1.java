package Final2016_2;
/**
 * Java Final 2016 Main Method Part1
 * @author Steven Vuong
 * @version 09-01-2018
 */
/**
 * Import necessary packages
 */
import java.util.*;
import java.io.*;
import java.net.*;


public class ExamPart1 {
	
	public static void main(String[] args) {
		
		try {
			
			ArrayList<AudioFile> allAudioFiles = ExamPart1Methods.audioFileArray(); //Grab AudioFiles
			HashMap<String, String> indexHashMap = ExamPart1Methods.indexFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/index.txt"); //Grab index details
			
			for (AudioFile af : allAudioFiles) { //Loop through audiofiles

				Double Duration = (double)af.NumberOfSamples / (double)af.SampleFrequency; //calculates duration (using double cast)
				Double Amplitude = 20*Math.log10(af.AmplitudeRMS / (double) af.MaxAmplitude); //Calculates Amplitude
				String Instrument = indexHashMap.get(af.Filename); //grabs instrument
				
				System.out.println("Filename: "+af.Filename);
				System.out.println("Duration: "+Duration);
				System.out.println("Amplitude in dBFS: "+Amplitude);
				System.out.println("Instrument: "+Instrument);
				System.out.println("");
				
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
