package module8;

/**
 * Main class to run Countdown task and PrimeNumberTask in their own thread
 * @author Steven Vuong
 * @version: 07-12-2017
 */

public class ThreadsMain {
	
	public static void Main(String[] args) {
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
			
			System.out.println("Largest Integer: " + pnt.numbersTested); 
			System.out.println("Largest Prime Number: " + pnt.primeNumberList.get(pnt.primeNumberList.size()-1));
			System.out.println("Number of Prime Numbers found: " + pnt.primeNumberList.size());
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
