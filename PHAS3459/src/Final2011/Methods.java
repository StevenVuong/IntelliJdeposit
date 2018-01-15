package Final2011;

import java.io.*;
import java.util.*;
import java.net.*;

public class Methods {
	
	private static BufferedReader urlToBufferReader(String url) throws MalformedURLException, IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
	
	public static HashMap<String, String> getRegions(String url) throws MalformedURLException, IOException {
		
		BufferedReader br = urlToBufferReader(url);
				
		String empty = ""; //Initialise string
		br.readLine(); //Skip first line
		HashMap<String, String> regionHM = new HashMap<String, String>(); //Initialise hashmap
		
		while ((empty = br.readLine()) != null) { //loop through values
			
			Scanner sn = new Scanner(empty).useDelimiter(",");
			
			String ID = sn.next();
			String RegionName = sn.next();
			
			sn.close();
			
			regionHM.put(ID, RegionName);
			
		}
		
		return regionHM;
	}
	
	public static HashMap<String, Double> getPopulations(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		BufferedReader br = urlToBufferReader(url);
		
		String empty = "";
		br.readLine(); //Skip first line
		HashMap<String, Double> populationHM = new HashMap<String, Double>(); //Initialise hashmap
		
		while ((empty = br.readLine()) != null) {
			
			Scanner sn = new Scanner(empty);
			
			String ID = sn.next();
			Double Population = Double.parseDouble(sn.next());
			
			sn.close();
			
			populationHM.put(ID, Population);
			
		}
		
		return populationHM;
	}
	
	public static String startsWithID(String Id, String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object for XYZ
		BufferedReader br = urlToBufferReader(url);
		
		String empty = "";
		String correctLine = "nonce";
		
		while ((empty = br.readLine()) != null) { //loop through values
			
			Scanner sn = new Scanner(empty);
			
			if (sn.next().equals(Id)) { //if ID is equal to the line, set values corresponding to correct id
				
				correctLine = empty;
				
			}
			
		}
		
		return correctLine;
	}
	
	public static HashMap<String, Region> readDataHM() throws MalformedURLException, IOException {
		
		//Grab HashMaps and values for Regions and Populations (ID is key for both of them)
		HashMap<String, String> allRegionsHM = getRegions("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2011-12/final/regions.txt");
		HashMap<String, Double> allPopulationsHM = getPopulations("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2011-12/final/populations.txt");
		
		//Initialise hashMap
		HashMap<String, Region> allHM = new HashMap<String, Region>();
		
		for (String IdRegion: allRegionsHM.keySet()) { //Loop through ID's of regions
			
			for (String IdPopulation : allPopulationsHM.keySet()) { //Loop through ID's of populations
				
				if (IdPopulation.equals(IdRegion)) { //Look for matching ID's
					
					//Set region name & population
					String Region = allRegionsHM.get(IdPopulation);
					Double Population = allPopulationsHM.get(IdPopulation);
					
					//Grabs each line corresponding to ID for each dataset
					String lineXYZ = startsWithID(IdPopulation, "http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2011-12/final/occurrencesXYZ.txt");
					String lineAB = startsWithID(IdPopulation, "http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2011-12/final/occurrencesAB.txt");

					//Initialise values for a lack of values. Values of -1.0 are clearly non-valid
					Double NumAAA = -1.0;
					Double NumBBB = -1.0;
					Double NumXXX = -1.0;
					Double NumYYY = -1.0;
					Double NumZZZ = -1.0;
					
					if (lineAB  != "nonce") { //condition to parse

						Scanner snAB = new Scanner(lineAB);
						
						snAB.next(); 
						
						NumAAA = Double.parseDouble(snAB.next());
						NumBBB = Double.parseDouble(snAB.next());
						
					}
					if (lineXYZ != "nonce") {
						
						Scanner snXYZ = new Scanner(lineXYZ); //Creates scanner objects

						//Skip the first part (ID's, which we already have)
						snXYZ.next(); 
						
						//Parse values accordingly
						 NumXXX = Double.parseDouble(snXYZ.next());
						 NumYYY = Double.parseDouble(snXYZ.next());
						 NumZZZ = Double.parseDouble(snXYZ.next());
						 
					}

					Region regionID = new Region(IdPopulation, Region, Population, NumXXX, NumYYY, NumZZZ, NumAAA, NumBBB); //Create new region object with values
					
					allHM.put(IdPopulation, regionID); //Add region as value to hashmap with ID as corresponding key
				}
				
			}
			
		}
		
		return allHM;
		
	}
	


}
