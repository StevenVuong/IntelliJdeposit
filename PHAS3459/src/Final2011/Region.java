package Final2011;

public class Region {
	
	//Initialise variables
	String ID; String RegionName; 
	Double Population;
	Double NumXXX; Double NumYYY; Double NumZZZ;
	Double NumAAA; Double NumBBB;

	
	
	/**
	 * Constructor to generate region object for all the possible fields
	 * @param iD
	 * @param regionName
	 * @param population
	 * @param numXXX
	 * @param numYYY
	 * @param numZZZ
	 * @param numAAA
	 * @param numBBB
	 */
	public Region(String iD, String regionName, Double population, Double numXXX, Double numYYY, Double numZZZ,
			Double numAAA, Double numBBB) {
		super();
		ID = iD;
		RegionName = regionName;
		Population = population;
		NumXXX = numXXX;
		NumYYY = numYYY;
		NumZZZ = numZZZ;
		NumAAA = numAAA;
		NumBBB = numBBB;
	}
	
	public String toString() {
		return ("ID: "+this.ID+", Region: "+this.RegionName+", Population: "+this.Population+", NumXXX: "+this.NumXXX+", "
				+ "NumYYY: "+this.NumYYY+", NumZZZ: "+this.NumZZZ+", NumAAA: "+this.NumAAA+", NumBBB: "+this.NumBBB);
	}
	
}
