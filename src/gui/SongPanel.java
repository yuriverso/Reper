package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongPanel extends JPanel implements ActionListener{

	private final int WIDTH = 370, HEIGHT = 45;
	
	MasterPanel masterPanel;
	
	// Attributes
	private int id;
	private String name, artist, tone;
	private int length;

	// Components
	JLabel idLabel, nameLabel, artistLabel, toneLabel, lengthLabel;
	ReperButton addButton, removeButton;
	
	SongPanel(String function, MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.pink);
		setLayout(null);
		
		addComponents(function);
	}
	
	public void addComponents(String function) {
		if(function.equals("add")) {
			addButton = new ReperButton(5, 5, 20, 30, masterPanel.al);
			addButton.setBackground(Color.green);
			addButton.setOpaque(true);
			addButton.addActionListener(this);
			add(addButton);
		}else if(function.equals("remove")) {
			removeButton = new ReperButton(5, 5, 20, 30, masterPanel.al);
			removeButton.setBackground(Color.red);
			removeButton.setOpaque(true);
			removeButton.addActionListener(this);
			add(removeButton);
		}
		idLabel = new JLabel();
		idLabel.setText(String.valueOf(id));
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setBounds(30, 0, 30, 45);
		idLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(idLabel);
		
		nameLabel = new JLabel();
		nameLabel.setText(name);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setBounds(60, 0, 120, 45);
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(nameLabel);
		
		artistLabel = new JLabel();
		artistLabel.setText(artist);
		artistLabel.setHorizontalAlignment(JLabel.CENTER);
		artistLabel.setBounds(180, 0, 100, 45);
		artistLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(artistLabel);
		
		toneLabel = new JLabel();
		toneLabel.setText(tone);
		toneLabel.setHorizontalAlignment(JLabel.CENTER);
		toneLabel.setBounds(280, 0, 30, 45);
		toneLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(toneLabel);
		
		lengthLabel = new JLabel();
		lengthLabel.setText(String.valueOf(length));
		lengthLabel.setHorizontalAlignment(JLabel.CENTER);
		lengthLabel.setBounds(310, 0, 65, 45);
		lengthLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lengthLabel);
	}
	
	public void updateData() {
		idLabel.setText(String.valueOf(id));
		nameLabel.setText(name);
		artistLabel.setText(artist);
		toneLabel.setText(tone);
		lengthLabel.setText(String.valueOf(length));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			setBackground(Color.gray);
			SongPanel song = new SongPanel("remove", masterPanel);

			masterPanel.setPanel.addSong(song);
			masterPanel.setPanel.updateSongs();
		}
		if(e.getSource() == removeButton) {
			masterPanel.setPanel.songPanels.remove(this);
			masterPanel.setPanel.updateSongs();
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTone() {
		return tone;
	}

	public void setTone(String tone) {
		this.tone = tone;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
//gui.SongPanel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.LineBorder@1b50d949,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=370,height=50]]
//gui.SongPanel[,0,0,372x50,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.LineBorder@49ecabf3,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=370,height=50]]