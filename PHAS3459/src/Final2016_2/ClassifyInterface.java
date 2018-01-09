package Final2016_2;
/**
 * Interface which defines method for classes to implement. Java Final 2018
 * @author Steven Vuong
 * @version 09-01-2018
 */
public interface ClassifyInterface {
	
	/**
	 * Represents an algorithm for classifying audio samples
	 * @param AudioFile AU
	 * @return String
	 */
	String classify(AudioFile af);

}
