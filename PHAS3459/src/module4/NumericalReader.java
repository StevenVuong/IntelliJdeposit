package module4;

import java.io.*;
import java.util.Scanner;

public class NumericalReader {

	private double minValue;
	private double maxValue;
	private static double nValues;
	private double sumOfValues;

	static String url1 = ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
	static String url2 = ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");

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
		//	dataFile = ("C:" + File.separator + "mywork" + File.separator + dataFile); // Creates folder
			File file = new File(dataFile);
			FileWriter fw = new FileWriter(file); // create the file and allows to write over it
			// if (file.createNewFile()) {
			// System.out.println("File is created!");
			// } else {
			// System.out.println("File already exists.");
			// }

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
		if ((line.trim().isEmpty()) || line.startsWith("//") || !Character.isDigit(line.charAt(0))) { // check if line
																										// is empty or
																										// starts with
																										// comment line
			return; // return is like a way of doing nothing
		}
		try {

			Scanner charNum = new Scanner(line); // Breaks down line into individual character strings
			while (charNum.hasNextDouble()) {

				System.out.println(charNum); // printing our values
				BufferedWriter b = new BufferedWriter(new FileWriter("fileName")); // creates a new file of name
																					// fileName
				PrintWriter pw = new PrintWriter(b);
				pw.println(charNum); // prints array of numbers to file
				pw.close();
				// updating our values
				nValues++;
				double numm = charNum.nextDouble();
				sumOfValues = sumOfValues + numm;
				if (numm < minValue) {
					minValue = numm;
				}
				if (numm > maxValue) {
					maxValue = numm;
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	void analysisEnd() {
		System.out.println("the maximum value is: " + maxValue);
		System.out.println("the minimum value is: " + minValue);
		System.out.println("the total number of values read is: " + nValues);
		double average = sumOfValues / nValues;
		System.out.println("the average value is: " + average);
	}

	public static void main(String[] args) throws Exception {

		String saveDir = NumericalReader.getStringFromKeyboard(); // allows user to specify the save Directory
		if (saveDir.trim().isEmpty()) { // check if line is empty
			saveDir = new String(System.getProperty("user.home"));
		}

		System.out.println("save Directory is: " + saveDir);

		String saveFile = (saveDir + File.separator + "fileName"); // uses File.separator so user doesn't have to
																		// specify
																		// trailing slash and the end of each directory
																		// name
		NumericalReader nr = new NumericalReader();
		BufferedReader reader = nr.brFromURL(url1); // gives Buffer Reader object from URL
		nr.analysisStart(saveFile); // initialize minValue etc, creates a file and writes into it

		String empty = new String("");
		// try {
		// FileReader fr = new FileReader(fileName);
		// BufferedReader br = new BufferedReader(fr);

		while ((empty = reader.readLine()) != null) {
			nr.analyseData(empty); // analyse lines, check for comments etc..
		}
		// } catch (Exception e) {
		// e.getMessage();
	}

	// String a = new String("5 0 88 9");
	// v twofoureight1;twofoureight1=new analyseData(a);
	// b=new analyseData(a);

}

// }
