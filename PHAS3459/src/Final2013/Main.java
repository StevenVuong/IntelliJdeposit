package Final2013;

import java.net.*;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			//grab the specimen from URL
			HashMap<String, ArrayList<Specimen>> specimenIdHashMap = Methods.speciesAsKeyHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/survey-plants.txt");
			
			//grab scientific name from URL
			HashMap<String, String> specimenDetailsHashMap = Methods.hashMapFromURLDetails("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/species-plants.txt");
			
			/**
			 * Part 1
			 */
			//Initialise values
			Double maxMean = 0.0;
			String maxMeanSpecimenID = null;
			Double minMean = 10000000000000000000000000000.0;
			String minMeanSpecimenID = null;
			
			for (String id : specimenIdHashMap.keySet()) { //Loop through ID's
				
				ArrayList<Specimen> speciesArrayList = specimenIdHashMap.get(id);
				
				//grab name and number of species
				String scientificName = specimenDetailsHashMap.get(id);
				Integer specimenCount = speciesArrayList.size();
				
				Integer Height = 0; //Initialise value
				
				for (Specimen spec : speciesArrayList) {
					
					Height += spec.Height;
					
				}
				
				Double meanHeight = (double) Height / specimenCount; //calculate mean
				
				if (meanHeight > maxMean) { //finds maximum mean height
					maxMean = meanHeight;
					maxMeanSpecimenID = id;
				}
				if (meanHeight < minMean) { //finds minimum mean height
					minMeanSpecimenID = id;
					
				}
				
				System.out.println("ID: "+id);
				System.out.println("Scientific Name: "+scientificName);
				System.out.println("Number of specimens found: "+specimenCount);
				System.out.println("Mean height: "+meanHeight);
				System.out.println("");
				
			}
			String MinMeanHeight = specimenDetailsHashMap.get(minMeanSpecimenID);
			String MaxMeanHeight = specimenDetailsHashMap.get(maxMeanSpecimenID);
			
			System.out.println("Lowest mean height scientific name: "+MinMeanHeight);
			System.out.println("Maximum mean height scientific name: "+MaxMeanHeight);
			
			/**
			 * Part 2
			 */
			ArrayList<Specimen> urticaAL = specimenIdHashMap.get("NT"); //grab arraylist of specimen corresponding to Urtica
			ArrayList<Specimen> north30AL = (new ContainerLatitude()).regionSort(urticaAL, -30.0, 90.0, null);
			ArrayList<Specimen> south30AL = (new ContainerLatitude()).regionSort(urticaAL, -90.0, -30.0, null);
			
			//initialise values
			Double n30Sum = 0.0;
			Double n30Counter = 0.0;
			Double s30Sum = 0.0;
			Double s30Counter = 0.0;
			
			for (Specimen ns : north30AL) {
				n30Sum += ns.Height;
				n30Counter++;
			}
			for (Specimen ns : south30AL) {
				s30Sum += ns.Height;
				s30Counter++;
			}
			Double n30Mean = n30Sum / n30Counter; //calculate mean
			Double s30Mean = s30Sum / s30Counter;
			
			ArrayList<Specimen> solanumC = specimenIdHashMap.get("BN"); //grab corresponding arraylist
			ArrayList<Specimen> within50K = (new ContainerDistance()).regionSort(solanumC, -30.967, 75.430, 50.0);
			
			Double fiftyKSum = 0.0;
			Double fiftyKCounter = 0.0;
			
			for (Specimen fik : within50K) {
				fiftyKSum += fik.Height;
				fiftyKCounter++;
			}
			Double fiftyKMean = fiftyKSum / fiftyKCounter;
			
			System.out.println("");
			System.out.println("Mean height of species Urtica diodica north of latitude: -30 deg is: "+n30Mean+", and south of latitude -30 deg is: "+s30Mean);
			System.out.println("Mean height of species Solanum carolinense within 50km of latitude -30.967 deg and longitude 75.430 deg is: "+fiftyKMean);
			
			/**
			 * Part 3
			 */
			//grab the specimen from URL
			HashMap<String, ArrayList<Specimen>> specimenIdHashMapAnimal = Methods.speciesAsKeyHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/survey-animals.txt");
			ArrayList<Specimen> part3Animals = new ArrayList<Specimen>(); //Initialise arraylist
			
			for (String id : specimenIdHashMapAnimal.keySet()) {
				ArrayList<Specimen> idsArray = specimenIdHashMapAnimal.get(id);
				part3Animals.addAll(idsArray); //add all the animals to one Arraylist
			}
			
			//grab scientific name from URL
			HashMap<String, String> specimenDetailsHashMapAnimal = Methods.hashMapFromURLDetails("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2013-14/species-animals.txt");
		
			ArrayList<Specimen> within100K = (new ContainerDistance()).regionSort(part3Animals, -30.967, 75.430, 100.0); //arraylist of animals within 100k
			HashMap<String, Specimen> hmSpeciesNames = new HashMap<String, Specimen>(); //Initialise hashmap

			for (Specimen snP3 : within100K) {

				if (hmSpeciesNames.get(snP3.ID) == null) {
					String scienceyName = specimenDetailsHashMapAnimal.get(snP3.ID);
					hmSpeciesNames.put(scienceyName, snP3);
				}
				
			}
			System.out.println("");
			System.out.println("Names of animals found exclusively in the region: "+hmSpeciesNames.keySet());
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
