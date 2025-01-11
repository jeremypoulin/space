package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Energy;
import object.OBJ_Orb;

public class MON_Spider extends Entity{
	
	GamePanel gp;
	
	public MON_Spider(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_monster;
		name = "Spider";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 4;
		life = maxLife;
		attack = 2;
		defense = 0;
		exp = 11;
		projectile = new OBJ_Orb(gp);
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	public void getImage() {
		
		up1 = setup("/monster/monspider1",gp.tileSize,gp.tileSize);
		up2 = setup("/monster/monspider2",gp.tileSize,gp.tileSize);
		down1 = setup("/monster/monspider1",gp.tileSize,gp.tileSize);
		down2 = setup("/monster/monspider2",gp.tileSize,gp.tileSize);
		left1 = setup("/monster/monspider1",gp.tileSize,gp.tileSize);
		left2 = setup("/monster/monspider2",gp.tileSize,gp.tileSize);
		right1 = setup("/monster/monspider1",gp.tileSize,gp.tileSize);
		right2 = setup("/monster/monspider2",gp.tileSize,gp.tileSize);
		
	}
/*	public void update() {
		
		super.update();
		
		int xDistance = Math.abs(worldX - gp.player.worldX);
		int yDistance = Math.abs(worldY - gp.player.worldY);
		int tileDistance = (xDistance + yDistance)/gp.tileSize;
		
		if(onPath == false && tileDistance < 5) {
			int i = new Random().nextInt(100)+1;
			if(i > 50) {
				onPath = true;
			}
		}
		if(onPath == true && tileDistance > 20) {
			onPath = false;
		}
		
	}*/
	public void setAction() {
		
		if(onPath == true) {
			
//			int goalCol = 12;
//			int goalRow = 9;
			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			
			
			searchPath(goalCol,goalRow);
			
/*			int i = new Random().nextInt(100)+1;
			if(i > 97 && projectile.alive == false && shotAvailableCounter == 30) {
				
				projectile.set(worldX, worldY, direction, true, this);
	//			gp.projectileList.add(projectile);
				
				for(int ii = 0; ii < gp.projectile[1].length; ii++) {
					if(gp.projectile[gp.currentMap][ii] == null) {
						gp.projectile[gp.currentMap][ii] = projectile;
						break;
					}
				}
				
				shotAvailableCounter = 0;
				
			}*/
			speed = 4;
			
		}
		else {
			
			actionLockCounter ++;
			
			if(actionLockCounter == 120) {
				Random random = new Random();
				int i = random.nextInt(100)+1; // pick up a number from 1 to 100
				
				if(i <= 25) {
					direction = "up";
				}
				if(i > 25 && i <= 50) {
					direction = "down";
				}
				if(i > 50 && i<= 75) {
					direction = "left";
				}
				if(i > 75 && i <= 100) {
					direction = "right";
				}
				
				actionLockCounter = 0;
			
			}
			
			speed = defaultSpeed;
			
		}
		
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		onPath = true;
		
	}
	public void checkDrop() {
		
		//ROLL A DICE
		int i = new Random().nextInt(100)+1;
		
		//SET THE MONSTER DROP
		if(i > 0) {
			
			dropItem(new OBJ_Energy(gp));
			
		}
		if(i >= 50) {
			
			dropItem(new OBJ_Energy(gp));
			
		}
		
	}

}
