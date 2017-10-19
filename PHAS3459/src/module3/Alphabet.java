package module3;

//importing relevant modules
import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Alphabet {

	private static Random rnd = new Random(); // Creating random object

	public static char randomCharacter() { // Creating static method to generate numbers 0-127
		int randomNumber1 = rnd.nextInt(128); // 0 to 127
		char charRandom = (char) randomNumber1; // casts the random number into a character
		return charRandom;
	}

	public static StringBuilder randomString = new StringBuilder(); // initialises a string with StringBuilder
	public static int randomSums = 0; //initialises summation of random digits
	public static int randomExceptions = 0; //initialises counter for number of exceptions

	public static void main(String[] args) throws Exception {

		int counter = 0; // initialises counter
		while (counter < 250) { // creates a while loop, setting the condition to run 250 iterations if counter
								// is increased by 1 each time
			char randomChar = randomCharacter(); // creates a random character
			boolean randomCharBoolean = Character.isLetterOrDigit(randomChar); // sets the boolean for a random
																				// character, if it is a letter or digit
			if (randomCharBoolean == true) { // creates condition for 'if' loop
				randomString.append(randomChar); // adds the letter/digit to the string

				try {
					String randomString = Character.toString(randomChar); // converts character to string
					Integer randomLetterOrDigit = Integer.parseInt(randomString); // parse integer
					randomSums += randomLetterOrDigit; // adds the integer onto the current summation
				} catch (Exception e) {
					randomExceptions++; // adds one to count the number of exceptions
				}
			}
			counter++;
		}
		System.out.println("the StringBuilder string is: ");
		System.out.println(randomString);
		System.out.println("");
		System.out.println("The sum of numbers added together are: " + randomSums);
		System.out.println("The number of exceptions thrown by Integer.parseInt() is: " + randomExceptions);

	}

}
