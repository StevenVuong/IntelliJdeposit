package module6_2;
/**
 * Interface with goodnessOfFit calculator parameter
 * @author Steven Vuong
 * @version 06-01-2018
 */
import java.util.Collection;

public interface GoodnessOfFitCalculator {
	
	double gofCalculator(Collection<DataPoint> data, Theory th);

}
