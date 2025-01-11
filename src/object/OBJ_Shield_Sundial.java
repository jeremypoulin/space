package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Sundial extends Entity{
	
	public OBJ_Shield_Sundial(GamePanel gp) {
		super(gp);
		
		type = type_sundialshield;
		name = "Sundial Shield";
		down1 = setup("/objects/sundialshield",gp.tileSize - 16,gp.tileSize - 16);
		defenseValue = 3;
		title = "sundial shield.";
		description = "defense: 3.";
		price = 4;
	}

}
