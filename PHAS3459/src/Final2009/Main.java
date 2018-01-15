package Final2009;
/**
 * Main method for java Final 2009
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			Method.writeToFile(); //writes to file
			
			System.out.println("");
			System.out.println("Using Regular Class:");
			
			Method.maximumSbRatio(); //calculates maximum Signal-Background ratio and gives the energy at which it occurs
			
			System.out.println("");
			System.out.println("Using Interface Class:");
			
			String urlSignal = "http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/final/eox-signal.txt";
			String urlBackground = "http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2009-10/final/eox-background.txt";
			
			double startTimeSb = System.currentTimeMillis();
			double sb = (new MetricCutoffOriginal()).cutOff(urlSignal, urlBackground, 1.0);
			double totalTimeSb = System.currentTimeMillis() - startTimeSb;
			
			System.out.println("");
			
			double startTimeSb1 = System.currentTimeMillis();
			double sb1 = (new MetricCutoffTwist()).cutOff(urlSignal, urlBackground, 1.0);
			double totalTimeSb1 = System.currentTimeMillis() - startTimeSb1;
			
			System.out.println("");
			System.out.println("These both give the same energy value output");
			
			if (totalTimeSb > totalTimeSb1) {
				System.out.println("However non square root background has a faster computation");
			}
			else System.out.println("However square root background has a faster computation and is more optimised");
			
			
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
