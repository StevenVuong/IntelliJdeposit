package MidTerm2010_11;
/**
 * Java MidTerm 2010-11 Neutrino Event Object constructor
 * @author Steven Vuong
 * @version 07-01-2018
 */
public class NeutrinoEvent {
	
	/**
	 * Initialise variables
	 */
	String Name; String InteractionType;
	Double Energy;
	
	/**
	 * Constructor to generate a neutrinoEvent object with each of the set paramaters
	 * @param name String
	 * @param interactionType String
	 * @param energy Double
	 */
	public NeutrinoEvent(String name, String interactionType, Double energy) {
		super();
		Name = name;
		InteractionType = interactionType;
		Energy = energy;
	}

	
	
}
