package Practice;
//String FileName = url.substring(58); //File name is after the 58th character
//ArrayList<Integer> nums = new ArrayList<Integer>();
//Collections.sort(nums); //Sorts the order. There is also Collections.Max().
//Hindsight, make another hashmap with region as key and arraylist of region objects as values .
//Have you tried hashmap inside a hashmap?
//double totalTimeSb1 = System.currentTimeMillis() - startTimeSb1;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Useful_Methods {

/**
 * Create bufferedReader object from URL String
 * @param url
 * @return
 * @throws MalformedURLException
 * @throws IOException
 */
private static BufferedReader brFromURL(String url) throws MalformedURLException, IOException {
	//Turns data from URL into buffered reader object
	URL u = new URL(url);
	InputStream is = u.openStream();
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	
	return br;
}

/**
 * Method which calculates the energy and prints to a file
 * @throws IOException
 */
public static void writeToFile() throws IOException {
	    
    File fout = new File("C:\\files\\signal.txt"); //creates a new file and saves in this particular location
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos)); //creates bufferedwriter object
 
	for (int i = 0; i < 100; i++) { //loops through 100 times
		
		double energy = generateEnergy(2.5, 0.25); //gets energy from other method, setting mean to 2.5 and standard dev to 0.25
		String energyString = String.valueOf(energy);
		bw.write(energyString); //writes the bytes to file
		bw.newLine(); //reads to a new line each time
		
	}
 
	bw.close();

}

 /** HashMap<String,ArrayList<Player>> teams = new HashMap<String,ArrayList<Player>>();

for (Player p : players) { //Loop through players
	if (teams.get(p.Team) == null) { //if keyset doesn't exist, create it
		ArrayList<Player> playerArray = new ArrayList<Player>(); //Create arraylist and adds player
		playerArray.add(p);
		teams.put(p.Team, playerArray);
	}
	else {
		ArrayList<Player> playerArray = teams.get(p.Team); //Adds player to existing arrayList
		playerArray.add(p); 
		teams.put(p.Team, playerArray);
	}
		 
}//System.out.print(teams.keySet());
*/

}
