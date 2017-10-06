package module1;
import java.util.Date;

public class HelloWorld {

	public static void main (String[] args) {
		//Testing Dates
		System.out.println("Hello World!");
		System.out.println("Program starting");
		 Date myDate = new Date();
		 System.out.println(myDate);
		 System.out.println("Program finished");

		 //Testing Integer
		 int xx=100; int yy = 200;
		 System.out.println(xx);//print the value of x	
		 System.out.println("the value of x is" + xx); //prints out x with some description
		 System.out.println("x="+xx+" and y="+yy);
		 
		 
		 //Declaring types
		 int n; //An integer
		 float e; //32 bit real number
		 float E; 
		 //Assigning values
		 double xd=100.234;
		 int xx1=1;
		 int ia2=xx1;
		 int ii2=3;
		 int ix=1234567890;
		 
		 int iy= 10*ix;
		 long iy2= 10*ix;
		 System.out.println(iy);
		 System.out.println(iy2);
		 
		 int ix3 = 123456789;
		 int iy3 = 123456788;
		 System.out.println(ix3-iy3);
		 // Widening conversions
		 double fx = ix3;
		 double fy = iy3;
		 System.out.println("this is"+(fx-fy));
		 // What happens when you make
		 // these doubles instead of floats? Gain precision?
		 
		 double xd2=100.0; //This is allowed. Cast is stated
		float xx2 = (float) 100.0; //The float is explicitly stated here
		float xy2 = 100.0f; //float is denoted by the f
		 
		
		 // addition (+),
		 // subtraction (-)
		 int ia,ib,ic,id; //defining the stuff
		 ib = 2;
		 id = 5;
		 ia = ib + 4;
		 ic = id - 2;
		 // multiplication (*),
		 // division (/),
		 // remainder (%)
		 ia = ib / 2;
		 ic = id * 3;
		 // increment (++),
		 // decrement (--)
		 ia++; // same as ia = ia + 1;
		 ib--; // same as ib = ib - 1;
		 
		 
		 // comparison
		 // == : is equal to
		 // != : is not equal to
		 // < : is less than
		 // <= : is less than or equal to
		 // > : is greater than
		 // >= : is greater than or equal to
		 boolean isSameAs;
		 int iaa = 4; int ibb = 4; int icc = 5;
		 isSameAs = (iaa == ibb); // True;
		 isSameAs = (iaa == icc); // False;
		 isSameAs = (iaa != icc); // True;
		 
		 
		 // AND (&), OR (|), NOT (~),
		 // XOR (^), left shift (<<),
		 // signed right shift (>>),
		 // unsigned right shift (>>>)
		 
		 //Boolean Conditionals
		// conditional AND (&&)
		 // conditional OR (||)
		 // Doesn't check a against c
		 // if a is not greater than b:
		 int a=10; int b=9; int c=8;
		 boolean biggest = (a > b) && (a > c);
		 // Doesn't check a against c
		 // if a is less than b:
		 boolean notBiggest = (a < b) || (a < c);
		 
		 int ib1 = 1;
		 // At this point in the code
		 // ib has the value 1
		 ib1 = ib1 + 8;
		 // ib now has the value 9
		 System.out.println(ib1);
		 
		 ///////////////////////////////////////////////////////////////////////////////////////////////
		 //Functions!
		 // The function declaration is of the form:
		 //<return type> FunctionName (<arguments>)
		 // where:
		 // <return type> : the type of the result
		 // returned by the function
		 // (e.g. int, double or a
		 // class type).
		 //
		 // FunctionName : programmer defined function
		 // name.
		 //
		 // <arguments> : list of variables with their
		 // types passed to the function,
		 // and used in the function code.
		 
		 switch (2) {
		 case 1:
		 System.out.println("Jan");
		 break;
		 case 2:
		 System.out.println("Feb");
		 break;
		 case 3:
		 System.out.println("Mar");
		 break;
		 default:
		 System.out.println("???");
		 break;
		 
		 
	}

}
}
