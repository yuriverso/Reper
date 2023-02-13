package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpenSetPanel extends JPanel{

	MasterPanel masterPanel;
	ReperButton openButton, closeButton;
	JLabel titleLabel, nameLabel;
	JComboBox<String> comboBox;
	ArrayList<String> sets;
	
	OpenSetPanel(MasterPanel masterPanel){
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
		titleLabel = new JLabel("Abrir Set List");
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
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(80,60,300,20);
		add(comboBox);
		
		openButton = new ReperButton(80, 120, 140, 40, masterPanel.al);
		openButton.setText("Abrir");
		add(openButton);
		
		closeButton = new ReperButton(240, 120, 140, 40, masterPanel.al);
		closeButton.setText("Fechar");
		add(closeButton);
	}
	
	public void fillComboBox() {
		comboBox.removeAllItems();
		sets = masterPanel.jdbc.getSets();
		for(int i=1; i<sets.size(); i++) {
			comboBox.addItem(sets.get(i));
		}
		
	}
}
