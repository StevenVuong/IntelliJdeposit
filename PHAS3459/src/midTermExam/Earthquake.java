package midTermExam;

	public class Earthquake {


		//initialise member variables
		int Year, Month, Day, Hour, Min, Az, Id;
		double Second, Lat, Lon, Dep, EH1, EH2, Ez, Mag;
		
		public Earthquake(int year, int month, int day, int hour, int min, double second, double lat, double lon, double dep, double EH1, double EH2, int Az, double Ez, double Mag, int Id) {
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
		
		public double getMag() {
			return Mag;
		}
		
		public String getDetails() {
			return ("Date: "+Day + "/" + Month + "/" + Year + " at " + Hour + "h:" + Min + "mins:" + Second + "s at lat: " + Lat + " and Long: " + Lon + " with magnitude: " + Mag + " and ID: " + Id);
		}
		
		public String getErrors() { 
			return ("EH1 is: " + EH1 +",  EH2 is: " + EH2 + ", AZ is: " + Az + ", and EZ is: " + Ez);
		}


	}

