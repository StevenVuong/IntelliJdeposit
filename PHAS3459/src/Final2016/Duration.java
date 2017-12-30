package Final2016;
/**
 * Class which implements classify and classifies depending on duration
 * @author Steven Vuong
 * @version 30-12-2017
 */
public class Duration implements Classify{

	/**
	 * Method which classifies sounds as 'long' or 'short'
	 * @param Audio object
	 * @return String of duration classification
	 */
	public String classify(Audio au) {
		
		double x = ((double )au.SampleCount/ (double)au.Freq);
		
		if (x >= 1) { 
			return ("Long");
		}
		
		else {
			return ("Short");
		}
		
	}

}
