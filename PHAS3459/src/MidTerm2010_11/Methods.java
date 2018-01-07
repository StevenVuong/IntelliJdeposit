package MidTerm2010_11;
/**
 * Class containing methods for Java MidTerm exam 2010_11
 * @author Steven Vuong
 * @version 07-01-2018
 */
/**
 * Import necessary Modules
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Methods {

	/**
	 * Method which parses values from single line to output NeutrinoEvent object
	 * @param String line
	 * @return NeutrinoEvent object
	 */
	public static NeutrinoEvent parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Create new scanner object with line
		
		//Parse Objects
		String Name = sn.next();
		String InteractionType = sn.next();
		Double Energy = Double.parseDouble(sn.next());
		
		return new NeutrinoEvent(Name, InteractionType, Energy);
	}
	
	/**
	 * Method to create arrayList of NeutrinoEvent objects from the URL
	 * @param url String
	 * @return ArrayList<NeutrinoEvent>
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static ArrayList<NeutrinoEvent> dataFromUrl(String url) throws IOException, MalformedURLException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Initialise arraylist & line
		ArrayList<NeutrinoEvent> neutrinoEventArrayList = new ArrayList<NeutrinoEvent>(); 
		String line = "";
		
		while ((line = br.readLine()) != null) { //loop through values and add to arrayList
			neutrinoEventArrayList.add(parseLine(line)); 
		}
		
		return neutrinoEventArrayList;
	}
	
	/**
	 * Method which creates hashMap with Name of event as key and arraylist of neutrinoEvent values as values
	 * @return HashMap<String, ArrayList<NeutrinoEvent>>
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static HashMap<String, ArrayList<NeutrinoEvent>> neutrinoEventHashMapNames(String url) throws IOException, MalformedURLException {
		
		//Grabs all the neutrino event data
		ArrayList<NeutrinoEvent> allNeutrinoEvents = dataFromUrl(url);
		
		//Initialise HashMap using name as key
		HashMap<String, ArrayList<NeutrinoEvent>> neutrinoEventHM = new HashMap<String, ArrayList<NeutrinoEvent>>();
		
		for (NeutrinoEvent ne : allNeutrinoEvents) { //Loop through all neutrino events
			
			if (neutrinoEventHM.get(ne.Name) == null) { //Check if key already exists
				
				ArrayList<NeutrinoEvent> neutrinoAL = new ArrayList<NeutrinoEvent>();//Initialise ArrayList
				neutrinoAL.add(ne);
				neutrinoEventHM.put(ne.Name, neutrinoAL); //Add to hashMap
				
			}
			else {
				
				ArrayList<NeutrinoEvent> neutrinoAL = neutrinoEventHM.get(ne.Name);
				neutrinoAL.add(ne);
				neutrinoEventHM.put(ne.Name, neutrinoAL);
				
			}
			
		}
		
		return neutrinoEventHM;
		
	}
	
	public static HashMap<String, ArrayList<NeutrinoEvent>> neutrinoEventsHashMapEquipment(HashMap<String, ArrayList<NeutrinoEvent>> hm) throws IOException, MalformedURLException {
		
		for (String name : hm.keySet()) { //Loops through names
			
			ArrayList<NeutrinoEvent> neutrinoAL = hm.get(name); //arrayList of names for certain experiment
			
			HashMap<String, ArrayList<NeutrinoEvent>> neutrinoHM = new HashMap<String, ArrayList<NeutrinoEvent>>(); //initialise hashmap for equipment
			
			for (NeutrinoEvent ne : neutrinoAL) { //Loop through neutrino events by name
				
				if (neutrinoHM.get(ne.InteractionType) == null) {//Check if key exists
					
					ArrayList<NeutrinoEvent> nAL = new ArrayList<NeutrinoEvent>(); //initialise AL
					nAL.add(ne);
					neutrinoHM.put(ne.InteractionType, nAL);
					
				}
				
				else {
					
					ArrayList<NeutrinoEvent> nAL = neutrinoHM.get(ne.InteractionType);
					nAL.add(ne);
					neutrinoHM.put(ne.InteractionType, nAL);
					
				}
			}
		}
		return null;
	}
	
}
