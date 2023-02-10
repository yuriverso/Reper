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

	private final int WIDTH = 370, HEIGHT = 50;
	
	MasterPanel masterPanel;
	
	// Attributes
	private int id;
	private String name, artist, tone;
	private double length;

	// Components
	JLabel nameLabel, artistLabel, toneLabel, lengthLabel;
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
		Font font = new Font("Arial", Font.PLAIN, 5);
		if(function.equals("add")) {
			addButton = new ReperButton(5, 10, 30, 30, masterPanel.al);
			addButton.setFont(font);
			addButton.setText(String.valueOf(id));
			addButton.setBackground(Color.green);
			addButton.setOpaque(true);
			addButton.addActionListener(this);
			add(addButton);
		}else if(function.equals("remove")) {
			removeButton = new ReperButton(5, 10, 30, 30, masterPanel.al);
			removeButton.setText(String.valueOf(id));
			removeButton.setBackground(Color.red);
			removeButton.setOpaque(true);
			removeButton.addActionListener(this);
			add(removeButton);
		}
		nameLabel = new JLabel();
		nameLabel.setText(name);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setBounds(40, 0, 120, 50);
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(nameLabel);
		
		artistLabel = new JLabel();
		artistLabel.setText(artist);
		artistLabel.setHorizontalAlignment(JLabel.CENTER);
		artistLabel.setBounds(160, 0, 115, 50);
		artistLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(artistLabel);
		
		toneLabel = new JLabel();
		toneLabel.setText(tone);
		toneLabel.setHorizontalAlignment(JLabel.CENTER);
		toneLabel.setBounds(275, 0, 50, 50);
		toneLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(toneLabel);
		
		lengthLabel = new JLabel();
		lengthLabel.setText(String.valueOf(length));
		lengthLabel.setHorizontalAlignment(JLabel.CENTER);
		lengthLabel.setBounds(325, 0, 50, 50);
		lengthLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(lengthLabel);
	}
	
	public void updateData() {
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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
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