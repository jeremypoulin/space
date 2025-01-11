package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BlueGate extends Entity{
	
GamePanel gp;
	
	public OBJ_BlueGate(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = "BlueGate";
		down1 = setup("/objects/bluegate",gp.tileSize,gp.tileSize);
		collision = true;
		
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	}
	public void interact() {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "locked.";
		
	}

}
