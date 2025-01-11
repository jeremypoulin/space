package tile_interactive;

import java.awt.Color;

import main.GamePanel;

public class IT_WitheredTree extends InteractiveTile{
	
	GamePanel gp;

	public IT_WitheredTree(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		maxLife = 2;
		life = maxLife;
		type = type_iTile;
//		regenerative = true;
		hpBarOn = false;
		down1 = setup("/tiles_interactive/witheredtree",gp.tileSize,gp.tileSize);
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
//	public InteractiveTile getRegeneratedForm() {
//		InteractiveTile tile = new IT_Web(gp, worldX/gp.tileSize, worldY/gp.tileSize);
//		return tile;
//		
//	}
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
