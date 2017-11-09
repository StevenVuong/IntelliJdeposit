package midTermExam;

public class year2015p2 {

	//initialise member variables
	int Year, Month, Day, Hour, Min, Az, Id;
	double Second, Lat, Lon, Dep, EH1, EH2, Ez, Mag;
	
	public year2015p2(int year, int month, int day, int hour, int min, double second, double lat, double lon, double dep, double EH1, double EH2, int Az, double Ez, double Mag, int Id) {
		//constructor to input earthquake data into each earthquake
		this.Year = year;
		this.Month = month;
		this.Day = day;
		this.Hour = hour;
		this.Min = min;
		this.Az = Az;
		this.Second = second;
		this.Lat = lat;
		this.Lon = lon;
		this.Dep = dep;
		this.EH1 = EH1;
		this.EH2 = EH2;
		this.Ez= Ez;
		this.Mag = Mag;
		this.Id = Id;
		
	}
	
}
