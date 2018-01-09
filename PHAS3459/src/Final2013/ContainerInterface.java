package Final2013;
/**
 * Interface which defines method for classes to implement
 * @author Steven Vuong
 * @version 09-01-2018
 */
import java.util.*;

public interface ContainerInterface {

	/**
	 * Represents method to take container of specimens as ArrayList and return ArrayList of specimens which would be a subset of parameter
	 * @param specimens ArrayList
	 * @return specimen ArrayList
	 */
	ArrayList<Specimen> regionSort(ArrayList<Specimen> specimens, Double param1, Double param2, Double param3);
	
}
