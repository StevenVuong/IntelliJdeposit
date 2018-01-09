package Final2016_2;
/**
 * Class which implements ClassifyInterface. Classifies AudioFile Objects on loudness
 * @author Steven Vuong
 * @version 09-01-2018
 */
public class ClassifyLoudness implements ClassifyInterface {

	/**
	 * classifies sounds as long or short depending on loudness
	 * @param AudioFile object
	 * @return String
	 */
	public String classify(AudioFile af) {
		
		Double Amplitude = 20*Math.log10(af.AmplitudeRMS / (double) af.MaxAmplitude); //Calculates Amplitude
		
		if (Amplitude > -20.0) {
			return ("Loud");
		}
		
		else {
			return ("Quiet");
		}
	}

}
