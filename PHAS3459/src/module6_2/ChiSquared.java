package module6_2;
/**
 * Method to calculate chi-squared values using datapoints and theory, implements GoodnessOfFitCalculator
 * @author Steven Vuong
 * @version 06-01-18
 */
import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	
	public double gofCalculator(Collection<DataPoint> data, Theory th) {
	double chiSq = 0;
		
		//loops through data and calculates chi-square
		for (DataPoint dp : data) { 
			chiSq += (Math.pow((Math.pow(dp.getY(), 2) - Math.pow(dp.getX(),2)),2))/(Math.pow(dp.getEy(), 2));
		}

		return chiSq;
	
	}
}
