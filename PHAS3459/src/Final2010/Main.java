package Final2010;
/**
 * Class with main method for 2010 Java Final Exam
 * @author SID: 15011252
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			//Grabs arraylist of data from URL
			ArrayList<Reading> readingsData = Methods.readingsFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/final/readings.txt");
			//Creates hashmap with data types as key
			HashMap<String, ArrayList<Reading>> readingsHashMap = Methods.readingsHashMap(readingsData);
			//Grabs arraylist of stations (takes a long time to compile due to large dataset
			ArrayList<Station> stationsArrayList = Methods.stationsArrayList("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/final/stations.txt");
			
			ArrayList<Reading> temperatureMeasurements = readingsHashMap.get("TMAX");
			Double highestTemperature = 0.0;
			Reading highestReading = null;
			
			for (Reading r : temperatureMeasurements) { //loop through all temperature measurements to find highest temperature
				
				for (Double data : r.data) {
					if (data > highestTemperature) {
						highestTemperature = data;
						highestReading = r;
					}
				}
				
			}
			System.out.println("Highest Temperature: "+highestTemperature);
				
			/**
			 * Cross check data again to see if highest temperature ever occurs again, print the details
			 */
			for (Reading r : temperatureMeasurements) { //loop through all temperature measurements
				
				for (Double data : r.data) { //loop through the datapoints
					if (data.equals(highestTemperature)) {
						String country = Methods.returnCountryCrossReference(r.Id);
						String stationName = "";
						for (Station s : stationsArrayList) {
							if (r.Id.equals(s.StationID)) {
								stationName = s.StationName; //finds the station name
							}
						}
						System.out.println("Date: "+ r.Year+":"+r.Month+", Country: "+country+", Station Name: "+stationName);
					}
				}
				
			}
			
			/**
			 * Part 2 (commented out)
			 * Part 3 (uses interface to calculate now)
			 */
			ArrayList<Reading> maxTempMeasurements = readingsHashMap.get("TMAX"); //grab arraylist of mean max temperatures 
			double part3CalcA = (new StatisticLowMeanMax()).statistic(maxTempMeasurements); //process this with interface 
			//Methods.calcLowestMeanMaxTemp(maxTempMeasurements);
			
			HashMap<Integer, ArrayList<Reading>> yearsHM = Methods.YearAsKey(readingsData); //create hashmap with year as the key
			
			for (Integer year : yearsHM.keySet()) { //loop through years
				
				ArrayList<Reading> yearlyAL = yearsHM.get(year); //create arraylist of values corresponding to the year
				double part3CalcB = (new StatisticLowMeanMax()).statistic(yearlyAL); //process lowest mean max with interface
				//Methods.calcLowestMeanMaxTemp(yearlyAL);
				
				if (year.equals(1966)) {
					double part3CalcC = (new StatisticRMS()).statistic(yearlyAL); //calculates for 1996 the rms difference
				}
				
			}
			
			
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}



}
