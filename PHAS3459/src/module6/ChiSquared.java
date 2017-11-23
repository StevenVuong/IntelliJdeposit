package module6;

import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator {
	// class holding method of calculating chi-squared value for inputted data and theory

	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		// returns chi sqaure values for a given set of x, y and y uncertainties
		
		double chiSquareTotal = 0;
		
		//loop which calculates chi-square for each datapoint and sums all the values
		for (DataPoint dp : data) {
			chiSquareTotal += (Math.pow((Math.pow(dp.getY(), 2) - Math.pow(dp.getX(),2)),2))/(Math.pow(dp.getEy(), 2));
		}
		
		return chiSquareTotal;
	}

	
	
}
