package Final2016;

import java.util.ArrayList;

public class ExamPart3 {

	public static void main(String[] args) {
		try {
			
			//Grab method from part 1 to create ararylist of audio objects
			ArrayList<Audio> audio = ExamPart1.getAudioFiles();
					
			for (Audio au : audio) { //Loop through audio list
				String SpectralD = (new SpectralDensity()).classify(au);
				System.out.println("For file: "+au.FileName+", the sound is " + SpectralD);
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
