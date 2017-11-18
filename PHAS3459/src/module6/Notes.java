package module6;

//Inheritance extends one class to a new one with specialised functionality. The specialised one is referred to as a subclass
//of the original(superclass). Useful in scenarios e.g. particles with similar and different properties
//specify a class that inherits the behaviour of a parent class using 'extends'

public class Notes { //Notes is our superclass
	
	public Notes() {}
	
	//any amount of classes can extend same superclass. Can be a tree with multiple branches
	//to instantiate a 'notes' object, we use syntax:
	Notes noteObject = new Notes();

	protected String name = "className";
	
	protected void print(String text) {
		System.out.println(text);
	}
	protected String className() {return name;}
	
	public class NotesSubclass extends Notes{}
	Test sub = new Test();
	
	//Restriction: Cannot reduce visibility of superclass (can't override public with protected or private)
	//Method of subclass cannot throw exception not declared using throws in superclass
	
	//superclass constructor: use keywords super(); in a constructor for superclass
	//constructors can carry out initialisation specific to subclass
	
	public static void main(String [] args) {
//		Notes a = new Notes();
//		 a.print("a.print()");
	}
	
	//Polymorphism(object can take many forms). Rule of inheritance: Is-A. Object of subclass should be substitutable for object of superclass
	//Can use references to other class to manipulate the other objects
	// if want to use object in subclass, have to cast variable (getters)
	
	//common use of inheritance is in defining exception classes to represent specific events
//	 public class TooLazyException extends Exception {
//		 public TooLazyException() {}
//		 public TooLazyException(String message) {
//		 super("TooLazyException ERROR: "+message);
//		 }
//		 }
	
	 public interface Cloneable { } //empty interfaces called marker interfaces
	 //can provide information of something
//	 SomeObject o; // initialised elsewhere
//	 SomeObject copy;
	 // If this object extends Cloneable, I expect to be able to call its
	 // clone() method in order to copy its internal state into another object:
//	 if (o instanceof Cloneable) {
//	 copy = o.clone()
//	 } else {
//	 copy = null;
//	 }
}
