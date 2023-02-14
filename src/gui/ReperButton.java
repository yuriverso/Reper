package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReperButton extends JButton{

	
	ReperButton(int x, int y, int width, int height, ActionListener a){
		setBounds(x, y, width, height);
		setText(null);
		setFocusable(false);
		setOpaque(false);
		addActionListener(a);
	}

}
