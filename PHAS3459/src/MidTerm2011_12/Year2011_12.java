package MidTerm2011_12;

/**
 * Import necessary classes
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Year2011_12 {

	public static void main(String[] args) {
		try {
			
			//Get ArrayList of position objects from URL
			ArrayList<Position> positionsArrayList = PositionMethods.dataFromUrl("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2011-12/midterm/bpm.txt");
			
			//Get HashMap of positions with the z-location as the key (BPM z-position)
			HashMap<Double, ArrayList<Position>> positionsHashMap = PositionMethods.positionHashMap(positionsArrayList);
			
			System.out.println("There are "+positionsHashMap.keySet().size()+" BPMs");
			System.out.println("BPM distances: "+positionsHashMap.keySet()+" relative from the origin");
			System.out.println("");
			
			//Initialise variables
			double minRadius = Double.MAX_VALUE;
			double minRadiusZPos = 0.0;
			
			for (Double zPos : positionsHashMap.keySet()) { //Loop through BPM positions
				
				ArrayList<Position> positionsAL = positionsHashMap.get(zPos); //Create arraylist from data for position
				
				//Initialise variables
				double sumX = 0.0;
				double sumY = 0.0;

				for (Position pos : positionsAL) { //Loop through data points
					
					sumX += pos.x;
					sumY += pos.y;
					
				}
				//Calculate mean x and y values
				double meanX = (sumX / positionsAL.size());
				double meanY = (sumY / positionsAL.size());
				
				//Initialise variables
				double radialDistance = 0.0; 
				double sumRadialDistances = 0.0;
				double maxRadius = 0.0;

				for (Position pos : positionsAL) { //Loop through each data point
					
					radialDistance = Math.pow((pos.x - meanX),2) + Math.pow((pos.y - meanY), 2); //Calculates radial distance for each particle
					sumRadialDistances += radialDistance;
					
					if (radialDistance > maxRadius) { //Sets condition to find maximum radius
						maxRadius = radialDistance;
					}
					if (radialDistance < minRadius) { //Sets condition to find minimum radius
						minRadius = radialDistance;
						minRadiusZPos = pos.z;
					}
					
				}
				double rmsRadius = (sumRadialDistances / positionsAL.size()); //Calculates rms radius
				
				System.out.println("Position: "+zPos);
				System.out.println("Number of particles measured: "+positionsAL.size());
				System.out.println("Mean x pos: "+meanX);
				System.out.println("Mean y pos: "+meanY);
				System.out.println("RMS Radius: "+rmsRadius);
				System.out.println("Max radius: "+maxRadius);
				System.out.println("");
				
			}
			
			System.out.println("The pipe narrows at: "+minRadiusZPos+" with radius: "+minRadius);
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
