package module5;

import java.util.*;

public class TestSquareMatrix {

	static double[][] a = { { 1, 2, 0 }, { 0, 2, 0 }, { -2, 0, 1 } }; // define arrays to put into objects
	static double[][] b = { { 2, 1, 0 }, { 0, 1, 0 }, { -1, 0, 1 } };
	static double[][] c = { { 4, 3 }, { 3, 2 } };
	static double[][] d = { { -2, 3 }, { 3, -4 } };

	public static void main(String[] args) {

		try {
			SquareMatrix A = new SquareMatrix(a); // put matrix into SquareMatrix object
			SquareMatrix B = new SquareMatrix(b);
			SquareMatrix C = new SquareMatrix(c);
			SquareMatrix D = new SquareMatrix(d);

			System.out.println(A.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String dog = "SquareMatrix \n";
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a[i].length; j++) { // the m[i] is to go through the
		// sceond array
		// dog += "," + a[i][j];
		// }
		// dog += "\n";
		// }
		// System.out.println(dog);
		// }

	}
}
