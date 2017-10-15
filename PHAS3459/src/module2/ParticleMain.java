package module2;

public class ParticleMain {

	public static void main(String args[]) {
		FallingParticle fallingParticle = new FallingParticle(5.3, 3.6); //creates the 'falling particle' object
		fallingParticle.setH(10); //sets the drop height
		fallingParticle.drop(0.5); //Runs the method inside falling particle with 0.5s as the time interval between loops
		fallingParticle.drop(0.1); //Runs the method inside falling particle with 0.1s as the time interval between loops
		fallingParticle.drop(0.01); //Runs the method inside falling particle with 0.01s as the time interval between loops
		fallingParticle.drop(0.001); //Runs the method inside falling particle with 0.001s as the time interval between loops
		fallingParticle.drop(0.0001); //Runs the method inside falling particle with 0.0001s as the time interval between loops
		
		System.out.println(" ");
		
		System.out.println("When the timer interval is 0.5s, we run 2 loops before the particle hits the floor, so 1 second has passed");
		System.out.println("When the timer interval is 0.1s, we run 4 loops before the particle hits the floor, so 0.4 second has passed");
		System.out.println("When the timer interval is 0.01s, we run 12 loops before the particle hits the floor, so 0.12 second has passed");
		System.out.println("When the timer interval is 0.001s, we run 37 loops before the particle hits the floor, so 0.037 second has passed");
		System.out.println("When the timer interval is 0.0001s, we run 113 loops before the particle hits the floor, so 0.0113 second has passed");
		
		System.out.println("");
		
		System.out.println("The number of seconds passed is proportional to the number of loops*the time interval, this is expected");
		System.out.println("What is interesting is that the number of loops run as the time interval decreases increases, however the rate of increase");
		System.out.println("decreases. This could be due to the fact that the loop prints out a value, which would slow down the counting process.");
	}
}
