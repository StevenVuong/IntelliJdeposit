package Final2010;
/**
 * Interface which allows other classes to implement, taking in an arraylist of Reading objects and outputting a double
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface StatisticInterface {

	/**
	 * Method which defines input and output types, essentially returns statistic for ArrayList of Reading objects
	 * @param readingArrayList
	 * @return statistic double
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	double statistic(ArrayList<Reading> readingArrayList) throws MalformedURLException, IOException;
	
}
