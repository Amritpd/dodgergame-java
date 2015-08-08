package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	Handler handler;
	Random r= new Random();

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public void tick() {	
		x += velX;
		y += velY;
		
		x = Game.clamp((int) x, 0, Game.WIDTH - 38);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 64);
		
		handler.addObject(new Trail((int) x,(int) y, ID.Trail, Color.white, 32, 32, 0.1F, handler));
		
		collision();
	}
	
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){//Running through all the objects in the game
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
			    //collision code
				if(getBounds().intersects(tempObject.getBounds())){//if the player and the enemy interesect/collide
					HUD.HEALTH -= 2;		
				}			
			}
			if (tempObject.getID() == ID.BossEnemy){
					if(getBounds().intersects(tempObject.getBounds())){
						HUD.HEALTH -= 10;		
				}
			}
			if (tempObject.getID() == ID.HunterEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 4;
				}
			}
			if (tempObject.getID() == ID.HealthParticle){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH += (r.nextInt(11) + 10);
					handler.removeObject(tempObject);
				}	
		    }
		}
	}
	
	public void render(Graphics g) {	
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y,  32,  32);
	}


	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 32, 32);
	}
}
