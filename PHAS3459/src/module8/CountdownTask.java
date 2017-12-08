package module8;

/**
 * Class to count down from an inputted number of seconds
 * Implements the runnable interface
 * 
 * @author Steven Vuong
 * @version: 07-12-2017
 */


public class CountdownTask implements Runnable{
	
	int time;
	
	/** 
	 * Constructs a countdown object for a given number of seconds
	 * @param seconds Number of seconds to count down
	 */
	public CountdownTask(int seconds) {
		this.time = seconds;
	}
	
	/**
	 * Counts down from given seconds in object when called
	 */
	public void run() {
		
		while (time >= 1) { 
			try {
				Thread.sleep(1000); //Pause for 1 second for given times until t=0
				System.out.println("Time Remaining: "+(time-1));
				time--;//Reduce the timer by 1 second
			}
			catch (InterruptedException e) { //Stop early if main thread is interrupted (or runs forever)
				System.out.println(e);
			}
		}
	}
	

}
