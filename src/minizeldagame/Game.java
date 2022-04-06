package minizeldagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int HEIGHT = 480;
	public static int WIDTH = 640;
	public static int SCALE = 1;
	public Player player;
	public World world;
	boolean canShot = true;
	int bulletFrames;
	int bulletTargFrames = 60;
	BufferedImage bSprite;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		new SpriteSheet();
		world = new World();
		player = new Player(64, 64);
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("mini zelda");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Thread(game).start();
	}
	
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 150, 13));
		g.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
		player.render(g);
		world.render(g);
		for(Bullets bullet:player.bullets) {
			bullet.render(g);
		}
		bs.show();
	}

	private void tick() {
		player.tick();
		if(!canShot) {
			bulletFrames++;
		}
		if(bulletFrames >= bulletTargFrames) {
			canShot = true;
			bulletFrames = 0;
		}
		for(Bullets bullet:player.bullets) {
			bullet.tick();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			player.up = true;
		}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			player.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if((player.spriteAtual == SpriteSheet.player_front[1]||player.spriteAtual == SpriteSheet.player_front[0])&&canShot) {
				bSprite = SpriteSheet.getSprite(x, y, 15, 16);
				player.bullets.add(new Bullets(player.x+16, player.y+16, 0, 1, bSprite));
				canShot = false;
			}else if((player.spriteAtual == SpriteSheet.player_back[1]||player.spriteAtual == SpriteSheet.player_back[0])&&canShot) {
				bSprite = SpriteSheet.getSprite(x, y, 15, 16);
				player.bullets.add(new Bullets(player.x+16, player.y+16, 0, -1, bSprite));
				canShot = false;
			}else if((player.spriteAtual == SpriteSheet.player_left[1]||player.spriteAtual == SpriteSheet.player_left[0])&&canShot) {
				bSprite = SpriteSheet.getSprite(x, y, 16, 15);
				player.bullets.add(new Bullets(player.x+16, player.y+16, -1, 0, bSprite));
				canShot = false;
			}else if((player.spriteAtual == SpriteSheet.player_right[1]||player.spriteAtual == SpriteSheet.player_right[0])&&canShot) {
				bSprite = SpriteSheet.getSprite(x, y, 16, 15);
				player.bullets.add(new Bullets(player.x+16, player.y+16, 1, 0, bSprite));
				canShot = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode()== KeyEvent.VK_UP) {
			player.up = false;
		}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			player.down = false;
		}
		
	}

}
