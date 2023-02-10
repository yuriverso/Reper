package main;

import javax.swing.JFrame;

import gui.MasterPanel;

public class Reper {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		MasterPanel masterPanel = new MasterPanel();
		frame.add(masterPanel);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
		
}
