package module6;

//Collection: represents group of objects. Imports interface directly than one of its subinterfaces. Allow manipulation of interfaces
import java.util.Collection;

public interface GoodnessOfFitCalculator {
	// Interface for calculating goodness of a fit of data against theory

	// method of taking in collection of data and theory object holding a possible relationship
	double goodnessOfFit(Collection<DataPoint> data, Theory theory);

}
