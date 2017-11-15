package midTermExam;

public class Hitter {

	//initialise member variables
	String name;
	String team;
	String pos;
	int games;
	int ab;
	int runs;
	int Hits;
	int Doubles;
	int Triples;
	int Hr;
	int rbi;
	double avg;
	double obp;
	
	
	//create constructor to create object with hitter details
	public Hitter(String name, String team, String pos, int games, int ab, int runs, int hits, int doubles, int triples,
			int hr, int rbi, double avg, double obp) {
		this.name = name;
		this.team = team;
		this.pos = pos;
		this.games = games;
		this.ab = ab;
		this.runs = runs;
		this.Hits = hits;
		this.Doubles = doubles;
		this.Triples = triples;
		this.Hr = hr;
		this.rbi = rbi;
		this.avg = avg;
		this.obp = obp;
	}
	
	public String getTeam() {
		return team;
	}

	public String getDetails() {
		return ("Name: "+name+", Team: "+team+", Pos:"+pos+", N.o of Games: "+games+", Runs: "+runs+", hits: "+Hits+", doubles: "+Doubles+", triples: "+Triples
				+", hit rate: " +Hr+", rbi: "+rbi+", average: "+avg+", obp: "+obp);
	}
	
}
