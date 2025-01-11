package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed, shiftPressed;
	//DEBUG
	boolean showDebugText = false;
	
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			titleState(code);
		}
		
		//PLAY STATE
		else if(gp.gameState == gp.playState) {
			playState(code);
		}
		
		//PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			pauseState(code);
		}
		
		//DIALOGUE STATE
		else if(gp.gameState == gp.dialogueState) {
			dialogueState(code);
		}
		
		//CHARACTER STATE
		else if(gp.gameState == gp.characterState) {
			characterState(code);
		}
		
		//OPTIONS STATE
		else if(gp.gameState == gp.optionsState) {
			optionsState(code);
		}
		//GAME OVER STATE
		else if(gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
		//TRADE STATE
		else if(gp.gameState == gp.tradeState) {
			tradeState(code);
		}
	}
	
	public void titleState(int code) {
		
		if(gp.ui.titleScreenState == 0) {
			
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				gp.playSE(4);
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				gp.playSE(4);
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_SPACE) {
				gp.playSE(11);
				if(gp.ui.commandNum == 0) {
					gp.ui.titleScreenState = 1;
				}
				if(gp.ui.commandNum == 1) {
					gp.saveLoad.load();	
					gp.gameState = gp.playState;
					gp.ui.titleScreenState = 0;
					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
			if(code == KeyEvent.VK_8) {
				gp.ui.commandNum = 3;
				gp.playSE(4);

			}
			
		}
		else if(gp.ui.titleScreenState == 1) {
			
			if(code == KeyEvent.VK_SPACE) {
				gp.stopMusic();
				gp.gameState = gp.playState;
				gp.ui.titleScreenState = 0;
				gp.playMusic(0);
			}
			
		}
		
	}
	public void playState(int code) {
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			gp.playSE(4);
			gp.gameState = gp.pauseState;
		}
		if(code == KeyEvent.VK_E) {
			gp.playSE(4);
			gp.gameState = gp.characterState;
		}
		if(code == KeyEvent.VK_SPACE) {
			enterPressed = true;
			if(gp.ui.commandNum == 0 && gp.player.turnOffSound == false) {
				gp.playSE(1);
			}
			else if(gp.ui.commandNum == 1) {
				gp.playSE(13);
			}

		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = true;
			gp.playSE(8);
		}
		if(code == KeyEvent.VK_ESCAPE) {
			gp.playSE(4);
			gp.gameState = gp.optionsState;
		}
		
		//DEBUG
		if(code == KeyEvent.VK_T) {
			if(showDebugText == false) {
				showDebugText = true;
			}
			else if(showDebugText == true) {
				showDebugText = false;
			}
		}
		if(code == KeyEvent.VK_R) {
			gp.playSE(9);
			switch(gp.currentMap) {
			case 0:	gp.tileM.loadMap("/maps/world2.txt", 0); break;
			case 1: gp.tileM.loadMap("/maps/world2.txt", 1); break;
			}
			
		}
		
	}
	public void pauseState(int code) {
		
		if(code == KeyEvent.VK_P) {
			gp.playSE(4);
			gp.gameState = gp.playState;
		}
		
	}
	public void dialogueState(int code) {
		
		if(code == KeyEvent.VK_SPACE) {		
			gp.playSE(4);
			gp.gameState = gp.playState;				
		}
		
	}
	public void characterState(int code) {
		
		if(code == KeyEvent.VK_E) {
			gp.playSE(4);
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_SPACE ) {
			gp.playSE(11);
			gp.player.selectItem();
		}
		playerInventory(code);
		
	}
	public void optionsState(int code) {
		
		if(code == KeyEvent.VK_ESCAPE) {
			gp.playSE(4);
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_SPACE) {
			gp.playSE(11);
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0: maxCommandNum = 4; break;
		case 1: maxCommandNum = 1; break;
		}
		
		if(code == KeyEvent.VK_W) {
			gp.playSE(4);
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.playSE(4);
			gp.ui.commandNum++;
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 0 && gp.music.volumeScale > 0) {
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(11);
				}
				if(gp.ui.commandNum == 1 && gp.se.volumeScale > 0) {
					gp.se.volumeScale--;
					gp.playSE(11);
				}
			}
		}
		if(code == KeyEvent.VK_D) {
			
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 0 && gp.music.volumeScale < 5) {
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(11);
				}
			}
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.se.volumeScale < 5) {
					gp.se.volumeScale++;
					gp.playSE(11);
				}
			}
			
		}
		
	}
	public void gameOverState(int code) {
		
		if(code == KeyEvent.VK_W) {
			gp.playSE(4);
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.playSE(4);
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_SPACE) {
			gp.playSE(11);
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.resetGame();
			}
			else if(gp.ui.commandNum == 1) {
				gp.stopMusic();
				gp.gameState = gp.titleState;
				gp.ui.commandNum = 0;
				gp.resetGame();
			}
		}
		
	}
	public void tradeState(int code) {
		
		if(code == KeyEvent.VK_SPACE) {
			gp.playSE(11);
			enterPressed = true;
		}
		
		if(gp.ui.subState == 0) {
			if(code == KeyEvent.VK_W) {
				gp.playSE(4);
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.playSE(4);
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
		}
		if(gp.ui.subState == 1) {
			npcInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.subState = 0;
			}
		}
		if(gp.ui.subState == 2) {
			playerInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.subState = 0;
			}
		}
		
	}
	public void playerInventory(int code) {
		
		if(code == KeyEvent.VK_W) {
			gp.playSE(4);
			if(gp.ui.playerSlotRow != 0) {	
				gp.ui.playerSlotRow--;
			}
		}
		if(code == KeyEvent.VK_A) {
			gp.playSE(4);
			if(gp.ui.playerSlotCol != 0) {
				gp.ui.playerSlotCol--;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.playSE(4);
			if(gp.ui.playerSlotRow != 3) {
				gp.ui.playerSlotRow++;
			}
		}
		if(code == KeyEvent.VK_D) {
			gp.playSE(4);
			if(gp.ui.playerSlotCol != 4) {
				gp.ui.playerSlotCol++;
			}
		}
		
	}
	public void npcInventory(int code) {
		
		if(code == KeyEvent.VK_W) {
			gp.playSE(4);
			if(gp.ui.npcSlotRow != 0) {	
				gp.ui.npcSlotRow--;
			}
		}
		if(code == KeyEvent.VK_A) {
			gp.playSE(4);
			if(gp.ui.npcSlotCol != 0) {
				gp.ui.npcSlotCol--;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.playSE(4);
			if(gp.ui.npcSlotRow != 3) {
				gp.ui.npcSlotRow++;
			}
		}
		if(code == KeyEvent.VK_D) {
			gp.playSE(4);
			if(gp.ui.npcSlotCol != 4) {
				gp.ui.npcSlotCol++;
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = false;
		}
		
	}

}
