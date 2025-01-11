package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_GoldKey;
import object.OBJ_NaturalAttack_Normal;
import object.OBJ_Shield_Sundial;
import object.OBJ_Shield_Web;
import object.OBJ_TorchGun;
import object.OBJ_XmasBoots;

public class SaveLoad {
	
	GamePanel gp;
	
	public SaveLoad(GamePanel gp) {
		this.gp = gp;
		
	}
	public Entity getObject(String itemName) {
		
		Entity obj = null;
		
		switch(itemName) {
		case "TorchGun": obj = new OBJ_TorchGun(gp); break;
		case "XmasBoots": obj = new OBJ_XmasBoots(gp); break;
		case "GoldKey": obj = new OBJ_GoldKey(gp); break;
		case "GoldenApple": obj = new OBJ_GoldKey(gp); break;
		case "Sundial Shield": obj = new OBJ_Shield_Sundial(gp); break;
		case "Web Shield": obj = new OBJ_Shield_Web(gp); break;
		case "Natural Attack": obj = new OBJ_NaturalAttack_Normal(gp); break;
		case "Door": obj = new OBJ_Door(gp); break;
		case "Chest": obj = new OBJ_Chest(gp); break;
		}
		return obj;
		
	}
	public void save() {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
			
			DataStorage ds = new DataStorage();
			
			ds.level = gp.player.level;
			ds.maxLife = gp.player.maxLife;
			ds.life = gp.player.life;
			ds.maxEnergy = gp.player.maxEnergy;
			ds.energy = gp.player.energy;
			ds.strength = gp.player.strength;
			ds.agility = gp.player.agility;
			ds.exp = gp.player.exp;
			ds.nextLevelExp = gp.player.nextLevelExp;
			
			for(int i = 0; i < gp.player.inventory.size(); i++) {
				ds.itemNames.add(gp.player.inventory.get(i).name);
			}
			
			ds.currentWeaponSlot = gp.player.getCurrentWeaponSlot();
			ds.currentShieldSlot = gp.player.getCurrentShieldSlot();
			
			ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
			ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
			ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];
			ds.mapObjectLootNames = new String[gp.maxMap][gp.obj[1].length];
			ds.mapObjectOpened = new boolean[gp.maxMap][gp.obj[1].length];
			
			for(int mapNum = 0; mapNum < gp.maxMap; mapNum ++) {
				
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(gp.obj[mapNum][i] == null) {
						ds.mapObjectNames[mapNum][i] = "NA";
					}
					else {
						ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
						ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
						ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
						if(gp.obj[mapNum][i].loot != null) {
							ds.mapObjectLootNames[mapNum][i] = gp.obj[mapNum][i].loot.name;
						}
						ds.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;
					}
					
				}
				
			}
			
			//Write the DataStorage object
			oos.writeObject(ds);
			
			
		}
		catch(Exception e) {
			System.out.println("save exception.");
		}
		
	}
	public void load() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
			
			DataStorage ds = (DataStorage)ois.readObject();
			
			gp.player.level = ds.level;
			gp.player.maxLife = ds.maxLife;
			gp.player.life = ds.life;
			gp.player.maxEnergy = ds.maxEnergy;
			gp.player.energy = ds.energy;
			gp.player.strength = ds.strength;
			gp.player.agility = ds.agility;
			gp.player.exp = ds.exp;
			gp.player.nextLevelExp = ds.nextLevelExp;
			
			gp.player.inventory.clear();
			for(int i = 0; i < ds.itemNames.size(); i++) {
				gp.player.inventory.add(getObject(ds.itemNames.get(i)));
			}
			
			gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
			gp.player.currentShield = gp.player.inventory.get(ds.currentShieldSlot);
			gp.player.getAttack();
			gp.player.getDefense();
			gp.player.getPlayerAttackImage();
			
			for(int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
				
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(ds.mapObjectNames[mapNum][i].equals("NA")) {
						gp.obj[mapNum][i] = null;
					}
					else {
						gp.obj[mapNum][i] = getObject(ds.mapObjectNames[mapNum][i]);
						gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
						gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
						if(ds.mapObjectLootNames[mapNum][i] != null) {
							gp.obj[mapNum][i].loot = getObject(ds.mapObjectLootNames[mapNum][i]);
						}
						gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];
					}
					
				}
				
			}
			
		}
		catch(Exception e) {
			System.out.println("load exception.");
		}
		
	}

}
