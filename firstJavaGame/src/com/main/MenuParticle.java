package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Handler handler;
	Random r = new Random();
	private Color col;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(6- -6) + -6);
		velY = (r.nextInt(6- -6) + -6);
		if (velX == 0)
			velX = 1;
		if(velY == 0) 
			velY = 1;
		
		col  = new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255));
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
		
		handler.addObject(new Trail((int) x,(int) y, ID.Trail, col, 16, 16, 0.02F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
	
		g.setColor(col);
		g.fillRect((int)x,(int) y,  16,  16);
	}


	
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
