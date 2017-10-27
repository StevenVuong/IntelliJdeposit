package module4;

//imports necessary features
import java.io.*;
import java.util.Scanner;

public class NumericalReader {

	//sets variables
	private double minValue;
	private double maxValue;
	private static double nValues;
	private double sumOfValues;
	private String fileName;
	PrintWriter pw;
	FileWriter fw;

	//creates strings for each URL
	static String url1 = ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
	static String url2 = ("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");

	public static String getStringFromKeyboard() { //creates method which inputs keyboard text and returns the string
		InputStreamReader r = new InputStreamReader(System.in); //creates InputStreamReader object which requires input
		BufferedReader b = new BufferedReader(r); //creates buffered reader object
		System.out.println("Enter Sentence");
		String s = null;
		try {
			s = b.readLine(); //sets string as buffered reader
			System.out.println("You wronte: " + s);
		} catch (IOException e) { //catches and prints any error should it not find an input
			System.out.println(e.getMessage());
		}
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws Exception { //non static method which uses method from WordCounter class to return bufferedReader object from URL input
		return WordCounter.brFromURL(urlName);
	}

	void analysisStart(String dataFile) {
		this.fileName = dataFile; //sets fileName variable as the input string
		try {
			
			File file = new File(dataFile); //creates file
			
		} finally {
			
			// initialises variables
			minValue = 1000; // sets high minimum value to be over-ridden
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
			return; // returns nothing here
		}
		try {
			Scanner charNum = new Scanner(line); // Breaks down line into individual character strings
			while (charNum.hasNextDouble()) {
				double numm = charNum.nextDouble();
				System.out.println(numm); // printing our values
				this.fw = fw;
				this.pw = pw;

				pw.println(numm + "\n"); // prints number to file

				// updating our values
				nValues++;
				sumOfValues = sumOfValues + numm;
				if (numm < minValue) {
					minValue = numm;
				}
				if (numm > maxValue) {
					maxValue = numm;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	void analysisEnd() {
		System.out.println("the maximum value is: " + maxValue);
		System.out.println("the minimum value is: " + minValue);
		System.out.println("the total number of values read is: " + nValues);
		double average = sumOfValues / nValues;
		System.out.println("the average value is: " + average);
		pw.close();
	}

	public static void main(String[] args) throws Exception {

		String saveDir = NumericalReader.getStringFromKeyboard(); // allows user to specify the save Directory
		if (saveDir.trim().isEmpty()) { // check if line is empty
			saveDir = new String(System.getProperty("user.home"));
		}

		System.out.println("save Directory is: " + saveDir);

		String saveFile = (saveDir + File.separator + "numbers1.txt"); // creates file name uses File.separator so user
																		// doesn't have to specify trailing slash and
																		// the end of each directory name

		NumericalReader nr = new NumericalReader(); // creates object of the class
		BufferedReader reader = nr.brFromURL(url1); // gives Buffer Reader object from URL

		nr.analysisStart(saveFile); // initialize minValue etc, creates a file and writes into it, renames the file
		FileWriter fw = new FileWriter(saveFile); // opens stream

		BufferedWriter b = new BufferedWriter(fw); // creates a new file of name fileName
		nr.pw = new PrintWriter(b);

		String empty = new String("");

		while ((empty = reader.readLine()) != null) {
			nr.analyseData(empty); // analyse lines, check for comments etc..
		}
		nr.analysisEnd(); // Print everything

	}

}
