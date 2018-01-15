package Final2010;
/**
 * Class which implements statistic interface and calculates the largest variation of rms values
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class StatisticRMS implements StatisticInterface{

	@Override
	public double statistic(ArrayList<Reading> readingArrayList) throws MalformedURLException, IOException {
		
		double highestValue = 0.0;
		double lowestValue = 100000000000000000000000.0;
		double largestVariation = 0.0;
		String country = "";
		
		for (Reading r : readingArrayList) { //loop through values
			
			ArrayList<Double> data = r.data;
			
			for (Double d : data) {
				
				if (d > highestValue) { //finds greatest value
					highestValue = d;
				}
				if (d < lowestValue) { //finds lowest value
					lowestValue = d;
				}
				
			}
			double difference = highestValue - lowestValue; //calculates difference
			double rms = Math.sqrt(difference); //calculates rms
			
			if (rms > largestVariation) {
				largestVariation = rms;
				country = Methods.returnCountryCrossReference(r.Id); //grabs country for the rms
			}
			
		}
		System.out.println("Country with largest variation is "+country+" with rms variation of "+largestVariation);
		return 0;
	}

}
