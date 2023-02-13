package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
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
	private int id, idx;
	private String name, artist, tone;
	private int length;
	public boolean isSelected = false;

	// Components
	JLabel idLabel, nameLabel, artistLabel, toneLabel, lengthLabel;
	ReperButton addButton, removeButton, selectButton;
	
	SongPanel(String function, MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.decode("#d9dbec"));
		setLayout(null);
		
		addComponents(function);
	}
	
	public void addComponents(String function) {
		
		idLabel = new JLabel();
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
		
		if(function.equals("add")) {
			addButton = new ReperButton(5, 5, 20, 30, masterPanel.al);
			addButton.setMargin(new Insets(0, 0, 0, 0));
			addButton.setText("+");
			addButton.setBackground(Color.decode("#7eff7d"));
			addButton.setOpaque(true);
			addButton.addActionListener(this);
			add(addButton);
		}else if(function.equals("remove")) {
			selectButton = new ReperButton(30, 0, 30, 45, masterPanel.al);
			selectButton.addActionListener(this);
			add(selectButton);
			removeButton = new ReperButton(5, 5, 20, 30, masterPanel.al);
			removeButton.setMargin(new Insets(0, 0, 0, 0));
			removeButton.setText("-");
			removeButton.setBackground(Color.decode("#ff7065"));
			removeButton.setOpaque(true);
			removeButton.addActionListener(this);
			add(removeButton);
		}
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
			SongPanel song = new SongPanel("remove", masterPanel);
			song.setId(this.getId());
			song.setName(this.getName());
			song.setArtist(this.getArtist());
			song.setTone(this.getTone());
			song.setLength(this.getLength());
			song.setIdx(masterPanel.setPanel.songPanels.size()+1);
			song.updateData();

			masterPanel.setPanel.addSong(song);
			masterPanel.setPanel.updateSongs();
			masterPanel.reperPanel.checkSelected();
		}
		if(e.getSource() == removeButton) {
			masterPanel.setPanel.songPanels.remove(this);
			masterPanel.setPanel.updateSongs();
			masterPanel.reperPanel.fillScrollPanel();
		}
		if(e.getSource() == selectButton) {
			if(isSelected) {
				masterPanel.setPanel.unselectAll();
				setBackground(Color.decode("#d9dbec"));
			}else {
				masterPanel.setPanel.unselectAll();
				isSelected = true;
				masterPanel.setPanel.checkIndexAndSelection();
			}
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

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
//gui.SongPanel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.LineBorder@1b50d949,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=370,height=50]]
//gui.SongPanel[,0,0,372x50,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.LineBorder@49ecabf3,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=370,height=50]]