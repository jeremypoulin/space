package object;

import java.io.IOException;

import entity.Entity;
import main.GamePanel;

public class OBJ_GoldKey extends Entity{
	
	GamePanel gp;
	
	
	public OBJ_GoldKey(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "GoldKey";
		down1 = setup("/objects/goldkey",gp.tileSize,gp.tileSize);
		title = "gold key.";
		description = "opens gold door.";
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "Door");
		
		if(objIndex != 999) {
			gp.ui.currentDialogue = "unlocked.";
			gp.playSE(9);
			gp.obj[gp.currentMap][objIndex] = null;
			return true;
			
		}
		else { 
			gp.ui.currentDialogue = "???";
			return false;
		}
		
	}

}
