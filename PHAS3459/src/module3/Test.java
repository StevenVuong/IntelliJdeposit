package module3;

public class Test {
	
	 public static int process(int j) throws Exception { //Note: Exceptions created with 'new', indicating they are just objects
		 if (j==13) {
		 throw new Exception("Unlucky number: "+j);
		 }
		 return 2*j;
	 }


	 public void doSomething() throws Exception { } //Java compiler forces us to declare when method may throw an exception using 'throws keyword'
	 //also forces us to deal with any exception, hence the need for a try, catch and fail block to match
	 

	 public static int process1(int j) throws RuntimeException { //Uses RuntimeException, doesn't declare throws, hard to know when may throw, could crash without try and finally
		 if (j==13) {
		 new RuntimeException("Unlucky number: "+j); //could add 'throw' before new
		 }
		 return 2*j;
		 }

	 
	 
	 
	 public static void main(String[] args) throws Exception {

		 for (int k=10; k<20; k++) { //When a method throws an exception, doesn't have to return a value, this sets exception condition
			 try { //code that throws an exception (response to failure)
			 int n = process(k);
			 System.out.println("in: "+k+" out: "+n);
			 }
			 catch (Exception e) { //code that handles exception
			 System.out.println(e);
			 }
			 finally { //finally means it happens regardless..
				 System.out.println("code that executes regardless of whether exception is thrown or not");
			 }
		 }

			 Complex.divide(new Complex(3.0,3.0),new Complex(0.0,0.0));
			
		
//		 
//		 try {
//			 boolean using_database = false;
//			 boolean using_file = true;
//			 MyClass.mycode();
//			 }
//			 catch (MyException e) {
//			 if (e.getMessage().equals("FILE ERROR") && using_file) {
//			 System.out.println("WE ARE IN BIG TROUBLE");
//			 }
//			 else {
//			 System.out.println("A PROBLEM BUT WE DO NOT CARE...");
//			 }
//			 // Note: "getMessage()"is defined for all exception types to return a string.
//			 //There is also the "equals()" operator
//			 //All exceptions except 'RunTimeException' must be caught or handled or generates a compile time error
//
	}

}
