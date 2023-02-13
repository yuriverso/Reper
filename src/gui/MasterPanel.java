package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jdbc.ReperConnection;
import jdbc.ReperJDBC;
import jdbc.Song;

public class MasterPanel extends JPanel{
	
	private final int WIDTH = 900, HEIGHT = 600;
	
	// Java Database Connection
	private ReperConnection reperConnection;
	ReperJDBC jdbc = new ReperJDBC(null);

	// Sprouting panels
	ConnectionPanel	connectionPanel;
	AddSongPanel addSongPanel;
	EditSongPanel editSongPanel;
	RemoveSongPanel removeSongPanel;
	SaveSetPanel saveSetPanel;
	OpenSetPanel openSetPanel;
	RemoveSetPanel removeSetPanel;
	ExportSetPanel exportSetPanel;
	
	// Components
	ReperActionListener al = new ReperActionListener(this);
	ReperPanel reperPanel;
	SetPanel setPanel;
	public JLabel connectionLabel, messageLabel;
	ReperButton dbConnectionButton, refreshButton, addSongButton, editSongButton, 
				removeSongButton, openSetButton, saveSetButton, removeSetButton, 
				reorderUpButton, reorderDownButton, exportButton;
	
	
	public MasterPanel(){
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setBackground(Color.gray);
		
		//addConnectionComponents();
		connectToDB();
		addComponents();
				
	}
	
	private void addComponents() {
		
		// Sprouting Panels
		connectionPanel = new ConnectionPanel(this);
		addSongPanel = new AddSongPanel(this);
		editSongPanel = new EditSongPanel(this);
		removeSongPanel = new RemoveSongPanel(this);
		saveSetPanel = new SaveSetPanel(this);
		openSetPanel = new OpenSetPanel(this);
		removeSetPanel = new RemoveSetPanel(this);
		exportSetPanel = new ExportSetPanel(this);
		
		// Buttons
		dbConnectionButton = new ReperButton(30, 30, 70, 30, al);
		dbConnectionButton.setMargin(new Insets(0, 0, 0, 0));
		dbConnectionButton.setText("Conexão");
		add(dbConnectionButton);
		refreshButton = new ReperButton(210, 30, 70, 30, al);
		refreshButton.setMargin(new Insets(0, 0, 0, 0));
		refreshButton.setText("Atualizar");
		add(refreshButton);
		addSongButton = new ReperButton(35, 550, 130, 30, al);
		addSongButton.setText("Adicionar");
		add(addSongButton);
		editSongButton = new ReperButton(165, 550, 130, 30, al);
		editSongButton.setText("Editar");
		add(editSongButton);
		removeSongButton = new ReperButton(295, 550, 130, 30, al);
		removeSongButton.setText("Remover");
		add(removeSongButton);
		openSetButton = new ReperButton(475, 550, 130, 30, al);
		openSetButton.setText("Abrir set");
		add(openSetButton);
		saveSetButton = new ReperButton(605, 550, 130, 30, al);
		saveSetButton.setText("Salvar Set");
		add(saveSetButton);
		removeSetButton = new ReperButton(735, 550, 130, 30, al);
		removeSetButton.setText("Remover set");
		add(removeSetButton);
		reorderUpButton = new ReperButton(865, 125, 30, 200, al);
		reorderUpButton.setMargin(new Insets(0, 0, 0, 0));
		reorderUpButton.setText("^");
		add(reorderUpButton);
		reorderDownButton = new ReperButton(865, 325, 30, 200, al);
		reorderDownButton.setMargin(new Insets(0, 0, 0, 0));
		reorderDownButton.setText("v");
		add(reorderDownButton);
		exportButton = new ReperButton(800, 30, 70, 30, al);
		exportButton.setMargin(new Insets(0, 0, 0, 0));
		exportButton.setText("Exportar");
		add(exportButton);
		
		// Connection Label
		connectionLabel = new JLabel();
		connectionLabel.setText(null);
		connectionLabel.setBackground(Color.green);
		connectionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		connectionLabel.setBounds(120, 30, 70, 30);
		connectionLabel.setOpaque(true);
		add(connectionLabel);
						
		// Message display label
		messageLabel = new JLabel("Welcome!");
		messageLabel.setForeground(Color.white);
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		messageLabel.setBackground(Color.black);
		messageLabel.setBorder(BorderFactory.createLineBorder(Color.white));
		messageLabel.setBounds(325, 30, 250, 50);
		messageLabel.setOpaque(true);
		add(messageLabel);
		
		// Panels
		setPanel = new SetPanel(this);
		reperPanel = new ReperPanel(this);
		
		//
		add(setPanel);
		add(reperPanel);
		

		setReturnComponents(reperConnection.getUrl(), reperConnection.getUser(), reperConnection.getPass());
	}
	

	public void enableComponents() {
		for(Component c : getComponents()) {
			c.setEnabled(true);
		}
		reperPanel.setVisible(true);
		setPanel.setVisible(true);
	}
	
	public void disableComponents() {
		for(Component c : getComponents()) {
			if(c != messageLabel) {
				c.setEnabled(false);
			}
		}
		reperPanel.setVisible(false);
		setPanel.setVisible(false);
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
