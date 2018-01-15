package MidTerm2009_10;

public class Measurement {
	
	Integer Year; Integer Month; Integer Day;
	String Time; 
	Double Concentration;
	Double Latitude;
	Double Longitude;
	
	/**
	 * Constructor for all the varibles to be measured
	 * @param year
	 * @param month
	 * @param day
	 * @param time
	 * @param concentration
	 */
	public Measurement(Integer year, Integer month, Integer day, String time, Double concentration) {
		Year = year;
		Month = month;
		Day = day;
		Time = time;
		Concentration = concentration;
		Latitude = this.Latitude;
		Longitude = this.Longitude;
	}
	
	public String getDetailsMeasurement() {
		return ("Date: "+this.Year+"/"+this.Month+"/"+this.Day+", Time: "+this.Time+", Concentration: "+this.Concentration);
	}
	

}
