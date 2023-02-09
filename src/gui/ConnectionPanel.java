package gui;

import java.awt.Color;
import javax.swing.JPanel;

public class ConnectionPanel extends JPanel{
	
	MasterPanel masterPanel;
	ReperButton cancelButton;
	
	ConnectionPanel(MasterPanel masterPanel){
		this.masterPanel = masterPanel;
		setBounds(100,100,400,200);
		setBackground(Color.blue);
		setLayout(null);
		setVisible(false);
		
		addComponents();
		
		masterPanel.add(this);
	}
	
	public void addComponents() {
		cancelButton = new ReperButton(10,10,180,180,masterPanel.al);
		add(cancelButton);
	}

}
