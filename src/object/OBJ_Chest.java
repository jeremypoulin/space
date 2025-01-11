package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity{
	
	GamePanel gp;
	Entity loot;
	boolean opened = false;
	
	public OBJ_Chest(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = "Chest";
		down1 = setup("/objects/chest",gp.tileSize,gp.tileSize);
		collision = true;
		
		solidArea.x = 4;
		solidArea.y = 16;
		solidArea.width = 40;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
	public void setLoot(Entity loot) {
		this.loot = loot;
	}
	public void interact() {
		
		gp.gameState = gp.dialogueState;
		
		if(opened == false) {
			gp.playSE(9);
			
			StringBuilder sb = new StringBuilder();
			sb.append("contains a " + loot.name + ".");
			
			if(gp.player.inventory.size() == gp.player.maxInventorySize) {
				sb.append("\n.but your inventory is full.");
			}
			else {
				sb.append("\nobtained " + loot.name + ".");
				gp.player.inventory.add(loot);
				opened = true;
			}
			gp.ui.currentDialogue = sb.toString();
			
		}
		else {
			gp.ui.currentDialogue = "empty.";
		}
		
	}

}
