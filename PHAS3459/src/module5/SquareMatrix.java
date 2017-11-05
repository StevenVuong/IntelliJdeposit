package module5;
//import necessary modules
import java.lang.reflect.Array;
import java.util.*;

public class SquareMatrix {

	double[][] matrix; // creates matrix

	public SquareMatrix(double[][] elements) throws Exception { // creates constructor for 2d array
		this.matrix = elements;
		int lengthArray = elements.length; // sets length of array
		for (int numOfRows = 0; numOfRows < lengthArray; numOfRows++) { // makes comparison row by row
			if (elements[numOfRows].length != lengthArray) { // checks rows[] against the columns
				throw new Exception("Matrix is not Square in row: " + (numOfRows + 1)); // catches any possible errors
			}
		}
	}

	public String toString() { // A toString which returns the Matrix in a readable format
		return "SquareMatrix" + Arrays.deepToString(this.matrix) + "]";
	}

	public static SquareMatrix unitMatrix(int size) { // creates a unit matrix of input size as argument
		double[][] m = new double[size][size];
		for (int i = 0; i < size; i++) {
			m[i][i] = 1;
		}
		SquareMatrix out = null; // set the output as null as we give a return later
		try {
			out = new SquareMatrix(m);
		} catch (Exception e) {
			System.out.println(e);
		}
		return out;
	}

	public boolean equals(Object obj) { //creates boolean with conditions if one matrix is equal to another (identity)
		if (this.matrix == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception { // adds both matrices together
		double[][] rows = sm1.matrix;
		double[][] columns = sm2.matrix;

		// compare the two matrices are of the same size
		if (rows.length != columns.length || Array.getLength(rows[0]) != Array.getLength(columns[0])) {
			throw new Exception("The two arrays are of different size!");
		}

		double[][] newMatrix = new double[rows.length][columns.length]; // creates output array
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < Array.getLength(newMatrix[0]); j++) {
				newMatrix[i][j] = rows[i][j] + columns[i][j];
			}
		}

		return new SquareMatrix(newMatrix);

	}

	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception { // subtracts one matrix
																								// from another
		double[][] rows = sm1.matrix;
		double[][] columns = sm2.matrix;

		// compare the two matrices are of the same size
		if (rows.length != columns.length || Array.getLength(rows[0]) != Array.getLength(columns[0])) {
			throw new Exception("The two arrays are of different size!");
		}

		double[][] newMatrix = new double[rows.length][columns.length]; // creates output array
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < Array.getLength(newMatrix[0]); j++) {
				newMatrix[i][j] = rows[i][j] - columns[i][j];
			}
		}

		return new SquareMatrix(newMatrix);

	}

	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception { // multiplies two arrays
																								// together
		double[][] rows = sm1.matrix;
		double[][] columns = sm2.matrix;

		if (rows.length != Array.getLength(columns[0])) {
			throw new Exception("The arrays are incompatible size for multiplication!");
		}

		double[][] newMatrix = new double[rows.length][columns.length]; // creates output array

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < Array.getLength(newMatrix[0]); j++) {
				double l = 0.;
				for (int k = 0; k < newMatrix.length; k++) { //multiply elements according to standard matrix multiplication
					l += rows[i][k] * columns[k][j]; 
				}
				newMatrix[i][j] = l; //puts result into output matrix
			}
		}

		return new SquareMatrix(newMatrix);
	}
}
