package midTermExam;

public class fourVector {

	//initialise variables
	
	double E;
	int nTracks;
	String triggerId;
	double charge;
	double px;
	double py;
	double pz;
	
	//constructor to create object containing all the details of a 4-vector
	public fourVector(double E, int nTracks, String triggerId, double charge, double px, double py, double pz) {
		
		this.E = E;
		this.nTracks = nTracks;
		this.triggerId = triggerId;
		this.charge = charge;
		this.px = px;
		this.py = py;
		this.pz = pz;
		
	}

	//generate getters for variables
	public double getE() {
		return E;
	}

	public int getnTracks() {
		return nTracks;
	}

	public String getTriggerId() {
		return triggerId;
	}

	public double getCharge() {
		return charge;
	}
	
	public double getP() { //calculates the magnitude of momentum
		return Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2) + Math.pow(pz, 2));
	}
	
	public fourVector combineFourVector(fourVector v1, fourVector v2) { //adds the two fourvectors
		return new fourVector(v1.E+v2.E, v1.nTracks, v1.triggerId, 0, v1.px+v2.px, v1.py+v2.py, v1.pz+v2.pz);
	}
	
	public String getDetails() {
		return ("Number of Tracks: " + nTracks + ", Trigger ID: " + triggerId + ", Charge: " + charge + 
				"Vector [E, px, py, pz] :" + "[" + E + ", " + px + ", " + py + ", " + pz + "]");
	}
	
}
