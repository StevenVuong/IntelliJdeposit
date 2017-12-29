package Practice;

//Import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class Year2016 {

	/**
	 * Method to details from line into objects
	 * @param line of player details
	 * @return Player object with details on player
	 */
	public static Player parseLine(String line) {
		
		Scanner sn = new Scanner(line).useDelimiter("\t"); //Separate tabbed details
		
		//Process player details into objects
		String Name = sn.next();
		String Team = sn.next();
		String Pos = sn.next();
		Integer Games = Integer.parseInt(sn.next());
		Integer Atbat = Integer.parseInt(sn.next());
		Integer Runs = Integer.parseInt(sn.next());
		Integer Hits = Integer.parseInt(sn.next());
		Integer Doubles = Integer.parseInt(sn.next());
		Integer Triples = Integer.parseInt(sn.next());
		Integer HomeRuns = Integer.parseInt(sn.next());
		Integer RBI = Integer.parseInt(sn.next());
		Double Average = Double.parseDouble(sn.next());
		Double OBP = Double.parseDouble(sn.next());
		
		sn.close(); //Close scanner object
		
		return new Player(Name, Team, Pos, Games, Atbat, Runs, Hits, Doubles, Triples, HomeRuns, RBI, Average, OBP);
		
	}

	/**
	 * Method to obtain all players from URL and sort into player objects before adding to arraylist.
	 * @param url string
	 * @return arraylist of players
	 * @throws Exception
	 */
	public static ArrayList<Player> dataFromUrl(String url) throws Exception {
		
		//Turns data from URL into buffered reader object
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//Initialise player arraylist
		ArrayList<Player> playerAL = new ArrayList<Player>();
		String line = "";
		
		//Ignore first two lines (Text and empty
		br.readLine();
		br.readLine();
		
		while ((line = br.readLine()) != null) { //loops through URL and adds players to arraylist
			playerAL.add(parseLine(line));
		}
		
		return playerAL;
		
	}
	
	public static void main(String[] args) {
		try {
			
			//Create Arraylist of all the players containing player objects
			ArrayList<Player> players = dataFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
			System.out.println("There are " + players.size() + " number of players");
			
			Integer maxHomeRuns = 0; //Initialising values
			String maxHomeRunnerDetails = null; 
			
			for (Player p : players) { //Loop through players
				if (p.HomeRuns > maxHomeRuns) { //Set condition for max home runs
					maxHomeRuns = p.HomeRuns;
					maxHomeRunnerDetails = p.getDetails();
				}
			}
			System.out.println("Max Home Runner Details: "+maxHomeRunnerDetails);
			
			//Create HashMap with team as the key and arraylist of players in team as values
			HashMap<String,ArrayList<Player>> teams = new HashMap<String,ArrayList<Player>>();
			
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
			System.out.println("");
			
			for (String team : teams.keySet()) { //Loop through each team

				//Initialise Variable
				Integer AtBatCount = 0; 
				double highestSlugPercent = 0.0; 
				Player HighestSlugger;
				String HighestSluggerDetails = null;
				double highestOPS = 0.0;
				Player HighestOPS;
				String HighestOPSDetails = null;
				ArrayList<Player> playersAL = teams.get(team);
				
				for (Player p : playersAL) {
					double SLG = (((p.Hits) + (2*p.Doubles) + (3*p.Triples) + (4*p.HomeRuns))/(double) p.AtBat);
					double OPS = SLG + p.OBP;
					if (p.AtBat >= 10) {
						AtBatCount++;
						if (SLG > highestSlugPercent) {
							highestSlugPercent = SLG;
							HighestSlugger = p;
							HighestSluggerDetails = p.getDetails();
						}
						if (OPS > highestOPS) {
							highestOPS = OPS;
							HighestOPS = p;
							HighestOPSDetails = p.getDetails();
						}
					}
				}
				System.out.println("");
				System.out.println("Team: "+team);
				System.out.println("Number of players with at least 10 atBats: "+AtBatCount);
				System.out.println("Highest Slugging Percentage Player" + HighestSluggerDetails);
				System.out.println("Highest OPS player details: "+HighestOPSDetails);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
