package module4;

import java.io.*;

public class NumericalReader {

	private double minValue;
	private double maxValue;
	private double nValues;
	private double sumOfValues;

	public static String getStringFromKeyboard() {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Enter Sentence");
		String s = null;
		try {
			s = b.readLine();
			System.out.println("You wronte: " + s);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws Exception {
		return WordCounter.brFromURL(urlName);
	}

	void analysisStart(String dataFile) { // creates new file called data file. Is it supposed to be a .file?

		try {
			File file = new File("c:\\dataFile.file"); // does this actually create a file?

			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// initialises variables
			minValue = 0;
			maxValue = 0;
			nValues = 0;
			sumOfValues = 0;

		}

	}

	void analyseData(String line) {
		line.split("\\s+"); // removes all white characters and comments? (non visible characters)
		line.replaceAll("(?m)^[ \t]*\r?\n", ""); // removes all spaces, tabs or pipe char.. What does this actually do

	}

	public static BufferedReader wc;

	public static void main(String[] args) {

		NumericalReader nr = new NumericalReader();

		String s = NumericalReader.getStringFromKeyboard(); // test
		System.out.println("s is: " + s);

	}

}
