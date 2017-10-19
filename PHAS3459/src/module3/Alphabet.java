package module3;

import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Math;

public class Alphabet {

	private static Random rnd = new Random();

	public static char randomCharacter() {
		int randomNumber1 = rnd.nextInt(128); // 0 to 127
		char charRandom = (char) randomNumber1; // casts the random number into a character
		return charRandom;
	}

	public static StringBuilder randomString = new StringBuilder(); // initialises a string with StringBuilder

	public static void main(String[] args) throws Exception {

		int counter = 0; // initialises counter
		while (counter < 250) { // creates a while loop, setting the condition to run 250 iterations if counter
								// is increased by 1 each time
			char randomChar = randomCharacter(); // creates a random character
			boolean randomCharBoolean = Character.isLetterOrDigit(randomChar);
			if (randomCharBoolean == true) { // creates condition for 'if' loop
				randomString.append(randomChar); // adds the letter/digit to the string
			//	System.out.println(randomString); //testing stringBuilder so far
				try {
					String randomString = Character.toString(randomChar); //converts character to string
					Integer randomLetterOrDigit = Integer.parseInt(randomString); // parse integer
				//	System.out.println(randomLetterOrDigit); //test
				} catch (Exception e) {
					//System.out.println("THIS DOESN'T WORK! "+e);
				}
			}
			counter++;
		}

		// System.out.println(randomChar);

	}

}
