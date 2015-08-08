package com.main;
//My first proper Java game. This is my rendition of the classic "Dodger"/"Wave" game
/*
 * To do list:
 * 
 * - Note down all levels that the bosses are on in a table for all game modes
 * - create more game modes with different enemy patterns
 * - find a way to be able to switch between game modes (probably just have to check the game state once)
 * - Add a button to the Menu page then or something
 * - Add background pictures
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {
	
	public enum STATE{
		Menu,
		Help,
		Game,
		End
	};
	
	public enum GAMEMODE{
		Mode1,
		Mode2,
		Mode3
	};
	
	public static STATE gameState = STATE.Menu;
	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 *9;
	public static int highScore = 0;
	private Thread thread;
	private boolean running = false;	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private int finalX, finalY;//Final position of player
	private Color myColor = new Color(0,0, 0, 255);
	Random r = new Random();
	
	public Game(){
		
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(handler, hud);
		this.addMouseListener(menu);//Start listening for mouse clicks
		this.addKeyListener(new KeyInput(handler));//Start "listening" for keyboard input
		new Window(WIDTH, HEIGHT, "Dodger", this);
		
	
		spawner = new Spawn(handler, hud);
		
		if (gameState == STATE.Game){
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2 -32, ID.Player, handler));
		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 25), r.nextInt(Game.HEIGHT - 25), ID.BasicEnemy, handler));
		handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
		} else {
			for(int i = 0; i < 15;i++){
				handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));		
			}		
		}
	}
	
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}   catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public void run(){//Game loop, pretty popular
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 /amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
		 long now = System.nanoTime();
		 delta += (now - lastTime) /ns;
		 lastTime = now;
		 while (delta >= 1){
			 tick();
			 delta--;
		 }
		 if (running)
			 render();
		 frames++;
		 
		 if (System.currentTimeMillis() - timer > 1000){
			 timer += 1000;
			 System.out.println("FPS: " + frames);
			 frames = 0;
		 }
	 }
	 stop();
		
	}
	
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game){
		hud.tick();
			
		spawner.tick();
		
		if (HUD.HEALTH <= 0){
			HUD.HEALTH = 100;
			
			if (highScore < hud.getScore())
				highScore = hud.getScore();
			
			for (int i = 0; i < handler.object.size(); i++){//Cycle through left over objects
				GameObject tempObject = handler.object.get(i);
				
				if (tempObject.getID() == ID.Player){//Find object with player ID
					 finalX = (int) tempObject.getX();//Get its coordinates
					 finalY = (int) tempObject.getY();
				}
			}
			gameState = STATE.End;//End the game
			
			handler.clearEnemies();
			
			for(int i = 0; i < 20;i++){//Add the explosion particle at the last position the Player was at
				handler.addObject(new ExplosionParticle(finalX, finalY, ID.ExplosionParticle, handler));
				handler.addObject(new RainMaker(-300, -400, ID.BossEnemy, handler));//Left rain-maker
				handler.addObject(new RainMaker(Game.WIDTH, -400, ID.BossEnemy, handler));//Right rain-maker	
			}
	
		}else if (gameState == STATE.Menu || gameState == STATE.End){			
			handler.clearPlayer();
			menu.tick();
		}
	}
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);//3 buffers created
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(myColor);
	
		g.fillRect(0, 0, WIDTH, HEIGHT);
			
		handler.render(g);//render objects first
		
		if (gameState == STATE.Game){
		hud.render(g);//render Heads Up Display "on top" of the objects
		}else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
			menu.render(g);
		}
		g.dispose();
	    bs.show();
	}
	
	public static float clamp(float var, float min, float max){
		if (var >= max) //If our position is equal to max position
		return var = max;//return max position every time so you can't leave the screen 
		else if (var <= min)//Same idea as above but with minimum
			return var= min;
		else return var;//Otherwise the position you're at is okay
	}
	
	
	public static void main(String args[]){
		new Game();
	}
}
