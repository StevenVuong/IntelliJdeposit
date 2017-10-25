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
			File file = new File(dataFile); // does this actually create a file?
			FileWriter fw = new FileWriter(file); // create the file and allows to write over it
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
		line.trim(); // removes all trailing and leading blanks
		if ((line.trim().isEmpty()) || line.startsWith("//")) { // check if line is empty or starts with comment line
			return; // return is like a way of doing nothing
		}
		String numLine = line.replaceAll("[^0-9]+", " "); // This returns the numbers
		String[] arrayOfStringBasedNumbers = numLine.trim().split(" "); // which returns number array
		System.out.println("creates an array of all the numbers" + arrayOfStringBasedNumbers);
		System.out.println("To Test");

		try {
			BufferedWriter b = new BufferedWriter(new FileWriter(line));
			PrintWriter pw = new PrintWriter(b);
			pw.println(arrayOfStringBasedNumbers);
			pw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static BufferedReader wc;

	public static void main(String[] args) {

		NumericalReader nr = new NumericalReader();

		String s = NumericalReader.getStringFromKeyboard(); // test
		System.out.println("s is: " + s);

	}

}
