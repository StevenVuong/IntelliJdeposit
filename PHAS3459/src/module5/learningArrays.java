package module5;
import java.lang.reflect.Array; //import array class
import java.util.*;

// General syntax to declare an array is:
//type[] arrayName = new type[length]
// An array storing two integer values:
//int[]ks = new int[2];
//ks[0] = 45; ks[1] = 46; //setting array values

// An array storing 10 Point objects:
//Point[] mypoints = new Point[10];
//mypoints[0] = new Point(10,11);
//mypoints[0].x = 12;
//points: array size is defined, then fixed. n length goes 0 to n-1, length is "length"

public class learningArrays {
	private static int[] values = new int[6];
	private static int[] valuesManualSetting = {0,1,4,9,16,25};
	private static int[][] grid = new int[4][5]; //initialises a grid of matrices, multi dimensional
	// or we can initialise as follows:
	private static int[][] grid2D = { {1,2,3,4}, // row-1
			{11,12,13,14}, // row-2
			{11,12,13,14} }; // row-3
	static ArrayList<Integer> mynumbers = new ArrayList<Integer>(); //creating and filling array of generic type, Integer
	static ArrayList<String> list = new ArrayList<String>();

	public learningArrays(int[] values) { // creates a constructor of the class
		data = values; // refers to hash code
	}

	private int[] data; // initialising the array

	public int[] negativeList() {
		int[] nData = new int[data.length];
		for (int i = 0; i < data.length; ++i) {
			nData[i] = -1 * data[i]; // can use array as a parameter
		}
		return nData; // can return an array
	}

	public static void main(String[] args) {
		int[] data = { 0, 5, 6, 7, 9, 10 }; // sets hash code
		Double d = 3.0; // object as capital D, can act methods on
		//double s = d.doubleValue(); // is a primitive, just a referral

		for (int i = 0; i < values.length; i++) {
			values[i] = i * i;
		}
		learningArrays myL = new learningArrays(data); // calls the constructor
		int[] nData = myL.negativeList();
		for (int i = 0; i < nData.length; i++) {
			System.out.println("ndata is: " + nData[i]);

			grid[0][0] = 1; // first element
			// ....
			grid[3][4] = 1; // last element
			int nRows = grid2D.length;
			int nCols = Array.getLength(grid2D[0]);

			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					mynumbers.add(x * y); //adding to the array
				}
			}
			int val = mynumbers.get(1); //getting values from the array
			list.add("welcome"); // add to end
			//Collections.sort(nums); //sorts array
		}
//
	}
}
