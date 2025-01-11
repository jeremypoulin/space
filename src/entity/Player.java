package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Fireball;
import object.OBJ_NaturalAttack_Normal;
import object.OBJ_Shield_Web;
import tile_interactive.IT_Web;
import tile_interactive.InteractiveTile;

public class Player extends Entity{
	
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	int standCounter = 0;
	int tileCounter = 0;
	public boolean attackCanceled = false;
	public boolean turnOffSound = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 6;
		solidArea.y = 10;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 20;
		
		attackArea.width = 36;
		attackArea.height = 36;
		
		
		setDefaultValues();
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 36;
		worldY = gp.tileSize * 20;
		defaultSpeed = 4;
		speed = defaultSpeed;
		direction = "down";
		
		//PLAYER STATUS
		level = 1;
		maxLife = 16;
		life = 4;
		maxEnergy = 4;
		energy = 4;
		strength = 1; //more = more damage given
		agility = 1; //more = less damage received
		exp = 0;
		nextLevelExp = 5;
		coin = 0;
		currentWeapon = new OBJ_NaturalAttack_Normal(gp);
		currentShield = new OBJ_Shield_Web(gp);
		projectile = new OBJ_Fireball(gp);
		attack = getAttack();
		defense = getDefense();
		
		setDefaultPositions();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
		
	}
	public void setDefaultPositions() {
		
		worldX = gp.tileSize * 7;
		worldY = gp.tileSize * 9;
		direction = "down";
		
	}
	public void restoreStatus() {
		
		life = 4;
		energy = 4;
		speed = defaultSpeed;
		invincible = false;
		attacking = false;
		knockback = false;
		
	}
	public void setItems() {
		
		inventory.clear();
		inventory.add(currentWeapon);
		inventory.add(currentShield);
		
	}
	public int getAttack() {
		
		attackArea = currentWeapon.attackArea;
		return attack = strength * currentWeapon.attackValue;
		
	}
	public int getDefense() {
		
		return defense = agility * currentShield.defenseValue;
		
	}
	public int getCurrentWeaponSlot() {
		int currentWeaponSlot = 0;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i) == currentWeapon) {
				currentWeaponSlot = i;
			}
		}
		return currentWeaponSlot;
	}
	public int getCurrentShieldSlot() {
		int currentShieldSlot = 0;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i) == currentShield) {
				currentShieldSlot = i;
			}
		}
		return currentShieldSlot;
	}
	public void getPlayerImage() {
		
		up1 = setup("/player/up1",gp.tileSize,gp.tileSize);
		up2 = setup("/player/up2",gp.tileSize,gp.tileSize);
		down1 = setup("/player/down1",gp.tileSize,gp.tileSize);
		down2 = setup("/player/down2",gp.tileSize,gp.tileSize);
		left1 = setup("/player/left1",gp.tileSize,gp.tileSize);
		left2 = setup("/player/left2",gp.tileSize,gp.tileSize);
		right1 = setup("/player/right1",gp.tileSize,gp.tileSize);
		right2 = setup("/player/right2",gp.tileSize,gp.tileSize);
		stopDown = setup("/player/stopdown",gp.tileSize,gp.tileSize);
		stopUp = setup("/player/stopup",gp.tileSize,gp.tileSize);
		stopLeft = setup("/player/stopleft",gp.tileSize,gp.tileSize);
		stopRight = setup("/player/stopright",gp.tileSize,gp.tileSize);
		
	}
	public void getPlayerAttackImage() {
		
		if(currentWeapon.type == type_naturalnormal) {
			
			attackUp1 = setup("/player/attackup1",gp.tileSize,gp.tileSize*2);
			attackUp2 = setup("/player/attackup2",gp.tileSize,gp.tileSize*2);
			attackDown1 = setup("/player/attackdown1",gp.tileSize,gp.tileSize*2);
			attackDown2 = setup("/player/attackdown2",gp.tileSize,gp.tileSize*2);
			attackLeft1 = setup("/player/attackleft1",gp.tileSize*2,gp.tileSize);
			attackLeft2 = setup("/player/attackleft2",gp.tileSize*2,gp.tileSize);
			attackRight1 = setup("/player/attackright1",gp.tileSize*2,gp.tileSize);
			attackRight2 = setup("/player/attackright2",gp.tileSize*2,gp.tileSize);
			
		}
		
		if(currentWeapon.type == type_torchgun) {
			
			attackUp1 = setup("/player/torchgunup1",gp.tileSize,gp.tileSize*2);
			attackUp2 = setup("/player/torchgunup2",gp.tileSize,gp.tileSize*2);
			attackDown1 = setup("/player/torchgundown1",gp.tileSize,gp.tileSize*2);
			attackDown2 = setup("/player/torchgundown2",gp.tileSize,gp.tileSize*2);
			attackLeft1 = setup("/player/torchgunleft1",gp.tileSize*2,gp.tileSize);
			attackLeft2 = setup("/player/torchgunleft2",gp.tileSize*2,gp.tileSize);
			attackRight1 = setup("/player/torchgunright1",gp.tileSize*2,gp.tileSize);
			attackRight2 = setup("/player/torchgunright2",gp.tileSize*2,gp.tileSize);
			
		}
		
	}
	
	public void update() {
		
		if(attacking == true) {
			
			attacking();
			
		}
		
		else if(keyH.upPressed == true || keyH.downPressed == true 
				|| keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) {
		
			if(keyH.upPressed == true) {
				direction = "up";
			}
			
			else if (keyH.downPressed == true) {
				direction = "down";
			}
			else if (keyH.leftPressed == true) {
				direction = "left";
			}
			else if (keyH.rightPressed == true) {
				direction = "right";
			}
			
			//CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			//CHECK NPC COLLISION
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			
			//CHECK MONSTER COLLISION
			int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
			contactMonster(monsterIndex);
			
			//CHECK INTERACTIVE TILE COLLISION
			int iTileIndex = gp.cChecker.checkEntity(this,  gp.iTile);
			
			
			//CHECK EVENT
			gp.eHandler.checkEvent();
			
			
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(collisionOn == false && keyH.enterPressed == false) {
				
				switch(direction) {
				case "up": worldY -= speed; break;
				case "down": worldY += speed; break;
				case "left": worldX -=speed; break;
				case "right": worldX += speed; break;
				}
				
			}
			
			if(keyH.enterPressed == true && attackCanceled == false) {
//				gp.playSE(7);
				attacking = true;
				spriteCounter = 0;
			}
			
			attackCanceled = false;
			
			gp.keyH.enterPressed = false;
		
			spriteCounter++;
			if(spriteCounter > 15) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		else {
			standCounter++;
			if(standCounter == 20) {
				spriteNum = 1;
				standCounter = 0;
			}
		}
		
		if(gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30 && projectile.haveResource(this) == true) {
			
			//SET DEFAULT COORDINATES, DIRECTION AND USER
			projectile.set(worldX, worldY, direction, true, this);
			
			//SUBTRACT USE COST
			projectile.subtractResource(this);
			
			//ADD IT TO THE LIST
//			gp.projectileList.add(projectile);
			for(int i = 0; i < gp.projectile[1].length; i++) {
				if(gp.projectile[gp.currentMap][i] == null) {
					gp.projectile[gp.currentMap][i] = projectile;
					break;
				}
			}
			
			shotAvailableCounter = 0;
			
		}
		
//		else if (keyH.upPressed == false || keyH.downPressed == false 
//				|| keyH.leftPressed == false || keyH.rightPressed == false) {
			
//			if(keyH.upPressed == false) {
//				direction = "stopdown";
//			}
//			else if (keyH.downPressed == false) {
//				direction = "stopdown";
//			}
//			else if (keyH.leftPressed == false) {
//				direction = "stopdown";
//			}
//			else if (keyH.rightPressed == false) {
//				direction = "stopdown";
//			}
//		}

		
		//This needs to be outside of key if statement!
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		if(life > maxLife) {
			life = maxLife;
		}
		if(energy > maxEnergy) {
			energy = maxEnergy;
		}
		if(life <= 0) {
			gp.ui.commandNum = -1;
			gp.stopMusic();
			gp.gameState = gp.gameOverState;
		}
	}
	public void attacking() {
		
		spriteCounter++;
		
		if(spriteCounter <=5) {
			spriteNum = 1;
		}
		if(spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
			
			//Save the current worldx, worldy, solidarea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHeight = solidArea.height;
			
			//Adjust player's worldX for the attackArea
			switch(direction) {
			case "up": worldY -= attackArea.height; break;
			case "down": worldY += gp.tileSize; break;
			case "left": worldX -= attackArea.width; break;
			case "right": worldX += gp.tileSize; break;
			}
			
			//attackArea becomes solidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			
			//check monster collision
			int monsterIndex = gp.cChecker.checkEntity(this,  gp.monster);
			damageMonster(monsterIndex, attack, currentWeapon.knockbackPower);
			
			int iTileIndex = gp.cChecker.checkEntity(this,  gp.iTile);
			damageInteractiveTile(iTileIndex, attack);
			
			int projectileIndex = gp.cChecker.checkEntity(this, gp.projectile);
			damageProjectile(projectileIndex);
			
			//restore og data
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHeight;
		}
		if(spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}
		
	}
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			//PICK UP ONLY ITEMS
			if(gp.obj[gp.currentMap][i].type == type_pickUpOnly) {
				
				gp.playSE(9);
				gp.obj[gp.currentMap][i].use(this);
				gp.obj[gp.currentMap][i] = null;
				
			}
			//OBSTACLE
			else if(gp.obj[gp.currentMap][i].type == type_obstacle) {
				if(keyH.enterPressed == true) {
					attackCanceled = true;
					gp.obj[gp.currentMap][i].interact();
				}
			}
			
			//INVENTORY ITEMS
			else {
				if(inventory.size() != maxInventorySize) {
			
				gp.playSE(11);
				inventory.add(gp.obj[gp.currentMap][i]);
				
				}	
				gp.obj[gp.currentMap][i] = null;
			}	
		}
		
	}
	public void interactNPC(int i) {
		
		if(gp.keyH.enterPressed == true) {
			
			if(i != 999) {
				
				attackCanceled = true;	
				gp.gameState = gp.dialogueState;
				gp.npc[gp.currentMap][i].speak();
				
			}
			
		}
		
		if(i != 999) {
			
			turnOffSound = true;
			if(gp.keyH.enterPressed == true) {
//				turnOffSound = true;
				gp.gameState = gp.dialogueState;
				gp.npc[gp.currentMap][i].speak();
			}
			
		}
		else {
			if(gp.keyH.enterPressed == true) {
				attacking = true;
				turnOffSound = false;
			}
		}
//		turnOffSound = false;
	}
	public void contactMonster(int i) {
		
		if(i != 999) {
			
			if(invincible == false && gp.monster[gp.currentMap][i].dying == false) {
				
			int damage = gp.monster[gp.currentMap][i].attack - defense;
			if(damage < 0) {
				damage = 0;
			}
				
			life -= damage;
			invincible = true;
			gp.playSE(5);
		
			}
		}	
		
	}
	public void damageMonster(int i, int attack, int knockbackPower) {
		
		if(i != 999) {
			
			if(gp.monster[gp.currentMap][i].invincible == false && gp.monster[gp.currentMap][i].dying == false) {
				
				if(knockbackPower > 0) {
					knockback(gp.monster[gp.currentMap][i], knockbackPower);
				}
				
				int damage = attack - gp.monster[gp.currentMap][i].defense;
				if(damage < 0) {
					damage = 0;
				}
				
				gp.monster[gp.currentMap][i].life -= damage;
				gp.monster[gp.currentMap][i].invincible = true;
				gp.monster[gp.currentMap][i].damageReaction();
				
				if(gp.monster[gp.currentMap][i].life <= 0) {
					gp.monster[gp.currentMap][i].dying = true;
					gp.ui.addMessage("dead");
					exp += gp.monster[gp.currentMap][i].exp;
					checkLevelUp();
				}
			}
			
		}
		
	}
	public void knockback(Entity entity, int knockbackPower) {
		
		entity.direction = direction;
		entity.speed += knockbackPower;
		entity.knockback = true;
		
	}
	public void damageInteractiveTile(int i, int attack) {
		
		if(i != 999) {
			
			if(gp.iTile[gp.currentMap][i].destructible == true && gp.iTile[gp.currentMap][i].invincible == false) {
			
			
				int damage = attack;
				if(damage < 0) {
					damage = 0;
				}
			
				gp.iTile[gp.currentMap][i].life -= damage;
				gp.iTile[gp.currentMap][i].invincible = true;
//				generateParticle(gp.iTile[i],gp.iTile[i]);
				
				if(gp.iTile[gp.currentMap][i].life <= 0) {
					gp.iTile[gp.currentMap][i] = null;
				}
			}
		
		}
		
	}
	public void damageProjectile(int i) {
		
		if(i != 999) {
			Entity projectile = gp.projectile[gp.currentMap][i];
			projectile.alive = false;
//			generateParticle(projectile,projectile;)
		}
		
	}
	public void checkLevelUp() {
		
		if(exp >= nextLevelExp) {
			
			level++;
			nextLevelExp = nextLevelExp*2;
			strength++;
			attack = getAttack();
			defense = getDefense();
			
			gp.ui.addMessage("level " + level);
			
		}
		
	}
	public void selectItem() {
		
		int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol,gp.ui.playerSlotRow);
		
		if(itemIndex < inventory.size()) {
			
			Entity selectedItem = inventory.get(itemIndex);
			
			if(selectedItem.type == type_naturalnormal) {
				
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
				gp.ui.commandNum = 0;
				
			}
			if(selectedItem.type == type_torchgun) {
				
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
				gp.ui.commandNum = 1;
				
			}
			
			if(selectedItem.type == type_webshield) {
				
				currentShield = selectedItem;
				defense = getDefense();
				
			}
			if(selectedItem.type == type_sundialshield) {
				
				currentShield = selectedItem;
				defense = getDefense();
				
			}
			if(selectedItem.type == type_consumable) {
				
				if(selectedItem.use(this) == true) {
					inventory.remove(itemIndex);
				}

			}
			if(selectedItem.type == type_iTile) {
				
				
				
			}
			if(selectedItem.type == type_boots) {
				
				speed = 6;
				
			}
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;
		
		switch(direction) {
		case "up":
			if(attacking == false) {
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				break;
			}
			if(attacking == true) {
				tempScreenY = screenY - gp.tileSize;
				if(spriteNum == 1) {image = attackUp1;}
				if(spriteNum == 2) {image = attackUp2;}
				break;
			}
		case "down":
			if(attacking == false) {
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
				break;
			}
			if(attacking == true) {
				if(spriteNum == 1) {image = attackDown1;}
				if(spriteNum == 2) {image = attackDown2;}
				break;
			}
		case "left":
			if(attacking == false) {
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				break;
			}
			if(attacking == true) {
				tempScreenX = screenX - gp.tileSize;
				if(spriteNum == 1) {image = attackLeft1;}
				if(spriteNum == 2) {image = attackLeft2;}
				break;
			}
		case "right":
			if(attacking == false) {
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				break;
			}
			if(attacking == true) {
				if(spriteNum == 1) {image = attackRight1;}
				if(spriteNum == 2) {image = attackRight2;}
				break;
			}

		}
		
		if(invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		}
		
		g2.drawImage(image,  tempScreenX,  tempScreenY, null);
		
		//reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		
		
	}
}
