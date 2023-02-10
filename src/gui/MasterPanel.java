package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jdbc.ReperConnection;
import jdbc.ReperJDBC;

public class MasterPanel extends JPanel{
	
	private final int WIDTH = 900, HEIGHT = 600;
	
	// Java Database Connection
	private ReperConnection reperConnection;
	ReperJDBC jdbc = new ReperJDBC(null);

	// Sprouting panels
	ConnectionPanel	connectionPanel;
	
	// Components
	ReperActionListener al = new ReperActionListener(this);
	ReperPanel reperPanel;
	SetPanel setPanel;
	public JLabel connectionLabel, messageLabel;
	ReperButton dbConnectionButton, refreshButton, addSongButton, editSongButton, 
				removeSongButton, openSetButton, saveSetButton, exportButton, 
				reorderUpButton, reorderDownButton;
	
	
	MasterPanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.decode("#b02c3a"));
		
		//addConnectionComponents();
		connectToDB();
		addComponents();
				
	}
	
	private void addComponents() {
		
		// Sprouting Panels
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
		
		// Connection Label
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

		setReturnComponents(reperConnection.getUrl(), reperConnection.getUser(), reperConnection.getPass());
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
	
	public void updateConnectionMessageAndLabel(int status) {
		if(status == 0) {
			connectionLabel.setBackground(Color.green);
			messageLabel.setForeground(Color.green);
			messageLabel.setText("Conexão bem sucedida");
		}else if(status == 1) {
			connectionLabel.setBackground(Color.red);
			messageLabel.setForeground(Color.red);
			messageLabel.setText("Erro de conexão com o DB");
		}
		
	}
	public void setReturnComponents(String url, String user, String pass) {
		connectionPanel.urlTextField.setText(url);
		connectionPanel.userTextField.setText(user);
		connectionPanel.passTextField.setText(pass);
		
		if(jdbc.getCon() != null) updateConnectionMessageAndLabel(0);
		else if(jdbc.getCon() == null) updateConnectionMessageAndLabel(1);
	}
	
	public void connectToDB() {
		reperConnection = new ReperConnection();
		jdbc = new ReperJDBC(reperConnection.openCon());
	}
	
	public void newConnection(String url, String user, String pass) {
		reperConnection = new ReperConnection();
		jdbc = new ReperJDBC(reperConnection.openCon(url, user, pass));
		
		setReturnComponents(url, user, pass);
	}
	
	public ReperJDBC getJdbc() {
		return jdbc;
	}

	public void setJdbc(ReperJDBC jdbc) {
		this.jdbc = jdbc;
	}
	
}
