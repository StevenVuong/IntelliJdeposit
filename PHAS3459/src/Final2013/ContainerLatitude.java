package Final2013;
/**
 * Class which implements container interface and gives arraylist of species within certain latitude and longitude
 * @author Steven Vuong
 * @version 09-01-2018
 */
import java.util.ArrayList;

public class ContainerLatitude implements ContainerInterface {

	/**
	 * Method which takes in ArrayList of Specimens and creates subarray
	 * @param ArrayList of specimens
	 * @param minimum latitude (double)
	 * @param Double max latitude
	 * @param spare parameter
	 * @return ArrayList of specimens within latitudes
	 */
	public ArrayList<Specimen> regionSort(ArrayList<Specimen> specimens, Double minLat, Double maxLat, Double param3) {
		
		ArrayList<Specimen> specimenAL = new ArrayList<Specimen>(); //Initialise subset arraylist
		
		for (Specimen sc : specimens) {
	
			if ((sc.Latitude >= minLat) && (sc.Latitude <= maxLat)) {
				
				specimenAL.add(sc);
				
			}
			
		}

		return specimenAL;
		
	}

}
