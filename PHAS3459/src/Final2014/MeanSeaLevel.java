package Final2014;
/**
 * Method which calculates mean of all sea level readings at sites and prints. Has main method
 * @author Steven Vuong
 * @version 03-01-2018
 * @implements CalculationInterface
 */
/**
 * Import necessary modules
 */
import java.util.ArrayList;
import java.util.HashMap;

public class MeanSeaLevel implements CalculationInterface {

	/**
	 * Method which returns mean sea level of all tides
	 * @param Tide arraylist
	 * @return double mean sealevel
	 */
	public double calculate(ArrayList<Tide> tideArrayList) {
		
		double sumSeaLevel = 0.0; //initialise sum of values
		
		for (Tide tide : tideArrayList) {
			
			sumSeaLevel += tide.SeaLevelReal;
			
		}
		
		return (sumSeaLevel / tideArrayList.size()); //calculate and return mean
	}

	public static void main(String [] args) {
		
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
				
				double meanSeaLevel = (new MeanSeaLevel()).calculate(siteTideArrayList); //Create new instance and calculates mean sea level
				String site = sitesHashMap.get(identifier); //grab corresponding site
				
				System.out.println("For site: "+site+", the mean sea level is: "+meanSeaLevel);
				
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
}
