package MidTerm2014_15;
/**
 * Class containing constructor of exoplanet object with details of exoplanet
 * @author Steven Vuong
 * @version 01/01/2018
 */
public class Exoplanet {

	//Initialise Varibles
	String Name; String Method;
	int Year; 
	double Mass; double Separation; double Distance;
	
	/**
	 * Constructor which takes in details of planet as objects and creates an exoplanet object containing all the details
	 * @param String Name
	 * @param Integer Year
	 * @param String Method
	 * @param Double Mass
	 * @param Double Separation
	 * @param Double Distance
	 */
	public Exoplanet (String Name, int Year, String Method, double Mass, double Separation, double Distance) {
		this.Name = Name;
		this.Year = Year;
		this.Method = Method;
		this.Mass = Mass;
		this.Separation = Separation;
		this.Distance = Distance;
	}
	
	public String getDetails() {
		return ("Name: "+Name+", Year: "+Year+", Discovery Method: "+Method+", Mass: "+Mass+", Separation (a.u): "+Separation+", Distance (parsecs): "+Distance);
	}
	
}
