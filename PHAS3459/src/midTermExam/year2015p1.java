package midTermExam;

//import necessary classes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class year2015p1 {

	
	public static year2015p2 parseLine(String line) {
		// Return a Earthquake object containing all the data of one Earthquake. 
		Scanner mult = new Scanner(line);
		mult.useDelimiter("\t"); // Set up new scanner to analyse multiple numbers in the same line of the input file
		
		// Put the data in each column of the input file into each of these variables. 
		int year = Integer.parseInt(mult.next()); 
		int month = Integer.parseInt(mult.next()); 
		int day = Integer.parseInt(mult.next()); 
		int hour = Integer.parseInt(mult.next()); 
		int minute = Integer.parseInt(mult.next()); 
		double second = Double.parseDouble(mult.next()); 
		double lat = Double.parseDouble(mult.next()); 
		double lon = Double.parseDouble(mult.next()); 
		double depth = Double.parseDouble(mult.next()); 
		double eh1 = Double.parseDouble(mult.next()); 
		double eh2 = Double.parseDouble(mult.next()); 
		int az = Integer.parseInt(mult.next()); 
		double ez = Double.parseDouble(mult.next()); 
		double mag = Double.parseDouble(mult.next()); 
		int id = Integer.parseInt(mult.next()); 
		
		mult.close(); // Close scanner
		return new year2015p2(year, month, day, hour, minute, second, lat, lon, depth, eh1, eh2, az, ez, mag, id); // Output as a new object containing all of the data. 
}
}
	
