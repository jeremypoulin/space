package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[30];
	FloatControl fc;
	int volumeScale = 3;
	float volume;
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/theme.wav");
		soundURL[1] = getClass().getResource("/sound/attack.wav");
		soundURL[2] = getClass().getResource("/sound/boss.wav");
		soundURL[3] = getClass().getResource("/sound/bossnoise.wav");
		soundURL[4] = getClass().getResource("/sound/button.wav");
		soundURL[5] = getClass().getResource("/sound/damage.wav");
		soundURL[6] = getClass().getResource("/sound/filler.wav");
		soundURL[7] = getClass().getResource("/sound/final.wav");
		soundURL[8] = getClass().getResource("/sound/fireball.wav");
		soundURL[9] = getClass().getResource("/sound/levelup.wav");
		soundURL[10] = getClass().getResource("/sound/nostalgia.wav");
		soundURL[11] = getClass().getResource("/sound/select.wav");
		soundURL[12] = getClass().getResource("/sound/tense.wav");
		soundURL[13] = getClass().getResource("/sound/torch.wav");
		soundURL[14] = getClass().getResource("/sound/ivysqueak.wav");
		soundURL[15] = getClass().getResource("/sound/atticusmiaou.wav");
		soundURL[16] = getClass().getResource("/sound/ivymiaou.wav");
		soundURL[17] = getClass().getResource("/sound/keaton.wav");
		soundURL[18] = getClass().getResource("/sound/mochiger.wav");
		soundURL[19] = getClass().getResource("/sound/phinbark.wav");

		
	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			
		} catch(Exception e) {
			
		}
		
	}
	public void play() {
		
		clip.start();
		
	}
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	public void stop() {
		
		if(this.clip != null) {
			clip.stop();
		}
		
	}
	public void checkVolume() {
		
		switch(volumeScale) {
		case 0: volume = -80f; break;
		case 1: volume = -20f; break;
		case 2: volume = -12f; break;
		case 3: volume = -5f; break;
		case 4: volume = 1f; break;
		case 5: volume = 6f; break;
		}
		fc.setValue(volume);
		
	}

}
