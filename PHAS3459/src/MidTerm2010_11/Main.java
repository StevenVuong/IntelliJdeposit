package MidTerm2010_11;

/**
 * MidTerm 2010_11. Class with main method.
 * @author Steven Vuong
 * @version 07-01-2018
 */
/**
 * Import nevessary
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			//Grab hashMap for each neutrinoEvent
			HashMap<String, ArrayList<NeutrinoEvent>> hm = Methods.neutrinoEventHashMapNames("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/midterm/NeutrinoEvents.txt");
		
			//Grab ArrayList for neutrinoEvents
			ArrayList<NeutrinoEvent> ArrayListExpt = Methods.dataFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2010-11/midterm/NeutrinoExperiments.txt");
			
			for (String name : hm.keySet()) { //Loops through names
				
				ArrayList<NeutrinoEvent> neutrinoAL = hm.get(name); //arrayList of names for certain experiment
				
				HashMap<String, ArrayList<NeutrinoEvent>> neutrinoHM = new HashMap<String, ArrayList<NeutrinoEvent>>(); //initialise hashmap for equipment with Interaction type as key and values corresponding 
				
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
				
				for (String Interaction : neutrinoHM.keySet()) { //loops through interactions
					
					ArrayList<NeutrinoEvent> nAL = neutrinoHM.get(Interaction); //arraylist of interactions for name
					
					System.out.println("Experiment: "+name+", Equipment: "+Interaction+", Number of events: "+nAL.size());
					
					for (NeutrinoEvent ne : ArrayListExpt) {
						if (ne.Name.equals(name) && (ne.InteractionType.equals(Interaction))){
							
							Double eventsNumberPredicted = ne.Energy;
							Double denominator = Math.pow(eventsNumberPredicted, 0.5);
							Double Significance = (nAL.size() - eventsNumberPredicted)/denominator; //Calculates significance
							
							//Print statement conditions
							if (Significance > 3) {System.out.println("Appearance likely");}
							if (Significance < -3) {System.out.println("Dissapearance likely");}
							if ((Significance < 3) && (Significance > -3)) {System.out.println("Neither likely to appear or dissapear");}
							System.out.println("");
								
						}
					}
					
				}
				
			}
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
	}

}
