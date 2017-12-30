package Final2016;
/**
 * Class which implements classify and classifies depending on loudness
 * @author Steven Vuong
 * @version 30-12-2017
 */
public class Loudness implements Classify {
	/**
	 * Method which classifies sounds as 'loud' or 'quiet'
	 * @param audio object
	 * @return String of loudness classification
	 */
	public String classify(Audio au) {
		
		double x = 20 * Math.log10((au.aRMS/au.MaxAmp));
		
		if (x >= -20) {
			return ("Loud");
		}
		else {
			return ("Quiet");
		}
	}

}
