package Final2009;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Interface to represent metric that can be used to define minimum energy cut off
 * @author SID: 15011252
 * @version 15-01-2018
 */
public interface MetricInterface {
	
	/**
	 * Method which can represent any metric(double) with inputs S and B
	 * @param counterS
	 * @param counterB
	 * @return double cutOff
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public double cutOff(String urlSignal, String urlBackground, double lowerBoundary) throws MalformedURLException, IOException; 

}
