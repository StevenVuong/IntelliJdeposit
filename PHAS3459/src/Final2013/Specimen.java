package Final2013;
/**
 * File which creates specimen object and constructor. Start time: 2:55pm
 * @author Steven Vuong
 * @version 09/01/2018
 */
public class Specimen {
	
	//Initialise Variables
	Double Latitude; Double Longitude;
	String ID;
	Integer Height;
	
	/**
	 * Constructor for specimen object using set variables
	 * @param latitude
	 * @param longitude
	 * @param iD
	 * @param height
	 */
	public Specimen(Double latitude, Double longitude, String iD, Integer height) {
		Latitude = latitude;
		Longitude = longitude;
		ID = iD;
		Height = height;
	}
	
	

}
