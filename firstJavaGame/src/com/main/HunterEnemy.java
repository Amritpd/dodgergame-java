package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HunterEnemy extends GameObject{

	private Handler handler;
	private GameObject player;
	
	public HunterEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for (int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getID() == ID.Player){
				player = handler.object.get(i);
			}//get(i) retrieves the gameObject
		}
	}
		

	
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		 float diffX = x - player.getX() - 16;
         float diffY = y - player.getY() - 16;
		//distance is calculated using Pythagorean Theorem
         float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX())+(y-player.getY())*(y-player.getY()));
		//If the enemy reaches game boundaries turn it around
		
		velX = ((-1.0F/distance) * diffX)  * 3.25F;
		velY = ((-1.0F/distance) * diffY) * 3.25F;

		handler.addObject(new Trail( x, y, ID.Trail, Color.MAGENTA, 16, 16, 0.02F, handler));
	}//Smaller float number means longer trail
	

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.MAGENTA);
		g.fillRect((int) x,(int)  y,  16,  16);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

}
