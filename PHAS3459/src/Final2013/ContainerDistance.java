package Final2013;
/**
 * Class which implements container interface and gives arraylist of species within certain distance from latitude and logitude
 * @author Steven Vuong
 * @version 09-01-2018
 */
import java.util.ArrayList;

public class ContainerDistance implements ContainerInterface {
	/**
	 * Method which takes in ArrayList of Specimens and creates subarray
	 * @param ArrayList of specimens
	 * @param Double latitude
	 * @param Double Longitude
	 * @param Distance
	 * @return ArrayList of specimens within latitudes
	 */
	public ArrayList<Specimen> regionSort(ArrayList<Specimen> specimens, Double latitude, Double longitude, Double Distance) {
		
		ArrayList<Specimen> specimenAL = new ArrayList<Specimen>(); //Initialise subset arraylist
		
		for (Specimen sn : specimens) {
			
			double dist = calculateDistance(sn, latitude, longitude);
			
			if (dist <= Distance) { //condition for if distance is within the boundary
				
				specimenAL.add(sn); //add specimen to arraylist if within boundary
				
			}
			
		}
		
		return specimenAL;
		
	}
	
	/**
	 * Calculates distance between a specimen and a point
	 * @param Specimen
	 * @param latitude
	 * @param longitude
	 * @return distance in km
	 */
	public double calculateDistance(Specimen sn, Double latitude, Double longitude) {
		
		double theta = sn.Longitude - longitude;
		double dist = Math.sin(deg2rad(sn.Latitude)) * Math.sin(deg2rad(latitude)) + Math.cos(deg2rad(sn.Latitude)) * Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344; //converts to km

		return dist;
	}
	
	/**
	 * converts degrees to radians
	 * @param radians
	 * @return degrees
	 */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	/**
	 * converts radians to degrees
	 * @param rad
	 * @return degrees
	 */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
