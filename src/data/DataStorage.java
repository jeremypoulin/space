package data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable{
	
	//PLAYER STATS
	int level;
	int maxLife;
	int life;
	int maxEnergy;
	int energy;
	int strength;
	int agility;
	int exp;
	int nextLevelExp;
	
	ArrayList<String> itemNames = new ArrayList<>();
	int currentWeaponSlot;
	int currentShieldSlot;
	String mapObjectNames[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootNames[][];
	boolean mapObjectOpened[][];

}
