package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class ExplosionParticle  extends GameObject{

	Random r = new Random();
	private Color col;
	private Handler handler;
	public ExplosionParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (r.nextInt(6- -6) + -6);
		velY = (r.nextInt(6- -6) + -6); 
		
		col  = new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255));
	}

	
	public void tick() {
		
		x += velX;
		y += velY;		
		
		handler.addObject(new Trail( x, y, ID.Trail, col, 32, 32, 0.2F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(col);
		g.fillRect((int) x,(int) y,  32,  32);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 32, 32);
	}

}
