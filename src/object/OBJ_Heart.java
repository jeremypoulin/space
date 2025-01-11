package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
	
	GamePanel gp;
	
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickUpOnly;
		name = "Heart";
		value = 2;
		down1 = setup("/objects/fullheart",gp.tileSize,gp.tileSize);
		image = setup("/objects/fullheart",gp.tileSize,gp.tileSize);
		image2 = setup("/objects/halfheart",gp.tileSize,gp.tileSize);
		image3 = setup("/objects/emptyheart",gp.tileSize,gp.tileSize);
		
	}
	public boolean use(Entity entity) {
		
		entity.life += value;
		return true;
		
	}

}
