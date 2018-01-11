package Final2012;

/**
 * Import necessary modules
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			/**
			 * Part 1
			 */
			//Grab data from URL as ArrayLists
			ArrayList<Event> backgroundGG = Methods.dataFromURLBackground("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/backgroundGG.txt");
			ArrayList<Event> backgroundZZ = Methods.dataFromURLBackground("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/backgroundZZ.txt");
			
			//Initialise variables
			Double sumBackgroundEventsPredictedGG = 0.0;
			Double sumBackgroundEventsPredictedZZ = 0.0;
			
			for (Event eG : backgroundGG) { //Loop through ArrayList
				
				if ((eG.lowEdge >= 120) && (eG.highEdge <= 140)) { //Condition for region of background event
					
					sumBackgroundEventsPredictedGG += eG.predictedNumberEvents;
					
				}
				
			}
			for (Event eZ : backgroundZZ) { //Loop through ArrayList
				
				if ((eZ.lowEdge >= 120) && (eZ.highEdge <= 140)) { //Condition for region of background event
					
					sumBackgroundEventsPredictedZZ += eZ.predictedNumberEvents;
					
				}
				
			}
			
			System.out.println("Number of predicted background events for GG between 120-140 GeV: "+sumBackgroundEventsPredictedGG);
			System.out.println("Number of predicted background events for ZZ between 120-140 GeV: "+sumBackgroundEventsPredictedZZ);
			System.out.println("");
			
			//Grabs higgs data
			ArrayList<Higgs> higgsArray = Methods.dataFromHiggs("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/higgsData.txt");
			
			//Create hashmaps for each channel with their keys as energy
			HashMap<Double, ArrayList<Higgs>> ggChannel = Methods.EnergyHashMap(higgsArray, "GG");
			HashMap<Double, ArrayList<Higgs>> zzChannel = Methods.EnergyHashMap(higgsArray, "ZZ");
			
			//Initialise variables
			Double sumBackgroundEventsHiggsGG = 0.0;
			Double sumBackgroundEventsHiggsZZ = 0.0;
			
			for (Double i : ggChannel.keySet()) { //loop through keyset
				
				ArrayList<Higgs> iArray = ggChannel.get(i); //Grab arraylist
				
				if ((i >= 120.0) && (i <= 140)) { //Condition to count (typo 240 -> 140)
					
					sumBackgroundEventsHiggsGG += iArray.size();
					
				}
				
			}
			for (Double i : zzChannel.keySet()) { //loop through keyset
				
				ArrayList<Higgs> iArray = zzChannel.get(i); //Grab arraylist
				
				if ((i >= 120.0) && (i <= 140)) { //Condition to count (typo 240 -> 140)
					
					sumBackgroundEventsHiggsZZ += iArray.size();
					
				}
				
			}
			
			System.out.println("Number of real background events for GG between 120-140 GeV: "+sumBackgroundEventsHiggsGG);
			System.out.println("Number of real background events for ZZ between 120-140 GeV: "+sumBackgroundEventsHiggsZZ);
			
			// Gets the log likelyhoods of each value
			Double logLikelyhoodGG = Methods.logLikelyhood(backgroundGG, ggChannel);
			Double logLikelyhoodZZ = Methods.logLikelyhood(backgroundZZ, zzChannel);
			
			System.out.println("");
			System.out.println("Log likelyhood for GG: "+logLikelyhoodGG);
			System.out.println("LogLikelyhood for ZZ: "+logLikelyhoodZZ);
			
			/**
			 * Part 2 & 3
			 */
			//Initialise variables
			//channel a
			Double NA = 100.0;
			Double SigmaA = 2.0;
			Double MassA = 110.5;
			Double LLsumA = 0.0;
			double lowestMassA = 0.0;
			double LowestLogA = 1000000.0;
			
			while (MassA < 179.6) { //produce 80 signal productions
			HashMap<Double, Double> partA = (new PredictionGaussian()).prediction(NA, MassA, SigmaA);
			
			for (Double d : partA.keySet()) { //loops through energy bins
				
				/**
				 * The yi calculation is wrong, the values returned for it are way too low.. Problem may lie in PredictionGaussian
				 */
				double yi = partA.get(d); //grabs predicted number for that energy set
				
				for (Event eG : backgroundGG) { //loops through background GG prediction values
					
					if ((d - eG.lowEdge) < 0.51) {
						
						double ni = eG.predictedNumberEvents;
						double LL = (yi - ni) + (ni * Math.log(ni/yi));
						if (LL < LowestLogA) {
							LowestLogA = LL;
							lowestMassA = MassA;
						}
						LLsumA += LL;
						
						
					}
					
				}
				
				}
			
			MassA = MassA + 1;
			
			}
			System.out.println("Channel GG, Lowest mass is: "+lowestMassA);
		
			//channel b
			Double NB = 6.0;
			Double SigmaB = 1.0;
			Double MassB = 110.5;
			double LLsumB = 0.0;
			double lowestMassB = 0.0;
			double LowestLogB = 1000000.0;
			while (MassB < 179.5) {
			HashMap<Double, Double> partB = (new PredictionGaussian()).prediction(NB, MassB, SigmaB);
			for (Double d : partB.keySet()) {
				
				double yi = partB.get(d);
				
				for (Event eZ : backgroundZZ) { //Loop through ArrayList
					
					if ((d - eZ.lowEdge) < 0.51) {
						
						double ni = eZ.predictedNumberEvents;
						double LL = (yi - ni) + (ni * Math.log(ni/yi));
						if (LL < LowestLogB) {
							LowestLogB = LL;
							lowestMassB = MassB;
						}
						LLsumB += LL;
					}
					
				}
				}
			//System.out.println("log likelyhood for mass: "+MassB+"is "+LLsum);
			MassB = MassB + 1;
			//Produce 80 signal predictions
			}
			System.out.println("Channel ZZ, Lowest mass is: "+lowestMassB);
			
			double sigmaz = Math.pow(-2*(LLsumB-LLsumA), 0.5);
			
			System.out.println("");
			System.out.println(sigmaz);
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
