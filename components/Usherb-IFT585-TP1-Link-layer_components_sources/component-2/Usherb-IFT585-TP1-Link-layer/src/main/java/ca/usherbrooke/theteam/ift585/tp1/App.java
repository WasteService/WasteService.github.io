/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1;

import ca.usherbrooke.theteam.ift585.tp1.ui.MainFrame;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 * Main class for the application.
 */
public class App {

	private static Logger log = Logger.getLogger(App.class);
	private static MainFrame mainFrame;

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// Create MainFrame
		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
}
