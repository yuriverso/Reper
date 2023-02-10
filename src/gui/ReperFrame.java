package gui;

import javax.swing.JFrame;

import jdbc.ReperJDBC;

public class ReperFrame extends JFrame{
	
	ReperJDBC jdbc;
	public MasterPanel masterPanel;
	
	public ReperFrame(ReperJDBC jdbc){
		this.jdbc = jdbc;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		masterPanel = new MasterPanel();
		add(masterPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
