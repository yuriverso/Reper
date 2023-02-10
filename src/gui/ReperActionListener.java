package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReperActionListener implements ActionListener{
	
	MasterPanel masterPanel;
	
	ReperActionListener(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Master Panel buttons
		if (e.getSource() == masterPanel.dbConnectionButton) {
			System.out.println("db connection");
			masterPanel.setBackground(Color.decode("#8c222d"));
			masterPanel.connectionPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.refreshButton) {
			System.out.println("refresh");
			masterPanel.reperPanel.fillScrollPanel();
			masterPanel.messageLabel.setForeground(Color.black);
			masterPanel.messageLabel.setText("Lista atualizada!");
		}
		if (e.getSource() == masterPanel.addSongButton) {
			System.out.println("add song");
			masterPanel.setBackground(Color.decode("#8c222d"));
			masterPanel.addSongPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.editSongButton) {
			System.out.println("edit song");
			masterPanel.setBackground(Color.decode("#8c222d"));
			masterPanel.editSongPanel.setVisible(true);
			masterPanel.disableComponents();
			
		}
		if (e.getSource() == masterPanel.removeSongButton) {
			System.out.println("remove song");
			masterPanel.setBackground(Color.decode("#8c222d"));
			masterPanel.removeSongPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.openSetButton) {
			System.out.println("open set");
		}
		if (e.getSource() == masterPanel.saveSetButton) {
			System.out.println("save set");
		}
		if (e.getSource() == masterPanel.exportButton) {
			System.out.println("export");
		}
		if (e.getSource() == masterPanel.reorderUpButton) {
			System.out.println("reorder up");
		}
		if (e.getSource() == masterPanel.reorderDownButton) {
			System.out.println("reorder down");
		}
		
		// ConnectionPanel buttons
		if(e.getSource() == masterPanel.connectionPanel.closeButton) {
			System.out.println("cancel button");
			masterPanel.setBackground(Color.decode("#b02c3a"));
			masterPanel.connectionPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		if(e.getSource() == masterPanel.connectionPanel.connectButton) {
			System.out.println("connect button");
			String url = masterPanel.connectionPanel.urlTextField.getText(); 
			String user = masterPanel.connectionPanel.userTextField.getText();
			String pass = masterPanel.connectionPanel.passTextField.getText();
			masterPanel.newConnection(url, user, pass);
			
		}
		
		// AddSongPanel buttons
		if(e.getSource() == masterPanel.addSongPanel.addButton) {
			masterPanel.addSongPanel.addSong();
			masterPanel.reperPanel.fillScrollPanel();
			masterPanel.addSongPanel.clearFields();
		}
		if(e.getSource() == masterPanel.addSongPanel.closeButton) {
			System.out.println("cancel button");
			masterPanel.setBackground(Color.decode("#b02c3a"));
			masterPanel.addSongPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// EditSongPanel buttons
		if(e.getSource() == masterPanel.editSongPanel.editButton) {
			masterPanel.editSongPanel.editSong();
			masterPanel.reperPanel.fillScrollPanel();
			masterPanel.editSongPanel.clearFields();
		}
		if(e.getSource() == masterPanel.editSongPanel.closeButton) {
			System.out.println("cancel button");
			masterPanel.setBackground(Color.decode("#b02c3a"));
			masterPanel.editSongPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// DeleteSongPanel buttons
		if(e.getSource() == masterPanel.removeSongPanel.removeButton) {
			masterPanel.removeSongPanel.removeSong();
			masterPanel.reperPanel.fillScrollPanel();
			masterPanel.removeSongPanel.idTextField.setText("");
		}
		if(e.getSource() == masterPanel.removeSongPanel.closeButton) {
			System.out.println("cancel button");
			masterPanel.setBackground(Color.decode("#b02c3a"));
			masterPanel.removeSongPanel.setVisible(false);
			masterPanel.enableComponents();
		}
	}

}
