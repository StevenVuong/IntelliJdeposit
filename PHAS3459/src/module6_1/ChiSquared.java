package module6_1;
/**
 * Class which implements GoodNessofFitCalculator and returns a value of chi-square
 * @author Steven Vuong
 * @version 26-12-2017
 */

import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {


	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		
		double chiSq = 0;
		
		//loops through data and calculates chi-square
		for (DataPoint dp : data) { 
			chiSq += (Math.pow((Math.pow(dp.getY(), 2) - Math.pow(dp.getX(),2)),2))/(Math.pow(dp.getEy(), 2));
		}

		return chiSq;
		
	}

}
