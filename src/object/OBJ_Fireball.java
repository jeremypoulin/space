package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{
	
	GamePanel gp;

	public OBJ_Fireball(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Fireball";
		speed = 5;
		maxLife = 60;
		life = maxLife;
		knockbackPower = 0;
		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
		
	}
	public void getImage() {
		
		up1 = setup("/projectile/fireballup1",gp.tileSize,gp.tileSize);
		up2 = setup("/projectile/fireballup2",gp.tileSize,gp.tileSize);
		down1 = setup("/projectile/fireballdown1",gp.tileSize,gp.tileSize);
		down2 = setup("/projectile/fireballdown2",gp.tileSize,gp.tileSize);
		left1 = setup("/projectile/fireballleft1",gp.tileSize,gp.tileSize);
		left2 = setup("/projectile/fireballleft2",gp.tileSize,gp.tileSize);
		right1 = setup("/projectile/fireballright1",gp.tileSize,gp.tileSize);
		right2 = setup("/projectile/fireballright2",gp.tileSize,gp.tileSize);
		
	}
	public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		if(user.energy >= useCost) {
			haveResource = true;
		}
		return haveResource;
		
	}
	public void subtractResource(Entity user) {
		
		user.energy -= useCost;
		
	}

}
