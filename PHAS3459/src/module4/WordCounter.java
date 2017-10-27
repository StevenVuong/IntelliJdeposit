package module4;

import java.io.*; //import necessary features
import java.net.URL;
import java.util.Scanner;

public class WordCounter {

	private static String urlText = ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt"); // creates
																												// string
																												// of
																												// text
																												// file
																												// for
																												// this
																												// class
	private static String fileDirectory = ("C:\\Users\\Steven Vuong\\Downloads\\module4_text.txt"); // creates string of
																									// fileDirectory for
																									// this class

	public static BufferedReader brFromURL(String urlName) throws FileNotFoundException, IOException { // creates static
																										// method for
																										// returning
																										// buffered
																										// reader from
																										// URL string
																										// with
																										// exception for
																										// error
		URL u = new URL(urlName); // creates URL object
		InputStream is = u.openStream(); // effectively searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); // sets the buffered reader as the inputStreamReader
		return b;
	}

	public static BufferedReader brFromFile(String fileName) throws IOException { // creates static method for returning
																					// buffered reader from fileName
		File u = new File(fileName); // creates new file
		FileReader isr = new FileReader(u); // searches for file
		BufferedReader b = new BufferedReader(isr); // creates buffered reader object
		return b;

	}

	public static int countWordsInResource(BufferedReader dataAsBR) { // creates static method for counting words in a
																		// file
		int count = 0; // initialises counter
		try (Scanner s = new Scanner(dataAsBR);) { // sets scanner, breaks apart each string of characters
			while (s.hasNext()) { // sets condition for loop
				s.next();
				count++; // increases counter by 1
			}
		}
		return (int) count;
	}

	public static void main(String[] args) throws IOException { // main method with 'throws Exception'
		try {
			BufferedReader brFromURL = WordCounter.brFromURL(urlText); // gets buffered reader using brFromURL method
			System.out.println("The returned buffer reader object is" + brFromURL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader brFromFile = WordCounter.brFromFile(fileDirectory); //gets buffered reader from file using brFromFile method
			System.out.println("The returned buffer reader object is: " + brFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			int brFromFile = WordCounter.countWordsInResource(brFromURL(urlText)); //counts words in URL
			System.out.println("The number of words in this file is: " + brFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
