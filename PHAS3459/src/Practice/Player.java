package Practice;
/**
 * Class which contains Player constructor and toString get Details
 * @author Steven Vuong
 * @version 28-12-2017
 */
public class Player {
	
	//Initialise Player Details as objects
	String Name; String Team; String Pos;
	Integer Games; Integer AtBat; Integer Runs;
	Integer Hits; Integer Doubles; Integer Triples;
	Integer HomeRuns; Integer RBI;
	Double Average; Double OBP;
	
	//Generate constructor with player details
	public Player(String name, String team, String pos, Integer games, Integer atBat, Integer runs, Integer hits,
			Integer doubles, Integer triples, Integer homeRuns, Integer rBI, Double average, Double oBP) {
		Name = name;
		Team = team;
		Pos = pos;
		Games = games;
		AtBat = atBat;
		Runs = runs;
		Hits = hits;
		Doubles = doubles;
		Triples = triples;
		HomeRuns = homeRuns;
		RBI = rBI;
		Average = average;
		OBP = oBP;
	}
	
	/**
	 * Method to return player details
	 * @return
	 */
	public String getDetails() {
		return ("Name: "+Name+" || Team: "+Team+" || Position: "+Pos+" || Games: "+Games+" || AtBats: "+AtBat+" || Runs: "+Runs+" || Hits: "+Hits+" || Doubles: "+Doubles
				+" || Triples: "+Triples+" || HomeRuns: "+HomeRuns+" || RBI: "+RBI+" || Average: "+Average+" || OBP: "+OBP);
	}

}
