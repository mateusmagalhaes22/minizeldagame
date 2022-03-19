package minizeldagame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static BufferedImage spritesheet;
	public static BufferedImage player_front;
	public static BufferedImage player_back;
	public static BufferedImage player_left;
	public static BufferedImage player_right;
	public static BufferedImage tileWall;
	
	public SpriteSheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		player_front = SpriteSheet.getSprite(1, 11, 16, 16);
		player_back = SpriteSheet.getSprite(141, 11, 16, 16);
		player_left = SpriteSheet.getSprite(52, 11, 16, 16);
		player_right = SpriteSheet.getSprite(52, 11, 16, 16);
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
