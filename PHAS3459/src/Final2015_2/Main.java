package Final2015_2;
/**
 * Main class for Final 2015
 * @author SID: 15011252
 * @version 15/01/2018
 */
public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			Method.allPulsesAnalysis(); //Second bulletpoint
			
			Method.detectorsAnalysis(); //third bulletpoint

		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
