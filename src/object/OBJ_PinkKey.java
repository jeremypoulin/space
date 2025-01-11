package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_PinkKey extends Entity{
	
	GamePanel gp;
	
	
	public OBJ_PinkKey(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "PinkKey";
		down1 = setup("/objects/pinkkey",gp.tileSize,gp.tileSize);
		title = "pink key.";
		description = "opens pink door.";
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "PinkGate");
		
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
