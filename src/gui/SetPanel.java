package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import jdbc.Song;

public class SetPanel extends JPanel{

	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	JScrollPane scrollPane;
	JPanel scrollPanel;
	GridLayout gridLayout;
	
	ArrayList<SongPanel> songPanels;
	
	
	SetPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		
		setBounds(475, 100, WIDTH, HEIGHT);
		setBackground(Color.black);
		setLayout(null);
		
		songPanels = new ArrayList<SongPanel>();
		
		addComponents();
	}
	
	public void saveSet() {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		for(SongPanel songPanel : songPanels) {
			int id = songPanel.getId();
			String name = songPanel.getName();
			String artist = songPanel.getArtist();
			String tone = songPanel.getTone();
			int length = songPanel.getLength();
			Song song = new Song(id, name, artist, tone, length);
			songs.add(song);
		}
		masterPanel.jdbc.createTable(masterPanel.saveSetPanel.nameTextField.getText(), songs);
		masterPanel.setLabel.setText(masterPanel.saveSetPanel.nameTextField.getText());
	}
	
	public void openSet() {
		if(masterPanel.jdbc.getCon() != null) {
			try {
				songPanels.clear();
				scrollPanel.removeAll();
				scrollPanel.revalidate();
				scrollPanel.repaint();
				ArrayList<Song> songs;
				songs = masterPanel.jdbc.getSetSongs(masterPanel.openSetPanel.comboBox.getSelectedItem().toString());
				
				for(Song song : songs) {
					SongPanel songPanel = new SongPanel("remove", masterPanel);
					songPanel.setId(song.getId());
					songPanel.setName(song.getName());
					songPanel.setArtist(song.getArtist());
					songPanel.setTone(song.getTone());
					songPanel.setLength(song.getLength());
					songPanel.updateData();
					songPanels.add(songPanel);
				}
				for(SongPanel songPanel : songPanels) {
					scrollPanel.add(songPanel);
				}
				masterPanel.setLabel.setText(masterPanel.openSetPanel.comboBox.getSelectedItem().toString());
				
			}catch(Exception e) {
				e.printStackTrace();
				masterPanel.messageLabel.setForeground(Color.red);
				masterPanel.messageLabel.setText("Erro ao obter músicas");
			}
		}
	}
	
	public void addSong(SongPanel song) {
		
		songPanels.add(song);
		if(songPanels.size() < 10) gridLayout = new GridLayout(songPanels.size()+(10-songPanels.size()), 0);
		else gridLayout = new GridLayout(songPanels.size(), 0);
		scrollPanel.setLayout(gridLayout);
	}
	
	public void updateSongs() {
		scrollPanel.removeAll();
		scrollPanel.revalidate();
		scrollPanel.repaint();
		
		int totalLength = 0;
		
		for(SongPanel s : songPanels) {
			scrollPanel.add(s);
			totalLength += s.getLength();
		}
		masterPanel.timeCountLabel.setText(String.valueOf(totalLength));
		checkIndexAndSelection();
	}
	
	public void checkIndexAndSelection() {
		int i = 1;
		for(SongPanel songPanel : songPanels) {
			songPanel.setIdx(i);
			songPanel.idLabel.setText(String.valueOf(songPanel.getIdx()));
			i++;
			if(songPanel.isSelected) {
				songPanel.setBackground(Color.decode("#b7f79a"));
			}
			else {
				songPanel.setBackground(Color.decode("#d9dbec"));
			}
		}
	}
	
	public void unselectAll() {
		for(SongPanel songPanel : songPanels) {
			songPanel.isSelected = false;
		}
	}
	
	public void addComponents() {
		gridLayout = new GridLayout(songPanels.size()+10, 0);
		
		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.white);
		scrollPanel.setVisible(true);
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		//scrollPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		scrollPane = new JScrollPane(scrollPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, WIDTH, HEIGHT);
		add(scrollPane);
	}
	
	public void exportSet(String setName) {
		try{
			FileWriter writer = new FileWriter("exported/"+setName+".txt");
			for(SongPanel songPanel : songPanels) {
				writer.append(songPanel.getName()+"\n");
			}
			writer.close();
			}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
