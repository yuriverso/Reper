package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jdbc.Song;

public class ReperPanel extends JPanel{
	
	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	ReperButton addAllButton, orderByIdButton, orderByNameButton, orderByArtistButton, orderByToneButton, orderByLengthButton;
	JScrollPane scrollPane;
	JPanel scrollPanel;
	GridLayout gridLayout;
	
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
				
				gridLayout = new GridLayout(songPanels.size(), 0);
				scrollPanel.setLayout(gridLayout);
				
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
		scrollPanel.setBackground(Color.white);
		scrollPanel.setVisible(true);

		scrollPane = new JScrollPane(scrollPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 25, WIDTH, HEIGHT-25);
		add(scrollPane);
		
		// Buttons
		addAllButton = new ReperButton(0, 0, 32, 25, masterPanel.al);
		addAllButton.setMargin(new Insets(0, 0, 0, 0));
		addAllButton.setText("+");
		add(addAllButton);
		orderByIdButton = new ReperButton(31, 0, 30, 25, masterPanel.al);
		orderByIdButton.setMargin(new Insets(0, 0, 0, 0));
		orderByIdButton.setText("ID");
		add(orderByIdButton);
		orderByNameButton = new ReperButton(61, 0, 120, 25, masterPanel.al);
		orderByNameButton.setText("Nome");
		add(orderByNameButton);
		orderByArtistButton = new ReperButton(181, 0, 100, 25, masterPanel.al);
		orderByArtistButton.setText("Artista");
		add(orderByArtistButton);
		orderByToneButton = new ReperButton(281, 0, 30, 25, masterPanel.al);
		orderByToneButton.setMargin(new Insets(0, 0, 0, 0));
		orderByToneButton.setText("T");
		add(orderByToneButton);
		orderByLengthButton = new ReperButton(311, 0, 80, 25, masterPanel.al);
		orderByLengthButton.setMargin(new Insets(0, 0, 0, 0));
		orderByLengthButton.setText("Duração (s)");
		add(orderByLengthButton);
	}
		
}
