package module6;


public class Test extends Notes {//we will use test as our subclass
	//when we create a test class, we are creating a notes object and adding the details
	//the notes object inherits all the variables and methods of the test class
	//but must be declared public or protected in the notes class
	//any private are hidden to subclasses
	
	//We can add behaviour to subclass not provided by superclass
	protected int square(int i) {return i*i;}
	
	//sublcasses can override methods by declaring a new version with same name and same args
	//can also hide a member variable by declaring a new one with same name
	//overriding is not overloading(same name but different arguments)
	
	public static void main(String [] args) {
		 
			Notes a = new Notes();
			 a.print("a.print()");
			 
			 Test sub = new Test();
		 
		// sub.print("sub.print()");
		// System.out.println("sub.className = " + sub.className());
		 
		//protected means they are accessible to classes and their superclass
		//default is public (any class in package)
		//member variables can be protected instead of private for extension of class	 
			 
		//subclass allows to keep existing variable but add new variable. Checks before changing
		//subclass inherit directly from one-base class
			 
		//Abstract Classes:
//			 public abstract class Particle {
//				 public abstract String name();}
			 //Any class with abstract method is abstract. Must be declared as such
			 //Abstract class can't be instantiated
			 //subclass of abstract instantiated only if it overrides each abstract of superclass & provides implementation
			 //if subclass of abstract doesn't implement all abstract method, the subclass is abstract
			 //static, private and final cannot be abstract
			 //class can be declared abstract even if no abstract methods
			 
		//Interface: Defines methods that all things simulated must implement
		    //public interface SimulableParticle {}
			 //contains no implementation, all methods are abstract
			 //all methods public, error if private or protected
			 //no data members can be defined except final and static constants
			 //interface cannot be instantiated
			
			 //commonly used to define families of objects
			 //define APIs (application programmer interfaces)
			 //define constants
			 //only subclass can extend abstract class
			 //common to declare classes that extend abstract and implement certain relevant interfaces
			 
	 }
	 
	
	
}
