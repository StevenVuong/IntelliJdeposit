package Final2016;
/**
 * Class which implements classify interface to classify sounds as high/medium/low using spectral density algorithm
 * @author Steven Vuong
 * @version 30-12-2017
 */
import java.util.*;

public class SpectralDensity implements Classify {

	/**
	 * method which returns the spectral density of a signal at frequency f.
	 * @param samples arrayList (modified from [] array)
	 * @param t
	 * @param f
	 * @return (double) Spectral density of a signal
	 */
	private double spectralDensity(ArrayList<Integer> samples, double t, double f) {
		int bigN = samples.size();
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
		sumCos += (double)samples.get(n)* Math.cos(z*n);
		sumSin += (double) samples.get(n)* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
		}
	
	
	/**
	 * Method which returns string depending on which has the greatest spectral density
	 * @param Audio object
	 * @return String reporting on classification of audio file spectral density
	 */
	public String classify(Audio au) {
		
		double sd100 = spectralDensity(au.Data, (au.SampleCount/au.Freq), 100.0);
		double sd400 = spectralDensity(au.Data, (au.SampleCount/au.Freq), 400.0);
		double sd1000 = spectralDensity(au.Data, (au.SampleCount/au.Freq), 1000.0);

		if ((sd100 > sd400) & (sd100 > sd1000)) {return "low";}
		if ((sd400 > sd100) & (sd400 > sd1000)) {return "medium";}
		if ((sd1000 > sd400) & (sd1000 > sd100)) {return "high";}
		
		else {return ("some have equal spectral densities");}
		
	}

}
