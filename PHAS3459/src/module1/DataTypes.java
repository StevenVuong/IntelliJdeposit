package module1;
import java.lang.Math.*;
public class DataTypes {

	public static void main(String[] args) {
		//banana
		//Changing the variable of 10
		
		double doubVar = 10.0;
		System.out.println("double variable: "+doubVar);
		
		float floatVar = 10;
		System.out.println("float variable: "+floatVar); //The result from this is 10.0 as it is a float
		
		int intVar = 10;
		System.out.println("int variable: "+intVar);

		long longVar = 10;
		System.out.println("long variable: "+longVar);
		
		byte byteVar = 10;
		System.out.println("byte variable: "+byteVar);
		
		//
		System.out.println(" ");
		//
		//Printing 10 squared from different variables
		System.out.println("double variable squared: "+doubVar*doubVar);
		System.out.println("float variable squared: "+floatVar*floatVar);
		System.out.println("int variable squared: "+intVar*intVar);
		System.out.println("long variable squared: "+longVar*longVar);
		System.out.println("byte variable squared: "+byteVar*byteVar);
		
		//
		System.out.println(" ");
		//
		//Using 'char' and mixing types
		char charVar0 ='c'+10;
		System.out.println("c is 3rd in the alphabet, 'charVar0' adds 10 to get the 13th letter, "+charVar0);
		
		char charVar1 ='g'-5;
		System.out.println("g is 7th in the alphabet, 'charVar1' counts back 5 to get the 2nd letter, "+charVar1);
		
		char charVar2 ='b' + 20;
		System.out.println("b is 2nd in the alphabet, 'charVar2' adds 20 to get the 22nd letter, "+charVar2);
		
		char charVar3 ='a' + 2 ;
		System.out.println("a is the 1st letter of the alphabet, charVar3 adds 2 to get the third letter: "+charVar3);
		
		float t1 = 1;
		int t2 = 3;
		double t3 = t1 + t2;
		System.out.println("float 1 is added to integer 3 to give out double: "+ t3);
		
		double t4 = 5.3;
		short t5 = 7;
		double t6 = t4 * t5;
		System.out.println("double 5.3 is multiplied by short 7 to give double: "+ t6);
		
		//
		System.out.println(" ");
		//
		//Using a value which hasn't been initialised
		System.out.println("When trying to use a variable which has not been initialised, e.g. int j=1; int i; j=i+1 ");
		System.out.println("A compilation error appears stating: 'The local variable i may not have been initializedat module1.DataTypes.main(DataTypes.java:61)'");
		System.out.println("Upon looking into this, it is because Instances and class variables are initialized to 0, but local variables are not. Source:https://stackoverflow.com/questions/2187632/why-does-javac-complain-about-not-initialized-variable ");
		System.out.println("And so it becomes confused and outputs an error as there is no innate framwork to automatically fix this error");
		
		//
		System.out.println(" ");
		//
		//Casting a double as an int
		double p1 = 4.99;
		int p2;
		//p2 = p1;
		System.out.println("When trying to convert 4.99 to an int, an error appears, 'cannot convert double to int' ");
		p2 = (int) p1; // Using a cast now
		System.out.println("Using a cast, however, our result becomes: "+p2+", it is clear this becomes rounded down. Because the resolution of 0.99 is too small to be comprehended by the 4 to add on");
	}

}
