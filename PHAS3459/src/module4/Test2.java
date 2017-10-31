package module4;

import java.io.*;

public class Test2 {
	 InputStreamReader r = new InputStreamReader(System.in);
	  BufferedReader b = new BufferedReader(r);
	  
	public static void main(String[] args) {
//		int CARRIAGE_RETURN = 10;
//		int av;
//		System.out.println("Type something please!");
//		try {
//			do {
//				av = System.in.read();
//				char avc = (char) av;
//				System.out.println(av + ": " + avc);
//			} while (av != CARRIAGE_RETURN);
//		} catch (java.io.IOException e) {
//			System.out.println("Problem: " + e.getMessage());
//		}
//		System.out.println("Thank you!");
//	


		System.out.println("Please type something!");
/*	  try {
//	    String s = b.readLine();
//	    System.out.println("You typed: "+s);
	  }
	  catch (IOException e) {
	    System.out.println("Problem: "+e.getMessage());
	  }*/
	}
}

//	//adding all numbers in text
//	  try (
//			    BufferedReader r = new BufferedReader(new FileReader(file));
//			    Scanner s = new Scanner(r);
//			  ) {
//			    double sum = 0;
//			    while (s.hasNext()) {
//			      String token = s.next();
//			      try {
//			        double x = Double.parseDouble(token);
//			        sum += x;
//			      } catch (NumberFormatException e) {
//			        // Ignore anything that is not a number!
//			      }
//			    }
//			  }
	
	
	
	
	
//	Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)"); // define regex, find numbers and includes integers
//	Matcher matcher = regex.matcher(line); // make matcher object, constructed from regex
//	while (matcher.find()) { // while there's a match, continue to do this, finds subsequence of input
//								// sequence
//		double a = Double.parseDouble(matcher.group(1)); // returns
//		nValues++;
//		sumOfValues = sumOfValues + a;
//		if (a < minValue) {
//			minValue = a;
//		}
//		if (a > maxValue) {
//			maxValue = a;
//		}
//		System.out.println(a);
//
	
	
	// Insert numbers read in
	// double a = Double.parseDouble(numLine);
	// String[] arrayOfStringBasedNumbers = numLine.trim().split(" "); // which
	// returns number array split at
	// // spaces
	//
	// for (int i = 0; i < arrayOfStringBasedNumbers.length; i++) {
	// nValues++;
	// sumOfValues = sumOfValues + a;
	// if (a < minValue) {
	// minValue = a;
	// }
	// if (a > maxValue) {
	// maxValue = a;
	// }
	// }
	
	
	// double a = Double.parseDouble();
	// String numLine = line.replaceAll("[^\\d]+", " "); // This returns the numbers