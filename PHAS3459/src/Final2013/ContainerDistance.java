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
	
	double earthRadius = 6371; //Set earths radius
	
	/**
	 * Calculates distance between a specimen and a point
	 * @param Specimen
	 * @param latitude
	 * @param longitude
	 * @return distance in km
	 */
	public double calculateDistance(Specimen sn, Double latitude, Double longitude) {
		
		double h = (haversin(sn.Latitude - latitude) + (Math.cos(sn.Latitude)*Math.cos(latitude)*haversin(sn.Longitude-longitude)));
		
		return (2 * earthRadius * Math.asin(Math.pow(h, 0.5)));
	}
	
/**
 * Calculates haversin
 * @param theta double
 * @return haversin
 */
	public double haversin(double theta) {
		
		return Math.pow(Math.sin(theta/2), 2); //calculates haversin
	}

}
