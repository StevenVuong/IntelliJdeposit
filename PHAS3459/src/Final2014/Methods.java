package Final2014;

import java.io.*;
import java.util.*;
import java.net.*;

public class Methods {

	public static Tide parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Create scanner object
		
		//parse details into objects
		String Identifier = sn.next();
		Integer Year = Integer.parseInt(sn.next());
		Integer Month = Integer.parseInt(sn.next());
		Integer Day = Integer.parseInt(sn.next());
		Integer Hour = Integer.parseInt(sn.next());
		Integer Minute = Integer.parseInt(sn.next());
		Double SeaLevelReal = Double.parseDouble(sn.next());
		Double SeaLevelPredicted = Double.parseDouble(sn.next());
		
		sn.close(); //Close scanner
		
		//Create and return tide object with details from string
		return new Tide(Identifier, Year, Month, Day, Hour, Minute,
				SeaLevelReal, SeaLevelPredicted);
		
	}
	
	public static ArrayList<Tide> tideFromUrl(String url) throws IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<Tide> tideArrayList = new ArrayList<Tide>(); //Initialise arraylist
		String line = ""; //Initialise line
		
		while ((line = br.readLine()) != null) { //loop through values
			
			tideArrayList.add(parseLine(line)); //create tide objects and add to arraylist
			
		}
		
		return tideArrayList;
	}
	
	public static ArrayList<Tide> allTides() throws IOException {
		
		//Grab tide array lists
		ArrayList<Tide> tidesArray1999 = tideFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/tides-1999.txt");
		ArrayList<Tide> tidesArray2000 = tideFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/tides-2000.txt");
		ArrayList<Tide> tidesArray2001 = tideFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/tides-2001.txt");
		
		//Create large arraylist with all values
		ArrayList<Tide> allTideData = new ArrayList<Tide>(); //Initialise arraylist
		
		allTideData.addAll(tidesArray1999);
		allTideData.addAll(tidesArray2000);
		allTideData.addAll(tidesArray2001);

		return allTideData;

	}
	
	public static HashMap<String, String> siteHashMap(String url) throws IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Initialise hashmap with identifier to be key and name of port to be value
		HashMap<String, String> sitesHashMap = new HashMap<String, String>(); 
		
		br.readLine(); //Ignore first line
		
		String line = "";
		
		while ((line = br.readLine()) != null) {
			
			Scanner sn = new Scanner(line); //Create scanner object from line
			
			//Parse values
			String Site = sn.next();
			String Identifier = sn.next();
			
			sitesHashMap.put(Identifier, Site); //Add to hashmap
			
		}
		
		return sitesHashMap;
	}
	
	public static ArrayList<Tide> allTidesNewData() throws IOException {
		
		//Grab tide array lists
		ArrayList<Tide> tidesArray2004 = tideFromUrlNew("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt");
		ArrayList<Tide> tidesArray2005 = tideFromUrlNew("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt");
		ArrayList<Tide> tidesArray2006 = tideFromUrlNew("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt");
		
		//Create large arraylist with all values
		ArrayList<Tide> allTideData = new ArrayList<Tide>(); //Initialise arraylist
		
		allTideData.addAll(tidesArray2004);
		allTideData.addAll(tidesArray2005);
		allTideData.addAll(tidesArray2006);

		return allTideData;

	}
	
	public static Tide parseLineNew(String line) {
		
		Scanner sn = new Scanner(line); //Create scanner object
		
		//parse details into objects
		Integer Year = Integer.parseInt(sn.next());
		Integer Month = Integer.parseInt(sn.next());
		Integer Day = Integer.parseInt(sn.next());
		Integer Hour = Integer.parseInt(sn.next());
		Integer Minute = Integer.parseInt(sn.next());
		String Identifier = sn.next();
		Double SeaLevelReal = Double.parseDouble(sn.next());
		Double SeaLevelPredicted = Double.parseDouble(sn.next());
		
		sn.close(); //Close scanner
		
		//Create and return tide object with details from string
		return new Tide(Identifier, Year, Month, Day, Hour, Minute,
				SeaLevelReal, SeaLevelPredicted);
		
	}
	public static ArrayList<Tide> tideFromUrlNew(String url) throws IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		ArrayList<Tide> tideArrayList = new ArrayList<Tide>(); //Initialise arraylist
		String line = ""; //Initialise line
		
		while ((line = br.readLine()) != null) { //loop through values
			
			tideArrayList.add(parseLineNew(line)); //create tide objects and add to arraylist
			
		}
		
		return tideArrayList;
	}
}
