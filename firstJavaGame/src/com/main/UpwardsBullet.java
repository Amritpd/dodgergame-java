package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class UpwardsBullet  extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public UpwardsBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5- -5) + -5);
		velY = -5; //Constant x and y velocities
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		//If the bullet reaches game boundaries, remove it
		if(y <= 0) handler.removeObject(this);
		
		handler.addObject(new Trail( x, y, ID.Trail, Color.red, 16, 16, 0.02F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y,  16,  16);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
