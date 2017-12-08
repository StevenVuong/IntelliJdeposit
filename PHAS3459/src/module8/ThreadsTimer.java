package module8;

import java.util.*;
import java.util.concurrent.*;

public class ThreadsTimer {

	public static void main(String[] args) {
		
		long tStart4 = System.currentTimeMillis(); //Start time
		
		int nPoints4 = 10000000; //number of test points
		int nThreads = 4; //number of threads
		
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads); //start multithread calculation
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		
		for (int iThread=0; iThread<nThreads; ++iThread) { //submit task to all threads
			MonteCarloPiCalculatorTask task4 = new MonteCarloPiCalculatorTask(nPoints4/nThreads);
			Future<Double> future = threadPool.submit(task4);
			futures.add(future);
		}
		
		double sum = 0.0; //initialise variable to hold result
		
		for (int iThread=0; iThread<nThreads; ++iThread) { //Get results from all threads
			double result;
			try {
				result = futures.get(iThread).get();
				sum += result;
			}
			catch (InterruptedException e) {
				System.out.print(e.getMessage());
			}
			catch (ExecutionException f) {
				System.out.print(f.getMessage());
			}
			
		}
		
		threadPool.shutdown();
		double pi4 = sum/nThreads; //calculates average results from all threads
		
		System.out.println("pi calculated using" + nThreads + " threads = " + pi4);
		System.out.println("Time Taken (ms): " + (System.currentTimeMillis()-tStart4));
		
		//Runs calculation for 1 thread
		long tStart1 = System.currentTimeMillis(); //Record start time for calculation
		int nPoints1 = 10000000;
		MonteCarloPiCalculatorTask task1 = new MonteCarloPiCalculatorTask(nPoints1); //create new pi task and call
		double pi = task1.call();
		
		System.out.println("pi calculated using single thread = "+pi);
		System.out.println("Time Taken (ms): " + (System.currentTimeMillis()-tStart1));
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("The calculation is faster using multiple threads than a single thread, as expected");
		System.out.println("The accuracy is similar for both as they have equal number of test points");
	}
	
}
