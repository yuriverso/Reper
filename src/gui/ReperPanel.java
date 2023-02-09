package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReperPanel extends JPanel{
	
	private final int WIDTH = 390, HEIGHT = 450;
	
	MasterPanel masterPanel;
	ReperButton orderByNameButton, orderByArtistButton, orderByToneButton, orderByLengthButton;
	JScrollPane scrollPane;
	JPanel scrollPanel;
	
	SongPanel song1, song2, song3;
	//SongPanel[] songPanels;
	ArrayList<SongPanel> songPanels;
	
	ReperPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(35, 100, WIDTH, HEIGHT);
		setBackground(Color.black);
		setLayout(null);
		
		//get number of songs
		//initialize songPanels with the number of songs []
		//add songs to scroll pane
		songPanels = new ArrayList<SongPanel>();
		//songPanels = new SongPanel[3];
		
		addComponents();
		fillScrollPanel();
	}
	
	public void fillScrollPanel() {
		
		song1 = new SongPanel("add", masterPanel);
		song2 = new SongPanel("add", masterPanel);
		song3 = new SongPanel("add", masterPanel);
		
		songPanels.add(song1);
		songPanels.add(song2);
		songPanels.add(song3);
		for(SongPanel s : songPanels) {
			scrollPanel.add(s);
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
