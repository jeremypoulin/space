package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Energy extends Entity{
	
	GamePanel gp;
	
	public OBJ_Energy(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickUpOnly;
		name = "Energy";
		value = 1;
		down1 = setup("/objects/Energy",gp.tileSize,gp.tileSize);
	}
	public boolean use(Entity entity) {
		
		entity.energy += value;
		return true;
		
	}
	

}
