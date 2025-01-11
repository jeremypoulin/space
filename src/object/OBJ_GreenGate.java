package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_GreenGate extends Entity{
	
GamePanel gp;
	
	public OBJ_GreenGate(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = "GreenGate";
		down1 = setup("/objects/greengate",gp.tileSize,gp.tileSize);
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
