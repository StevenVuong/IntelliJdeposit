package module4;

import java.io.*;

import module1.AlgorithmControl;

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
		try {

			String numLine = line.replaceAll("[^0-9]+", " "); // This returns the numbers only in a line
			// Insert numbers read in
			double a = Double.parseDouble(numLine);
			nValues++;
			sumOfValues = sumOfValues + a;
			if (a < minValue) {
				minValue = a;
			}
			if (a > maxValue) {
				maxValue = a;
			}

			String[] arrayOfStringBasedNumbers = numLine.trim().split(" "); // which returns number array
			System.out.println("creates an array of all the numbers" + arrayOfStringBasedNumbers);
			System.out.println("To Test");

			BufferedWriter b = new BufferedWriter(new FileWriter(line));
			PrintWriter pw = new PrintWriter(b);
			pw.println(arrayOfStringBasedNumbers); // prints array of numbers to file
			pw.close();
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
		
		String line = "";
		// String empty = new String("");
		
		String saveDir = NumericalReader.getStringFromKeyboard(); // allows user to specify the save Directory
		while (saveDir.trim().isEmpty()) { // check if line is empty
			String saveDir = new String(System.getProperty("user.home"));
		}

	}System.out.println("save Directory is: "+saveDir);

	String saveFile = (saveDir + File.separator + dataFile); // uses File.separator so user doesn't have to specify
																// trailing slash and the end of each directory name
	NumericalReader nr = new NumericalReader();

	BufferedReader reader = nr.brFromURL("http://foo/bar/");
	String line = "";

	nr.analysisStart(saveFile); // initialize minValue etc.

	String a = new String("5 0 88 9");
	v twofoureight1;twofoureight1=new analyseData(a);b=new analyseData(a);

}

}
