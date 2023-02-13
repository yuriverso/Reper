package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionPanel extends JPanel{
	
	MasterPanel masterPanel;
	ReperButton connectButton, closeButton;
	JLabel urlLabel, userLabel, passLabel;
	JTextField urlTextField, userTextField, passTextField;
	
	ConnectionPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(250,100,400,200);
		setBackground(Color.gray);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		urlLabel = new JLabel("URL");
		urlLabel.setHorizontalAlignment(JLabel.CENTER);
		urlLabel.setBounds(20, 20, 50, 20);
		urlLabel.setForeground(Color.black);
		add(urlLabel);
		
		userLabel = new JLabel("User");
		userLabel.setHorizontalAlignment(JLabel.CENTER);
		userLabel.setBounds(20, 60, 50, 20);
		userLabel.setForeground(Color.black);
		add(userLabel);
		
		passLabel = new JLabel("Pass");
		passLabel.setHorizontalAlignment(JLabel.CENTER);
		passLabel.setBounds(20, 100, 50, 20);
		passLabel.setForeground(Color.black);
		add(passLabel);
		
		urlTextField = new JTextField();
		urlTextField.setBounds(80,20,300,20);
		add(urlTextField);
		
		userTextField = new JTextField();
		userTextField.setBounds(80,60,300,20);
		add(userTextField);
		
		passTextField = new JTextField();
		passTextField.setBounds(80,100,300,20);
		add(passTextField);
		
		connectButton = new ReperButton(80, 140, 140, 40, masterPanel.al);
		connectButton.setText("Conectar");
		add(connectButton);
		
		closeButton = new ReperButton(240, 140, 140, 40, masterPanel.al);
		closeButton.setText("Fechar");
		add(closeButton);
	}

}
