package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_TorchGun extends Entity{

	public OBJ_TorchGun(GamePanel gp) {
		super(gp);
		
		type = type_torchgun;
		name = "TorchGun";
		down1 = setup("/objects/torchgun", gp.tileSize, gp.tileSize);
		attackValue = 2;
		price = 4;
		knockbackPower = 5;
		attackArea.width = 64;
		attackArea.height = 64;
		title = "torch gun.";
		description = "clear the webs.\nattack = 2";

	}

}
