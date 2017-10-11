package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(3,5,2);
		ThreeVector v2 = new ThreeVector(2,4,1);
		ThreeVector v3 = new ThreeVector(0,0,0);
		System.out.println("v1: "+v1);
		System.out.println("v2: "+v2);
		System.out.println("v3: "+v3);
	}
	
	
//	public static void main(String[] args) {
//		ThreeVector testVector = new ThreeVector(1.0, 2.0, 3.0);
//		ThreeVector testVector2 = new ThreeVector(1.0, 2.0, 3.0);
//		ThreeVector.scalarProduct(testVector, testVector2);
//		testVector.scalarProduct(testVector2); // non static calling. Belongs to object
//		// System.out.println(v);
//	}


}
