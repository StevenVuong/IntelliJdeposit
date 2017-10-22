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
	  try {
	    String s = b.readLine();
	    System.out.println("You typed: "+s);
	  }
	  catch (IOException e) {
	    System.out.println("Problem: "+e.getMessage());
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