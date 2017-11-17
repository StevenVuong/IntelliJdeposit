package midTermExam;
public class Ice {

	//initialise member variables
	int year;
	int month;
	String dataType;
	String region;
	double extent;
	double area;
	
	//Generate constructor to create object with all variables
	public Ice(int year, int month, String dataType, String region, double extent, double area) {
		this.year = year;
		this.month = month;
		this.dataType = dataType;
		this.region = region;
		this.extent = extent;
		this.area = area;
	}

	
	//generate getters for each variable
	public int getYear() {
		return year;
	}


	public int getMonth() {
		return month;
	}

	public String getDataType() {
		return dataType;
	}


	public String getRegion() {
		return region;
	}


	public double getExtent() {
		return extent;
	}


	public double getArea() {
		return area;
	}
	
	public String getDetails() {
		return ("Year: "+year+" || Month: "+month+" || dataType: "+dataType+ " || Region: "+ region+" || Extent: "+ extent+" || Area: "+ area);
	}

	
	
}
