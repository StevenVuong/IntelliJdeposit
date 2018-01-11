package Final2012;

/**
 * Import necessary modules
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class Methods {
	
	public static Event parseLineBackground(String line) {
		
		Scanner sn = new Scanner(line); //Create new scanner object
		
		//Parse details into value
		Integer lowEdge = Integer.parseInt(sn.next());
		Integer highEdge = Integer.parseInt(sn.next());
		Double predictedAmount = Double.parseDouble(sn.next());
		
		sn.close();

		return new Event(lowEdge, highEdge, predictedAmount);
	}
	
	public static ArrayList<Event> dataFromURLBackground(String url) throws MalformedURLException, IOException {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Ignore first line
		br.readLine();
		
		ArrayList<Event> eventArrayList = new ArrayList<Event>(); //Initialise arraylist
		String line = ""; //Initialise line
		
		while ((line = br.readLine()) != null) { //loop through values and add to arrayList
			eventArrayList.add(parseLineBackground(line));
		}
		
		return eventArrayList;
	}
	
	public static ArrayList<Higgs> dataFromHiggs(String url) throws MalformedURLException, IOException{
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Ignore first line
		br.readLine();
		
		ArrayList<Higgs> higgsArrayList = new ArrayList<Higgs>(); //Initialise arraylist
		String line = ""; //Initialise line
		
		while ((line = br.readLine()) != null) { //loop through values and add to arrayList
			
			Scanner sn = new Scanner(line);
			
			//Parses values into Higgs objects
			String Channel = sn.next();
			Double Energy = Double.parseDouble(sn.next());
			
			higgsArrayList.add(new Higgs(Channel, Energy));
			
		}
		
		return higgsArrayList;
		
	}
	
	public static HashMap<Double, ArrayList<Higgs>> EnergyHashMap(ArrayList<Higgs> higgsArray, String channel) {
		
		ArrayList<Higgs> ggArray = new ArrayList<Higgs>(); //Initialise arrayList
		
		for (Higgs h : higgsArray) { //loop through arraylist
			if (h.Channel.equals(channel)) { //selects values of particular channel
				ggArray.add(h);
			}
		}
		
		double i = 100.5; //initialise value
		HashMap<Double, ArrayList<Higgs>> higgsHashMap = new HashMap<Double, ArrayList<Higgs>>(); //Initialise hashMap
		
		while (i < 200.5) {
			
			for (Higgs h : ggArray) { //loop through ArrayList of channel GG
				
				double checker = Math.abs(h.Energy - i); //If the value is within 0.5 of i, it falls within the energy boundary for that bin
				
				if (checker <= 0.5) { //if falls within that energy boundary, add to that keyset corresponding to energy boundaries
					
					if (higgsHashMap.get(i) == null) {// if keyset doesn't exist, create it
						
						ArrayList<Higgs> energyHiggsArray = new ArrayList<Higgs>(); //Initialise arraylist
						energyHiggsArray.add(h);
						higgsHashMap.put(i, energyHiggsArray);
						
					}
					else {
						
						ArrayList<Higgs> energyHiggsArray = higgsHashMap.get(i);
						energyHiggsArray.add(h);
						higgsHashMap.put(i, energyHiggsArray);
						
					}
					
				}
				
			}
			
			i = i + 1.0;
		}
		
		return higgsHashMap;
		
	}
	
	public static double logLikelyhood(ArrayList<Event> backgroundArrayList, HashMap<Double, ArrayList<Higgs>> MainHashMap) {
		
		Double logLikelyhood = 0.0;
		
		for (Double i : MainHashMap.keySet()) { //can loop through entire energy set as only 100 values
			
			ArrayList<Higgs> higgsArray = MainHashMap.get(i); //grab arraylist corresponding to the key
			
			for (Event e : backgroundArrayList) {
				
				if ((i - e.lowEdge) < 0.52) { //condition for matching energy 
					
					//calculate log likelyhood and add 
					logLikelyhood += (e.predictedNumberEvents - higgsArray.size()) + (higgsArray.size() * (Math.log(higgsArray.size() / e.predictedNumberEvents)));
					
					
				}
				
			}
			
		}
		
		return logLikelyhood;
		
	}

}
