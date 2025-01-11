package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
	
	GamePanel gp;
	
	public Config(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void saveConfig() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
			
		/*	//MUSIC
			bw.write(String.valueOf(gp.music.volumeScale));
			bw.newLine();
			
			//SE
			bw.write(String.valueOf(gp.se.volumeScale));
			bw.newLine();
			
			bw.close();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadConfig() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
			
		//	String s = br.readLine();
			
		/*	//MUSIC
			s = br.readLine();
			gp.music.volumeScale = Integer.parseInt(s);
			
			//MUSIC
			s = br.readLine();
			gp.se.volumeScale = Integer.parseInt(s);
			
			br.close();*/
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
