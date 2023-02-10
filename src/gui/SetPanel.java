package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SetPanel extends JPanel{

	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	JScrollPane scrollPane;
	JPanel scrollPanel;
	
	ArrayList<SongPanel> songPanels;
	
	SetPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		
		setBounds(475, 100, WIDTH, HEIGHT);
		setBackground(Color.black);
		setLayout(null);
		
		songPanels = new ArrayList<SongPanel>();
		
		addComponents();
	}
	
	public void addSong(SongPanel song) {
		songPanels.add(song);
	}
	
	public void updateSongs() {
		scrollPanel.removeAll();
		scrollPanel.revalidate();
		scrollPanel.repaint();
		for(SongPanel s : songPanels) {
			scrollPanel.add(s);
		}
	}
	
	public void addComponents() {
		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.white);
		scrollPanel.setVisible(true);
		scrollPanel.setLayout(new GridLayout(10, 0));

		scrollPane = new JScrollPane(scrollPanel);
		scrollPane.setBounds(0, 0, WIDTH, HEIGHT);
		add(scrollPane);
	}
	
}
