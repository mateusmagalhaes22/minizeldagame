package minizeldagame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Rectangle {
	
	public boolean right;
	public boolean up;
	public boolean down;
	public boolean left;
	private int spd = 4;
	public BufferedImage spriteAtual;
	public int curAnimation;
	public int curFrames = 0;
	public int targetFrames = 8;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public void tick() {
		if (right && World.isFree(x+spd, y)) {
			x += spd;
			spriteAtual = SpriteSheet.player_right[curAnimation];
		}else if (left && World.isFree(x-spd, y)) {
			x -= spd;
			spriteAtual = SpriteSheet.player_left[curAnimation];
		}
		if (up && World.isFree(x, y-spd)) {
			y -= spd;
			spriteAtual = SpriteSheet.player_back[curAnimation];
		}else if (down && World.isFree(x, y+spd)) {
			y += spd;
			spriteAtual = SpriteSheet.player_front[curAnimation];
		}
		curFrames++;
		if (curFrames >= targetFrames) {
			curAnimation++;
			if (curAnimation >= SpriteSheet.player_front.length) {
				curAnimation = 0;
			}
			curFrames = 0;
		}
	}
	public void render(Graphics g) {
		g.drawImage(spriteAtual, x, y, 32, 32, null);
	}
}
