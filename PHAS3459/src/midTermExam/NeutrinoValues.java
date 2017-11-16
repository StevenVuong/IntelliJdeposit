package midTermExam;

public class NeutrinoValues {

	//initialise member variables
	String NameValues;
	String InteractionValues;
	double energyValues;
	
	//constructor to create an object containing details of variables
	public NeutrinoValues(String nameValues, String interactionValues, double energyValues) {
		NameValues = nameValues;
		InteractionValues = interactionValues;
		this.energyValues = energyValues;
	}

	
	//getters of member variables
	public String getNameValues() {
		return NameValues;
	}

	public String getInteractionValues() {
		return InteractionValues;
	}

	public double getEnergyValues() {
		return energyValues;
	}
	
	public String getDetailsValues() {
		return ("The name is: " + NameValues+", with interaction: "+InteractionValues+", with energy: "+energyValues);
	}
	
}
