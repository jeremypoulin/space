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
import main.UtilityTool;

public class Entity {
	
	GamePanel gp;	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, stopDown, stopUp, stopLeft, stopRight;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
	public BufferedImage image, image2, image3;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
	String dialogues[] = new String[20];
	
	//STATE
	public int worldX, worldY;
	public String direction = "down";	
	public int spriteNum = 1;
	public boolean collisionOn = false;
	public boolean invincible = false;
	public boolean regenerative = false;
	int dialogueIndex = 0;
	boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpBarOn = false;
	public boolean onPath = false;
	public boolean knockback = false;
	public Entity loot;
	public boolean opened = false;
	
	//COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invincibleCounter = 0;
	public int shotAvailableCounter = 0;
	int dyingCounter = 0;
	int hpBarCounter = 0;
	int knockbackCounter = 0;
	
	//CHARACTER ATTRIBUTES
	public String name;
	public int defaultSpeed;
	public int speed;
	public int maxLife;
	public int life;
	public int maxEnergy;
	public int energy;
	public int level;
	public int strength;
	public int agility;
	public int attack;
	public int defense;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public Entity currentWeapon;
	public Entity currentShield;
	public Projectile projectile;
	
	//ITEM ATTRIBUTES
	public ArrayList<Entity> inventory = new ArrayList<>();
	public final int maxInventorySize = 20;
	public int value;
	public int attackValue;
	public int defenseValue;
	public String title = "";
	public String description = "";
	public int useCost;
	public int price;
	public int knockbackPower;
	
