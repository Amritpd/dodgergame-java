package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class RainMaker extends GameObject{

	private Handler handler;
	private int timer = 44;
	@SuppressWarnings("unused")
	private int timer2 = 50;

	Random r = new Random();
	
	public RainMaker(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2; //Constant x and y velocities
	}

	public void tick() {
		
		x += velX;
		y += velY;
		
		if (timer <= 0){
			velY = 0;
		} else timer--;
		
		if(timer <= 0) 
			timer2--;
		if(timer <= 0){
			if (velX == 0)
				velX = 2;
			if( velX > 0)
				velX += 0.1F;
			else if (velX < 0)
				velX -= 0.01F;
			
			velX = Game.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(250);
			if(spawn == 0)
				handler.addObject(new RainParticle((int) x + 48, (int)y + 48 , ID.BasicEnemy, handler));
			
		}
		//If the enemy reaches game boundaries turn it around
		if (x <= -300 || x >= Game.WIDTH)
			velX *= -1;
		
		handler.addObject(new Trail( x, y, ID.Trail, Color.blue, 96, 96, 0.2F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect((int) x,(int) y,  96,  96);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 96, 96);
	}

}
