package tile_interactive;

import entity.Entity;
import main.GamePanel;

public class InteractiveTile extends Entity{
	
	GamePanel gp;
	public boolean destructible = false;
	public boolean tileVisible;

	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
		
	}

	public void update() {
		
		
		
	}
	public InteractiveTile getRegeneratedForm() {
		InteractiveTile tile = null;
		return tile;
	}

}
