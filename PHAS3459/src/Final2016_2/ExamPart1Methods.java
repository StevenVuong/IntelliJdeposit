package Final2016_2;
/**
 * Class containing methods to be used in part 1 of final exam 2016
 * @author Steven Vuong
 * @version 09-01-2018
 */
/**
 * Import necessary packages
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class ExamPart1Methods {

	/**
	 * Method which takes data from URL and returns AudioFile object
	 * @param url string
	 * @return AudioFile object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static AudioFile dataFromURL(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String Filename = url.substring(58); //takes filename which is after 58th character
		
		String firstLine = br.readLine(); //parses data from first line
		
		Scanner sn = new Scanner (firstLine); //create new scanner object
		
		//Parses values
		Integer Frequency = Integer.parseInt(sn.next());
		Integer NumberOfSamples = Integer.parseInt(sn.next());
		Integer MaxAmplitude = Integer.parseInt(sn.next());
		
		String empty = ""; //initialises string
		ArrayList<Integer> data = new ArrayList<Integer>(); //Initialises arraylist
		
		while ((empty = br.readLine()) != null) {
			data.add(Integer.parseInt(empty));
		}
		
		return new AudioFile(Filename, Frequency, NumberOfSamples, MaxAmplitude, data); 
	}
	
	/**
	 * Method which takes data from URL index and returns hashmap with filenames as the key and instruments as the object
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HashMap<String, String> indexFromURL(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String empty = ""; //initialises string
		HashMap<String, String> instrumentHashMap = new HashMap<String, String>(); //Initialise hashmap
		int i = 7;
		
		while (i >0) { // previous method didn't work, had to loop through integer values
			
			Scanner sn = new Scanner(br.readLine());
			
			//Parse values
			String fileName = sn.next();
			String Instrument = sn.next();
			
			instrumentHashMap.put(fileName, Instrument); //add values to hashmap
			i--;
			
		}
		
		return instrumentHashMap;
	}
	
	/**
	 * Method which creates AudioFile objects from URL and puts into ArrayList
	 * @return ArrayList of AudioFile objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<AudioFile> audioFileArray() throws MalformedURLException, IOException {
		
		//Creates AudioFile objects from URLs
		AudioFile File1 = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/recording01.txt");
		AudioFile File2 = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/recording02.txt");
		AudioFile File3 = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/recording03.txt");
		AudioFile File4 = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/recording04.txt");
		AudioFile genA = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/genA.txt");
		AudioFile genB = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/genB.txt");
		AudioFile genC = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/genC.txt");
		
		ArrayList<AudioFile> audioFileArrayList = new ArrayList<AudioFile>(); //Initialise arraylist
		
		//Add AudioFile objects to arraylist
		audioFileArrayList.add(File1);
		audioFileArrayList.add(File2);
		audioFileArrayList.add(File3);
		audioFileArrayList.add(File4);
		audioFileArrayList.add(genA);
		audioFileArrayList.add(genB);
		audioFileArrayList.add(genC);
		
		return audioFileArrayList;
	}
	
}
