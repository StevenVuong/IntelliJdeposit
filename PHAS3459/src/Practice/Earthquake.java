package Practice;
/**
 * Class which contains Earthquake constructor and toString get Details
 * @author Steven Vuong
 * @version 29-12-2017
 */
public class Earthquake {

	//Initialise Details as Objects
	Integer Year; Integer Month; Integer Day;
	Integer Hour; Integer Minute; Double Second;
	Double Lat; Double Long; Double Depth;
	Double EH1; Double EH2; Integer Az;
	Double Ez; Double Mag; Integer Id;
	
	//Constructor to create objects with all member details
	public Earthquake(Integer year, Integer month, Integer day, Integer hour, Integer minute, Double second, Double lat,
			Double l, Double depth, Double eH1, Double eH2, Integer az, Double ez, Double mag, Integer id) {
		Year = year;
		Month = month;
		Day = day;
		Hour = hour;
		Minute = minute;
		Second = second;
		Lat = lat;
		Long = l;
		Depth = depth;
		EH1 = eH1;
		EH2 = eH2;
		Az = az;
		Ez = ez;
		Mag = mag;
		Id = id;
	}
	
	//Method to get details about Earthquake
	public String getDetails() {
		return ("Date: "+Day+"/"+Month+"/"+Year+", Time: "+Hour+":"+Minute+":"+Second+", Location: "+Lat+":"+Long+", Depth: "+Depth+" +/- "+Ez+", Magnitude: "
				+Mag+", ID: "+Id);
	}
}
