package module6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories,
			GoodnessOfFitCalculator gofCalculator) {
		// calculate and return the best theory with best fit. Input is data, possible
		// theories and testing method

		// Initialise values
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;

		// loop through all theories, calculate goodness of fit and update the best
		// theory accordingly
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {
		try {

			// creates new arraylist to hold Theory objects
			ArrayList<Theory> theories = new ArrayList<Theory>();

			// creates theory objects and adds them into array list
			theories.add(new PowerLawTheory(2));
			theories.add(new PowerLawTheory(2.05));
			theories.add(new QuadraticTheory(1, 10, 0));

			// imports data as arraylist
			ArrayList<DataPoint> data = TestDataPoints
					.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			
			//runs best theory method and prints best theory
			Theory bestTheory = bestTheory(data, theories, new ChiSquared());
			System.out.println("The theory with closest fit to the data with the lowest chi-squared value is "+bestTheory);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}