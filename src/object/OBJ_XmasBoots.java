package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_XmasBoots extends Entity{
	
	
	public OBJ_XmasBoots(GamePanel gp) {
		super(gp);
		
		type = type_boots;
		name = "XmasBoots";
		down1 = setup("/objects/xmasboots",gp.tileSize,gp.tileSize);
		price = 4;
		title = "xmas boots.";
		description = "be speedy.\npermanently.";
		
	}

}
