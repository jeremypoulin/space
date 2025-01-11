package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_GoldenApple extends Entity{
	
	GamePanel gp;
	int value = 2;

	public OBJ_GoldenApple(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		name = "GoldenApple";
		down1 = setup("/objects/goldenapple", gp.tileSize, gp.tileSize);
		title = "golden apple.";
		description = "heal.";
		price = 2;
		
	}
	public boolean use(Entity entity) {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "+1 heart.";
		entity.life += value;
		return true;
		
	}
	
	

}
