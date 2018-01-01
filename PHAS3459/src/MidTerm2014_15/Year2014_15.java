package MidTerm2014_15;
/**
 * Class with main method which analyses exoplanets and prints data for each discovery method
 * @author Steven Vuong
 * @version 01-01-2018
 */
import java.util.*;

public class Year2014_15 {

	public static void main(String[] args) {
		try {
			
		//Obtain arraylist of exoplanets
		ArrayList<Exoplanet> exoplanetsArrayList = ExoplanetMethods.dataFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/exoplanets.txt");
		
		//Initialise variables
		double closestExoplanet = 1000.000;
		String closestExoplanetDetails = null;
		
		for (Exoplanet exp : exoplanetsArrayList) { //Loop through exoplanets
			if ((exp.Distance < closestExoplanet) && (exp.Distance != -1.0)) { //Finds closest exoplanet
				
				closestExoplanet = exp.Distance;
				closestExoplanetDetails = exp.getDetails();
				
				}
			}
		
		System.out.println("Closest exoplanet details: "+closestExoplanetDetails);
		System.out.println("");
		
		//Sort exoplanets into hashmap with method as key
		HashMap<String, ArrayList<Exoplanet>> exoplanetsHM = ExoplanetMethods.planetHashMap(exoplanetsArrayList);
		
		for (String method : exoplanetsHM.keySet()) { //Loop through methods
			
			ArrayList<Exoplanet> exoplanets = exoplanetsHM.get(method);
			
			//Initialise variables
			int yearEarliestDiscovery = 0;
			String yearEarliestDiscoveryDetails = null;
			double lightestExoplanet = 1000.00;
			String lighestExoplanetDetails = null;
			
			for (Exoplanet exp : exoplanets) { //Loop through exoplanets in arraylist
				if (exp.Year < yearEarliestDiscovery) { //Finds earliest exoplanet discovery year
					yearEarliestDiscovery = exp.Year;
					yearEarliestDiscoveryDetails = exp.getDetails();
				}
				if (exp.Mass < lightestExoplanet) { //Finds lightest exoplanet for the method
					lightestExoplanet = exp.Mass;
					lighestExoplanetDetails = exp.getDetails();
				}
			}
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Method: "+method);
			System.out.println("Number of exoplanets discovered: "+exoplanets.size());
			System.out.println("Earliest Exoplanet Discovery Details: "+yearEarliestDiscoveryDetails);
			System.out.println("Lightest Exoplanet Details: "+lighestExoplanetDetails);
		}
		
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	
}
