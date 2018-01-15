package Final2009;

import java.io.IOException;
import java.net.MalformedURLException;

public class MetricCutoffTwist implements MetricInterface {

	public double cutOff(String urlSignal, String urlBackground, double lowerBoundary) throws MalformedURLException, IOException {

		//initialise values
		double maxSbRatio = 0.0;
		double maxSbRatioEnergy = 0.0;
		
		double minEnergy = lowerBoundary; //set minimum energy
		
		while (minEnergy <= 3.0) {
			
			double counterSignal = Method.getCounter(urlSignal , minEnergy);
			double counterBackground = Method.getCounter(urlBackground, minEnergy);
			
			double sbRatio = counterSignal / Math.sqrt(counterBackground); //calculates for a square rooted value
			
			if (sbRatio > maxSbRatio) { //find X that maximuses S/B
				
				maxSbRatio = sbRatio;
				maxSbRatioEnergy = minEnergy;
				
			}
			
			minEnergy = minEnergy + 0.1;
		}
		
		System.out.println("Max signal-background ratio for S/(sqrt B): "+maxSbRatio);
		System.out.println("Max Signal-background ratio energy for S/(sqrt B): "+maxSbRatioEnergy);
		
		return maxSbRatioEnergy;
	}

}
