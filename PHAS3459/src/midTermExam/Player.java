package midTermExam;

public class Player {

		
		String playerName, Team, Pos; // Initialise member variables
		int Games, AB, R, H, Doubles, Triples, HR;
		double RBI, AVG, OBP;
		
		public Player(String pl, String te, String pos, int games, int ab, int r, int h, int d, int t, int hr, double rbi, double avg, double obp) {
			// Constructor to put the inputed player data into the member variables of the object
			
			this.playerName = pl;
			this.Team = te;
			this.Pos = pos;
			this.Games = games;
			this.AB = ab;
			this.R = r;
			this.H = h;
			this.Doubles = d;
			this.Triples = t;
			this.HR = hr;
			this.RBI = rbi;
			this.AVG = avg;
			this.OBP = obp;
		}
	}
