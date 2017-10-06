package module1;
public class VectorMethods {
	
	//Set of Methods with input parameters
	 public double dotProduct(double x1, double x2, double y1, double y2, double z1, double z2) { 
		 double a = ((x1*x2)+(y1*y2)+(z1*z2));
		 return a;
	 	}
	 
	 public double magnitude(double x1,double y1,double z1) {
		 double b = Math.sqrt(((x1*x1)+(y1*y1)+(z1*z1)));
		 return b;
	 	}
	 
	 public double angle(double x1,double x2,double y1,double y2,double z1,double z2) {
		 
		VectorMethods angle = new VectorMethods(); //creates object
		double dot = angle.dotProduct(x1, x2, y1, y2, z1, z2);//invokes dot product
		double mag1 = angle.magnitude(x1, y1, z1); //invokes magnitude, calculating for each vector
		double mag2 = angle.magnitude(x2, y2, z2);
			//
		 double c = Math.acos(dot/(mag1*mag2)); //calculates angle
		 return c;
	 	}
	 
	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		//Initialising co-ordinates of vectors
		double vx1 = 2.0;
		double vx2 = 1.0;
		double vy1 = 3.0;
		double vy2 = 3.0;
		double vz1 = 4.0;
		double vz2 = 2.0;
		//Invoking previous methods
		double a1 = vm.dotProduct(vx1,vx2,vy1,vy2,vz1,vz2); 
		double a2 = vm.magnitude(vx1,vy1,vz1);
		double a3 = vm.magnitude(vx2,vy2,vz2);
		double a4 = vm.angle(vx1,vx2,vy1,vy2,vz1,vz2);
		
		//Printing out the properties of vectors (2,3,4) and (1,3,2)
		System.out.println("The dot product between the two vectors is: "+ a1);
		System.out.println("The magnitude of one vector is: "+ a2);
		System.out.println("The magnitude of the other vector is: "+ a3);
		System.out.println("The angle between the two vectors is: "+ a4 +" radians");
		
		//Attempting to calculate the angle between (2,3,4) and (0,0,0)
		double a5 = vm.angle(vx1,0.0,vy1,0.0,vz1,0.0);
		System.out.println("answer for second angle: "+ a5 +" radians. The answer here is NaN (not a number) as there is an undefined operation.");
		System.out.println("This could possibly be the fact that we divide 0 by 0 or that we are calculating the arccos of such a result");	
		System.out.println("A way around this could be to just use the first vector and calculate the angle with that and ignore the second IF it is (0,0,0)");
	}

	}
