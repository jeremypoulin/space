package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import entity.Entity;
import object.OBJ_EnergyCrystal;
import object.OBJ_Heart;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font dotGothic_40, dotGothic_80;
	BufferedImage fullheart, halfheart, emptyheart, fullcrystal, emptycrystal, energy;
	public boolean messageOn = false;
//	public String message = "";
//	int messageCounter = 0;
	ArrayList<String> message = new ArrayList<>();
	ArrayList<Integer> messageCounter = new ArrayList<>();
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int titleScreenState = 0;
	public int playerSlotCol = 0;
	public int playerSlotRow = 0;
	public int npcSlotCol = 0;
	public int npcSlotRow = 0;
	int subState = 0;
	int counter = 0;
	public Entity npc;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/DotGothic16-Regular.ttf");
			dotGothic_40 = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();		
		}
		
		//CREATE HUD OBJECT
		Entity heart = new OBJ_Heart(gp);
		fullheart = heart.image;
		halfheart = heart.image2;
		emptyheart = heart.image3;
		Entity crystal = new OBJ_EnergyCrystal(gp);
		fullcrystal = crystal.image;
		emptycrystal = crystal.image2;
		Entity energyCrystal = new OBJ_EnergyCrystal(gp);
		energy = energyCrystal.down1;
		
	}
	
	public void addMessage(String text) {
		
		message.add(text);
		messageCounter.add(0);
		
	}
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(dotGothic_40);
		g2.setColor(Color.white);
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
			drawMessage();
		}
		
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
		}
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		//DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}
		//CHARACTER STATE
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory(gp.player,true);
		}
		//OPTIONS STATE
		if(gp.gameState == gp.optionsState) {
			drawOptionsScreen();
		}
		//GAME OVER STATE
		if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen();
		}
		// TRANSITION STATE
		if(gp.gameState == gp.transitionState) {
			drawTransition();
		}
		// TRADE STATE
		if(gp.gameState == gp.tradeState) {
			drawTradeScreen();
		}
	}
	public void drawPlayerLife() {
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		//MAX LIFE
		while(i < gp.player.maxLife/2) {
			g2.drawImage(emptyheart,  x,  y,  null);
			i++;
			x += gp.tileSize;
		}
		
		//RESET
		x = gp.tileSize/2;
		y = gp.tileSize/2;
		i = 0;
		
		//CURRENT LIFE
		while(i < gp.player.life) {
			g2.drawImage(halfheart, x, y, null);
			i++;
			if(i < gp.player.life) {
				g2.drawImage(fullheart,  x,  y, null);
			}
			i++;
			x += gp.tileSize;
		}
		
		//DRAW MAX ENERGY
		x = gp.tileSize/2 - 8;
		y = gp.tileSize*2 - 16;
		i = 0;
		while(i < gp.player.maxEnergy) {
			
			g2.drawImage(emptycrystal,  x,  y,  null);
			i++;
			x += 35;
			
		}
		
		//DRAW ENERGY
		x = gp.tileSize/2 - 8;
		y = gp.tileSize*2 - 16;
		i = 0;
		while(i < gp.player.energy) {
			g2.drawImage(fullcrystal,  x,  y,  null);
			i++;
			x +=35;
		}
		
	}
	public void drawMessage() {
		
		int messageX = gp.tileSize;
		int messageY = gp.tileSize*4;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
		
		for(int i = 0; i < message.size(); i++) {
			
			if(message.get(i) != null) {
				
				g2.setColor(Color.white);
				g2.drawString(message.get(i), messageX, messageY);
				
				int counter = messageCounter.get(i) + 1;
				messageCounter.set(i, counter);
				messageY += 50;
				
				if(messageCounter.get(i) > 180) {
					
					message.remove(i);
					messageCounter.remove(i);
					
				}
				
			}
			
		}
		
	}
	public void drawTitleScreen() {
		
		if(titleScreenState == 0) {
			
			g2.setColor(new Color(0, 0, 0));
			g2.fillRect(0,  0,  gp.screenWidth,  gp.screenHeight);
			g2.setColor(new Color(255, 191, 0));
			g2.fillArc(-125, -125, 250, 250, 90, 360);
			
			g2.setColor(Color.black);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC,24F));
			String sign = "for you,";
			String signlow = "from me.";
			g2.drawString(sign, 5, 32);
			g2.drawString(signlow, 5, 62);
			
			//TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
			String text = "space.";
			int x = getXforCenteredText(text);
			int y = 115;
			
			//SHADOW
			g2.setColor(Color.gray);
			g2.drawString(text, x+5, y+5);
			
			//MAIN COLOR
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//MENU
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
			
			text = "new web.";
			x = getXforCenteredText(text);
			y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.setColor(new Color(255, 191, 0));
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			g2.setColor(Color.white);
			text = "load web.";
			x = getXforCenteredText(text);
			y += 52;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.setColor(new Color(255, 191, 0));
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			g2.setColor(Color.white);
			text = "escape.";
			x = getXforCenteredText(text);
			y += 52;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.setColor(new Color(255, 191, 0));
				g2.drawString(">", x-gp.tileSize, y);
			}	
			
			//EGG
			
			if(commandNum == 3) {
			g2.setColor(Color.black);
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			g2.setColor(new Color(255, 191, 0));
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC,36F));
			text = "space.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 160);
			text = "vast, infinite, empty";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 200);
			text = "that which surrounds everything that you know, lost.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 240);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD | Font.ROMAN_BASELINE,36F));
			text = "in measureless oceans of space.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 280);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC,36F));
			text = "reach out, and seek to connect.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 320);
			g2.setFont(g2.getFont().deriveFont(Font.BOLD | Font.ROMAN_BASELINE,36F));
			text = "til the bridge you need be form'd.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 360);
			g2.setFont(g2.getFont().deriveFont(Font.ITALIC,36F));
			text = "for you are the glue that holds your world together.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 400);
			text = "you spin your own web.";
			x = getXforCenteredText(text);
			g2.drawString(text, x, 440);
			
			}
			
		}
		else if(titleScreenState == 1) {
			
			g2.setColor(Color.black);
			g2.fillRect(0,  0,  gp.screenWidth, gp.screenHeight);
			
			g2.setColor(new Color(255, 191, 0));
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,128F));
			String text = "for calli.";
			int x = getXforCenteredText(text);
			int y = gp.screenHeight/2+32;
			g2.drawString(text, x, y);
			
		}
		
	}
	
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);	
		int y = gp.screenHeight/2;
		
		g2.drawString(text,  x,  y);
		
	}
	public void drawDialogueScreen() {
		
		//WINDOW
		int x = gp.tileSize * 2;
		int y = gp.tileSize/2;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*3;
		drawSubWindow(x, y, width, height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,24F));
		x += gp.tileSize;
		y += gp.tileSize+10;
		
		
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 32;
		}
		
	}
	public void drawCharacterScreen() {
		
		// CREATE A FRAME
		final int frameX = gp.tileSize;
		final int frameY = gp.tileSize/2;
		final int frameWidth = gp.tileSize*6;
		final int frameHeight = gp.tileSize*10+34;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//TEXT
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 40;
		
		//NAMES
		g2.drawString("level:", textX, textY);textY += lineHeight;
		g2.drawString("life:", textX, textY);textY += lineHeight;
		g2.drawString("energy:", textX, textY);textY += lineHeight;
		g2.drawString("strength:", textX, textY);textY += lineHeight;
		g2.drawString("agility:", textX, textY);textY += lineHeight;
		g2.drawString("attack:", textX, textY);textY += lineHeight;
		g2.drawString("defense:", textX, textY);textY += lineHeight;
		g2.drawString("exp:", textX, textY);textY += lineHeight;
		g2.drawString("next level:", textX, textY);textY += lineHeight;
		g2.drawString("coin:", textX, textY);textY += lineHeight;
		g2.drawString("weapon:", textX, textY);textY += lineHeight;
		g2.drawString("shield:", textX, textY);textY += lineHeight;
		
		//VALUES
		int tailX = (frameX + frameWidth) - 30;
		//Reset textY
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.energy + "/" + gp.player.maxEnergy);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.strength);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.agility);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.attack);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.defense);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.exp);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.coin);
		textX = getXforAlignToRightText(value,tailX);
		g2.drawString(value, textX, textY);
		textY += 48;
		
		g2.drawImage(gp.player.currentWeapon.down1, tailX - 24, textY - 32, null);
		textY += 40;
		g2.drawImage(gp.player.currentShield.down1, tailX - 24, textY - 32, null);
		
	}
	public void drawInventory(Entity entity, boolean cursor) {
		
		int frameX = 0;
		int frameY = 0;
		int frameWidth = 0;
		int frameHeight = 0;
		int slotCol = 0;
		int slotRow = 0;
		
		if(entity == gp.player) {
			frameX = gp.tileSize*14;
			frameY = gp.tileSize/2;
			frameWidth = gp.tileSize*6;
			frameHeight = gp.tileSize*5;
			slotCol = playerSlotCol;
			slotRow = playerSlotRow;
		}
		else {
			frameX = gp.tileSize;
			frameY = gp.tileSize/2;
			frameWidth = gp.tileSize*6;
			frameHeight = gp.tileSize*5;
			slotCol = npcSlotCol;
			slotRow = npcSlotRow;
		}
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//SLOT
		final int slotXstart = frameX + 25;
		final int slotYstart = frameY + 25;
		int slotX = slotXstart;
		int slotY = slotYstart;
		
		//DRAW PLAYER'S ITEMS
		for(int i = 0; i < entity.inventory.size(); i++) {
			
			//EQUIP CURSOR
			if(entity.inventory.get(i) == entity.currentWeapon ||
					entity.inventory.get(i) == entity.currentShield) {
				g2.setColor(new Color(45, 45, 45));
				g2.fillRoundRect(slotX,  slotY,  gp.tileSize, gp.tileSize, 10, 10);
			}
			
			g2.drawImage(entity.inventory.get(i).down1, slotX + 8, slotY + 8, null);
			
			slotX += gp.tileSize;
			
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY += gp.tileSize;
			}
			
		}
		
		//CURSOR
		if(cursor == true) {
			
			int cursorX = slotXstart + (gp.tileSize * slotCol);
			int cursorY = slotYstart + (gp.tileSize * slotRow);
			int cursorWidth = gp.tileSize;
			int cursorHeight = gp.tileSize;
			
			g2.setColor(new Color(255, 191, 0));
			g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
			
			int dFrameX = frameX;
			int dFrameY = frameY + frameHeight;
			int dFrameWidth = frameWidth;
			int dFrameHeight = gp.tileSize * 3;
			
			int titleTextX = dFrameX + 25;
			int titleTextY = dFrameY + gp.tileSize;
			g2.setColor(new Color(255, 191, 0));
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
			
			int itemIndex = getItemIndexOnSlot(slotCol,slotRow);
			
			if(itemIndex < entity.inventory.size()) {
				
				drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
				
				for(String line: entity.inventory.get(itemIndex).title.split("\n")) {
					
					g2.drawString(line, titleTextX, titleTextY);
					titleTextY += 32;
					
				}
				
			}
			
			int descTextX = dFrameX + 25;
			int descTextY = dFrameY + (gp.tileSize + 32);
			g2.setFont(g2.getFont().deriveFont(28F));
			g2.setColor(Color.white);
			
			if(itemIndex < entity.inventory.size()) {
				
				for(String line: entity.inventory.get(itemIndex).description.split("\n")) {
					
					g2.drawString(line, descTextX, descTextY);
					descTextY += 32;
					
				}
				
			}
		}
		
	}
	public void drawGameOverScreen() {
		
		g2.setColor(new Color(0,0,0,125));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		
		text = "fail.";
		g2.setColor(new Color(255, 191, 0, 50));
		x = getXforCenteredText(text);
		y = gp.tileSize*4;
		g2.drawString(text,  x,  y);
		//Main
		g2.setColor(new Color(255, 191, 0));
		g2.drawString(text, x-4, y-4);
		
		//retry
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "retry.";
		x = getXforCenteredText(text);
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", x-40, y);
		}
		
		//end
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "end.";
		x = getXforCenteredText(text);
		y += 65;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", x-40, y);
		}
		
	}
	public void drawOptionsScreen() {
		
		g2.setColor(Color.white);;
		g2.setFont(g2.getFont().deriveFont(32F));
		
		//SUB WINDOW
		int frameX = gp.tileSize*6;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize*9;
		int frameHeight = 320;
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		switch(subState) {
		case 0: options_top(frameX, frameY); break;
		case 1: endGameConfirmation(frameX, frameY); break;
		case 2: options_controls(frameX, frameY); break;
		}
		
		gp.keyH.enterPressed = false;
		
	}
	public void options_top(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "options.";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		//MUSIC
		textX = frameX + gp.tileSize;
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("music.", textX, textY);
		if(commandNum == 0) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
		}
		
		//SE
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("sound fx.", textX, textY);
		if(commandNum == 1) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
		}
		
		//CONTROLS
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("controls.", textX, textY);
		if(commandNum == 2) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 2;
				commandNum = 0;
			}
		}
		
		//END GAME
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("end.", textX, textY);
		if(commandNum == 3) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 1;
				commandNum = 0;
			}
		}
		
		//BACK
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("back.", textX, textY);
		if(commandNum == 4) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				commandNum = 0;
				gp.gameState = gp.playState;
			}
		}
		
		//MUSIC VOLUME
		textX = frameX + gp.tileSize*4+20;
		textY = frameY + 84;
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(textX, textY, 180, 4);
		int volumeWidth = 36 * gp.music.volumeScale;
		g2.setColor(new Color(255, 191, 0));
		g2.fillRect(textX, textY+1, volumeWidth, 2);
		
		//SE VOLUME
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(textX, textY, 180, 4);
		volumeWidth = 36 * gp.se.volumeScale;
		g2.setColor(new Color(255, 191, 0));
		g2.fillRect(textX, textY+1, volumeWidth, 2);
		
		gp.config.saveConfig();
		
	}
	public void options_controls(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "controls.";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		textX = frameX + gp.tileSize;
		textY += gp.tileSize;
		g2.drawString("move.", textX, textY); textY += gp.tileSize;
		g2.drawString("confirm/attack.", textX, textY); textY += gp.tileSize;
		g2.drawString("shoot.", textX, textY); textY += gp.tileSize;
		g2.drawString("inventory/status.", textX, textY); textY += gp.tileSize;
		
		g2.setColor(new Color(255, 191, 0));
		textX = frameX + gp.tileSize*7;
		textY = frameY + gp.tileSize*2;
		g2.drawString("wasd.", textX, textY); textY += gp.tileSize;
		g2.drawString("enter.", textX, textY); textY += gp.tileSize;
		g2.drawString("f.", textX, textY); textY += gp.tileSize;
		g2.drawString("e.", textX, textY); textY += gp.tileSize;
		
		//BACK
		g2.setColor(Color.white);
		textX = frameX + gp.tileSize;
		textY = gp.tileSize*7;
		g2.drawString("back.", textX, textY);
		if(commandNum == 0) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 2;
			}
		}
		
	}
	public void endGameConfirmation(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "the end?";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		//NO
		textX = frameX + gp.tileSize;
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("no.", textX, textY);
		if(commandNum == 0) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 3;
			}
		}
		
		//YES
		textY += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("yes.", textX, textY);
		if(commandNum == 1) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				gp.music.stop();
				subState = 0;
				gp.gameState = gp.titleState;
				commandNum = 0;
				gp.resetGame();
			}
			
		}
		
	/*	int textX = frameX + gp.tileSize;
		int textY = frameY + gp.tileSize;
		
		currentDialogue = "the end?";
		
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
			
		//YES
		String text = "yes.";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize*2;
		g2.drawString(text, textX, textY);
		if(commandNum == 0) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				gp.gameState = gp.titleState;
			}
		}
		
		//NO
		text = "no.";
		textX = getXforCenteredText(text);
		textY += gp.tileSize;
		g2.drawString(text, textX, textY);
		if(commandNum == 1) {
			g2.setColor(new Color(255, 191, 0));
			g2.drawString(">", textX-25, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 3;
			}
		}*/
		
	}
	public void drawTransition() {
		
		counter++;
		g2.setColor(new Color(0,0,0,counter*5));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		if(counter == 50) {
			counter = 0;
			gp.gameState = gp.playState;
			gp.currentMap = gp.eHandler.tempMap;
			gp.player.worldX = gp.tileSize * gp.eHandler.tempCol;
			gp.player.worldY = gp.tileSize * gp.eHandler.tempRow;
			gp.eHandler.previousEventX = gp.player.worldX;
			gp.eHandler.previousEventY = gp.player.worldY;
			
		}
		
	}
	public void drawTradeScreen() {
		
		switch(subState) {
		case 0: trade_select(); break;
		case 1: trade_buy(); break;
		case 2: trade_sell(); break;
		}
		gp.keyH.enterPressed = false;
		
	}
	public void trade_select() {
		
		drawDialogueScreen();
		
		//DRAW WIDNOW
		int x = gp.tileSize * 16;
		int y = gp.tileSize/4;
		int width = gp.tileSize * 3;
		int height = (int)(gp.tileSize * 3.5);
		drawSubWindow(x,y,width,height);
		
		//DRAW TEXTS
		x += gp.tileSize;
		y += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("buy.", x, y);
		if(commandNum == 0) {
			g2.setColor(new Color(255,191,0));
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				subState = 1;
			}
		}
		y += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("sell.", x, y);
		if(commandNum == 1) {
			g2.setColor(new Color(255,191,0));
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				subState = 2;
			}
		}
		y += gp.tileSize;
		g2.setColor(Color.white);
		g2.drawString("exit.", x, y);
		if(commandNum == 2) {
			g2.setColor(new Color(255,191,0));
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				commandNum = 0;
				gp.gameState = gp.dialogueState;
				currentDialogue = "beat it.";
			}
		}
		y += gp.tileSize;
		
	}
	public void trade_buy() {
		
		//DRAW PLAYER INVENTORY
		drawInventory(gp.player, false);
		//DRAW NPC INVENTORY
		drawInventory(npc, true);
		
		//DRAW HINT WINDOW
		int x = gp.tileSize;
		int y = gp.tileSize*9;
		int width = gp.tileSize*6;
		int height = gp.tileSize*2;
		drawSubWindow(x,y,width,height);
		g2.drawString("[esc] exit.", x+24, y+60);
		
		//DRAW PLAYER ENERGY WINDOW
		x = gp.tileSize*25;
		y = gp.tileSize*9;
		width = gp.tileSize*6;
		height = gp.tileSize*2;
		drawSubWindow(x,y,width,height);
		g2.drawString("energy: " + gp.player.energy + ".", x+24, y+60);
		
		//DRAW PRICE WINDOW
		int itemIndex = getItemIndexOnSlot(npcSlotCol,npcSlotRow);
		if(itemIndex < npc.inventory.size()) {
			
			x = (int)(gp.tileSize*4.5);
			y = (int)(gp.tileSize*5);
			width = (int)(gp.tileSize*2.5);
			height = gp.tileSize;
			drawSubWindow(x,y,width,height);
			g2.drawImage(energy, x+10, y+8, 32, 32, null);
			
			int price = npc.inventory.get(itemIndex).price;
			String text = "" + price;
			x = getXforAlignToRightText(text, gp.tileSize*8);
			g2.drawString(text,  x-16,  y+34);
			
			//BUY AN ITEM
			if(gp.keyH.enterPressed == true) {
				if(npc.inventory.get(itemIndex).price > gp.player.energy) {
					subState = 0;
					gp.gameState = gp.dialogueState;
					currentDialogue = "nice try fool.";
					drawDialogueScreen();
				}
				else if(gp.player.inventory.size() == gp.player.maxInventorySize) {
					subState = 0;
					gp.gameState = gp.dialogueState;
					currentDialogue = "you got too much stuff fool.";
				}
				else {
					gp.player.energy -= npc.inventory.get(itemIndex).price;
					gp.player.inventory.add(npc.inventory.get(itemIndex));
				}
			}
			
		}
		
	}
	public void trade_sell() {
		
		//DRAW PLAYER INVENTORY
		drawInventory(gp.player, true);
		
		int x;
		int y;
		int width;
		int height;
		
		//DRAW HINT WINDOW
			x = gp.tileSize;
			y = gp.tileSize*9;
			width = gp.tileSize*6;
			height = gp.tileSize*2;
			drawSubWindow(x,y,width,height);
			g2.drawString("[esc] exit.", x+24, y+60);
			
			//DRAW PLAYER ENERGY WINDOW
			x = gp.tileSize*25;
			y = gp.tileSize*9;
			width = gp.tileSize*6;
			height = gp.tileSize*2;
			drawSubWindow(x,y,width,height);
			g2.drawString("energy: " + gp.player.energy + ".", x+24, y+60);
			
			//DRAW PRICE WINDOW
			int itemIndex = getItemIndexOnSlot(playerSlotCol,playerSlotRow);
			if(itemIndex < gp.player.inventory.size()) {
				
				x = (int)(gp.tileSize*28.5);
				y = (int)(gp.tileSize*5.5);
				width = (int)(gp.tileSize*2.5);
				height = gp.tileSize;
				drawSubWindow(x,y,width,height);
				g2.drawImage(energy, x+10, y+8, 32, 32, null);
				
				int price = gp.player.inventory.get(itemIndex).price/2;
				String text = "" + price;
				x = getXforAlignToRightText(text, gp.tileSize*31);
				g2.drawString(text,  x-16,  y+34);
				
				//SELL AN ITEM
				if(gp.keyH.enterPressed == true) {
					
					if(gp.player.inventory.get(itemIndex) == gp.player.currentWeapon || gp.player.inventory.get(itemIndex) == gp.player.currentShield) {
						commandNum = 0;
						subState = 0;
						gp.gameState = gp.dialogueState;
						currentDialogue = "you can't sell an equipped item.";
					}
					else {
						gp.player.inventory.remove(itemIndex);
						gp.player.energy += price;
					}
					
				}
				
			}
		
	}
	public int getItemIndexOnSlot(int slotCol, int slotRow) {
		int itemIndex = slotCol + (slotRow*5);
		return itemIndex;
	}
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0, 0, 0, 180);
		g2.setColor(c);
		g2.fillRoundRect(x,  y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
	}
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text,  g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
		
	}
	public int getXforAlignToRightText(String text, int tailX) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text,  g2).getWidth();
		int x = tailX - length;
		return x;
		
	}
	
}