	//TYPE
	public int type; //0 = player, 1 = npc, 2 = monster
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_naturalnormal = 3;
	public final int type_torchgun = 4;
	public final int type_webshield = 5;
	public final int type_consumable = 6;
	public final int type_pickUpOnly = 7;
	public final int type_iTile = 8;
	public final int type_sundialshield = 9;
	public final int type_boots = 10;
	public final int type_obstacle = 11;
	
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	public int getLeftX() {
		return worldX + solidArea.x;
	}
	public int getRightX() {
		return worldX + solidArea.x + solidArea.width;
	}
	public int getTopY() {
		return worldY + solidArea.y;
	}
	public int getBottomY() {
		return worldY + solidArea.y + solidArea.height;
	}
	public int getCol() {
		return (worldX + solidArea.x)/gp.tileSize;
	}
	public int getRow() {
		return (worldY + solidArea.y)/gp.tileSize;
	}
	public void resetCounter() {
		
		spriteCounter = 0;
		actionLockCounter = 0;
		invincibleCounter = 0;
		shotAvailableCounter = 0;
		dyingCounter = 0;
		hpBarCounter = 0;
		knockbackCounter = 0;
		
	}
	public void setLoot(Entity loot) {}
	public void setAction() {}
	public void damageReaction() {}
	public void speak() {
		
		if(dialogues[dialogueIndex] == null) {
			
			dialogueIndex = 0;
			
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
		
	}
	public void interact() {}
	public boolean use(Entity entity) {return false;}
	public void checkDrop() {}
	public void dropItem(Entity droppedItem) {
		
		for(int i = 0; i < gp.obj[1].length; i++) {
			if(gp.obj[gp.currentMap][i] == null) {
				gp.obj[gp.currentMap][i] = droppedItem;
				gp.obj[gp.currentMap][i].worldX = worldX;
				gp.obj[gp.currentMap][i].worldY = worldY;
				break;
			}
		}
		
	}
	public Color getParticleColor() {
		Color color = null;
		return color;
	}
	public int getParticleSize() {
		
		int size = 0;
		return size;
		
	}
	public int getParticleSpeed() {
		
		int speed = 0;
		return speed;
		
	}
	public int getParticleMaxLife() {
		
		int maxLife = 0;
		return maxLife;
		
	}
	public void generateParticle(Entity generator, Entity target) {
		
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxLife = generator.getParticleMaxLife();
		
//		Particle p1 = new Particle(gp, target, color, size, speed, maxLife, -2, -1);
	//	Particle p2 = new Particle(gp, target, color, size, speed, maxLife, 2, -1);

//		gp.particleList.add(p1);
//		gp.particleList.add(p2);
//

		
	}
	public void checkCollision() {
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.monster);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		
		
		if(this.type == type_monster && contactPlayer == true) {
			if(gp.player.invincible == false) {
				
				damagePlayer(attack);
				
			}
		}
		
	}
	public void update() {
		
		if(knockback == true) {
			
			checkCollision();
			
			if(collisionOn == true) {
				knockbackCounter = 0;
				knockback = false;
				speed = defaultSpeed;
			}
			else if(collisionOn == false) {
				switch(gp.player.direction) {
				case "up": worldY -= speed;
				break;
				case "down": worldY += speed;
				break;
				case "left": worldX -=speed;
				break;
				case "right": worldX += speed;
				break;
				
				}
			}
			
			knockbackCounter++;
			if(knockbackCounter == 10) {
				knockbackCounter = 0;
				knockback = false;
				speed = defaultSpeed;
			}
			
		}
		else {
			
			setAction();
			
			checkCollision();
			
			//IF COLLISION IS FALSE, NPC CAN MOVE
			if(collisionOn == false) {
				
				switch(direction) {
				case "up": worldY -= speed;
					break;
				case "down": worldY += speed;
					break;
				case "left": worldX -=speed;
					break;
				case "right": worldX += speed;
					break;
				}
				
			}
			
		}
	
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
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
	}
	public void damagePlayer(int attack) {
		
		int damage = attack - gp.player.defense;
		if(damage < 0) {
			damage = 0;
		}
		
		gp.player.life -= damage;
		gp.player.invincible = true;
		gp.playSE(5);
		
		
	}
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY  + gp.player.screenY) {
			
			switch(direction) {
			case "up":
				if(spriteNum == 1) {image = up1;}
				if(spriteNum == 2) {image = up2;}
				break;
			case "down":
				if(spriteNum == 1) {image = down1;}
				if(spriteNum == 2) {image = down2;}
				break;
			case "left":
				if(spriteNum == 1) {image = left1;}
				if(spriteNum == 2) {image = left2;}
				break;
			case "right":
				if(spriteNum == 1) {image = right1;}
				if(spriteNum == 2) {image = right2;}
				break;
			}
			
			//monster HP bar
			if(type == 2 && hpBarOn == true) {
				
				double oneScale = (double)gp.tileSize/maxLife;
				double hpBarValue = oneScale*life;
				
				
				
//				g2.setColor(Color.black);
//				g2.fillRect(screenX + 3, screenY - 3, gp.tileSize - 6, 4);
				
				g2.setColor(new Color(255, 191, 0));
				g2.fillRect(screenX, screenY - 2, (int)hpBarValue, 2);
				
				hpBarCounter++;
				
				if(hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
			}
			if(type == 8 && hpBarOn == true) {
				
				double oneScale = (double)gp.tileSize/maxLife;
				double hpBarValue = oneScale*life;
				
				
				
//				g2.setColor(Color.black);
//				g2.fillRect(screenX + 3, screenY - 3, gp.tileSize - 6, 4);
				
				g2.setColor(new Color(239, 0, 53));
				g2.fillRect(screenX, screenY - 2, (int)hpBarValue, 2);
				
				hpBarCounter++;
				
				if(hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
			}
			
			if(invincible == true) {
				hpBarOn = true;
				hpBarCounter = 0;
				changeAlpha(g2,0.4F);
		}
		if(dying == true) {
			dyingAnimation(g2);
		}

		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
		changeAlpha(g2,1F);
		
		}
		
	}
	public void dyingAnimation(Graphics2D g2) {
		
		dyingCounter++;
		
		int i = 5;
		
		if(dyingCounter <= i) {changeAlpha(g2, 0f);}
		if(dyingCounter > i && dyingCounter <= i*2) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*2 && dyingCounter <= i*3) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*3 && dyingCounter <= i*4) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*4 && dyingCounter <= i*5) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*5 && dyingCounter <= i*6) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*6 &&dyingCounter <= i*7) {changeAlpha(g2, 0f);}
		if(dyingCounter > i*7 && dyingCounter <= i*8) {changeAlpha(g2, 1f);}
		if(dyingCounter > i*8) {
			alive = false;
		}
		
	}
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
		
	}
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool = new UtilityTool() ;
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image,  width,  height);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public void searchPath(int goalCol, int goalRow) {
		
		int startCol = (worldX + solidArea.x)/gp.tileSize;
		int startRow = (worldY + solidArea.y)/gp.tileSize;
		
		gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);
		
		if(gp.pFinder.search() == true) {
			
			//next worldX & worldY
			int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
			int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;
			
			//entity's solidArea position
			int enLeftX = worldX + solidArea.x;
			int enRightX = worldX + solidArea.x + solidArea.width;
			int enTopY = worldY + solidArea.y;
			int enBottomY = worldY + solidArea.y + solidArea.height;
			
			if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "up";
			}
			else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
				direction = "down";
			}
			else if(enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
				//left or right
				if(enLeftX > nextX) {
					direction = "left";
				}
				if(enLeftX < nextX) {
					direction = "right";
				}
			}
			else if(enTopY > nextY && enLeftX > nextX) {
				//up or left
				direction = "up";
				checkCollision();
				if(collisionOn == true) {
					direction = "left";
				}
			}
			else if(enTopY > nextY && enLeftX < nextX) {
				//up or right
				direction = "up";
				if(collisionOn == true) {
					direction = "right";
				}
			}
			else if(enTopY < nextY && enLeftX > nextX) {
				//down or left
				direction = "down";
				checkCollision();
				if(collisionOn == true) {
					direction = "left";
				}
			}
			else if(enTopY < nextY && enLeftX < nextX) {
				//down or right
				direction = "down";
				checkCollision();
				if(collisionOn == true) {
					direction = "right";
				}
			}
//			//if goal is reached, stop search
//			int nextCol = gp.pFinder.pathList.get(0).col;
//			int nextRow = gp.pFinder.pathList.get(0).row;
//			if(nextCol == goalCol && nextRow == goalRow) {
//				onPath = false;
//			}
		}
		
	}
	public int getDetected(Entity user, Entity target[][], String targetName) {
		
		int index = 999;
		
		//CHECK THE SURROUNDING OBJECT
		int nextWorldX = user.getLeftX();
		int nextWorldY = user.getTopY();
		
		switch(user.direction) {
		case "up": nextWorldY = user.getTopY()-user.speed; break;
		case "down": nextWorldY = user.getBottomY()+user.speed; break;
		case "left": nextWorldX = user.getLeftX()-user.speed; break;
		case "right": nextWorldX = user.getRightX()+user.speed; break;
		}
		int col = nextWorldX/gp.tileSize;
		int row = nextWorldY/gp.tileSize;
		
		for(int i = 0; i < target[1].length; i++) {
			if(target[gp.currentMap][i] != null) {
				if(target[gp.currentMap][i].getCol() == col && target[gp.currentMap][i].getRow() == row && target[gp.currentMap][i].name.equals(targetName)) {
					index = i;
					break;
				}
			}
		}
		return index;
		
	}
	

}
