package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class FastEnemy extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		boolean dir = r.nextBoolean();
		
		if(dir){
			velX = 2;
			velY = 9;
		}
		else {
			velX = 9;
			velY = 2;
		}
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		//If the enemy reaches game boundaries turn it around
		if (y <= 0 || y >= Game.HEIGHT - 48) 
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject(new Trail((int) x,(int) y, ID.Trail, Color.cyan, 16, 16, 0.02F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
	
		g.setColor(Color.cyan);
		g.fillRect((int)x,(int) y,  16,  16);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
