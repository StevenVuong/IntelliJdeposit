package midTermExam;

public class NeutrinoPredicted {

	//initialise member variables
	String NamePredicted;
	String InteractionPredicted;
	double frequencyPredicted;
	
	//constructor to create an object containing details of variables
	public NeutrinoPredicted(String namePredicted, String interactionPredicted, double frequencyPredicted) {
		NamePredicted = namePredicted;
		InteractionPredicted = interactionPredicted;
		this.frequencyPredicted = frequencyPredicted;
	}

	//generate getters for object variables
	public String getNamePredicted() {
		return NamePredicted;
	}

	public String getInteractionPredicted() {
		return InteractionPredicted;
	}

	public double getFrequencyPredicted() {
		return frequencyPredicted;
	}

	public String getDetailsPredicted() {
		return ("The name is: " + NamePredicted+", with interaction: "+InteractionPredicted+", with frequency: "+frequencyPredicted);
	}
	
	
}
