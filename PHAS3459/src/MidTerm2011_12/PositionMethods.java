package MidTerm2011_12;
/**
 * Class containing methods to be used to analyse poisiton data
 * @author Steven Vuong
 * @version 01/01/2018
 */

/**
 * Import necessary classes
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class PositionMethods {

	/**
	 * Method which parses data from line and creates position object
	 * @param String line
	 * @return Position object
	 */
	public static Position parseLine(String line) {
		
		Scanner sn = new Scanner(line); //Creates new scanner object
		
		double x = Double.parseDouble(sn.next());
		double y = Double.parseDouble(sn.next());
		double z = Double.parseDouble(sn.next());
		
		sn.close();
		
		return new Position(x, y, z);
	}
	
	/**
	 * Method which takes data from URL and places in ArrayList to sort
	 * @param String url
	 * @return ArrayList of position objects
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ArrayList<Position> dataFromUrl(String url) throws MalformedURLException, IOException {
		
		//Turn URL String into bufferedreader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		br.readLine(); //Ignore first line
	
		//Initialise arraylist and string
		ArrayList<Position> positionsArrayList = new ArrayList<Position>();
		String line = "";
		
		while ((line=br.readLine()) != null) { //Loop through values and add to array list
			positionsArrayList.add(parseLine(line));
		}
		
		return positionsArrayList;
	}
	
	/**
	 * Method to sort through data and put in hashmap with z position as key and position array as values corresponding to the z-position
	 * @param exoplanetsArrayList
	 * @return HashMap with method as key and arraylist of exoplanets as values
	 */
	public static HashMap<Double, ArrayList<Position>> positionHashMap(ArrayList<Position> positionsAL) {
		
		HashMap<Double, ArrayList<Position>> positionHM = new HashMap<Double, ArrayList<Position>>(); //Initialise hashmap
		
		for (Position pos : positionsAL) {
			
			if ((positionHM.get(pos.z)) == null) { //Check if key already exists within hashmap
				ArrayList<Position> posAL = new ArrayList<Position>();
				posAL.add(pos);
				positionHM.put(pos.z, posAL);
			}
			else {
				ArrayList<Position> posAL = positionHM.get(pos.z);
				posAL.add(pos);
				positionHM.put(pos.z, posAL);
			}	
		}
		
		return positionHM;
	}
	
}
