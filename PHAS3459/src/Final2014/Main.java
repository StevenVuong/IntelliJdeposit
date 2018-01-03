package Final2014;
/**
 * Final exam 2014-15 main method
 * @author Steven Vuong
 * @version 03-01-2018
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Main {
	
	public static void main(String[] args) {
		try {
			/**
			 * Part 1 below this
			 */
			
			//Grab sites
			HashMap<String, String> sitesHashMap = Methods.siteHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/sites.txt");
			
			//Grab all the tides
			ArrayList<Tide> tidesArrayList = Methods.allTides();
			
			//Initialise objects
			Double highestObservedLevel = 0.0;
			Tide highestObservedTide = null;
			Double maxTidalSurge = 0.0;
			Tide maxSurgeTide = null;
			
			for (Tide tide : tidesArrayList) { //Loop through arraylist
				
				if (tide.SeaLevelReal > highestObservedLevel) { //Condition for the highest observed sea level
					
					highestObservedLevel = tide.SeaLevelReal;
					highestObservedTide = tide;
					
				}
				
				Double tidalSurge = (tide.SeaLevelPredicted - tide.SeaLevelReal); //calculates tidal surge for each tide
				
				if (tidalSurge > maxTidalSurge) {
					
					maxTidalSurge = tidalSurge;
					maxSurgeTide = tide;
					
				}
				
			}
			
			//find location of highest observed tide
			String highestObservedLocation = sitesHashMap.get(highestObservedTide.Identifier); 
			
			//find location of greatest tidal surge
			String maxTidalSurgeSite = sitesHashMap.get(maxSurgeTide.Identifier);
			
			System.out.println("Highest observed level: "+highestObservedLevel);
			System.out.println("Identifier: "+highestObservedTide.Identifier);
			System.out.println("location: "+highestObservedLocation);
			System.out.println("Date: "+highestObservedTide.Day+"/"+highestObservedTide.Month+"/"+highestObservedTide.Year);
			System.out.println("Time: "+highestObservedTide.Hour+":"+highestObservedTide.Minute);
			//
			System.out.println("");
			System.out.println("Largest Tidal Surge: "+maxTidalSurge);
			System.out.println("Location: "+maxTidalSurgeSite);
			System.out.println("Date: "+maxSurgeTide.Day+"/"+maxSurgeTide.Month+"/"+maxSurgeTide.Year);
			System.out.println("Time: "+maxSurgeTide.Hour+":"+maxSurgeTide.Minute);
			
			
			/**
			 * Last part of part 3 below:
			 */
			
			//Grab sites
			HashMap<String, String> sitesHashMapNew = Methods.siteHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt");
			
			//Grab all the tides
			ArrayList<Tide> tidesArrayListNew = Methods.allTidesNewData();
			System.out.println(tidesArrayListNew.size());
			
			//Initialise objects
			Double maxTidalSurgeNew = 0.0;
			Tide maxSurgeTideNew = null;
			
			for (Tide tide : tidesArrayListNew) { //Loop through arraylist

				Double tidalSurge = (tide.SeaLevelPredicted - tide.SeaLevelReal); //calculates tidal surge for each tide
				
				if (tidalSurge > maxTidalSurgeNew) {
					
					maxTidalSurgeNew = tidalSurge;
					maxSurgeTideNew = tide;
					
				}
				
			}
			String siteOfNewDataSurge = sitesHashMapNew.get(maxSurgeTideNew.Identifier); //grab site
			
			System.out.println("");
			System.out.println("With new data:");
			System.out.println("Largest Tidal Surge: "+maxTidalSurgeNew);
			System.out.println("Location: "+siteOfNewDataSurge);
			System.out.println("Date: "+maxSurgeTideNew.Day+"/"+maxSurgeTideNew.Month+"/"+maxSurgeTideNew.Year);
			System.out.println("Time: "+maxSurgeTideNew.Hour+":"+maxSurgeTideNew.Minute);
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}

}
