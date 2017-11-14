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
		//	if (token.equals("2012")) break;
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
		
		for (int i = 1; i < 13; i++) { //loops through each month
			
			//initilaise variables
			double maxRainfall = Double.MIN_VALUE;
			double minRainfall = Double.MAX_VALUE;
			double rainfallTotal = 0;
			double rainfallTotalSquare = 0;
			
			//loops through each year and sets maximum and minimum rainfall
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
	public static void wettestThreeMonths(ArrayList<ArrayList<Double>> data) {
		
		//initialise variables
		double maxRainfallThreeMonth = Double.MIN_VALUE;
		ArrayList<Double> yearFinal = null;
		int finalMonth = 0;
		
		for (int j = 0; j < data.size(); j++) { //loops through all the years
			ArrayList<Double> yearIndex = data.get(j); //grabs the current year and makes an array 
			for (int i = 3; i < 13; i++) {
				double threeMonthRainfall = (yearIndex.get(i) + yearIndex.get(i-1) + yearIndex.get(i-2)); //calculates sum of rainfall for three consecutive months
				if (threeMonthRainfall > maxRainfallThreeMonth) {
					maxRainfallThreeMonth = threeMonthRainfall;
					yearFinal = yearIndex;
					finalMonth = i;
				}
			}
		}
		
		System.out.println("Wettest three month period between month: " + (finalMonth-2) + " and " + (finalMonth) + ",in year: " + 
		yearFinal + ", with rainfall amount: " + maxRainfallThreeMonth);
		
	}
	
	public static void finalYearAnalysis(ArrayList<ArrayList<Double>> data) {
		
		ArrayList<Double> finalYear = data.get((data.size() -1 )); //creates an array of final year values
		int counter = 0;
		
		for (int i = 1; i < 13; i++) { //loops for each month
			counter = 0; //reset counter for each month
			for (int j = 0; j < data.size() - 1; j++) {
				ArrayList<Double> year = data.get(j) ;
				if (year.get(i) > finalYear.get(i)) { //condition to add to the counter
					counter++;
				}
			}
		
			double percentage = (counter/(data.size())) * 100;
			System.out.println("the percentage of previous years with greater rainfall for month: " + i + ", is " + percentage + "%");
			
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			ArrayList<ArrayList<Double>> data = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/HadEWP_monthly_qc.txt");
			ArrayList<ArrayList<Double>> dataForFinalYear = data;
			data.remove(data.size()-1); //removes 2012 (invalid) entry
			
			//runs methods
			wettestMonth(data);
			wettestYearEachMonth(data);
			wettestThreeMonths(data);
			finalYearAnalysis(dataForFinalYear);
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());

		}
		
	}
	
}
