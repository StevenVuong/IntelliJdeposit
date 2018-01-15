package MidTerm2008_9;
/**
 * Class which sets constructor of Experimental Data
 * @author SID: 15011252
 *
 */
public class Data {
	
	/**
	 * Initialise variables
	 */
	String Name;
	Double MinMass; Double MaxMass; Double ExpectedCount;

	/**
	 * Constructor class for higgs data containing all the details of it
	 * @param name
	 * @param minMass
	 * @param maxMass
	 * @param expectedCount
	 */
	public Data(String name, Double minMass, Double maxMass, Double expectedCount) {
		Name = name;
		MinMass = minMass;
		MaxMass = maxMass;
		ExpectedCount = expectedCount;
	}
	
	

}
