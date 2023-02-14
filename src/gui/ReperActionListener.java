package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

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
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.connectionPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.refreshButton) {
			System.out.println("refresh");
			masterPanel.reperPanel.fillScrollPanel();
			masterPanel.setPanel.updateSongs();
			masterPanel.messageLabel.setForeground(Color.white);
			masterPanel.messageLabel.setText("Lista atualizada!");
		}
		if (e.getSource() == masterPanel.addSongButton) {
			System.out.println("add song");
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.addSongPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.editSongButton) {
			System.out.println("edit song");
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.editSongPanel.setVisible(true);
			masterPanel.disableComponents();
			
		}
		if (e.getSource() == masterPanel.removeSongButton) {
			System.out.println("remove song");
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.removeSongPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.openSetButton) {
			System.out.println("open set");
			masterPanel.openSetPanel.fillComboBox();
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.openSetPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.saveSetButton) {
			System.out.println("save set");
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.saveSetPanel.setVisible(true);
			masterPanel.disableComponents();
			
		}
		if(e.getSource() == masterPanel.removeSetButton) {
			System.out.println("remove set");
			masterPanel.removeSetPanel.fillComboBox();
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.removeSetPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.exportButton) {
			System.out.println("export");
			masterPanel.setBackground(Color.decode("#595959"));
			masterPanel.exportSetPanel.setVisible(true);
			masterPanel.disableComponents();
		}
		if (e.getSource() == masterPanel.reorderUpButton) {
			System.out.println("reorder up");
			int selected = -1;
			for(int i = 1; i < masterPanel.setPanel.songPanels.size(); i++) {
				if(masterPanel.setPanel.songPanels.get(i).isSelected) {
					selected = i;	
				}
			}
			if(selected != -1) 
			Collections.swap(masterPanel.setPanel.songPanels, selected, selected-1);
			masterPanel.setPanel.updateSongs();
		}
		if (e.getSource() == masterPanel.reorderDownButton) {
			System.out.println("reorder down");
			int selected = -1;
			for(int i = 0; i < masterPanel.setPanel.songPanels.size()-1; i++) {
				if(masterPanel.setPanel.songPanels.get(i).isSelected) {
					selected = i;	
				}
			}
			if(selected != -1)
			Collections.swap(masterPanel.setPanel.songPanels, selected, selected+1);
			masterPanel.setPanel.updateSongs();
		}
		
		// ReperPanel filter buttons
		if(e.getSource() == masterPanel.reperPanel.addAllButton) {
			for(SongPanel songPanel : masterPanel.reperPanel.songPanels) {
				SongPanel newSongPanel = new SongPanel("remove", masterPanel);
				newSongPanel.setId(songPanel.getId());
				newSongPanel.setName(songPanel.getName());
				newSongPanel.setArtist(songPanel.getArtist());
				newSongPanel.setTone(songPanel.getTone());
				newSongPanel.setLength(songPanel.getLength());
				newSongPanel.updateData();
				masterPanel.setPanel.addSong(newSongPanel);
				
			}
			masterPanel.reperPanel.checkSelected();
			masterPanel.setPanel.updateSongs();
		}
		if(e.getSource() == masterPanel.reperPanel.orderByIdButton) {
			System.out.println("order by id");
			masterPanel.reperPanel.fillScrollPanel("id");
		}
		if(e.getSource() == masterPanel.reperPanel.orderByNameButton) {
			System.out.println("order by name");
			masterPanel.reperPanel.fillScrollPanel("nome");
		}
		if(e.getSource() == masterPanel.reperPanel.orderByArtistButton) {
			System.out.println("order by artist");
			masterPanel.reperPanel.fillScrollPanel("artista");
		}
		if(e.getSource() == masterPanel.reperPanel.orderByToneButton) {
			System.out.println("order by tone");
			masterPanel.reperPanel.fillScrollPanel("tom");
		}
		if(e.getSource() == masterPanel.reperPanel.orderByLengthButton) {
			System.out.println("order by length");
			masterPanel.reperPanel.fillScrollPanel("duracao");
		}
		
		// ConnectionPanel buttons
		if(e.getSource() == masterPanel.connectionPanel.closeButton) {
			System.out.println("cancel button");
			masterPanel.setBackground(Color.gray);
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
			masterPanel.setBackground(Color.gray);
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
			masterPanel.setBackground(Color.gray);
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
			masterPanel.setBackground(Color.gray);
			masterPanel.removeSongPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// SaveSetPanel buttons
		if(e.getSource() == masterPanel.saveSetPanel.saveButton) {
			if(masterPanel.saveSetPanel.nameTextField.getText().contains(" ")) {
				masterPanel.messageLabel.setForeground(Color.red);
				masterPanel.messageLabel.setText("Erro! Contém espaços");
			}else {
				masterPanel.setPanel.saveSet();
				masterPanel.setBackground(Color.gray);
				masterPanel.saveSetPanel.setVisible(false);
				masterPanel.enableComponents();
				masterPanel.messageLabel.setForeground(Color.green);
				masterPanel.messageLabel.setText("Salvo com sucesso!");
			}
			
		}
		if(e.getSource() == masterPanel.saveSetPanel.closeButton) {
			masterPanel.setBackground(Color.gray);
			masterPanel.saveSetPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// OpenSetPanel buttons
		if(e.getSource() == masterPanel.openSetPanel.openButton) {
			masterPanel.setPanel.openSet();
			masterPanel.setBackground(Color.gray);
			masterPanel.openSetPanel.setVisible(false);
			masterPanel.enableComponents();
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Carregado com sucesso!");
			
		}
		if(e.getSource() == masterPanel.openSetPanel.closeButton) {
			masterPanel.setBackground(Color.gray);
			masterPanel.openSetPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// RemoveSetPanel buttons
		if(e.getSource() == masterPanel.removeSetPanel.removeButton) {
			masterPanel.jdbc.dropTable(masterPanel.removeSetPanel.comboBox.getSelectedItem().toString());
			masterPanel.setBackground(Color.gray);
			masterPanel.removeSetPanel.setVisible(false);
			masterPanel.enableComponents();
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Excluído com sucesso!");
		}
		if(e.getSource() == masterPanel.removeSetPanel.closeButton) {
			masterPanel.setBackground(Color.gray);
			masterPanel.removeSetPanel.setVisible(false);
			masterPanel.enableComponents();
		}
		
		// ExportSetPanel buttons
		if(e.getSource() == masterPanel.exportSetPanel.exportButton) {
			masterPanel.setPanel.exportSet(masterPanel.exportSetPanel.nameTextField.getText());
			masterPanel.setBackground(Color.gray);
			masterPanel.exportSetPanel.setVisible(false);
			masterPanel.enableComponents();
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Exportado com sucesso!");
		}
		if(e.getSource() == masterPanel.exportSetPanel.closeButton) {
			masterPanel.setBackground(Color.gray);
			masterPanel.exportSetPanel.setVisible(false);
			masterPanel.enableComponents();
		}
	}

}
