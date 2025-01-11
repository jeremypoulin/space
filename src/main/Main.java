package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main (String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("space.");
//		new Main().setIcon();
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		gamePanel.config.loadConfig();
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	}
/*	public void setIcon() {
		
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("tiles_interactive/web.png"));
		window.setIconImage(icon.getImage());
		
	}*/
	
}
