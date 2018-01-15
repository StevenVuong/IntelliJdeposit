package Final2011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StatisticOccurances implements StatisticInterface{

	public double statistic(HashMap<String, Region> allData, Double sumXXX, Double sumYYY, Double sumZZZ, Double sumAAA, Double sumBBB, Double population) {
		
		Double highestOccurancesXXX = 0.0;
		String highestOccurancesRegionXXX = "";
		Double highestStatisticalSignificanceXXX = 0.0;
		
		Double highestOccurancesYYY = 0.0;
		String highestOccurancesRegionYYY = "";
		Double highestStatisticalSignificanceYYY = 0.0;
		
		Double highestOccurancesZZZ = 0.0;
		String highestOccurancesRegionZZZ = "";
		Double highestStatisticalSignificanceZZZ = 0.0;
		
		Double highestOccurancesAAA = 0.0;
		String highestOccurancesRegionAAA = "";
		Double highestStatisticalSignificanceAAA = 0.0;
		
		Double highestOccurancesBBB= 0.0;
		String highestOccurancesRegionBBB = "";
		Double highestStatisticalSignificanceBBB = 0.0;
		
		Double sumOccurancesXXX = 0.0;
		Double sumOccurancesYYY = 0.0;
		Double sumOccurancesZZZ = 0.0;
		Double sumOccurancesAAA = 0.0;
		Double sumOccurancesBBB = 0.0;
		
		for (String id : allData.keySet()) {
			
			Region r = allData.get(id);
			
			//NumXXX Disease
			Double nationalAverageScalingExpectedXXX = (sumXXX / population) * r.Population;
			Double ExcessOccurancesXXX = nationalAverageScalingExpectedXXX - r.NumXXX;
			sumOccurancesXXX += ExcessOccurancesXXX;
			Double StatisticalSignificanceXXX = ExcessOccurancesXXX / (Math.sqrt(nationalAverageScalingExpectedXXX));
			
			if (ExcessOccurancesXXX > highestOccurancesXXX) {
				highestOccurancesXXX = ExcessOccurancesXXX;
				highestOccurancesRegionXXX = r.RegionName;
				highestStatisticalSignificanceXXX = StatisticalSignificanceXXX;
			}
			
			//NumYYY Disease 
			Double nationalAverageScalingExpectedYYY = (sumYYY / population) * r.Population;
			Double ExcessOccurancesYYY = nationalAverageScalingExpectedYYY - r.NumYYY;
			sumOccurancesYYY += ExcessOccurancesYYY;
			Double StatisticalSignificanceYYY = ExcessOccurancesYYY / (Math.sqrt(nationalAverageScalingExpectedYYY));
			
			if (ExcessOccurancesYYY > highestOccurancesYYY) {
				highestOccurancesYYY = ExcessOccurancesYYY;
				highestOccurancesRegionYYY = r.RegionName;
				highestStatisticalSignificanceYYY = StatisticalSignificanceYYY;
			}
			
			
			//NumZZZ Disease 
			Double nationalAverageScalingExpectedZZZ = (sumZZZ / population) * r.Population;
			Double ExcessOccurancesZZZ = nationalAverageScalingExpectedZZZ - r.NumZZZ;
			sumOccurancesZZZ += ExcessOccurancesZZZ;
			Double StatisticalSignificanceZZZ = ExcessOccurancesZZZ / (Math.sqrt(nationalAverageScalingExpectedZZZ));
			
			if (ExcessOccurancesZZZ > highestOccurancesZZZ) {
				highestOccurancesZZZ = ExcessOccurancesZZZ;
				highestOccurancesRegionZZZ = r.RegionName;
				highestStatisticalSignificanceZZZ = StatisticalSignificanceZZZ;
			}
			
			//NumAAA Disease 
			Double nationalAverageScalingExpectedAAA = (sumAAA / population) * r.Population;
			Double ExcessOccurancesAAA = nationalAverageScalingExpectedAAA - r.NumAAA;
			sumOccurancesAAA += ExcessOccurancesAAA;
			Double StatisticalSignificanceAAA = ExcessOccurancesAAA / (Math.sqrt(nationalAverageScalingExpectedAAA));
			
			if (ExcessOccurancesAAA > highestOccurancesAAA) {
				highestOccurancesAAA = ExcessOccurancesAAA;
				highestOccurancesRegionAAA = r.RegionName;
				highestStatisticalSignificanceAAA = StatisticalSignificanceAAA;
			}
			
			//NumBBB Disease 
			Double nationalAverageScalingExpectedBBB = (sumBBB / population) * r.Population;
			Double ExcessOccurancesBBB = nationalAverageScalingExpectedBBB - r.NumAAA;
			sumOccurancesBBB += ExcessOccurancesBBB;
			Double StatisticalSignificanceBBB = ExcessOccurancesBBB / (Math.sqrt(nationalAverageScalingExpectedBBB));
			
			if (ExcessOccurancesBBB > highestOccurancesBBB) {
				highestOccurancesBBB = ExcessOccurancesBBB;
				highestOccurancesRegionBBB = r.RegionName;
				highestStatisticalSignificanceBBB = StatisticalSignificanceBBB;
			}
			
		
			
			
		}
		System.out.println("");
		System.out.println("For XXX: ");
		System.out.println("Region with highest occurances: "+highestOccurancesRegionXXX);
		System.out.println("Occurances: "+highestOccurancesXXX);
		System.out.println("Statistical Significance: "+highestStatisticalSignificanceXXX);
		
		System.out.println("");
		System.out.println("For YYY: ");
		System.out.println("Region with highest occurances: "+highestOccurancesRegionYYY);
		System.out.println("Occurances: "+highestOccurancesYYY);
		System.out.println("Statistical Significance: "+highestStatisticalSignificanceYYY);
		
		System.out.println("");
		System.out.println("For ZZZ: ");
		System.out.println("Region with highest occurances: "+highestOccurancesRegionZZZ);
		System.out.println("Occurances: "+highestOccurancesZZZ);
		System.out.println("Statistical Significance: "+highestStatisticalSignificanceZZZ);
		
		System.out.println("");
		System.out.println("For AAA: ");
		System.out.println("Region with highest occurances: "+highestOccurancesRegionAAA);
		System.out.println("Occurances: "+highestOccurancesAAA);
		System.out.println("Statistical Significance: "+highestStatisticalSignificanceAAA);
		
		System.out.println("");
		System.out.println("For BBB: ");
		System.out.println("Region with highest occurances: "+highestOccurancesRegionBBB);
		System.out.println("Occurances: "+highestOccurancesBBB);
		System.out.println("Statistical Significance: "+highestStatisticalSignificanceBBB);
		
		/**
		 * last part of part 2?
		 */
		System.out.println("");
		Double meanOccurancesXXX = sumOccurancesXXX / allData.keySet().size();
		Double meanOccurancesYYY = sumOccurancesYYY / allData.keySet().size();
		Double meanOccurancesZZZ = sumOccurancesZZZ / allData.keySet().size();
		Double meanOccurancesAAA = sumOccurancesAAA / allData.keySet().size();
		Double meanOccurancesBBB = sumOccurancesBBB / allData.keySet().size();
		
		for (String id : allData.keySet()) {
			
			Region r = allData.get(id);
				
		}
		
		return 0;
	}
	
	
	public static ArrayList<Double> diseaseSpecific(String disease) throws MalformedURLException, IOException {
		
		HashMap<String, Region> allDataHM = Methods.readDataHM();
		ArrayList<Double> diseaseAL = new ArrayList<Double>();
		
		for (String id : allDataHM.keySet()) {
			
			Region r = allDataHM.get(id);
			
			if (disease.equals("NumXXX")) {
				diseaseAL.add(r.NumXXX);
			}
			if (disease.equals("NumYYY")) {
				diseaseAL.add(r.NumYYY);
			}
			if (disease.equals("NumZZZ")) {
				diseaseAL.add(r.NumZZZ);
			}
			if (disease.equals("NumAAA")) {
				diseaseAL.add(r.NumAAA);
			}
			if (disease.equals("NumBBB")) {
				diseaseAL.add(r.NumBBB);
			}
			//Calc standard dev?
		}
		
		return diseaseAL;
	}
}

