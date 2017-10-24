package module4;

import java.io.*;

public class NumericalReader {

	// public static StringBuilder stringFromKeyboard = new StringBuilder();

	public static String getStringFromKeyboard() {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(r);
		System.out.println("Enter Sentence");
		String s = null;
		try {
			s = b.readLine();
			System.out.println("You wronte: "+s);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return s;
	}

	public static void main(String[] args) {

		NumericalReader nr = new NumericalReader();

	}

}
