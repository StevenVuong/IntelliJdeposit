package Final2011;

import java.util.ArrayList;
import java.util.HashMap;

public interface StatisticInterface {

	/**
	 * Interface which returns statistic from data
	 * @param allDataHashMap<String, Region>
	 * @return double statistical value
	 */
	double statistic(HashMap<String, Region> allDataHM, Double param1, Double param2, Double param3, Double param4, Double param5, Double param6);
	
}
