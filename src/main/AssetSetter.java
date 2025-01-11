package main;

import entity.NPC_Ivy;
import entity.NPC_Keaton;
import entity.NPC_Mochi;
import entity.NPC_Mom;
import entity.NPC_Myah;
import entity.NPC_Phin;
import entity.NPC_Three;
import entity.NPC_Whitey;
import entity.Entity;
import entity.NPC_April;
import entity.NPC_Atticus;
import entity.NPC_Bailey;
import entity.NPC_Braden;
import entity.NPC_Dad;
import entity.NPC_Duncan;
import entity.NPC_Isa;
import monster.MON_Clompa;
import monster.MON_Spider;
import object.OBJ_EnergyCrystal;
import object.OBJ_BlueBox;
import object.OBJ_BlueGate;
import object.OBJ_BlueKey;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_GoldKey;
import object.OBJ_GoldenApple;
import object.OBJ_GreenBox;
import object.OBJ_GreenGate;
import object.OBJ_GreenKey;
import object.OBJ_Heart;
import object.OBJ_RedBox;
import object.OBJ_RedGate;
import object.OBJ_RedKey;
import object.OBJ_TorchGun;
import object.OBJ_XmasBoots;
import tile_interactive.IT_GoldenTree;
import tile_interactive.IT_Web;
import tile_interactive.IT_WitheredTree;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		int mapNum = 0;
		
		int i = 0;
		gp.obj[mapNum][i] = new OBJ_Door(gp);
		gp.obj[mapNum][i].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_RedGate(gp);
		gp.obj[mapNum][i].worldX = 30 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 5 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_RedGate(gp);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_BlueGate(gp);
		gp.obj[mapNum][i].worldX = 76 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenGate(gp);
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenGate(gp);
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 34 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 4 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 35 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GreenKey(gp));
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 55 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 5 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 28 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_RedBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_RedKey(gp));
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_RedBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_RedKey(gp));
		gp.obj[mapNum][i].worldX = 70 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldKey(gp));
		gp.obj[mapNum][i].worldX = 31 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 3 * gp.tileSize;
		i++;
		
		mapNum = 1;
		gp.obj[mapNum][i] = new OBJ_GreenBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GreenKey(gp));
		gp.obj[mapNum][i].worldX = 36 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		
		mapNum = 3;
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldKey(gp));
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
		i++;
		
		mapNum = 4;
		gp.obj[mapNum][i] = new OBJ_BlueBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_BlueKey(gp));
		gp.obj[mapNum][i].worldX = 33 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 65 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_BlueBox(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_GoldenApple(gp));
		gp.obj[mapNum][i].worldX = 33 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		
	}
	public void setNPC() {
		int mapNum = 0;
		int i = 0;
		
		mapNum = 1;
		gp.npc[mapNum][i] = new NPC_Phin(gp);
		gp.npc[mapNum][i].worldX = 34 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		mapNum = 2;
		gp.npc[mapNum][i] = new NPC_Mochi(gp);
		gp.npc[mapNum][i].worldX = 54 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Keaton(gp);
		gp.npc[mapNum][i].worldX = 57 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		mapNum = 3;
		gp.npc[mapNum][i] = new NPC_Atticus(gp);
		gp.npc[mapNum][i].worldX = 64 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 15 * gp.tileSize;
		i++;
		
		mapNum = 4;
		gp.npc[mapNum][i] = new NPC_Ivy(gp);
		gp.npc[mapNum][i].worldX = 13 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 62 * gp.tileSize;
		i++;
		
		mapNum = 6;
		gp.npc[mapNum][i] = new NPC_April(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 1 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Atticus(gp);
		gp.npc[mapNum][i].worldX = 21 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Bailey(gp);
		gp.npc[mapNum][i].worldX = 62 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Braden(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 4 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Dad(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 5 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Duncan(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 6 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Isa(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 7 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Ivy(gp);
		gp.npc[mapNum][i].worldX = 21 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Mochi(gp);
		gp.npc[mapNum][i].worldX = 69 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 21 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Mom(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Myah(gp);
		gp.npc[mapNum][i].worldX = 37 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Phin(gp);
		gp.npc[mapNum][i].worldX = 69 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 20 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Three(gp);
		gp.npc[mapNum][i].worldX = 62 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		gp.npc[mapNum][i] = new NPC_Whitey(gp);
		gp.npc[mapNum][i].worldX = 21 * gp.tileSize;
		gp.npc[mapNum][i].worldY = 55 * gp.tileSize;
		i++;
		
	}
	public void setMonster() {
		int mapNum = 0;
		int i = 0;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 54 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 45 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 66 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 76 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 76 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 20 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 11 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 12 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 13 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 26 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 4 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 41 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 70 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 35 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 72 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 22 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 26 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 3 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 7 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 13 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 71 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 15 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 28 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 62 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 13 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 76 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 33 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 32 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 48 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 32 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 43 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 48 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 20 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 52 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 14 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 51 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 3 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 41 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 14 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 41 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 15 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 25 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 37 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 25 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 33 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 26 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 33 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 33 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 28 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 40 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 38 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 18 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 58 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 74 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 62 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 30 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 65 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		
		mapNum = 1;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 31 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 18 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 31 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 32 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 33 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 34 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 35 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		
		mapNum = 3;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 9 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 11 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 57 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 13 * gp.tileSize;
		i++;
		
		mapNum = 4;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 26 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 65 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Spider(gp);
		gp.monster[mapNum][i].worldX = 27 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 65 * gp.tileSize;
		i++;
		
		mapNum = 5;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 30 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 31 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 32 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 34 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 35 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 36 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 38 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 39 * gp.tileSize;
		i++;
		gp.monster[mapNum][i] = new MON_Clompa(gp);
		gp.monster[mapNum][i].worldX = 36 * gp.tileSize;
		gp.monster[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		
	}
	public void setInteractiveTile() {
		int mapNum = 0;
		int i = 0; 
		gp.iTile[mapNum][i] = new IT_Web(gp, 18, 53);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 18, 52);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 18, 51);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 18, 45);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 18, 46);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 17, 48);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 17, 52);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 14, 55);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 55);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 56);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 57);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 10, 63);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 10, 66);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 10, 72);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 22, 51);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 22, 60);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 16, 65);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 23, 64);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 66);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 67);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 68);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 69);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 70);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 71);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 72);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 28, 73);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 58, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 59, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 60, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 61, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 62, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 63, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 3, 5);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 4, 5);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 5);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 3, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 4, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 3, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Web(gp, 5, 4);
		i++;
		
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 21, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 22, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 23, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 24, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 25, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 28, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 29, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 30, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 25, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 26, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 27, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 28, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 76, 16);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 76, 15);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 76, 14);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 76, 13);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 76, 12);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 75, 15);
		i++;
		
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 15, 33);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 15, 34);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 25);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 26);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 27);
		i++;
		gp.iTile[mapNum][i] = new IT_GoldenTree(gp, 16, 28);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 29);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 30);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 31);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 16, 32);
		i++;
		gp.iTile[mapNum][i] = new IT_GoldenTree(gp, 16, 33);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 5, 12);
		i++;
		gp.iTile[mapNum][i] = new IT_GoldenTree(gp, 5, 13);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 5, 14);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 5, 15);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 5, 16);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 5, 17);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 6, 17);
		i++;
		gp.iTile[mapNum][i] = new IT_GoldenTree(gp, 6, 18);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 6, 19);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 7, 19);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 7, 20);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 7, 21);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 8, 21);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 8, 22);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 8, 23);
		i++;
		gp.iTile[mapNum][i] = new IT_GoldenTree(gp, 5, 24);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 6, 24);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 7, 24);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 8, 24);
		i++;
		gp.iTile[mapNum][i] = new IT_WitheredTree(gp, 9, 24);
		i++; 
		
	}

}





























