package Final2014;
/**
 * Constructor class for tide object
 * @author Steven Vuong
 * @version 03-01-2018
 */
public class Tide {
	
	//Initialise variables
	String Identifier;
	Integer Year; Integer Month; Integer Day;
	Integer Hour; Integer Minute;
	Double SeaLevelReal; Double SeaLevelPredicted;


	/**
	 * Constructor for all the detail objects into one tide object
	 * @param identifier
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param seaLevelReal
	 * @param seaLevelPredicted
	 */
	public Tide(String identifier, Integer year, Integer month, Integer day, Integer hour, Integer minute,
			Double seaLevelReal, Double seaLevelPredicted) {
		Identifier = identifier;
		Year = year;
		Month = month;
		Day = day;
		Hour = hour;
		Minute = minute;
		SeaLevelReal = seaLevelReal;
		SeaLevelPredicted = seaLevelPredicted;
	}

	
	
}
