package module5;

public class TreatWell {
public static void main(String[] args) {
	int n = 4; //set dimensions
	for (int i=1; i<=n;i++) {
		for (int j=1; j<n; j++) {
			if(i==1||j==1) {
				System.out.println("-");//prints horizontal lines
			}
			else if (j==1||j==n) {
				System.out.println("|");//prints vertical lines
			}
			else System.out.println(" "); 
		}//
	}
}
}
