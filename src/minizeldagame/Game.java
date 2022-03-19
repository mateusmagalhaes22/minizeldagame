package minizeldagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int HEIGHT = 480;
	public static int WIDTH = 480;
	public static int SCALE = 1;
	public Player player;
	public World world;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		world = new World();
		player = new Player(64, 64);
		new SpriteSheet();
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
		bs.show();
	}

	private void tick() {
		player.tick();
		
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
