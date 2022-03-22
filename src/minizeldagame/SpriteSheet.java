package minizeldagame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage tileWall;
	
	public SpriteSheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		player_front = new BufferedImage[2];
		player_front[0] = SpriteSheet.getSprite(1, 11, 16, 16);
		player_front[1] = SpriteSheet.getSprite(18, 11, 16, 16);
		player_back = new BufferedImage[2];
		player_back[0] = SpriteSheet.getSprite(69, 11, 16, 16);
		player_back[1] = SpriteSheet.getSprite(86, 11, 16, 16);
		player_right = new BufferedImage[2];
		player_right[0] = SpriteSheet.getSprite(34, 11, 16, 16);
		player_right[1] = SpriteSheet.getSprite(51, 11, 16, 16);
		player_left = new BufferedImage[2];
		player_left[0] = SpriteSheet.getSprite(275, 241, 16, 16);
		player_left[1] = SpriteSheet.getSprite(290, 241, 16, 16);
		try {
			tileWall = ImageIO.read(getClass().getResource("/tilewall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
