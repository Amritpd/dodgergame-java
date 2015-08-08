package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class RainParticle  extends GameObject{

	private Handler handler;
	Random r = new Random();
	private Color col;
	
	public RainParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2;
		velY = 5; //Constant x and y velocities
		
		col  = new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255));
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		//If the bullet reaches game boundaries, remove it
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail( x, y, ID.Trail, col, 16, 16, 0.05F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(col);
		g.fillRect((int) x,(int) y,  16,  16);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
