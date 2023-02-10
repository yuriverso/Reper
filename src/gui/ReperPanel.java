package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jdbc.Song;

public class ReperPanel extends JPanel{
	
	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	ReperButton orderByNameButton, orderByArtistButton, orderByToneButton, orderByLengthButton;
	JScrollPane scrollPane;
	JPanel scrollPanel;
	
	ArrayList<SongPanel> songPanels;
	
	ReperPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(35, 100, WIDTH, HEIGHT);
		setBackground(Color.black);
		setLayout(null);
		
		
		songPanels = new ArrayList<SongPanel>();
		addComponents();

		fillScrollPanel();
	}
	
	public void fillScrollPanel() {
		if(masterPanel.jdbc.getCon() != null) {
			try {
				ArrayList<Song> songs;
				songs = masterPanel.jdbc.getAllSongs();
				for(Song song : songs) {
					SongPanel songPanel = new SongPanel("add", masterPanel);
					songPanel.setId(song.getId());
					songPanel.setName(song.getName());
					songPanel.setArtist(song.getArtist());
					songPanel.setTone(song.getTone());
					songPanel.setLength(song.getLength());
					songPanel.updateData();
					songPanels.add(songPanel);
				}
				for(SongPanel s : songPanels) {
					scrollPanel.add(s);
				}
			}catch(Exception e) {
				e.printStackTrace();
				masterPanel.messageLabel.setForeground(Color.red);
				masterPanel.messageLabel.setText("Erro ao obter músicas");
			}
		}
		
	}
	
	
	public void addComponents() {
		scrollPanel = new JPanel();
		//scrollPanel.setBounds(0, 25, WIDTH, HEIGHT-25);
		scrollPanel.setBackground(Color.white);
		scrollPanel.setVisible(true);
		scrollPanel.setLayout(new GridLayout(10, 0));

		scrollPane = new JScrollPane(scrollPanel);
		scrollPane.setBounds(0, 25, WIDTH, HEIGHT-25);
		add(scrollPane);
		
		// Buttons
		orderByNameButton = new ReperButton(0, 0, 97, 25, masterPanel.al);
		add(orderByNameButton);
		orderByNameButton = new ReperButton(97, 0, 98, 25, masterPanel.al);
		add(orderByNameButton);
		orderByNameButton = new ReperButton(195, 0, 97, 25, masterPanel.al);
		add(orderByNameButton);
		orderByNameButton = new ReperButton(292, 0, 98, 25, masterPanel.al);
		add(orderByNameButton);
	}
		
}
