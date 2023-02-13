package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.Song;

public class AddSongPanel extends JPanel{

	MasterPanel masterPanel;
	ReperButton addButton, closeButton;
	JLabel nameLabel, artistLabel, toneLabel, lengthLabel, titleLabel;
	JTextField nameTextField, artistTextField, toneTextField, lengthTextField;
	
	AddSongPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(250,100,400,280);
		setBackground(Color.gray);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		titleLabel = new JLabel("Adicionar uma música");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(130, 15, 140, 30);
		titleLabel.setForeground(Color.black);
		titleLabel.setBackground(Color.white);
		titleLabel.setOpaque(true);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(titleLabel);
		
		nameLabel = new JLabel("Nome");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setBounds(20, 60, 50, 20);
		nameLabel.setForeground(Color.black);
		add(nameLabel);
		
		artistLabel = new JLabel("Artista");
		artistLabel.setHorizontalAlignment(JLabel.CENTER);
		artistLabel.setBounds(20, 100, 50, 20);
		artistLabel.setForeground(Color.black);
		add(artistLabel);
		
		toneLabel = new JLabel("Tom");
		toneLabel.setHorizontalAlignment(JLabel.CENTER);
		toneLabel.setBounds(20, 140, 50, 20);
		toneLabel.setForeground(Color.black);
		add(toneLabel);
		
		lengthLabel = new JLabel("Duração");
		lengthLabel.setHorizontalAlignment(JLabel.CENTER);
		lengthLabel.setBounds(20, 180, 50, 20);
		lengthLabel.setForeground(Color.black);
		add(lengthLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(80,60,300,20);
		add(nameTextField);
		
		artistTextField = new JTextField();
		artistTextField.setBounds(80,100,300,20);
		add(artistTextField);
		
		toneTextField = new JTextField();
		toneTextField.setBounds(80,140,100,20);
		add(toneTextField);
		
		lengthTextField = new JTextField();
		lengthTextField.setBounds(80,180,100,20);
		add(lengthTextField);
		
		addButton = new ReperButton(80, 220, 140, 40, masterPanel.al);
		addButton.setText("Adicionar");
		add(addButton);
		
		closeButton = new ReperButton(240, 220, 140, 40, masterPanel.al);
		closeButton.setText("Fechar");
		add(closeButton);
	}
	
	public void addSong() {
		Song song = new Song();
		
		if(nameTextField.getText().equals("") || artistTextField.getText().equals("") ||
		   toneTextField.getText().equals("") || lengthTextField.getText().equals("")) {
			masterPanel.messageLabel.setForeground(Color.red);
			masterPanel.messageLabel.setText("Campo(s) inválido(s)!");
		}else {
			song.setName(nameTextField.getText());
			song.setArtist(artistTextField.getText());
			song.setTone(toneTextField.getText());
			song.setLength(Integer.valueOf(lengthTextField.getText()));
			masterPanel.jdbc.insertSong(song);
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Música adicionada");
		}
		
	}
	
	public void clearFields() {
		nameTextField.setText("");
		artistTextField.setText("");
		toneTextField.setText("");
		lengthTextField.setText("");
	}
	
}
