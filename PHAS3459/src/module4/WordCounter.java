package module4;

import java.io.*; //import necessary features
import java.net.URL;
import java.util.Scanner;

public class WordCounter {
	
	public static BufferedReader brFromURL(String urlName) throws FileNotFoundException, IOException { //creates static method for returning buffered reader from URL string with exception for error
		URL u = new URL(urlName); //creates URL object
		InputStream is = u.openStream(); //effectively searches for the url
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr); //sets the buffered reader as the inputStreamReader
		return b;
	}

	public static BufferedReader brFromFile(String fileName) throws IOException { //creates static method for returning buffered reader from fileName
		File u = new File(fileName); //creates new file
		FileReader isr = new FileReader(u); //searches for file
		BufferedReader b = new BufferedReader(isr); //creates buffered reader object
		return b;

	}

	public static int countWordsInResource(BufferedReader dataAsBR) {
		int count = 0;
		try (Scanner s = new Scanner(dataAsBR);) {
			while (s.hasNext()) {
				s.next();
				count++;
			}
		}
		return (int) count;
	}

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader brFromURL = WordCounter
					.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println("The returned buffer reader object is" + brFromURL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader brFromFile = WordCounter.brFromFile("C:\\Users\\Steven Vuong\\Downloads\\module4_text.txt");
			System.out.println("The returned buffer reader object is: " + brFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			int brFromFile = WordCounter.countWordsInResource(
					brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt")); // what file in
																											// particular?

			System.out.println("The number of words in this file is: " + brFromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
