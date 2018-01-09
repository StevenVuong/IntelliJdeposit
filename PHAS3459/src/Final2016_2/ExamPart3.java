package Final2016_2;
/**
 * Java Final 2016 Main Method Part3
 * @author Steven Vuong
 * @version 09-01-2018
 */
/**
 * Import necessary packages
 */
import java.util.ArrayList;
import java.util.HashMap;

public class ExamPart3 {

	public static void main(String[] args) {
		
		try {
			
			ArrayList<AudioFile> allAudioFiles = ExamPart1Methods.audioFileArray(); //Grab AudioFiles
			HashMap<String, String> indexHashMap = ExamPart1Methods.indexFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/index.txt"); //Grab index details
			
			for (AudioFile af : allAudioFiles) { //Loop through audiofiles

				Double Duration = (double)af.NumberOfSamples / (double)af.SampleFrequency; //calculates duration (using double cast)
				Double Amplitude = 20*Math.log10(af.AmplitudeRMS / (double) af.MaxAmplitude); //Calculates Amplitude
				String Instrument = indexHashMap.get(af.Filename); //grabs instrument
				
				String Length = (new ClassifyLength()).classify(af); //Instantiates new interface then invokes method
				String Loudness = (new ClassifyLoudness()).classify(af);
				String SpectralD = (new ClassifySpectralDensity()).classify(af);
				
				System.out.println("Filename: "+af.Filename);
				System.out.println("Duration: "+Duration);
				System.out.println("Amplitude in dBFS: "+Amplitude);
				System.out.println("Instrument: "+Instrument);
				System.out.println("Length: "+Length);
				System.out.println("Loudness: "+Loudness	);
				System.out.println("Spectral Density: "+SpectralD);
				System.out.println("");
				
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
}
