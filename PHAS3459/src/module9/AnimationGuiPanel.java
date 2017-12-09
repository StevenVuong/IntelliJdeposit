package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Solar system orbits animation with stop and exit buttons
 * 
 * @author Steven Vuong
 * @version 09-12-18
 *
 */

public class AnimationGuiPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private AnimationPanel animPanel; //panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	
	/**
	 * Create JPanel containing animation panel and buttons
	 */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(600,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		animPanel = new AnimationPanel(600,600);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		
		add(animPanel);
		add(buttonPanel);
		
	}
	
	/**
	 * Start animation when applet is started
	 */
	public void start() {
		animPanel.start();
	}
	
	/**
	 * Stop animation when applet is stopped
	 */
	private void stop() {
		animPanel.stop();
	}

	/**
	 * Respond to button clicks
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) start();
		else if (e.getSource() == stopButton) stop();
		else if (e.getSource() == exitButton) System.exit(0);
	}

}
