package module8;

import java.util.ArrayList;

/**
 * Main class to run Countdown task and PrimeNumberTask in their own thread
 * @author Steven Vuong
 * @version: 07-12-2017
 */

public class ThreadsMain {
	
	public static void main(String[] args) {
		try {
			//Create objects to countdown and to calculate primes
			CountdownTask cdt = new CountdownTask(10);
			PrimeNumberTask pnt = new PrimeNumberTask();
			
			//Start threads to run above tasks
			Thread cdtThread = new Thread(cdt);
			Thread pntThread = new Thread(pnt);
			
			//Wait for CountdownTask to finish before interrupting primeNumberTask
			cdtThread.join(); 
			pntThread.interrupt();
			
			int maxPrimeValue = getMaxPrime(pnt.primeNumberList);
			
			System.out.println("Largest Integer: " + pnt.numbersTested); 
			System.out.println("Largest Prime Number: " + maxPrimeValue);
			System.out.println("Number of Prime Numbers found: " + pnt.primeNumberList.size());
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Finds maximum number in an array
	 * @param Arraylist of prime integers
	 * @return integer of maximum prime number
	 */
	public static int getMaxPrime(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE; //initialise the maximum value
		for (int i=0; i<list.size(); i++) { //loop through arrayList
			if(list.get(i) > max) { //compares value to max value and replaces if greater
				max = list.get(i);
			}
		}
		return max;
	}
	

}
