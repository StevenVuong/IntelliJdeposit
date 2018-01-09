package Final2016_2;
/**
 * Class which implements ClassifyInterface. Classifies AudioFile Objects on length
 * @author Steven Vuong
 * @version 09-01-2018
 */
public class ClassifyLength implements ClassifyInterface {

	/**
	 * classifies sounds as long or short depending on duration length
	 * @param AudioFile object
	 * @return String
	 */
	public String classify(AudioFile af) {
		
		Double Duration = (double)af.NumberOfSamples / (double)af.SampleFrequency; //calculates duration (using double cast)
		
		if (Duration > 1.0) {
			return ("Long");
		}
		
		else {
			return ("Short");
		}
	}

}
