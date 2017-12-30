package Final2016;
/**
 * Interface which defines method for classes to implement
 * @author Steven Vuong
 * @version 30-12-2017
 */
public interface Classify {

	/**
	 * Represents algorithm for classifying sounds
	 * @param Audio object
	 * @return String representing classification of sound
	 */
	String classify(Audio au);
	
}
