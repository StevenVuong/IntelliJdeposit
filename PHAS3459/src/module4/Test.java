//package module4;
//
//import java.io.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.URL;
//
//public class Test {
//
//	// Scanner class to tokenise inputs?
//	BufferedReader r = new BufferedReader(new FileReader(file));
//	Scanner s = new Scanner(r);
//	double sum = 0;while(s.hasNext())
//	{
//		String token = s.next();
//		try {
//			double x = Double.parseDouble(token);
//			sum += x;
//		} catch (NumberFormatException e) {
//			// Ignore anything that is not a number!
//		}
//	}
//
//	// Print contents of text file to the screen
//	public static void printFile(String fileName)
//	 throws IOException {
//	 FileReader fr = new FileReader(fileName);
//	 BufferedReader br = new BufferedReader(fr);
//	 String line;
//	 while ((line=br.readLine()) != null) {
//	 System.out.println(line);
//	 }
//	}
//
//	public static void main(String[] args) throws Exception {
//		System.out.println("pi = "+Math.PI);
//		System.out.format("pi = %.3f; e = %.3f", Math.PI, Math.E);//sets DP as double typically prints 16 digits.. Unnecessary
//		System.out.format("; each is stored using %d bits%n", Double.SIZE);
//
//		InputStreamReader r = new InputStreamReader(System.in);
//		BufferedReader b = new BufferedReader(b);
//		System.out.println("Please type something!");
//		 try {
//		 String s = b.readLine();
//		 System.out.println("You typed: "+s);
//		 }
//		 catch (IOException e) {
//		 System.out.println("Problem: "+e.getMessage());
//		 }
//
//		 //Writing to a file
//		 FileWriter f = new FileWriter(fileName);
//		 BufferedWriter b = new BufferedWriter(f);
//		 PrintWriter pw = new PrintWriter(b);
//		 pw.println("Some numbers");
//		 for (int i=0; i<10; i++) {
//		 pw.println(i+" "+i*0.1);
//		 }
//		 pw.close();
//
//		 //Reading from the web
//		 URL u = new URL(http://www.hep.ucl.ac.uk/undergrad/3459/phas3459CourseNotes/OEBPS/Text/module4.xhtml);
//		 InputStream is = u.openStream();
//		 InputStreamReader isr = new InputStreamReader(is);
//		 BufferedReader b = new BufferedReader(isr);
//		 String line;
//		 while ((line=br.readLine()) != null) {
//		 System.out.println(line);
//		 }
//
//
//		 }
//
//}
