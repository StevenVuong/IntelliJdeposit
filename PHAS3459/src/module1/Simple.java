package module1;

 public class Simple {
 public Simple() { }
 
 public double quadratic(double x) {
	 double y;
	 double a = 2.0;
	 double b = 3.0;
	 double c = 5.0;
	 y = a*x*x + b*x + c;
	 return y;
 	}
 
 	public static void main (String[] args) {
 		// Instantiate Simple object:
 		// explained in module 2
 		Simple myS = new Simple();
 
 		double xx = 2.0;
 
 		double yy = myS.quadratic(xx);
 		
 		System.out.println("xx = "+xx);
 		System.out.println("yy = "+yy);
 	}
 	
 	 public double function2(double xx) {
 		 double y;
 		 y = Math.cos(xx);
 		 return y;
 	 	}
 	 
 	 double function1( double x1 ) {
 		 double x3 = function2( x1/10.0 + 2 );
 		 double x2 = x1 * x3;
 		 return x2;
 		 } 
 }
 //https://stackoverflow.com/questions/7325779/calling-a-method-inside-another-method-in-same-class