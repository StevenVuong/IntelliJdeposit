package module6_1;
/**
 * Class which Main method which returns the best theory to calculate the goodness-of-fit
 * @author Steven Vuong
 * @version 26-12-2017
 */


import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {
	
	/**
	 * Method which calculates the function with the closest fit to theoretical values
	 * @param data
	 * @param theories
	 * @param gofCalculator
	 * @return Theory object
	 */
	  private static Theory bestTheory(Collection<DataPoint> data,
	            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
	        boolean first = true;
	        double bestGoodnessOfFit = 0.0;
	        Theory bestTheory = null;
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
			  
		  //Obtaining values from URL
		  ArrayList<DataPoint> data = new ArrayList<DataPoint>(TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"));
		  
		  //Initialising arraylist of theories and adding Theory objects
		  ArrayList<Theory> theories = new ArrayList<Theory>(); 
		  theories.add(new PowerLawTheory(2));
		  theories.add(new PowerLawTheory(2.05));
		  theories.add(new QuadraticTheory(1, 10, 0));
		  
		  Theory bestTheory = bestTheory(data, theories, new ChiSquared());
		  System.out.println("The theory with the best fit is: "+ bestTheory);
		  }
		  catch (Exception e) {
			  System.out.println(e.getMessage());
		  }
	  }
}
