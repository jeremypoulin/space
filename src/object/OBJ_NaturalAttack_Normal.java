package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_NaturalAttack_Normal extends Entity{

	public OBJ_NaturalAttack_Normal(GamePanel gp) {
		super(gp);
		
		type = type_naturalnormal;
		name = "Natural Attack";
		down1 = setup("/objects/naturalattack",gp.tileSize - 16,gp.tileSize - 16);
		attackValue = 1;
		knockbackPower = 8;
		attackArea.width = 36;
		attackArea.height = 36;
		title = "natural attack.";
		description = "the power within.\nattack: 1.";

	}

}
