package Final2016;

import java.io.*;
import java.net.*;
import java.util.*;

public class ExamPart1 {
	
	/**
	 * Method which parses data from audio URL and returns audio object with frequency data, number of samples
	 * max amplitude, data and instrument name
	 * @param url string
	 * @return Audio object
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static Audio audioFromURL(String url) throws NumberFormatException, IOException {
		
		//Turn URL String into bufferedReader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine(); //Parse first line
		//Create scanner object to break the line into multiple parts, separated by spaces
		Scanner sn = new Scanner(line); 
		
		Integer Freq = Integer.parseInt(sn.next());
		Integer SampleCount = Integer.parseInt(sn.next());
		Integer MaxAmp = Integer.parseInt(sn.next());
		
		sn.close(); //Close scanner
		
		ArrayList<Integer> dataArrayList = new ArrayList<Integer>(); //Initialise arraylist
		
		//Adds data to arraylist
		String empty = "";
		while ((empty = br.readLine()) != null) {
			//Scanner sn1 = new Scanner(br);
			dataArrayList.add(Integer.parseInt(empty));
			//sn1.close();
		}
		
		String FileName = url.substring(58); //File name is after the 58th character
		
		return new Audio(Freq, SampleCount, MaxAmp, dataArrayList, FileName);
		
	}
	
	/**
	 * Method to obtain audio objects from URL and put into arraylist
	 * @return ArrayList of audio objects
	 * @throws IOException
	 */
	private static ArrayList<Audio> getAudioFiles() throws IOException {
		//Create Audio objects, gathering data from URLs
		Audio recording1 = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		Audio recording2 = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		Audio recording3 = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		Audio recording4 = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
		Audio genA = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt");
		Audio genB = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt");
		Audio genC = audioFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt");
		
		//Initialise ArrayList of audio objects and add objects
		ArrayList<Audio> audioFiles = new ArrayList<Audio>();
		
		audioFiles.add(recording1);
		audioFiles.add(recording2);
		audioFiles.add(recording3);
		audioFiles.add(recording4);
		audioFiles.add(genA);
		audioFiles.add(genB);
		audioFiles.add(genC);
		
		return audioFiles;
	}

	/**
	 * Method which puts values from index URL into a hashmap and returns as such
	 * @param url string
	 * @return hashmap of filenames as key and instruments as value
	 * @throws IOException
	 */
	public static HashMap<String, String> indexHashMap(String url) throws IOException {
		
		//Turn URL String into bufferedReader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		HashMap<String, String> indexHM = new HashMap<String, String>();
		
		/**
		 * Doesn't appear to work, returns null at the end of statement
		String Line = "";
		while (((Line=br.readLine()) != null)) { //Loop through each line

			//Create scanner object to break the line into multiple parts, separated by spaces
			Scanner sn = new Scanner(Line); 
			
			String fileName = sn.next();
			String instrument = sn.next();

			sn.close();
			
			indexHM.put(fileName, instrument); //add key and values to hashmap
			System.out.println(indexHM.keySet());
		}
		*/
		
		int i = 7;
		while (i > 0) {
			String Line = br.readLine();
			Scanner sn = new Scanner(Line); 
			String fileName = sn.next();
			String instrument = sn.next();
			sn.close();
			indexHM.put(fileName, instrument); //add key and values to hashmap
			i--;
		}
		return indexHM;
		
	}
	
	
	public static void main(String[] args) {
		try {
			//Obtain audio files
			ArrayList<Audio> audioFiles = getAudioFiles();
			HashMap<String, String> indexHM = indexHashMap("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
			
			for (Audio af : audioFiles) {
				
				String filename = af.FileName;
				Double duration = (double) (af.SampleCount/af.Freq);
				Double amplitude = 20 * Math.log10((af.aRMS/af.MaxAmp));
				String Instrument = indexHM.get(af.FileName);
				
				System.out.println("FileName: "+filename+", Duration: "+duration+", Amplitude: "+amplitude+", Instrument: "+Instrument);
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
