package midTermExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Rainfall2013 {
	
	//method which parses double values from a year onto a string
	public static ArrayList<Double> parseLine(String line){
		
		ArrayList<Double> year_array = new ArrayList<Double>(); //initialise array for data of one year to go into
		Scanner sc = new Scanner(line);
		
		while (sc.hasNext()) { //condition to go through all the values in the line
			String token = sc.next();
			year_array.add(Double.parseDouble(token));
		}
		
		return year_array; 
		
	}
	
	//Makes data neater.. Puts into a string with all the necessary information
	public static String getDetails(ArrayList<Double> data) {
		
		StringBuilder s = new StringBuilder();
		s.append( "\nYear: " + data.get(0));
		
		for (int i = 1; i < data.size() -1; i++) {
			s.append("\nMonth: " + i + " : " + data.get(i));
		}
		
		s.append( "\nAnnual: " + data.get(13));
		
		return s.toString();
		
	}
	
	//method which creates buffered reader object from url to obtain data from and parses into arraylist
	public static ArrayList<ArrayList<Double>> dataFromURL(String urlName) throws Exception {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		
		ArrayList<ArrayList<Double>> arrayOfYears = new ArrayList<>(); //initialise array of years containing rainfall data array
		String line = "";  // Initialise string so that it is not initially null for the while loop below
		
		//ignore first 4 lines
		b.readLine();
		b.readLine();
		b.readLine();
		b.readLine();
		
		//loops through each line and adds the data to an array for a year before adding to an array of years and their data
		while ((line = b.readLine()) != null) {
			if(Character.isLetter(line.charAt(0))) continue;
			ArrayList<Double> dataLine = parseLine(line);
			if(!(dataLine.isEmpty())) arrayOfYears.add(dataLine);
		}
		
		return arrayOfYears;
	}
	
	//finds the wettest month
	public static void wettestMonth(ArrayList<ArrayList<Double>> arrayOfYears) {
		
		//initialise variables
		double maxRain = Double.MIN_VALUE; 
		ArrayList<Double> wettestMonthYear = new ArrayList<Double>();
		double wettestMonth = 0.0;
		
		for (ArrayList<Double> yr : arrayOfYears) { //loops through each year
			for (int i = 1; i < 13; i++) {
				if (yr.get(i) > maxRain) {
					maxRain = yr.get(i);
					wettestMonthYear = yr;
					wettestMonth = i;
				}
			}
		}
		System.out.println("Wettest Month: " + wettestMonth + "with info: " + getDetails(wettestMonthYear) );
	}
	
	//finds the wettest & driest year for each month and calculates the total rainfall for that month and the rms value
	public static void wettestYearEachMonth(ArrayList<ArrayList<Double>> data) {
		
		for (int i = 1; i < 13; i++) {
			
			//initilaise variables
			double maxRainfall = Double.MIN_VALUE;
			double minRainfall = Double.MAX_VALUE;
			double rainfallTotal = 0;
			double rainfallTotalSquare = 0;
			
			for (ArrayList<Double> annual : data) {
				double month = annual.get(i) ;
				if (month > maxRainfall) {
					maxRainfall = month;
				}
				if (month < minRainfall) {
					minRainfall = month;
				}
				rainfallTotal += month;
				rainfallTotalSquare += (month * month);
			}
			
			double averageRainfall = (rainfallTotal / data.size());
			double rmsRainfall = Math.sqrt(rainfallTotalSquare / data.size());
			
			System.out.println("\n for Month: " + i + ", has max rain: " + maxRainfall + ", and min rain: " + minRainfall + ", and average rain: "
					+ averageRainfall + ", and rms rainfall: " + rmsRainfall);
		}
	}
	
	//finds the wettest and wettest three month period and the total rainfall of this period
	
}
