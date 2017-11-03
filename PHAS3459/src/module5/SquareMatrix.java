package module5;

import java.util.*;

public class SquareMatrix {
	
	private double[][] M;

	public SquareMatrix(double[][] elements) throws Exception{ //creates constructor for 2d array
		this.M = elements;
		int lengthArray = elements.length;  //sets length of array
		for (int numOfRows=0; numOfRows < lengthArray; numOfRows++) { //makes comparison row by row
			if (elements[numOfRows].length != lengthArray) { //checks rows[] against the columns
				throw new Exception ("Matrix is not Square in row: "+ (numOfRows+1)); //catches any possible errors
			}
		}
	}
	
	public String toString() { //A toString which returns the Matrix in a readable format
		return "SquareMatrix" + Arrays.toString(M) + "]";
	}
}
