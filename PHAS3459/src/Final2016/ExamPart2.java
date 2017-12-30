package Final2016;

/**
 * Class with main method which loops through audio objects and classifies them 
 * depending on loudness and length of the sound
 * @author Steven Vuong
 * @version 30-12-2017
 */

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart2 {

	public static void main(String[] args) throws IOException {
		
		//Grab method from part 1 to create ararylist of audio objects
		ArrayList<Audio> audio = ExamPart1.getAudioFiles();
		
		for (Audio au : audio) { //Loop through audio list
			
			String Length = (new Duration()).classify(au); //Creates new instance of Duration class and uses it to find length of current audio object, using ".classify" to instantiate the method
			String Loudness = (new Loudness()).classify(au); //Creates new instance of Loudness class and uses it to determine if audio object is loud or not
			
			System.out.println("Filename: "+au.FileName+", Length: "+Length+", Sound: "+Loudness);
		}
		
		
	}
	
}
