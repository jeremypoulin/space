package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Web extends Entity{

	public OBJ_Shield_Web(GamePanel gp) {
		super(gp);
		
		type = type_webshield;
		name = "Web Shield";
		down1 = setup("/objects/webshield",gp.tileSize - 16,gp.tileSize - 16);
		defenseValue = 1;
		title = "web shield.";
		description = "defense: 1.";
	}

}
