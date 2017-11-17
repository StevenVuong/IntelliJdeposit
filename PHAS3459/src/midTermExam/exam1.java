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
			ArrayList<Ice> allIce = dataFromURLIce(
					"http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv");
			System.out.println("\n There are  " + allIce.size() + " datapoints in this list");

			// Initialises hashmap with month as key and ice objects as values
			HashMap<Integer, ArrayList<Ice>> iceByMonth = new HashMap<Integer, ArrayList<Ice>>();
			// updates month hashmap to sort into order according to months
			monthHashMap(allIce, iceByMonth);

			for (int currentMonth : iceByMonth.keySet()) { // loop through each Month

				ArrayList<Ice> icyMonths = iceByMonth.get(currentMonth); //creates arraylist of values from months
				//System.out.println(icyMonths.size());
				HashMap<Integer, ArrayList<Ice>> iceByYear = new HashMap<Integer, ArrayList<Ice>>();// Initialises hashmap with Year as key and ice objects as values
				// updates month hashmap to sort into order according to year, it is now the period
				yearHashMap(icyMonths, iceByYear);

				
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
					 System.out.println("For Period(m/yyyy), Lowest Extent Details: " + lowestExtentObjectDetails + " || and Lowest Area Details: " + lowestAreaObjectDetails);
				}

			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
