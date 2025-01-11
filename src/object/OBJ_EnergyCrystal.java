package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_EnergyCrystal extends Entity{

	GamePanel gp;
	
	public OBJ_EnergyCrystal(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickUpOnly;
		name = "EnergyCrystal";
		value = 1;
		down1 = setup("/objects/EnergyCrystalFull",gp.tileSize,gp.tileSize);
		image = setup("/objects/EnergyCrystalFull",gp.tileSize,gp.tileSize);
		image2 = setup("/objects/EnergyCrystalEmpty",gp.tileSize,gp.tileSize);
	}
	public boolean use(Entity entity) {
		
		entity.energy += value;
		return true;
		
	}
	
}
