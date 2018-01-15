package MidTerm2009_10;
/**
 * Class with constructor for location details
 * @author SID: 15011252
 * @version 13-01-2018
 */
public class Location {
	
	//Initialise variables
	Double Latitude;
	Double Longitude;
	
	/**
	 * Constructor for the variables
	 * @param latitude
	 * @param longitude
	 */
	public Location(Double latitude, Double longitude) {
		Latitude = latitude;
		Longitude = longitude;
	}
	
	public String getDetailsLoc() {
		return ("Latitude: "+this.Latitude+", Longitude: "+this.Longitude);
	}

}
