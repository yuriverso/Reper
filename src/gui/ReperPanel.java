package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jdbc.Song;

public class ReperPanel extends JPanel{
	
	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	ReperButton addAllButton, orderByIdButton, orderByNameButton, orderByArtistButton, orderByToneButton, orderByLengthButton;
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
				songPanels.clear();
				scrollPanel.removeAll();
				scrollPanel.revalidate();
				scrollPanel.repaint();
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
				for(SongPanel songPanel : songPanels) {
					if(masterPanel.setPanel.songPanels
							.stream().map(SongPanel::getName).collect(Collectors.toList())
							.contains(songPanel.getName())) {
						songPanel.setBackground(Color.gray);
					}
					scrollPanel.add(songPanel);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				masterPanel.messageLabel.setForeground(Color.red);
				masterPanel.messageLabel.setText("Erro ao obter músicas");
			}
		}
		
	}
	
	public void fillScrollPanel(String orderBy) {
		if(masterPanel.jdbc.getCon() != null) {
			try {
				songPanels.clear();
				scrollPanel.removeAll();
				scrollPanel.revalidate();
				scrollPanel.repaint();
				ArrayList<Song> songs;
				songs = masterPanel.jdbc.getAllSongs(orderBy);
				
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
				for(SongPanel songPanel : songPanels) {
					if(masterPanel.setPanel.songPanels
							.stream().map(SongPanel::getName).collect(Collectors.toList())
							.contains(songPanel.getName())) {
						songPanel.setBackground(Color.gray);
					}
					scrollPanel.add(songPanel);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				masterPanel.messageLabel.setForeground(Color.red);
				masterPanel.messageLabel.setText("Erro ao obter músicas");
			}
		}
		
	}
	
	public void checkSelected() {
		for(SongPanel songPanel : songPanels) {
			if(masterPanel.setPanel.songPanels
					.stream().map(SongPanel::getName).collect(Collectors.toList())
					.contains(songPanel.getName())) {
				songPanel.setBackground(Color.gray);
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
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 25, WIDTH, HEIGHT-25);
		add(scrollPane);
		
		// Buttons
		addAllButton = new ReperButton(0, 0, 32, 25, masterPanel.al);
		add(addAllButton);
		orderByIdButton = new ReperButton(31, 0, 30, 25, masterPanel.al);
		add(orderByIdButton);
		orderByNameButton = new ReperButton(61, 0, 120, 25, masterPanel.al);
		add(orderByNameButton);
		orderByArtistButton = new ReperButton(181, 0, 100, 25, masterPanel.al);
		add(orderByArtistButton);
		orderByToneButton = new ReperButton(281, 0, 30, 25, masterPanel.al);
		add(orderByToneButton);
		orderByLengthButton = new ReperButton(311, 0, 90, 25, masterPanel.al);
		add(orderByLengthButton);
	}
		
}
