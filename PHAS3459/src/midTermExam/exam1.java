package midTermExam;

//import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class exam1 {

	public static Ice parseLine(String line) {
		// return a Ice object with all the data of one line

		Scanner mult = new Scanner(line).useDelimiter(",\\s*"); // scans each value, separating by commas and
																// whitespaces

		// puts data into each variable
		int year = Integer.parseInt(mult.next());
		int month = Integer.parseInt(mult.next());
		String dataType = mult.next();
		String region = mult.next();
		double extent = Double.parseDouble(mult.next());
		double area = Double.parseDouble(mult.next());

		mult.close(); // close scanner

		// output as new Ice Object with all of the parsed data
		return new Ice(year, month, dataType, region, extent, area);
	}

	public static ArrayList<Ice> dataFromURLIce(String urlName) throws Exception {
		// Create an ArrayList of Ice objects from URL

		// takes url and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<Ice> ice = new ArrayList<Ice>(); // Define ArrayList containing Ice objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		b.readLine(); // Ignore the first line

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			ice.add(parseLine(line));
		}

		return ice; // output arrayList of ice objects
	}

	private static void monthHashMap(ArrayList<Ice> allIce, HashMap<Integer, ArrayList<Ice>> iceByMonth) {
		for (Ice iMonth : allIce) { // loop over all iceObjects
			if (iMonth.extent != -9999) { // condition to not include month in datatype (error)
				// If the object has not yet been put into the HashMap, create a new ArrayList
				// containing the current object and put it into the HashMap.
				if (iceByMonth.get(iMonth.month) == null) {
					ArrayList<Ice> iceMonthArray = new ArrayList<Ice>();
					iceMonthArray.add(iMonth);
					iceByMonth.put(iMonth.month, iceMonthArray);
				}
				// If the key month is already registered in hashmap, scans hashmap for
				// corresponding key, add current ice object to arraylist and update hashmap
				else {
					ArrayList<Ice> iceMonthArray1 = iceByMonth.get(iMonth.month);
					iceMonthArray1.add(iMonth);
					iceByMonth.put(iMonth.month, iceMonthArray1); // associates key to value
				}

			}
			
		}
	}

	private static void yearHashMap(ArrayList<Ice> allIce, HashMap<Integer, ArrayList<Ice>> iceByYear) {
		for (Ice iYear : allIce) { // loop over all iceObjects
			// If the object has not yet been put into the HashMap, create a new ArrayList
			// containing the current object and put it into the HashMap.
			if (iceByYear.get(iYear.year) == null) {
				ArrayList<Ice> iceYearArray = new ArrayList<Ice>();
				iceYearArray.add(iYear);
				iceByYear.put(iYear.year, iceYearArray);
			}
			// If the key year is already registered in hashmap, scans hashmap for
			// corresponding key, add current ice object to arraylist and update hashmap
			else {
				ArrayList<Ice> iceYearArray = iceByYear.get(iYear.year);
				iceYearArray.add(iYear);
				iceByYear.put(iYear.year, iceYearArray); // associates key to value
			}

		}
	}

	public static void main(String[] args) {
		try {
			ArrayList<Ice> allIce = dataFromURLIce("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
			System.out.println("\n There are  " + allIce.size() + " datapoints in this list");

			// Initialises hashmap with month as key and ice objects as values
			HashMap<Integer, ArrayList<Ice>> iceByMonth = new HashMap<Integer, ArrayList<Ice>>();
			// updates month hashmap to sort into order according to months
			monthHashMap(allIce, iceByMonth);
			
			for (int currentMonth : iceByMonth.keySet()) { // loop through each Month

				ArrayList<Ice> icyMonths = iceByMonth.get(currentMonth); //creates arraylist of values from months
				// Initialises hashmap with Year as key and ice objects as values
				HashMap<Integer, ArrayList<Ice>> iceByYear = new HashMap<Integer, ArrayList<Ice>>();
				yearHashMap(icyMonths, iceByYear);// updates month hashmap to sort into order according to year, it is now the period
	
				//initialise values 
				double lowestIceAreaYear = Double.MAX_VALUE;
				double lowestIceAreaYearValue = Double.MAX_VALUE;
				for (Ice icy : icyMonths) {
					if (icy.area < lowestIceAreaYear) {
						lowestIceAreaYearValue = icy.year;
					}
				}
				
				System.out.println("Month: " + currentMonth+ " || Lowest Ice Year: "+lowestIceAreaYearValue);

				// initialise lowest ice extent and area values and objects
				double lowestExtent = Double.MAX_VALUE;
				Ice lowestExtentObject = null;
				String lowestExtentObjectDetails = null;
				double lowestArea = Double.MAX_VALUE;
				Ice lowestAreaObject = null;
				String lowestAreaObjectDetails = null;
				for (Ice ic : icyMonths) { // loops through period to set lowest ice extent and area
					// updates values accordingly
					if (ic.extent < lowestExtent) {
						lowestExtent = ic.extent;
						lowestExtentObject = ic;
						lowestExtentObjectDetails = ic.getDetails();
					}
					if (ic.area < lowestArea) {
						lowestArea = ic.area;
						lowestAreaObject = ic;
						lowestAreaObjectDetails = ic.getDetails();
					}
					
					System.out.println("\nFor Period (m/yy)" + currentMonth+"/"+ic.year);
					 System.out.println("Lowest Extent Details: " + lowestExtentObjectDetails );
					 System.out.println("Lowest Area Details: " + lowestAreaObjectDetails);
					
				}
				
				
				for (int currentYear : iceByYear.keySet()) { // loop through each Year
					ArrayList<Ice> icyYears = iceByYear.get(currentYear); //creates arraylist of ice objects for each year
					ArrayList<Ice> icyYearsPlus = iceByYear.get(currentYear+1); //creates arraylist of ice objects for each year
					
					//initilaise variables
					double areaSum = 0;
					double areaSumYearAfter = 0;
					Ice yearAfterOne = null;
					
					for (int j = 0 ; j < icyYears.size(); j++) { //loop through years
						Ice Year = icyYears.get(j);
						areaSum += Year.area;
						//initialise variables again inside loop
						int YearPlusOne;
						double areaDifference = 0;
						double yearPlusOneArea = 0;
						for (int i = j ; i < icyYearsPlus.size(); i++) { //loops through years again to find sum of values for that year
							Ice YearAfter = icyYears.get(i);
							areaSumYearAfter += YearAfter.area;
							areaDifference = YearAfter.area - Year.area;
							
							System.out.println("Month: "+currentMonth + " || Year & Previous Year: "+YearAfter.year +" - "+((Year.year)-1)+" || Area Difference:" + areaDifference);
						}

					}
				}
				
				
			}

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
