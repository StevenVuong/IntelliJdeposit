package midTermExam;

public class Planet {
	
	//initialise member variables
	String name;
	int year;
	String method;
	double mass;
	double separation;
	double distance;
	
	public Planet(String name, int year, String method, double mass, double separation, double distance) {
		//constructor to create object with all the possible planet variables
		
		this.name = name;
		this.year = year;
		this.method = method;
		this.mass = mass;
		this.separation = separation;
		this.distance = distance;
		
	}
	
	//create getters for required details
	public String getPlanetDetails() {
		return ("Name: " + name +", Discovery Year: " + year + ", Discovery Method: " + method + ", mass: " + "Jupiter Masses, Separation to star: " + separation + "a.u, Distance to Earth: " + distance +"pascals");
	}
	
	public int getYear() {
		return (year);
	}

}
