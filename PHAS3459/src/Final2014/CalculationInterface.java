package Final2014;
/**
 * Interface which defines method for calculation of arbitrary statistic
 * @author Steven Vuong
 * @version 03-01-2018
 */
import java.util.ArrayList;

public interface CalculationInterface {
	
	/**
	 * Method which represents calculation of arbitrary statistic
	 * @param tideArrayList
	 * @return double (real number)
	 */
	double calculate(ArrayList<Tide> tideArrayList);

}
