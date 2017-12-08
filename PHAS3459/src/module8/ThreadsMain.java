package module8;

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
			
			//Create threads of objects
			Thread cdtThread = new Thread(cdt);
			Thread pntThread = new Thread(pnt);
			
			//Start threads to run above tasks
			cdtThread.start();
			pntThread.start();
			
			//Wait for CountdownTask to finish before interrupting primeNumberTask
			cdtThread.join(); 
			pntThread.interrupt();
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	


}
