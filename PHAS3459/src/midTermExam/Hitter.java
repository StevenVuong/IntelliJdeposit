package midTermExam;

public class Hitter {

	//initialise member variables
	String name;
	String team;
	String pos;
	int games;
	int ab;
	int runs;
	int hits;
	int doubles;
	int triples;
	int hr;
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
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.hr = hr;
		this.rbi = rbi;
		this.avg = avg;
		this.obp = obp;
	}
	
	public String getTeam() {
		return team;
	}

	public String getDetails() {
		return ("Name: "+name+", Team: "+team+", Pos:"+pos+", N.o of Games: "+games+", Runs: "+runs+", hits: "+hits+", doubles: "+doubles+", triples: "+triples
				+", hit rate: " +hr+", rbi: "+rbi+", average: "+avg+", obp: "+obp);
	}
	
}
