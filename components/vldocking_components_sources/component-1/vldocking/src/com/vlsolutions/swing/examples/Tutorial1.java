package com.vlsolutions.swing.examples;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;
import com.vlsolutions.swing.docking.DockingConstants;
import com.vlsolutions.swing.docking.DockingDesktop;

public class Tutorial1 extends JFrame {
	MyTextEditor editorPanel = new MyTextEditor();
	MyTree treePanel = new MyTree();
	MyGridOfButtons buttonGrid = new MyGridOfButtons();
	MyJTable tablePanel = new MyJTable();
	DockingDesktop desk = new DockingDesktop();

	public Tutorial1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(desk);

		desk.addDockable(editorPanel);
		desk.split(editorPanel, treePanel, DockingConstants.SPLIT_LEFT);
		desk.split(editorPanel, buttonGrid, DockingConstants.SPLIT_RIGHT);
		desk.split(buttonGrid, tablePanel, DockingConstants.SPLIT_BOTTOM);
	}

	public static void main(String[] args) {
		final Tutorial1 frame = new Tutorial1();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.validate();
		SwingUtilities.invokeLater(new Runnable() {
			// in the event dispatch thread
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}

class MyJTable extends JPanel implements Dockable {
	JTable table = new JTable();
	DockKey key = new DockKey("table");
	public MyJTable() {
		setLayout(new BorderLayout());
		table.setModel(new DefaultTableModel(5, 5));
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}

	@Override
	public DockKey getDockKey() {
		return key;
	}

	@Override
	public Component getComponent() {
		return this;
	}
}

class MyGridOfButtons extends JPanel implements Dockable {
	DockKey key = new DockKey("gridOfButtons");
	public MyGridOfButtons() {
		setLayout(new FlowLayout(FlowLayout.TRAILING, 3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				add(new JButton("btn" + (i * 3 + j)));
			}
		}
		setPreferredSize(new Dimension(200, 300));
	}

	@Override
	public DockKey getDockKey() {
		return key;
	}

	@Override
	public Component getComponent() {
		return this;
	}
}

class MyTree extends JPanel implements Dockable {
	JTree tree = new JTree();
	DockKey key = new DockKey("tree");
	public MyTree() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(tree);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}

	@Override
	public DockKey getDockKey() {
		return key;
	}

	@Override
	public Component getComponent() {
		return this;
	}
}

class MyTextEditor extends JPanel implements Dockable {
	JTextArea textArea = new JTextArea("A Text Area");
	DockKey key = new DockKey("textEditor");
	public MyTextEditor() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setPreferredSize(new Dimension(300, 400));
		add(jsp, BorderLayout.CENTER);
	}

	@Override
	public DockKey getDockKey() {
		return key;
	}

	@Override
	public Component getComponent() {
		return this;
	}
}
