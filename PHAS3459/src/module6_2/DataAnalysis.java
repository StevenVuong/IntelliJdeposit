package module6_2;

/**
 * Import necessary modules
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class DataAnalysis {
	
	/**
	 * Method which returns best theory using various theories and a set of data
	 * @param data
	 * @param theories
	 * @param gofCalculator
	 * @return
	 */
    private static Theory bestTheory(Collection<DataPoint> data,
            Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
        boolean first = true;
        double bestGoodnessOfFit = 0.0;
        Theory bestTheory = null;
        for (Theory theory : theories) {
            double gof = gofCalculator.gofCalculator(data, theory);
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
    			
    			//Grabs data from URL
    			ArrayList<DataPoint> dpArrayList = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"); 
    			
    			//Create theory objects
    			PowerLawTheory test1 = new PowerLawTheory(2.0);
    			PowerLawTheory test2 = new PowerLawTheory(2.05);
    			QuadraticTheory test3 = new QuadraticTheory(1.0, 10.0, 0);
    			
    			//Initialise ArrayList
    			Collection<Theory> theoryArray = new ArrayList<Theory>(); 
    			
    			//Add theories to array to test
    			theoryArray.add(test1);
    			theoryArray.add(test2);
    			theoryArray.add(test3);
    			
    			Theory bestTheory = bestTheory(dpArrayList, theoryArray, new ChiSquared());
    			
    			System.out.println(bestTheory.toString());
    			
    		}
    		
    		catch (Exception e) {
    			
    			System.out.println(e.getMessage());
    			
    		}
    	}

}
