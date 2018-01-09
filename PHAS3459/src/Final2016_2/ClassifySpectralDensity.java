package Final2016_2;

import java.util.ArrayList;

/**
 * Class which implements ClassifyInterface. Classifies AudioFile Objects on loudness
 * @author Steven Vuong
 * @version 09-01-2018
 */
public class ClassifySpectralDensity implements ClassifyInterface {

	/**
	 * Calculates the spectral density of a sample of data. Modified for arrayList
	 * @param ArrayList of sample data
	 * @param double time
	 * @param double frequency
	 * @return spectral density double
	 */
	private double spectralDensity(ArrayList<Integer> samples, double t, double f) {
		
		int bigN = samples.size();
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		
		for (int n = 0; n < bigN; ++n) {
			
			sumCos += samples.get(n)* Math.cos(z*n);
			sumSin += samples.get(n)* Math.sin(z*n);
			}
		
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
		
	}
	

	 /**
	 * Calculates spectral density and returns classification
	 * @param AudioFile object
	 * @return String
	*/
	public String classify(AudioFile af) {
		
		double sd100 = spectralDensity(af.AmplitudeData, ((double)af.NumberOfSamples/(double)af.SampleFrequency), 100.0);
		double sd400 = spectralDensity(af.AmplitudeData, ((double)af.NumberOfSamples/(double)af.SampleFrequency), 400.0);
		double sd1000 = spectralDensity(af.AmplitudeData, ((double)af.NumberOfSamples/(double)af.SampleFrequency), 1000.0);
		
		if ((sd100 > sd400) && (sd100 > sd1000)) {
			return ("low");
		}
		if ((sd400 > sd100) && (sd400 > sd1000)) {
			return ("medium");
		}
		
		else {
			return ("high");
		}
	}
	
	


}
