package midTermExam;

//import necessary classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;

public class year2014 {

	public static Planet parseLine(String line) {
		//return a planet object with all the data of one planet
		
		Scanner mult = new Scanner(line).useDelimiter(",");  //scans each value, separating by commas
		
		//puts data into each variable
		String name = mult.next();
		int year = Integer.parseInt(mult.next());
		String method = mult.next();
		double mass = Double.parseDouble(mult.next());
		double separation = Double.parseDouble(mult.next());
		double distance = -1; //adds condition if distance is non-existent, it outputs -1 so is deemed unphysical
		if (mult.hasNext()) {
			distance = Double.parseDouble(mult.next());  
		}
		
		mult.close(); //close scanner
		
		//output as new Planet Object with all of the parsed data
		return new Planet(name,year,method,mass,separation,distance); 
		
	}

	public static ArrayList<Planet> dataFromURLPlanet(String urlName) throws Exception {
		// Create an ArrayList of Planet objects from a URL
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);
		
		ArrayList<Planet> planets = new ArrayList<Planet>(); // Define ArrayList containing Player objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below
		b.readLine(); // Ignore the first line

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			planets.add(parseLine(line));
		}
		
		return planets;
		
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Planet> allPlanets = dataFromURLPlanet("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/exoplanets.txt");
			System.out.println("there are  " + allPlanets.size() + " exoplanets discovered in total in this list");
			
			//initialising values to hold planet with smallest distance
			Planet planetSmallestDistance = null;
			double distanceFromEarth = 10000000;
			String planetSmallestDistanceDetails = null;
			
			for (Planet p : allPlanets) { //loops over all planets
				if (p.distance != -1 & p.distance<distanceFromEarth) { //condition to find smallest distance (for planets where this is known)
					distanceFromEarth = p.distance;
					planetSmallestDistance = p; 
					planetSmallestDistanceDetails = p.getPlanetDetails();
				}
			}
			
			System.out.println("Smallest Planet Distance to Earth Details: " + planetSmallestDistanceDetails);
			
			HashMap<String, ArrayList<Planet>> planetsByMethod = new HashMap<String, ArrayList<Planet>>(); // Initialise HashMap to hold method names as keys and an ArrayList of planets as the values.
			
			// sort planets by method
			for (Planet p : allPlanets) { //loops over all planets
				if (planetsByMethod.get(p.method) == null) { // If the method has not yet been put into the HashMap, create a new ArrayList containing the current planet and put it into the HashMap.
					ArrayList<Planet> planetArray = new ArrayList<Planet>(); 
					planetArray.add(p);
					planetsByMethod.put(p.method, planetArray); 
				}
				else { //the method is already registered as a hashmap, scans hashmap for key, add current planet to arraylist and update hashmap
					ArrayList<Planet> currentMethod = planetsByMethod.get(p.method);
					currentMethod.add(p);
					planetsByMethod.put(p.method, currentMethod); //associates key to value
				}
			}
			
			for (String m: planetsByMethod.keySet()) { // Do the following for each method: loops through each method and gets key, m
				
				//initialising variables
				int earliestYear = 3000;
				double lightestMass = 3000;
				String lightestMassDetails = null;
				
				ArrayList<Planet> methodPlanet = planetsByMethod.get(m); //retrieve array list for method currently being considered
				
				for (Planet pMethod : methodPlanet) {
					
					if (pMethod.year < earliestYear) {
						earliestYear = pMethod.year;
					}
					
					if (pMethod.mass < lightestMass) {
						lightestMass = pMethod.mass;
						lightestMassDetails = pMethod.getPlanetDetails();
					}
					
				}
				System.out.println("");
				System.out.println("Method of Discovery: " + m);
				System.out.println("The number of explanets discovered is: " + methodPlanet.size());
				System.out.println("the earliest year an exoplanet was discovered with this was: " + earliestYear);
				System.out.println("the lightest exoplanet has details: " + lightestMassDetails);
				
			}
		}
		
		
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
