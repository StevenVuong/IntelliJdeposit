package Final2014;
/**
 * Method which calculates range of sea level readings at sites and prints. Has main method
 * @author Steven Vuong
 * @version 03-01-2018
 * @implements CalculationInterface
 */
/**
 * Import necessary modules
 */
import java.util.ArrayList;
import java.util.HashMap;

public class TidalRange implements CalculationInterface {

	/**
	 * Method which calculates tidal range at site
	 * @param ArrayList<Tide>
	 * @return double tidal range
	 */
	public double calculate(ArrayList<Tide> tideArrayList) {

		//Initialise values
		double highestReading = 0.0;
		double lowestReading = 100000000000000000.0;
		
		for (Tide tide : tideArrayList) { //loop through tides
			
			if (tide.SeaLevelReal > highestReading) { //Checks sea level
				
				highestReading = tide.SeaLevelReal;
				
			}
			if (tide.SeaLevelReal < lowestReading) {
				
				lowestReading = tide.SeaLevelReal;
				
			}
			
		}
		
		return (highestReading - lowestReading);
	}
	
	public static void main(String[] args) {
		
		try {
			
			//Grab sites
			HashMap<String, String> sitesHashMap = Methods.siteHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/sites.txt");
			
			//Grab all the tides
			ArrayList<Tide> tidesArrayList = Methods.allTides();
			
			for (String identifier : sitesHashMap.keySet()) { //loop through identifier
				
				ArrayList<Tide> siteTideArrayList = new ArrayList<Tide>(); //Initialise arraylist
				
				for (Tide tide : tidesArrayList) { //loop through all tides
					
					if (tide.Identifier.equals(identifier)) { //if have same identifier, add to arraylist
						siteTideArrayList.add(tide);
						
					}
				}
				
				double tidalRange = (new TidalRange()).calculate(siteTideArrayList); //Create new instance and calculates tidal range
				String site = sitesHashMap.get(identifier); //grab corresponding site
				
				System.out.println("For site: "+site+", the tidalRange: "+tidalRange);
				
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
