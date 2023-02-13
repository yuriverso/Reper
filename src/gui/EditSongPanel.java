package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.Song;

public class EditSongPanel extends JPanel{

	MasterPanel masterPanel;
	ReperButton editButton, closeButton;
	JLabel idLabel, nameLabel, artistLabel, toneLabel, lengthLabel, titleLabel;
	JTextField idTextField, nameTextField, artistTextField, toneTextField, lengthTextField;
	
	EditSongPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(250,100,400,280);
		setBackground(Color.decode("#b02c3a"));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		titleLabel = new JLabel("Editar uma música");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(20, 15, 140, 30);
		titleLabel.setForeground(Color.black);
		titleLabel.setBackground(Color.gray);
		titleLabel.setOpaque(true);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(titleLabel);
		
		idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setBounds(200, 20, 50, 20);
		idLabel.setForeground(Color.black);
		add(idLabel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setBounds(20, 60, 50, 20);
		nameLabel.setForeground(Color.black);
		add(nameLabel);
		
		artistLabel = new JLabel("Artist");
		artistLabel.setHorizontalAlignment(JLabel.CENTER);
		artistLabel.setBounds(20, 100, 50, 20);
		artistLabel.setForeground(Color.black);
		add(artistLabel);
		
		toneLabel = new JLabel("Tone");
		toneLabel.setHorizontalAlignment(JLabel.CENTER);
		toneLabel.setBounds(20, 140, 50, 20);
		toneLabel.setForeground(Color.black);
		add(toneLabel);
		
		lengthLabel = new JLabel("Length");
		lengthLabel.setHorizontalAlignment(JLabel.CENTER);
		lengthLabel.setBounds(20, 180, 50, 20);
		lengthLabel.setForeground(Color.black);
		add(lengthLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(240,20,140,20);
		add(idTextField);
		
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
		
		editButton = new ReperButton(80, 220, 140, 40, masterPanel.al);
		editButton.setText("Edit");
		add(editButton);
		
		closeButton = new ReperButton(240, 220, 140, 40, masterPanel.al);
		closeButton.setText("Close");
		add(closeButton);
	}
	
	public void editSong() {
		Song song = new Song();
		if(idTextField.getText().equals("") || nameTextField.getText().equals("") || artistTextField.getText().equals("") || 
				toneTextField.getText().equals("") || lengthTextField.getText().equals("")) {
			masterPanel.messageLabel.setForeground(Color.red);
			masterPanel.messageLabel.setText("Campo(s) inválido(s)!");
		}else {
			song.setId(Integer.valueOf(idTextField.getText()));
			song.setName(nameTextField.getText());
			song.setArtist(artistTextField.getText());
			song.setTone(toneTextField.getText());
			song.setLength(Integer.valueOf(lengthTextField.getText()));
			masterPanel.jdbc.editSong(song);
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Música editada!");
		}
	}
	
	
	public void clearFields() {
		idTextField.setText("");
		nameTextField.setText("");
		artistTextField.setText("");
		toneTextField.setText("");
		lengthTextField.setText("");
	}
	
}
