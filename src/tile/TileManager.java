package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][][];
	boolean drawPath = true;
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world2.txt",0);
		loadMap("/maps/web01.txt",1);
		loadMap("/maps/web02.txt",2);
		loadMap("/maps/web03.txt",3);
		loadMap("/maps/web04.txt",4);
		loadMap("/maps/finalweb.txt",5);
		loadMap("/maps/haven.txt",6);
	}
	
	public void getTileImage() {
			
			setup(0, "blacktile", false);
			setup(1, "static", true);
			setup(2, "river", true);
			setup(3, "tree", true);
			setup(4, "void", false);
			setup(5, "wallh", true);
			setup(6, "wallv", true);
			setup(7, "walllt", true);
			setup(8, "walllb", true);
			setup(9, "wallrt", true);
			setup(10, "wallrb", true);
			setup(11, "riverleft", true);
			setup(12, "riverright", true);
			setup(19, "rivertop", true);
			setup(20, "riverbottom", true);
			setup(15, "riverlb", true);
			setup(16, "riverrb", true);
			setup(17, "riverlt", true);
			setup(18, "riverrt", true);
			setup(13, "staticleft", true);
			setup(14, "staticright", true);
			setup(21, "statictop", true);
			setup(22, "staticbottom", true);
			setup(23, "staticlb", true);
			setup(24, "staticrb", true);
			setup(25, "staticlt", true);
			setup(26, "staticrt", true);
			setup(27, "riverlts", true);
			setup(28, "riverrts", true);
			setup(29, "riverlbs", true);
			setup(30, "riverrbs", true);
			setup(31, "staticlts", true);
			setup(32, "staticrts", true);
			setup(33, "staticlbs", true);
			setup(34, "staticrbs", true);
			setup(35, "wallle", true);
			setup(36, "wallre", true);
			setup(37, "wallbe", true);
			setup(38, "wallte", true);
			setup(39, "pit", false);
			setup(40, "appletree", true);
			setup(41, "greentree", true);
			setup(42, "brick", true);
			setup(43, "waterlt", true);
			setup(44, "waterlb", true);
			setup(45, "waterrt", true);
			setup(46, "waterrb", true);
			setup(47, "grass", false);
		
	}
	public void setup(int index, String imageName, boolean collision) {
		
		UtilityTool uTool = new UtilityTool();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName +".png"));
			tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap(String filePath, int map) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[map][col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
		

		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY  + gp.player.screenY) {
			
			g2.drawImage(tile[tileNum].image, (int)screenX, (int)screenY, null);
			
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
		
		/*if(drawPath == true) {
			g2.setColor(new Color(255,0,0,70));
			
			for(int i = 0; i < gp.pFinder.pathList.size();i++) {
				
				int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize;
				int worldY = gp.pFinder.pathList.get(i).row * gp.tileSize;
				int screenX = worldX - gp.player.worldX + gp.player.screenX;
				int screenY = worldY - gp.player.worldY + gp.player.screenY;
				
				g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
			}
		}*/
		
	}
	
}
