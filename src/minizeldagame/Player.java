package minizeldagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
	
	public boolean right;
	public boolean up;
	public boolean down;
	public boolean left;
	private int spd = 4;
	
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	public void tick() {
		if (right) {
			x += spd;
		}else if (left) {
			x -= spd;
		}
		if (up) {
			y -= spd;
		}else if (down) {
			y += spd;	
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
