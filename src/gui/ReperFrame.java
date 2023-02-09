package gui;

import javax.swing.JFrame;

public class ReperFrame extends JFrame{
	
	MasterPanel masterPanel;
	
	public ReperFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		
		masterPanel = new MasterPanel();
		add(masterPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
