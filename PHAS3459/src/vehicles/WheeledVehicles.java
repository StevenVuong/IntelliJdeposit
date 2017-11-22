package vehicles;

public abstract class WheeledVehicles implements Vehicles {
	private int wheels;

	public WheeledVehicles(int wheels) {
		this.wheels = wheels;
	}

	public int getWheels() {
		return wheels;
	}

	public abstract void changeTyre();
}
