package midTermExam;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.Scanner;
	import java.util.HashMap;

	public class year2016pPt1 {
		

		public static Player parseLine(String line) {
			// Return a Player object containing all the data of one player. 
			
			Scanner mult = new Scanner(line);
			mult.useDelimiter("\t"); // Set up new scanner to analyse multiple numbers in the same line of the input file

			String player = mult.next(); // Put the data in each column of the input file into each of these variables. 
			String team = mult.next();
			String pos = mult.next();
			int g = Integer.parseInt(mult.next());
			int ab = Integer.parseInt(mult.next());
			int r = Integer.parseInt(mult.next());
			int h = Integer.parseInt(mult.next());
			int d = Integer.parseInt(mult.next());
			int t = Integer.parseInt(mult.next());
			int hr = Integer.parseInt(mult.next());
			double rbi = Double.parseDouble(mult.next());
			double avg = Double.parseDouble(mult.next());
			double obp = Double.parseDouble(mult.next());
			
			mult.close(); // Close scanner
			return new Player(player, team, pos, g, ab, r, h, d, t, hr, rbi, avg, obp); // Output as a new object containing all of the data. 
		}

		public static ArrayList<Player> dataFromURL(String urlName) throws IOException {
			// Create an ArrayList of Player objects from a URL
			
			URL u = new URL(urlName);
			InputStream is = u.openStream();
			InputStreamReader r = new InputStreamReader(is);
			BufferedReader b = new BufferedReader(r);
					
			ArrayList<Player> players = new ArrayList<Player>(); // Define ArrayList containing Player objects
			String line = ""; // Initialise string so that it is not initially null for the while loop below
			b.readLine(); // Ignore the first two lines
			b.readLine();
			
			while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
				players.add(parseLine(line));
			}
			
			return players;
		}
		
		public static void main(String[] args) {
			try {
				ArrayList<Player> allPlayers = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/MLB2001Hitting.txt"); // Retrieve data from URL
				System.out.printf("The total number of players recorded in the file is %d. %n", allPlayers.size()); // Output total number of players
				
				HashMap<String, ArrayList<Player>> playersByTeams = new HashMap<String, ArrayList<Player>>(); // Initialise HashMap to hold team names as keys and an ArrayList of players in each team as the values.
				Player mostHRPlayer = null; // Initialise variables to hold the details of the player who hit the most home runs
				int mostHRs = 0;
				for (Player p: allPlayers) { // Loop over all players
					
					if (p.HR > mostHRs) { // Update variables if this player had more home runs than the currently held MostHRs
						mostHRs = p.HR;
						mostHRPlayer = p;
					}
					
					// Sort players by team and put into the playersByTeam HashMap. 
					if (playersByTeams.get(p.Team) == null) { // If the team has not yet been put into the HashMap, create a new ArrayList containing the current player and put it into the HashMap.
						ArrayList<Player> temp = new ArrayList<Player>();   
						temp.add(p);
						playersByTeams.put(p.Team, temp); 
					}
					else { // The playersByTeam HashMap already contains the player's team. Retrieve the ArrayList of all players sorted so far, add the current player to the list and put the updated list back into the HashMap.
						ArrayList<Player> currentTeam = playersByTeams.get(p.Team);
						currentTeam.add(p);
						playersByTeams.put(p.Team, currentTeam);
					}
				}
				System.out.printf("The player with the most home runs in 2001 was %s with %d home runs, playing for team %s in position %s. %n", mostHRPlayer.playerName, mostHRs, mostHRPlayer.Team, mostHRPlayer.Pos);
				System.out.printf("He played %d games, with %d At-Bats, %d total runs scored, %d hits, %d doubles, %d triples, a Runs Batted In figure of %.3f, a Batting Average of %.3f and an On-Base Percentage of %.3f.%n%n", mostHRPlayer.Games, mostHRPlayer.AB, mostHRPlayer.R, mostHRPlayer.H, mostHRPlayer.Doubles, mostHRPlayer.Triples, mostHRPlayer.RBI, mostHRPlayer.AVG, mostHRPlayer.OBP);
				
				for (String t: playersByTeams.keySet()) { // Do the following for each team. 
					
					int atbNumber = 0; // Initialise variables to hold number of players with >=10 At-Bats, maximum values and player names. 
					Player maxSLGPlayer = null;
					Player maxOPSPlayer = null;
					double maxSLG = 0.;
					double maxOPS = 0.;
					
					ArrayList<Player> teamPlayers = playersByTeams.get(t); // Retrieve the ArrayList of players for the team currently being considered. 
					
					for (Player atb: teamPlayers) {
						if (atb.AB >= 10) { // Do the following if the current player being considered has at least 10 At-Bats. 
							atbNumber++; // Increment the number of players so far considered who have at least 10 At-Bats. 
							
							double SLG = (atb.H + (2 * atb.Doubles) + (3 * atb.Triples) + (4 * atb.HR)) / (double)atb.AB; // Calculate Slugging Percentage and update maximum variables if needed.
							if (SLG > maxSLG) {
								maxSLG = SLG;
								maxSLGPlayer = atb;
								}
							
							double OPS = atb.OBP + SLG; // Calculate On-Base Plus Slugging figure and update maximum values if needed. 
							if (OPS > maxOPS) {
								maxOPS = OPS;
								maxOPSPlayer = atb;
							}
							
						}
					}
					
					System.out.println("------------------------------------------------------------------------");
					System.out.printf("In the team %s, %d players had at least 10 At-Bats. %n%n", t, atbNumber);
					System.out.printf("Of the players with at least 10 At-Bats in this team, %s had the highest Slugging Percentage, with a SLG of %f. %n", maxSLGPlayer.playerName, maxSLG);
					System.out.printf("He played for team %s in position %s, with %d games, %d At-Bats, %d total runs scored, %d hits, %d doubles, %d triples, %d home runs, a Runs Batted In figure of %.3f, a Batting Average of %.3f and an On-Base Percentage of %.3f.%n%n", maxSLGPlayer.Team, maxSLGPlayer.Pos, maxSLGPlayer.Games, maxSLGPlayer.AB, maxSLGPlayer.R, maxSLGPlayer.H, maxSLGPlayer.Doubles, maxSLGPlayer.Triples, maxSLGPlayer.HR, maxSLGPlayer.RBI, maxSLGPlayer.AVG, maxSLGPlayer.OBP);
					
					System.out.printf("Of the players with at least 10 At-Bats in this team, %s had the highest On-Base Plus Slugging figure, with an OPS of %f. %n", maxOPSPlayer.playerName, maxOPS);
					System.out.printf("He played for team %s in position %s, with %d games, %d At-Bats, %d total runs scored, %d hits, %d doubles, %d triples, %d home runs, a Runs Batted In figure of %.3f, a Batting Average of %.3f and an On-Base Percentage of %.3f.%n%n", maxOPSPlayer.Team, maxOPSPlayer.Pos, maxOPSPlayer.Games, maxOPSPlayer.AB, maxOPSPlayer.R, maxOPSPlayer.H, maxOPSPlayer.Doubles, maxOPSPlayer.Triples, maxOPSPlayer.HR, maxOPSPlayer.RBI, maxOPSPlayer.AVG, maxOPSPlayer.OBP);

				}		
			}
			catch (IOException e) {
				System.out.println(e);
			}

		}

	}
