package midTermExam;

import java.util.Scanner;

public final class Particle {
	public int charge;
	public double momentum;
	public double theta;
	public double phi;
	
	public Particle(){}
	
	public Particle(int q, double p, double the, double ph){
		charge = q;
		momentum = p;
		theta = the;
		phi = ph;
	}
		
	public static Particle parseLine(String line){
		Scanner s = new Scanner(line);
		return new Particle(s.nextInt(),s.nextDouble(),s.nextDouble(),s.nextDouble());		
	}
	
	public String toString() {
		return "Charge: "+charge+"\nMomentum: "+momentum+"\nTheta: "+theta+"\nPhi: "+phi;
	}
	
	
	public static double sumP(Particle p1, Particle p2){
		double zsum = p1.momentum*Math.cos(p1.theta)+p2.momentum*Math.cos(p2.theta);
		double ysum = p1.momentum*Math.sin(p1.theta)*Math.sin(p1.phi)+p2.momentum*Math.sin(p2.theta)*Math.sin(p2.phi);
		double xsum = p1.momentum*Math.sin(p1.theta)*Math.cos(p1.phi)+p2.momentum*Math.sin(p2.theta)*Math.cos(p2.phi);
		return Math.sqrt(zsum*zsum+ysum*ysum+xsum*xsum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
