package module6_1;
/**
 * Interface which defines goodness of fit object for classes to implement
 * @author Steven Vuong
 * @version 26-12-2017
 */
import java.util.Collection;

public interface GoodnessOfFitCalculator {
	
	double goodnessOfFit(Collection<DataPoint> data, Theory theory);
	
}
