package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasterPanel extends JPanel{
	
	private final int WIDTH = 900, HEIGHT = 600;
	
	// Components
	ReperActionListener al;
	ConnectionPanel connectionPanel;
	ReperPanel reperPanel;
	SetPanel setPanel;
	JLabel connectionLabel, messageLabel;
	ReperButton dbConnectionButton, refreshButton, addSongButton, editSongButton, 
				removeSongButton, openSetButton, saveSetButton, exportButton, 
				reorderUpButton, reorderDownButton;
	
	
	MasterPanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.decode("#b02c3a"));
		
		addComponents();
	}
	
	private void addComponents() {
		// Action listener
		al = new ReperActionListener(this);
		
		// Sprouting panels
		connectionPanel = new ConnectionPanel(this);
		
		// Buttons
		dbConnectionButton = new ReperButton(30, 30, 50, 30, al);
		add(dbConnectionButton);
		refreshButton = new ReperButton(170, 30, 50, 30, al);
		add(refreshButton);
		addSongButton = new ReperButton(35, 550, 130, 30, al);
		add(addSongButton);
		editSongButton = new ReperButton(165, 550, 130, 30, al);
		add(editSongButton);
		removeSongButton = new ReperButton(295, 550, 130, 30, al);
		add(removeSongButton);
		openSetButton = new ReperButton(475, 550, 130, 30, al);
		add(openSetButton);
		saveSetButton = new ReperButton(605, 550, 130, 30, al);
		add(saveSetButton);
		exportButton = new ReperButton(735, 550, 130, 30, al);
		add(exportButton);
		reorderUpButton = new ReperButton(865, 125, 30, 200, al);
		add(reorderUpButton);
		reorderDownButton = new ReperButton(865, 325, 30, 200, al);
		add(reorderDownButton);
		
		// Connecion Label
		connectionLabel = new JLabel();
		connectionLabel.setText(null);
		connectionLabel.setBackground(Color.green);
		connectionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		connectionLabel.setBounds(100, 30, 50, 30);
		connectionLabel.setOpaque(true);
		add(connectionLabel);
		
		// Message display label
		messageLabel = new JLabel("Welcome!");
		messageLabel.setForeground(Color.black);
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		messageLabel.setBackground(Color.gray);
		messageLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		messageLabel.setBounds(325, 30, 250, 50);
		messageLabel.setOpaque(true);
		add(messageLabel);
		
		// Panels
		reperPanel = new ReperPanel(this);
		setPanel = new SetPanel(this);
		//
		add(reperPanel);
		add(setPanel);
		//setPanel.addTest();
	}

	public void enableComponents() {
		for(Component c : getComponents()) {
			c.setEnabled(true);
		}
		for(Component c : setPanel.getComponents()) {
			c.setEnabled(true);
		}
		for(Component c : reperPanel.getComponents()) {
			c.setEnabled(true);
		}
	}
	
	public void disableComponents() {
		for(Component c : getComponents()) {
			c.setEnabled(false);
		}
		for(Component c : setPanel.getComponents()) {
			c.setEnabled(false);
		}
		for(Component c : reperPanel.getComponents()) {
			c.setEnabled(false);
		}
	}
	
}
