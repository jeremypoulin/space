package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BlueKey extends Entity{
	
	GamePanel gp;
	
	
	public OBJ_BlueKey(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_consumable;
		name = "BlueKey";
		down1 = setup("/objects/bluekey",gp.tileSize,gp.tileSize);
		title = "blue key.";
		description = "opens blue door.";
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		
		int objIndex = getDetected(entity, gp.obj, "BlueGate");
		
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
