package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;
import object.OBJ_GoldenApple;
import object.OBJ_Shield_Sundial;
import object.OBJ_TorchGun;
import object.OBJ_XmasBoots;

public class NPC_Keaton extends Entity{
	
	public NPC_Keaton(GamePanel gp) {
		super(gp);
		
		direction = "down";
		
		getImage();
		setDialogue();
		setItems();
		
		solidArea = new Rectangle();
		solidArea.x = 6;
		solidArea.y = 10;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 20;
		
	}
	
	public void getImage() {
		
		up1 = setup("/npc/keaton1",gp.tileSize,gp.tileSize);
		up2 = setup("/npc/keaton2",gp.tileSize,gp.tileSize);
		down1 = setup("/npc/keaton1",gp.tileSize,gp.tileSize);
		down2 = setup("/npc/keaton2",gp.tileSize,gp.tileSize);
		left1 = setup("/npc/keaton1",gp.tileSize,gp.tileSize);
		left2 = setup("/npc/keaton2",gp.tileSize,gp.tileSize);
		right1 = setup("/npc/keaton1",gp.tileSize,gp.tileSize);
		right2 = setup("/npc/keaton2",gp.tileSize,gp.tileSize);
		
	}
	
	public void setDialogue() {
		
		dialogues[0] = "wanna buy a sundial?";
		
	}
	
	public void setItems() {
		
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_GoldenApple(gp));
		inventory.add(new OBJ_TorchGun(gp));
		inventory.add(new OBJ_Shield_Sundial(gp));
		inventory.add(new OBJ_XmasBoots(gp));
		
	}
	
	public void speak() {
		
		gp.playSE(17);
		super.speak();
		gp.saveLoad.save();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
		
	}

}
