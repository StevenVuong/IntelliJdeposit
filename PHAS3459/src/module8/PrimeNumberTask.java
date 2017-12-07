package module8;

import java.util.ArrayList;

/**
 * Class to check if numbers are prime or not
 * Implements the runnable interface
 * 
 * @author Steven Vuong
 * @version: 07-12-2017
 */

public class PrimeNumberTask implements Runnable {

	ArrayList<Integer> primeNumberList = new ArrayList<Integer>(); //Initialise arraylist of prime numbers
	int numbersTested;
	
	/**
	 * Check if number is prime, adds any prime numbers found to arraylist
	 * Run until interrupted
	 */
	public void run() {
		int i = 1; //ignore 0 and 1
		while (true) {
			if (Thread.currentThread().isInterrupted()) return; //Stop if interrupted
			if (isPrime(i)) primeNumberList.add(i); //Add number to primenumber list if prime
			numbersTested = i;
			i++;
		}
	}
	
	
	/**
	 * Check if integer is prime
	 * @param num Integer to be tested
	 * @return boolean if prime
	 */
	public static boolean isPrime(int num) {
		int j=2;
		while (j<num) {
			if (num % j == 0) return false; //test if numbers are divisible by integer >1
		}
		return true;
	}

}
