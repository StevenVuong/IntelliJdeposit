package midTermExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Rainfall2013 {

	//method which creates buffered reader object from url to obtain data from
	public static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		return new BufferedReader(isr);
		
	}
	
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
	
	
}
