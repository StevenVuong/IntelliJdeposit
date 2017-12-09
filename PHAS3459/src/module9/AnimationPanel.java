package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JPanel with model of the solar system
 * 
 * @author Steven Vuong
 * @version 09-12-18
 *
 */
public class AnimationPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final int delay = 1; //delay between steps
	private final int delta = 86400; //Timestep between simulations in seconds
	int day = 0;
	
	private Timer animationTimer; //timer controlling frame rate
	Rock Mercury = new Rock(2,47400, 579E10); //create objects for each orbiting body
	Rock Venus = new Rock(4, 35000, 1.082E11);
	Rock Earth = new Rock(5, 29800, 1.496E11);
	Rock Mars = new Rock(3, 24100, 2.279E11);
	Rock Jupiter = new Rock(8, 13100, 7.786E11);
	Rock Saturn = new Rock(7, 9700, 1.4335E12);
	Rock Uranus = new Rock(6, 6800, 2.8725E12);
	Rock Neptune = new Rock(6, 5400, 4.4951E12);
	Rock Icarus = new Rock(2, 28710, 1.613E11); // Asteroid 1566 Icarus. A nicely appropriate name.
	Rock Comet = new Rock(10, 10000, 5E11); // A comet which partially vaporises every time it reaches perihelion
	
	/**
	 * Create panel containing simulation
	 * @param width of panel
	 * @param height of panel
	 */
	AnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	
	/**
	 * Paint Solar System objects
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int height = getHeight();
		int width = getWidth();
		
		//Fill in background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);
		
		//Move origin to centre of panel
		g.translate(width/2, height/2);
		
		//Draw Sun
		g.setColor(Color.YELLOW);
		g.fillOval(-5, -5, 10, 10);
		
		//Draw Planets
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval((int)(Mercury.x/2E10), (int)(Mercury.y/2E10), Mercury.radius, Mercury.radius);
	
		g.setColor(Color.WHITE);
		g.fillOval((int)(Venus.x/2E10), (int)(Venus.y/2E10), Venus.radius, Venus.radius);
	}
	
}
