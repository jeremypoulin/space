package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_GreenKey extends Entity{
	
	GamePanel gp;
	
	
	public OBJ_GreenKey(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "GreenKey";
		down1 = setup("/objects/greenkey",gp.tileSize,gp.tileSize);
		title = "green key.";
		description = "opens green door.";
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "GreenGate");
		
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
