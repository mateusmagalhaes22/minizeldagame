package minizeldagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullets extends Rectangle{
	public int dirX;
	public int dirY;
	public int spd = 8;
	public BufferedImage sprite;
	
	public Bullets(int x, int y, int dirx, int diry, BufferedImage sprite) {
		super(x, y, 8, 8);
		this.dirX = dirx;
		this.dirY = diry;
		this.sprite = sprite;
	}
	public void tick() {
		x += spd*dirX;
		y += spd*dirY;
		if (x >= Game.WIDTH*Game.SCALE || x <= 0 || y >= Game.HEIGHT*Game.SCALE || y <= 0) {
			try {
				this.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void render(Graphics g) {
		g.drawImage(sprite, x, y, width, height, null);
	}
}
