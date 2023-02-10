package main;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import gui.ReperFrame;
import jdbc.ReperConnection;
import jdbc.ReperJDBC;
import jdbc.Song;

public class Reper {
	
	public static void main(String[] args) {
		/*ReperConnection con = new ReperConnection();
		ReperJDBC jdbc = new ReperJDBC(con.openCon());
		ReperFrame frame = new ReperFrame(jdbc);
		if(jdbc.getCon() == null) {
			frame.masterPanel.connectionLabel.setBackground(Color.red);
			frame.masterPanel.messageLabel.setForeground(Color.red);
			frame.masterPanel.messageLabel.setText("Erro de conexão com o DB");
		}*/
		ReperFrame frame = new ReperFrame(null);
		
	}
		
}
