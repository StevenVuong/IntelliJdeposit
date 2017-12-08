package module8;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Class to calculate pi via MonteCarlo method Implements callable interface
 * 
 * @author Steven Vuong
 * @version: 08-12-2017
 */

public class MonteCarloPiCalculatorTask implements Callable<Double> {

	private final long n_points;
	double pi;

	/**
	 * Constructor using nPoints data points
	 * 
	 * @param number of data points
	 */
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}

	@Override
	/**
	 * Calculate pi with number of points specified in object
	 * Finds pi from number of random points lying in a circle
	 * @return pi
	 */
	public Double call() {
		Random rand = new Random();
		long n_in = 0;
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x * x + y * y;
			if (r2 < 1.0)
				++n_in;
		}
		return 4.0 * n_in / n_points;
	}
}