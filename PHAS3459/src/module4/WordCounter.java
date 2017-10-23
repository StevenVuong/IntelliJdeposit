package module4;

import java.io.*;
import java.util.Scanner;

import module2.Complex;

public class WordCounter {

	public static BufferedReader brFromURL(String urlName) throws FileNotFoundException  {
		return new BufferedReader(new FileReader(urlName));
	}

	public static BufferedReader brFromFile(String fileName) throws FileNotFoundException {
		return new BufferedReader(new FileReader(fileName));
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

	public static void main(String[] args) {
		try {
			BufferedReader brFromURL = WordCounter.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader brFromFile = WordCounter.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			int brFromFile = WordCounter.countWordsInResource(brFromFile("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
