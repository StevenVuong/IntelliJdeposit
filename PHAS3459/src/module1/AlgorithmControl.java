package module1;

public class AlgorithmControl {
	
	 public void loop() {
		 //Initialising the start conditions and the necessary closing value
		 int i = 0; 
		 int maxN = 10;
		 //Creates 'for' loop with (<initial action>,<condition>,<loop action>)
		 for (i=0;i<=maxN;i++){ 
			 System.out.println("i = "+i);
		 }
	 	}
	 //
	 public void decrement() {
		 //Initialising conditions
		 int i = 5;
		 int maxN = -12;
		 //Creating 'while' condition
		 while (i>=maxN){
			 System.out.println("i = "+i);
			 i--;
		 }
	 	}
	 //
	 public void increment() {
		 //Initialising conditions
		 double i = 2.4;
		 double maxN = 8.801; //This value is slightly larger to account for the systems' counting method, it may be unnecessary but is just a precautionary measure
		 double add = 0.2;
		 
		 for (i=2.4;i<=maxN;i+=add){
			 System.out.println("i = "+i);
		 }
		 System.out.println("When this is printed, it doesn't come out as an integer due to the way the programme counts using bits,"); 
		 System.out.println("meaning accuracy is lost after several decimal places. This could be fatal when dealing with extremely precise figures or large figures");
	 }
	 //
	 public void timer() {
		 //Initialising conditions
		 int loopposition = 0;
		 long tenSecondsFromNow = System.currentTimeMillis() + 10000; 
		 
		 while (tenSecondsFromNow>= System.currentTimeMillis()) {
			 if (loopposition%100==0){ //When the remainder after dividing by 100 is 0, the 'IF' condition is met
				 System.out.println("10s timer - Current Number of Loops: "+ loopposition);
			 }
			 loopposition++;
		 }
	 }
	 // I decided to leave the timer() as it defaults(overloads) to 10ms when no parameters are entered upon invoking timer(x,y)
	 public int timer(long maxTime, int loopSteps) {
		 int loopposition = 0; //Initialising counter
		 
		 while (maxTime>= System.currentTimeMillis()) {
			 if (loopposition%loopSteps==0){ //Creates condition for printing
				 System.out.println("for "+maxTime+" mS timer - the number of loops so far is: "+loopposition);
			 }
			 loopposition++;
		 }
		 return loopposition;
	 }
	 //
	public static void main(String[] args) {
		//
		System.out.println("For loop of integers 1 to 10:");
		AlgorithmControl onetoten = new AlgorithmControl(); //Creating an object
		onetoten.loop(); //Invoking the object
		//
		System.out.println("");
		//
		System.out.println("While loop of integers 5 to - 12:");
		AlgorithmControl fivetwelve = new AlgorithmControl();
		fivetwelve.decrement();
		//
		System.out.println("");
		//
		System.out.println("For loop of numbers 2.4 to 8.8 in increments of 0.2:");
		AlgorithmControl twofoureight = new AlgorithmControl();
		twofoureight.increment();
		//
		System.out.println("");
		//
		AlgorithmControl timeTime0 = new AlgorithmControl();
		AlgorithmControl timeTime = new AlgorithmControl();
		timeTime.timer();
		//
		AlgorithmControl timeTime1 = new AlgorithmControl();
		timeTime1.timer(8000,1000);
		//
		AlgorithmControl timeTime2 = new AlgorithmControl();
		timeTime2.timer(8000,40000);
		
		//Declaring the output as an integer
		int loop0 = timeTime0.timer(10000,100);
		int loop1 = timeTime1.timer(8000,1000);
		int loop2 = timeTime2.timer(8000,40000);
		//Here I've attempted to run the three values parallel to each other. However, the method returns multiple values and so the value of 'loop0' either locks or constantly updates.
		//Regardless of which one it does, only one value is printed rather than the preferred of multiple iterations.
		System.out.println("First Loop(10s, prints every 100 loops): " + loop0 + " Second Loop(8s, prints every 1000 loops): " + loop1 + " Third Loop(8s, prints every 40000 loops): " + loop2);
		//
		
	}

}
