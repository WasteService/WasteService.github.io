/**
 * TP1 - IFT585
 * @authors The Team : Benjamin Boudreau (08 318 402), Jean-François Ste-Marie, Jules Deliste, Nicolas Guimier
 */
package ca.usherbrooke.theteam.ift585.tp1.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;

/**
 *
 * @author benjamin
 */
public class ConsolePanel extends JPanel {

	private static Logger log = Logger.getLogger(ConsolePanel.class);

	/** Creates new form ConsoleUI */
	public ConsolePanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Résultats", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

		btnSaveFile = new JButton("Enregistrer sous ...");
		jScrollPaneResults = new javax.swing.JScrollPane();
		txaConsole = new javax.swing.JTextArea();

		txaConsole.setColumns(45);
		txaConsole.setEditable(false);
		txaConsole.setFont(new java.awt.Font("Lucida Console", 0, 13));
		jScrollPaneResults.setViewportView(txaConsole);
		jScrollPaneResults.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER & JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(jScrollPaneResults, BorderLayout.CENTER);
		add(btnSaveFile, BorderLayout.PAGE_END);

		btnSaveFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveToFile(null);
			}
		});
	}

	public void clear() {
		txaConsole.setText("");
		txaConsole.setCaretPosition(txaConsole.getText().length());
	}

	public void saveToFile(File file) {
		if (file == null) {
			file= new File("./output.txt");
		}
		JFileChooser fc = new JFileChooser(".");
		fc.setSelectedFile(file);
		int returnVal = fc.showSaveDialog(ConsolePanel.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			//This is where a real application would open the file.
			log.debug("Saving results to: " + file.getName());

			boolean peutEnregistrer = true;
			if (file.exists()) {
				returnVal = JOptionPane.showConfirmDialog(null, "Le fichier " + file.getName() + " existe. Êtes-vous certain de vouloir l'écraser ?", "Écraser?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (returnVal == JOptionPane.NO_OPTION) {
					peutEnregistrer = false;
					saveToFile(file);
				}
			}

			if (peutEnregistrer) {
				FileWriter out;
				try {
					out = new FileWriter(file, false);
					txaConsole.write(out);
					out.close();
				} catch (IOException ex) {
					log.error(ex.getMessage());
				}
			}
		}
	}

	public synchronized void write(String string) {
		txaConsole.append(string);
		txaConsole.setCaretPosition(txaConsole.getText().length());
	}

	public synchronized void writeLine(String string) {
		txaConsole.append(string + "\n");
		txaConsole.setCaretPosition(txaConsole.getText().length());
	}
	private javax.swing.JScrollPane jScrollPaneResults;
	private javax.swing.JTextArea txaConsole;
	private JButton btnSaveFile;
}
