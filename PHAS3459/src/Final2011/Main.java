package Final2011;

import java.io.*;
import java.util.*;
import java.net.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			//Grab Regions as values with ID as key hashmap
			HashMap<String, Region> allDataHM = Methods.readDataHM();
			
			/**
			 * Part 1
			 */
			//Initialise values
			Double SumPopulation = 0.0;
			Double SumXXX = 0.0;
			Double SumYYY = 0.0;
			Double SumZZZ = 0.0;
			Double SumAAA = 0.0;
			Double SumBBB = 0.0;
			Double highestDiseaseCount = 0.0;
			Region highestDiseaseRegion = null;
			Double lowestDiseaseCount = 1000000000000000000000000000000000000.0;
			Region lowestDiseaseRegion = null;
			
			for (String id : allDataHM.keySet()) { //Loop through all values
				
				Region r = allDataHM.get(id); //Set regions of all values
				
				//Adds to sum
				SumPopulation += r.Population;
				if (r.NumXXX != -1.0) {
					SumXXX += r.NumXXX;
					SumYYY += r.NumYYY;
					SumZZZ += r.NumZZZ;
				}
				if (r.NumAAA != -1.0) {
					SumAAA += r.NumAAA;
					SumBBB += r.NumBBB;	
				}
				
				//Calculates sum of diseases
				Double SumDisease = r.NumXXX + r.NumYYY + r.NumZZZ + r.NumAAA + r.NumBBB;
				
				if (r.NumXXX == -1.0) {
					SumDisease = r.NumAAA + r.NumBBB;
				}
				if (r.NumAAA == -1.0) {
					SumDisease = r.NumXXX + r.NumYYY;
				}
				if ((r.NumXXX == -1.0) && (r.NumAAA == -1.0)) {
					SumDisease = 0.0;
				}
				
				
				if (SumDisease >= highestDiseaseCount) {
					highestDiseaseCount = SumDisease;
					highestDiseaseRegion = r;
				}
				if (SumDisease <= lowestDiseaseCount) {
					lowestDiseaseCount = SumDisease;
					lowestDiseaseRegion = r;
				}
				
			}
			
			System.out.println("Total Population: "+SumPopulation);
			System.out.println("Total XXX Diseases: "+SumXXX);
			System.out.println("Total YYY Diseases: "+SumYYY);
			System.out.println("Total ZZZ Diseases: "+SumZZZ);
			System.out.println("Total AAA Diseases: "+SumAAA);
			System.out.println("Total BBB Diseases: "+SumBBB);
			System.out.println("");
			System.out.println("Region with lowest Disease Occurances is "+lowestDiseaseRegion.RegionName+", with "+lowestDiseaseCount+" number of diseases");
			System.out.println("Region with highest Disease Occurances is "+highestDiseaseRegion.RegionName+", with "+highestDiseaseCount+" number of diseases");
			
			/**
			 * Part 2
			 */
			
			Double a = (new StatisticOccurances()).statistic(allDataHM, SumXXX, SumYYY, SumZZZ, SumAAA, SumBBB, SumPopulation);
			
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
