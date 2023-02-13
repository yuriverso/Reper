package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveSongPanel extends JPanel{
	MasterPanel masterPanel;
	ReperButton removeButton, closeButton;
	JLabel idLabel, titleLabel;
	JTextField idTextField;
	
	RemoveSongPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(250,100,400,150);
		setBackground(Color.gray);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		titleLabel = new JLabel("Remover uma música");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBounds(130, 15, 140, 30);
		titleLabel.setForeground(Color.black);
		titleLabel.setBackground(Color.white);
		titleLabel.setOpaque(true);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(titleLabel);
		
		idLabel = new JLabel("ID");
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setBounds(20, 60, 50, 20);
		idLabel.setForeground(Color.black);
		add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(80,60,100,20);
		add(idTextField);
		
		removeButton = new ReperButton(80, 95, 140, 40, masterPanel.al);
		removeButton.setText("Remover");
		add(removeButton);
		
		closeButton = new ReperButton(240, 95, 140, 40, masterPanel.al);
		closeButton.setText("Fechar");
		add(closeButton);
	}
	
	public void removeSong() {
		if(idTextField.getText().equals("")) {
			masterPanel.messageLabel.setForeground(Color.red);
			masterPanel.messageLabel.setText("Campo(s) inválido(s)!");
		}else {
			masterPanel.jdbc.removeSong(Integer.valueOf(idTextField.getText()));
			masterPanel.messageLabel.setForeground(Color.green);
			masterPanel.messageLabel.setText("Música removida");
		}
	}
}
