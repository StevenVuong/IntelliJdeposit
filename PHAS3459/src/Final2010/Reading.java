package Final2010;
/**
 * Java Final 2010
 * @author SID:15011252
 * @version 12-01-2018
 */
import java.util.ArrayList;

public class Reading {

	//Initialising Variables
	String Id;
	Integer Year; Integer Month;
	String MeasurementType;
	ArrayList<Double> data;
	
	/**
	 * Constructor for reading object 
	 * @param id
	 * @param year
	 * @param month
	 * @param measurementType
	 * @param data
	 */
	public Reading(String id, Integer year, Integer month, String measurementType, ArrayList<Double> data) {
		
		Id = id;
		Year = year;
		Month = month;
		MeasurementType = measurementType;
		this.data = data;
		
	}
	
	
	
}
