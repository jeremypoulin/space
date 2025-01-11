package main;

import java.awt.Rectangle;

import entity.Entity;

public class EventHandler {

	GamePanel gp;
	EventRect eventRect[][][];
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	public EventHandler(GamePanel gp) {		
		this.gp = gp;
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if(row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
			
		}
		

		
	}
	
	public void checkEvent() {
		
		// Check if player is more than 1 tile from last event
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}
		
		if(canTouchEvent == true) {
			if(hit(0,4,4,"any") == true) {teleport(1,17,14,6);}
			else if(hit(1,17,14,"any") == true) {teleport(0,4,4,0);}
			else if(hit(0,75,75,"any") == true) {teleport(2,61,55,10);}
			else if(hit(2,61,55,"any") == true) {teleport(0,75,75,0);}
			else if(hit(0,4,75,"any") == true) {teleport(4,10,70,6);}
			else if(hit(4,10,70,"any") == true) {teleport(0,4,75,0);}
			else if(hit(0,75,4,"any") == true) {teleport(3,65,9,2);}
			else if(hit(3,65,9,"any") == true) {teleport(0,75,4,0);}
			else if(hit(0,39,57,"any") == true) {teleport(5,22,54,12);}
			else if(hit(5,22,54,"any") == true) {teleport(0,39,57,0);}
			else if(hit(5,46,30,"any") == true) {teleport(6,1,1,7);}
			else if(hit(6,1,1,"any") == true) {teleport(5,46,30,12);}
			
			else if(hit(2,57,48,"up") == true) {speak(gp.npc[1][0]);}
//			else if(hit(0,29,16,"right") == true) {teleport(27,16,gp.dialogueState);}
			else if(hit(1,23,28,"any") == true) {damagePit();}
			else if(hit(1,20,31,"any") == true) {damagePit();}
			else if(hit(1,18,22,"any") == true) {damagePit();}
			else if(hit(1,22,18,"any") == true) {damagePit();}
			else if(hit(1,29,15,"any") == true) {damagePit();}
			else if(hit(1,28,24,"any") == true) {damagePit();}
			else if(hit(1,34,31,"any") == true) {damagePit();}
//			else if(hit(0,23,12,"up") == true) {healingPool(27,14,gp.dialogueState);}
		}

		
	}
	public boolean hit(int map, int col, int row, String regDirection) {
		
		boolean hit = false;
		
		if(map == gp.currentMap) {
			
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
			
			if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
				if(gp.player.direction.contentEquals(regDirection) || regDirection.contentEquals("any")) {
					hit = true;
					
					previousEventX = gp.player.worldX;
					previousEventY = gp.player.worldY;
					
				}
			}
			
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
			
		}
		
		return hit;
	}
	public void teleport(int map, int col, int row, int bruh) {
		
		gp.music.stop();
		gp.gameState = gp.transitionState;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		
		canTouchEvent = false;
		gp.playSE(9);
		gp.playMusic(bruh);
		
	}
	public void damagePit() {
		
		gp.playSE(5);
		gp.player.life -= 1;
		gp.player.invincible = true;
//		eventRect[col][row].eventDone = true;
		canTouchEvent = false;
		
	}
	public void healingPool(int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.player.attackCanceled = true;
			gp.gameState = gameState;
			gp.ui.currentDialogue = "slurp.";
			gp.player.life = gp.player.maxLife;
		}
		
	}
	public void speak(Entity entity) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gp.dialogueState;
			gp.player.attackCanceled = true;
			entity.speak();
		}
		
	}
	
}
