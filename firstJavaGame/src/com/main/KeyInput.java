package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler){
		this.handler = handler;
		//initialize key keyDown boolean array as false
		keyDown[0] = keyDown[1] = keyDown[2] = keyDown[3] = false;
	}	//up key      down key    right key    left key
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){//looping through all the objects
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player){//If the object we're at has the player 1 ID
				//key events for player
				
				if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {//If up key is released
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){ //If down key is pressed
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_RIGHT|| key == KeyEvent.VK_D) {//If right key is pressed
					tempObject.setVelX(5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_LEFT|| key == KeyEvent.VK_A){ //If left key is pressed
					tempObject.setVelX(-5);
					keyDown[3] = true;
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_Q)
			System.exit(0);
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){//looping through all the objects
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.Player){
				if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) //If up key is released
					keyDown[0] = false;  
				if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) //If down key is released
					keyDown[1] = false;
				if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) //If right key is released
					keyDown[2] = false;
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) //If left key is released
					keyDown[3] = false;
				
				//Fixing the keyboard input glitch
				if(!keyDown[0] && !keyDown[1])
					tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3])
					tempObject.setVelX(0);
			} 		
		}
	}
}
