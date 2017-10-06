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
		 long maxTime1 = maxTime + System.currentTimeMillis();
		 
		 while (maxTime1>= System.currentTimeMillis()) {
			 if (loopposition%loopSteps==0){ //Creates condition for printing
				 System.out.println("for "+maxTime+" mS timer with counting every "+loopSteps+" loops - the total number of loops so far is: "+loopposition);
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
		//Creating objects
		AlgorithmControl timeTime0 = new AlgorithmControl();
		AlgorithmControl timeTime1 = new AlgorithmControl();
		AlgorithmControl timeTime2 = new AlgorithmControl();
		//Declaring the output as an integer and setting parameters 
		int loop0 = timeTime0.timer(10000,100); //10s, counts every 100 loops
		int loop1 = timeTime1.timer(8000,1000); //8s, counts every 1000 loops
		int loop2 = timeTime2.timer(8000,40000); //8s, counts every 40,000 loops
		//
		System.out.println(" ");
		//
		System.out.println("N.o of loops for 10s, counting every 100 loops: " + loop0);
		System.out.println("N.o of loops for 8s, counting every 1000 loops: "+loop1);
		System.out.println("N.o of loops for 8s, counting every 40,000 loops: "+loop2);
		//
		System.out.println("");
		//Increasing multiple, less to do between each iteration, able to run more interations. Counting itself slows it down so are less iterations. IF condition 
		System.out.println("The number of loops completed increases from 10s to 8s despite the amount of time increasing,");
		System.out.println("This factor is due to the fact that the program has to count more often, therefore slowing it down");
		System.out.println("as it has to run more iterations. This example is shown further when counting every 40,000 loops.");
		System.out.println("As there gap between is greater, there is less for the program to do between each iteration, allowing");
		System.out.println("it to run more iterations as the act of counting slows down the operation. This effect and difference");
		System.out.println("could be exaggerated by further slowing down the CPU by e.g. running more background processes");
	}

}
