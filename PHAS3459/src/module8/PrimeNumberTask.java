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

	int largestInteger;
	/**
	 * Check if number is prime, adds any prime numbers found to arraylist
	 * Run until interrupted
	 */
	public void run() {
		int i = 1; //ignore 0 and 1
		while (true) {
			if (isPrime(i)) {
				primeNumberList.add(i); //Add number to primenumber list if prime
			} 
			if (Thread.currentThread().isInterrupted()) {
		
				int maxPrimeValue = getMaxPrime(primeNumberList);
				
				System.out.println("Largest Integer: " + largestInteger); 
				System.out.println("Largest Prime Number: " + maxPrimeValue);
				System.out.println("Number of Prime Numbers found: " + primeNumberList.size());
				
				return; 
			}
			largestInteger = i;
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
		if (j>num) {return false;}
		while (j<num) {
			if (num % j == 0) return false; //test if numbers are divisible by integer >1
			j++;
		}
		return true;
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
