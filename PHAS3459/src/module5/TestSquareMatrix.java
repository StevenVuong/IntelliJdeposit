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

			SquareMatrix add = SquareMatrix.add(A, B); //adds two matrix objects prints
			System.out.println("the sum of A and B is: " + add.toString());
			
			SquareMatrix subtract = SquareMatrix.subtract(A, B); //subtracts two matrix objects and prints
			System.out.println("A subtract B gives: " + subtract.toString());
			
			SquareMatrix multiplyAB = SquareMatrix.multiply(A, B); //multiplies two matrix objects and prints
			System.out.println("A multiplied by B gives: " + multiplyAB.toString());
			
			SquareMatrix multiplyBA = SquareMatrix.multiply(B, A); //multiplies two matrix objects and prints
			System.out.println("B multiplied by A gives: " + multiplyBA.toString());
			
			SquareMatrix commutator = SquareMatrix.subtract(multiplyAB, multiplyBA); //subtracts two matrix objects and prints
			System.out.println("commutator [A,B] is: "+ commutator.toString());
			
			SquareMatrix multiplyCD = SquareMatrix.multiply(C,D); //multiplies two matrix objects and checks if the matrix is equal to unitary matrix
			System.out.println("C mutplied by D gives: " + multiplyCD.toString());
			System.out.println("multiplyCD is 2x2 unit matrix: " + multiplyCD.equals(SquareMatrix.unitMatrix(multiplyCD.matrix.length)));

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
