package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HealthParticle  extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	
	public HealthParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		velX = (r.nextInt(3- -3) + -3);
		velY = (r.nextInt(3- -3) + -3); 
		
		if (velX == 0)
			velX = 1;
		if (velY == 0)
			velY = 1;	
	}

	public void tick() {
		
		x += velX;
		y += velY;
		//If the enemy reaches game boundaries turn it around
		if (y <= 0 || y >= Game.HEIGHT - 48) 
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject(new Trail( x, y, ID.Trail, Color.pink, 16, 16, 0.2F, handler));
	}//Smaller float number means longer trail
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.fillRect((int) x,(int) y,  16,  16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
