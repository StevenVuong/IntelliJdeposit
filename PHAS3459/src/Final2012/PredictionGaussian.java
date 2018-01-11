package Final2012;

import java.util.HashMap;

public class PredictionGaussian implements PredictionInterface {

	public HashMap<Double, Double> prediction(Double N, Double Mass, Double Sigma) {
		
		double EnergyBin = 100.0;
		HashMap<Double, Double> hmGaussian = new HashMap<Double, Double>(); //initialise hashmap
		
		while (EnergyBin< 200.1) {
			
			double events = calcNumberEvents(EnergyBin, N, Mass, Sigma);
			hmGaussian.put(EnergyBin, events);
			
			EnergyBin = EnergyBin + 1.0;
		}

		return hmGaussian;
		
	}
	
	public double calcF(Double Energy, Double N, Double Mass, Double Sigma) {
		
		double f = (N / (Sigma * Math.sqrt(2*Math.PI))) * (Math.pow(Math.E, -(Math.pow((Energy - Mass),2) / (2*Math.pow(Sigma, 2))))); 
		
		return f;
	}
	
	public double calcNumberEvents(Double Energy, Double N, Double Mass, Double Sigma) {
		
		double f = 0.5*(calcF(Energy+1.0, N, Mass, Sigma) + calcF(Energy, N, Mass, Sigma));
		
		return f;
		
	}

}
