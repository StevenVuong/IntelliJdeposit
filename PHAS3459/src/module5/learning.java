package module5;

public class learning implements Cloneable {

	public static void changeIt(int i) {
		i = 2;
	}

	public static void main(String[] args) {

		// copying and relabelling variable
		int a = 1;
		int b = a; // not used but is referred to as long as it is there...
		b = 2;

		// can pass object as argument function, this creates new copy of value so it
		// doesn't change previous value
		int c = 1;
		changeIt(c);
		System.out.println("c is still " + c);

		// strings are immutable.. But when concatenate we must create new string
		String x = "Hello";
		System.out.println("Hash code x first: " + System.identityHashCode(x)); // hash code allows us to check if a
																				// value is identical
		x = x + " world"; // creates a new object
		System.out.println("Hash code x second: " + System.identityHashCode(x)); // as hash code refers to a location
																					// the memory value is called from

		// mutable method, build longer string from shorter ones, one way is to use
		// stringbuilder to add to it
		StringBuilder z = new StringBuilder("Hello");
		System.out.println("Hash code stringbuilder: " + System.identityHashCode(z));
		z.append(" world"); // adds data to existing object
		System.out.println("Hash code stringbuilder: " + System.identityHashCode(z));
	}

}

// two variables refer to set counter.. when c uses it uses outdated value
// import module2.SimpleCounter;
// SimpleCounter c = new SimpleCounter(1);
// SimpleCounter d = c;
// d.setCounter(2);
// System.out.println("c = "+c.getCounter());

// The second simplecounter has been forgotten.. java eventually deletes lost
// objects to free memory, Garbage Collection!
// SimpleCounter c = new SimpleCounter(3);
// SimpleCounter d = new SimpleCounter(4);
// d = c;

// Can use reference to change state of the variable to pass as argument
// Bad to set an object in a function, best to create a copy and use that if it
// it must be used.. Otherwise it could mess with object
// SimpleCounter a = new SimpleCounter(1);
// changeIt(a);
// public static void changeIt(SimpleCounter c)
// c.setCounter(2);

// create null, doesn't refer to anything. creates nullpoint exception
// MyCounter xx = null;try
// xx = new MyCounter(150.0)
// Only use if: 1)try/catch succeeds in assigning value 2) Check if variable is
// null before using 3) catch NullPointerException & use appropriate action#

// Check if two objects are equal
// SimpleCounter a = new SimpleCounter(1);
// SimpleCounter b = new SimpleCounter(1);
// System.out.println(a==b); // false as refer to the same object! It is changed
// SimpleCounter c = a;
// System.out.println(a==c); // true

// checks equivalency with multiple error conditions
// public boolean equals(Object obj) {
// if (this == obj) {
// return true;
// } else if (obj == null) {
// return false;
// } else if (getClass() != obj.getClass()) {
// return false;
// }
// final SimpleCounter other = (SimpleCounter) obj;
// if (counter != other.counter) {
// return false;
// }
// return true;
// }

// Extract info and instantiate in another object
// SimpleCounter c1 = new SimpleCounter(1);
// SimpleCounter c2 = new SimpleCounter(c1.getCounter())

// Clone method, inbuilt within Java
// try { //need to put in try otherwise may throw a CloneNotSupportedException
// SimpleCounter c2 = (SimpleCounter) c1.clone(); //Instantiate new object as
// cloned previous object
// System.out.println("Cloned object");
// }
// catch (CloneNotSupportedException e) {
// System.out.println("Can't clone object!");
// } //Won't work, will throw 'implements Clonable' to class

// Creates a shallow clone.. Exact copy (bitwise); includes member variable,
// same number of references
// SimpleCounterPair p1 = new SimpleCounterPair(); //simplecounter object
// try {
// SimpleCounterPair p2 = (SimpleCounterPair) p1.clone(); //sets the clone
// p2.first.setCounter(2);
// System.out.println(p1.first.getCounter());
// }
// catch (CloneNotSupportedException e) {
// System.out.println(e);
// }

// protected Object clone() throws CloneNotSupportedException {
// SimpleCounter copy1 = (SimpleCounter) this.first.clone(); //creates two
// copies
// SimpleCounter copy2 = (SimpleCounter) this.second.clone();
// SimpleCounterPair copy = new SimpleCounterPair(); //create separate copy of
// member object
// copy.first = copy1;
// copy.second = copy2;
// return (Object) copy;
// }

// Use of copy constructor
// public copyConstructor(SimpleCounter c) {
// counter = c.counter;
// }
// using this// SimpleCounter c2 = new copyConstructor(c1);