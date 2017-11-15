package midTermExam;

//import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class Year2016 {

	public static Hitter parseLine(String line) {
		// return a Hitter object with all the data of one Hitter

		Scanner mult = new Scanner(line).useDelimiter("\t"); // scans each value, separating by tabs

		// puts data into each variable
		String name = mult.next();
		String team = mult.next();
		String pos = mult.next();
		int games = Integer.parseInt(mult.next());
		int ab = Integer.parseInt(mult.next());
		int runs = Integer.parseInt(mult.next());
		int hits = Integer.parseInt(mult.next());
		int doubles = Integer.parseInt(mult.next());
		int triples = Integer.parseInt(mult.next());
		int hr = Integer.parseInt(mult.next());
		int rbi = Integer.parseInt(mult.next());
		double avg = Double.parseDouble(mult.next());
		double obp = Double.parseDouble(mult.next());

		mult.close(); // close scanner

		// output as new hitter Object with all of the parsed data
		return new Hitter(name, team, pos, games, ab, runs, hits, doubles, triples, hr, rbi, avg, obp);

	}

	public static ArrayList<Hitter> dataFromURLHitter(String urlName) throws Exception {
		// Create an ArrayList of Hitter objects from a URL

		// takes url and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<Hitter> hitters = new ArrayList<Hitter>(); // Define ArrayList containing Hitter objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		b.readLine(); // Ignore the first two lines
		b.readLine();

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			hitters.add(parseLine(line));
		}

		return hitters;

	}

	public static void main(String[] args) {
		try {

			ArrayList<Hitter> allHitters = dataFromURLHitter(
					"http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
			System.out.println("\n There are  " + allHitters.size() + " Hitters in this list");

			// Initialise variables
			int mostHomeRuns = 0;
			Hitter mostHomeRunsHitter;
			String mostHomeRunsHitterDetails = null;
			HashMap<String, ArrayList<Hitter>> hittersByTeam = new HashMap<String, ArrayList<Hitter>>();

			for (Hitter h : allHitters) { // loop over all hitters

				// If the team has not yet been put into the HashMap, create a new ArrayList
				// containing the current hitter and put it into the HashMap.
				if (hittersByTeam.get(h.team) == null) {
					ArrayList<Hitter> hitterArray = new ArrayList<Hitter>();
					hitterArray.add(h);
					hittersByTeam.put(h.team, hitterArray);
				}
				// If the team is already registered as a hashmap, scans hashmap for
				// corresponding key, add current hitter to arraylist and update hashmap
				else {
					ArrayList<Hitter> hitterArray = hittersByTeam.get(h.team);
					hitterArray.add(h);
					hittersByTeam.put(h.team, hitterArray); // associates key to value
				}

				if (h.Hr > mostHomeRuns) { // condition to set for max homeruns
					mostHomeRuns = h.Hr;
					mostHomeRunsHitter = h;
					mostHomeRunsHitterDetails = mostHomeRunsHitter.getDetails();
				}

			}

			for (String team : hittersByTeam.keySet()) { // loop through each team

				// initialise variables
				int atBatsCounter = 0;
				double highestSluggingPlayerValue = 0;
				String highestSluggingPlayer = null;
				//String highestSluggingPlayerDetails = null;
				double OPSmax = 0;
				String highestOPSPlayer = null;

				ArrayList<Hitter> hittersInTeam = hittersByTeam.get(team); // creates arraylist of hitters for team
																			// considered
				
				for (Hitter hit : hittersInTeam) { // loops through hitters in the team
					if (hit.ab >= atBatsCounter) { // condition for At-bats counter to run
						 atBatsCounter++;

						double SLG = (((hit.Hits) + (2 * hit.Doubles) + (3 * hit.Triples) + (4 * hit.Hr)) / ((double) hit.ab));
						if (SLG > highestSluggingPlayerValue) {
							highestSluggingPlayerValue = SLG;
							highestSluggingPlayer = hit.name;
							//highestSluggingPlayerDetails = hit.getDetails();
						}

						 double OPS = (SLG + hit.obp);
								if (OPS > OPSmax ) {
									OPSmax = OPS;
									highestOPSPlayer = hit.name;
								}
						
					}
				}
//				System.out.println("------------------------------------------------------------------------");
				System.out.println(
						"\nfor team " + team + ", there are " + atBatsCounter + " players with at least 10 At-Bats");
				System.out.println("for team " + team + ", the player with the highest slugging percentage is "
						+ highestSluggingPlayer+ " for top 10 at bat players");
				System.out.println("for team " + team+", the player with the highest OPS is " + highestOPSPlayer + " for top 10 at bat players");
			}

			System.out.println("\n The most homeruns Hitter has details: " + mostHomeRunsHitterDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
