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

	public BufferedReader brFromURL(String urlName) throws Exception { //non-static method which uses method from WordCounter class to return bufferedReader object from URL input
		return WordCounter.brFromURL(urlName);
	}

	void analysisStart(String dataFile) { //non-static method which creates a file of the name of the dataFile and initialises variables
		this.fileName = dataFile; //sets fileName variable as the input string
		try {
			
			File file = new File(dataFile); //creates file
			
		} finally {
			
			// initialises variables
			minValue = 1000; // sets high minimum value to be overridden
			maxValue = 0;
			nValues = 0;
			sumOfValues = 0;
			
		}

	}

	void analyseData(String line) { //non-static method with string input
		line.trim(); // removes all trailing and leading blanks
		if ((line.trim().isEmpty()) || line.startsWith("//") || !Character.isDigit(line.charAt(0))) { // check if line is empty or starts with comment line
			return; // returns nothing here
		}
		try {
			Scanner charNum = new Scanner(line); // Breaks down line into individual character strings
			while (charNum.hasNextDouble()) { //sets condition for while loop
				double numm = charNum.nextDouble(); //converts the character into double
				System.out.println(numm); // prints number to screen
				this.fw = fw; //sets variables again
				this.pw = pw;

				pw.println(numm + "\n"); // prints number to file

				// updating our values
				nValues++; //increase counter increment by one
				sumOfValues = sumOfValues + numm; //sums values
				if (numm < minValue) { //sets condition for minimum value
					minValue = numm;
				}
				if (numm > maxValue) { //sets condition for maximum value
					maxValue = numm;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	void analysisEnd() {
		//printing all the values now set
		System.out.println("the maximum value is: " + maxValue);
		System.out.println("the minimum value is: " + minValue);
		System.out.println("the total number of values read is: " + nValues);
		double average = sumOfValues / nValues; //calculates the average value
		System.out.println("the average value is: " + average);
		pw.close(); //closes the printWriter stream so a new line can be written on
	}

	public static void main(String[] args) throws Exception {
		

		String saveDir = NumericalReader.getStringFromKeyboard(); // allows user to specify the save Directory
		if (saveDir.trim().isEmpty()) { // check if line is empty
			saveDir = new String(System.getProperty("user.home")); //sets default as home directory if no input has been specified
		}

		System.out.println("save Directory is: " + saveDir); //prints the save directory

		String saveFile = (saveDir + File.separator + "numbers1.txt"); // creates file name & uses File.separator so user
																		// doesn't have to specify trailing slash and
																		// the end of each directory name
		
		NumericalReader nrTextOne = new NumericalReader(); // creates object of the class
		BufferedReader reader = nrTextOne.brFromURL(url1); // sets Buffer Reader object from URL
		nrTextOne.analysisStart(saveFile); // initialize minValue etc, creates a file and writes into it, renames the file
		
		FileWriter fw = new FileWriter(saveFile); // opens stream to write into file
		BufferedWriter b = new BufferedWriter(fw); // creates bufferedWriter object
		nrTextOne.pw = new PrintWriter(b); //sets the printWriter to write in the BufferedWriter we just created

		String empty = new String(""); //initialises String

		while ((empty = reader.readLine()) != null) {
			nrTextOne.analyseData(empty); // analyse lines, check for comments etc.., essentially calls printWriter
		}
		nrTextOne.analysisEnd(); // Print everything


		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Repeats for the second URL
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String saveFile2 = (saveDir + File.separator + "numbers2.txt"); // creates file name & uses File.separator so user
		// doesn't have to specify trailing slash and
		// the end of each directory name
		
		NumericalReader nrTextTwo = new NumericalReader(); // creates object of the class
		BufferedReader reader2 = nrTextOne.brFromURL(url2); // sets Buffer Reader object from URL
		nrTextTwo.analysisStart(saveFile2); // initialize minValue etc, creates a file and writes into it, renames the file
		
		FileWriter fw2 = new FileWriter(saveFile2); // opens stream to write into file
		BufferedWriter b2 = new BufferedWriter(fw2); // creates bufferedWriter object
		nrTextTwo.pw = new PrintWriter(b2); //sets the printWriter to write in the BufferedWriter we just created

		String empty2 = new String(""); //initialises String

		while ((empty2 = reader2.readLine()) != null) {
			nrTextTwo.analyseData(empty2); // analyse lines, check for comments etc.., essentially calls printWriter
		}
		nrTextTwo.analysisEnd(); // Print everything
		
		
		

	}

}
