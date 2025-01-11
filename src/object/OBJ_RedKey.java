package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_RedKey extends Entity{
	
	GamePanel gp;
	
	
	public OBJ_RedKey(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "RedKey";
		down1 = setup("/objects/redkey",gp.tileSize,gp.tileSize);
		title = "red key.";
		description = "opens red door.";
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "RedGate");
		
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
