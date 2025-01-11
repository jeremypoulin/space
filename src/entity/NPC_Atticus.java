package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class NPC_Atticus extends Entity{
	
	public NPC_Atticus(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getImage();
		setDialogue();
		
		solidArea = new Rectangle();
		solidArea.x = 6;
		solidArea.y = 10;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 20;
		
	}
	
	public void getImage() {
		
		up1 = setup("/npc/atticusl1",gp.tileSize,gp.tileSize);
		up2 = setup("/npc/atticusl2",gp.tileSize,gp.tileSize);
		down1 = setup("/npc/atticusr1",gp.tileSize,gp.tileSize);
		down2 = setup("/npc/atticusr2",gp.tileSize,gp.tileSize);
		left1 = setup("/npc/atticusl1",gp.tileSize,gp.tileSize);
		left2 = setup("/npc/atticusl2",gp.tileSize,gp.tileSize);
		right1 = setup("/npc/atticusr1",gp.tileSize,gp.tileSize);
		right2 = setup("/npc/atticusr2",gp.tileSize,gp.tileSize);
		
	}
	
	public void setDialogue() {
		
		dialogues[0] = "worship satan or die.";
		
	}
	
	public void setAction() {
		
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

		
	}
	public void speak() {
		
		gp.playSE(15);
		super.speak();

	}
}
