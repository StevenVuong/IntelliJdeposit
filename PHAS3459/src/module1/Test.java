package module1;

public class Test {
	 public Test() { }

	 public double sin2Theta (double theta){
		 double y;
		 // Convert input from degrees
		 double arad = Math.toRadians(theta);
		 // Example use of a
		 // Java math function:
		 y = 2.0*Math.sin(arad)*Math.cos(arad);
		 return y;
		}
		
	   public static void main (String[] args){
		 Test ss = new Test();
		 double angle = 45.0;
		
		 // Call our function:
		 double sin2t = ss.sin2Theta(angle);
			System.out.println(sin2t);
			
			
			double a=1.0;
			double b=1.0;
			double c=1.0;
			double d=1.0;
			 // Example use of "if; else if; else"
			 if (a > b) {
			 // Code written here is executed if:
			 // (1) a is greater than b
			 }
			 else if ( a > c ) {
			 // Code written here is executed if:
			 // (1) the block above was NOT executed,
			 // and
			 // (2) a is greater than c
			 }
			 else if ( a > d ) {
			 // Code written here is executed if:
			 // (1) Neither of the blocks above
			 // was executed,
			 // and
			 // (2) a is greater than d
			 }
			 else {
			 // Code written here is executed if:
			 // (1) None of the blocks above
			 // was executed.
			 }
			 
			 // greater than or less than
			 if (a > b) { }
			 if (a < b) { }
			 // greater/less than or equal to
			 if (a >= b) { }
			 if (a <= b) { }
			 // equality
			 if (a == b) {}
			 if (a != b) {}
			 // you can AND and OR tests
			 if ( (a > b) && (b > c) ) {}
			 if ( (a > b) || (b > d) ) {}
			 // etc.
			 
			 
			 int month = 3;
			 // Note the syntax of the "case"
			 // statement including the colon.
			 //
			 // Note the required "break"
			 // after the code for each case,
			 // which jumps to the code
			 // immediately following the final
			 // "}" at the end of the switch
			 // construction.
			 
			 //For Loop
			 
			 int i = 0;
			 int maxN = 10;
			 for ( i = 0 ; i < maxN ; i++) {
			 System.out.println(" i = "+i);
			 // execute code ...
			 }
			 
	   		}
	   
	   
		}
