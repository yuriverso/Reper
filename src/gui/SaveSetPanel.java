package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveSetPanel extends JPanel{
	MasterPanel masterPanel;
	ReperButton saveButton, closeButton;
	JLabel titleLabel, nameLabel;
	JTextField nameTextField;
	
	SaveSetPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(250,200,400,180);
		setBackground(Color.gray);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		titleLabel = new JLabel("Salvar Set List");
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
		
		nameTextField = new JTextField();
		nameTextField.setBounds(80,60,300,20);
		add(nameTextField);
		
		
		saveButton = new ReperButton(80, 120, 140, 40, masterPanel.al);
		saveButton.setText("Salvar");
		add(saveButton);
		
		closeButton = new ReperButton(240, 120, 140, 40, masterPanel.al);
		closeButton.setText("Fechar");
		add(closeButton);
	}
}
