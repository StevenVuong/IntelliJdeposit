package module2;

public class ParticleMain {

	public static void main(String args[]) {
		FallingParticle fallingParticle = new FallingParticle(5.3, 3.6);
		fallingParticle.setH(10);
		fallingParticle.drop(0.0001);
	}
}
