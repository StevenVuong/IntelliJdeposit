package Final2010;
/**
 * Implements Statistic interface
 * @author SID: 15011252
 *
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StatisticLowMeanMax implements StatisticInterface {

	@Override
	public double statistic(ArrayList<Reading> readingArrayList) throws MalformedURLException, IOException {
		// TODO Auto-generated method stu

		return calcLowestMeanMaxTemp(readingArrayList);

	}
	
	/**
	 * Method which calculates the lowest meanMax temperature and prints the country it corresponds to
	 * @param maxTempMeasurements
	 * @return 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static double calcLowestMeanMaxTemp(ArrayList<Reading> maxTempMeasurements)
			throws MalformedURLException, IOException {
		HashMap<String, ArrayList<Reading>> countryAsKeyHM = Methods.countryAsKey(maxTempMeasurements);//Initialise hashmap
		
		Double lowestMeanMaxTemperature = 10000000000000.0;
		String lowestMeanMaxCountry = "";
		Integer year = 0;
		Reading yearR = null;
		
		for (String country : countryAsKeyHM.keySet()) { //loop over countries
			
			ArrayList<Reading> readingsForCountry = countryAsKeyHM.get(country); //get values for that country
			Double sumMaxTemp = 0.0;
			Double counter = 0.0;
			
			for (Reading r : readingsForCountry) { //loop through readings
				
				for (Double d : r.data) { //loop through max temperature dataset
					sumMaxTemp += d;
					counter++;
					yearR = r;
				}
				
			}
			
			Double meanMaxTemp = sumMaxTemp / counter;
			
			if (meanMaxTemp < lowestMeanMaxTemperature) { //finds lowest mean max temperature
				lowestMeanMaxTemperature = meanMaxTemp;
				lowestMeanMaxCountry = country;
				year = yearR.Year;
			}
			
		}
		System.out.println("For Year: "+ year);
		System.out.println("Country with lowest mean max temperature: "+lowestMeanMaxCountry+", with average max temperature: "+lowestMeanMaxTemperature);
		return year;
	}
}
