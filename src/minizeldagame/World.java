package minizeldagame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static List<Block> blocos = new ArrayList<Block>();
	
	public World() {
		for(int x = 0; x < (Game.WIDTH*Game.SCALE/32); x++) {
			blocos.add(new Block(x*32, 0));
			blocos.add(new Block(x*32, Game.HEIGHT*Game.SCALE-32));
		}for(int y = 0; y < (Game.HEIGHT*Game.SCALE/32); y++) {
			blocos.add(new Block(0, y*32));
			blocos.add(new Block(Game.WIDTH*Game.SCALE-32, y*32));
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < blocos.size(); i++) {
			blocos.get(i).render(g);
		}
	}
	public static boolean isFree(int x, int y) {
		boolean free = true;
		for(int i = 0; i < blocos.size(); i++){
			Block blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				free = false;
			}
		}
		return free;
	}
}
