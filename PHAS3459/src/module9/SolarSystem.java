package module9;

import javax.swing.*;
/**
 * Solar system orbits animation with stop and exit buttons
 * 
 * @author Steven Vuong
 * @version 09-12-18
 *
 */
public class SolarSystem {

	public void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		
			public void run() {
				JFrame frame = new JFrame("Solar System animation");
				JPanel panel = new AnimationGuiPanel();
				frame.add(panel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(600,600);
				frame.setVisible(true);
			}
		});
		
	}
	
}
