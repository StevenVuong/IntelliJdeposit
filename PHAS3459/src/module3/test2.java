package module3;

public class test2 {
	
	
	char a = (char) 5;
	String randomString = Character.toString(a);			

	public static void main(String[] args) throws Exception {
		try {
			System.out.println(Integer.parseInt(randomString));

		} catch (Exception e) {
			System.out.println("THIS DOESN'T WORK!");
		}
	}

}
