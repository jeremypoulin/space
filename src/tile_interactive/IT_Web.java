package tile_interactive;

import java.awt.Color;
import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;

public class IT_Web extends InteractiveTile{
	
	GamePanel gp;

	public IT_Web(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		tileVisible = true;
		maxLife = 2;
		life = maxLife;
		type = type_iTile;
//		regenerative = true;
		hpBarOn = false;
		down1 = setup("/tiles_interactive/web",gp.tileSize,gp.tileSize);
		destructible = true;
		
	}
	public void update() {
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 20) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		
	}
	public InteractiveTile getRegeneratedForm() {
		InteractiveTile tile = new IT_Web(gp, worldX/gp.tileSize, worldY/gp.tileSize);
		return tile;
		
	}
	public Color getParticleColor() {
		Color color = new Color(206, 206, 206);
		return color;
	}
	public int getParticleSize() {
		
		int size = 6; //6 PIXELS
		return size;
		
	}
	public int getParticleSpeed() {
		
		int speed = 1;
		return speed;
		
	}
	public int getParticleMaxLife() {
		
		int maxLife = 5;
		return maxLife;
		
	}

}
