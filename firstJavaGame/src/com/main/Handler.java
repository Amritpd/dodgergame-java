package com.main;

import java.awt.*;
import java.util.*;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick(){
		for(int i = 0; i< object.size();i++){
			 GameObject tempObject = object.get(i);
			 
			 tempObject.tick();
		}
	}
	public void render(Graphics g){
		for (int index = 0; index < object.size(); index++){
			if(object.get(index) != null){
			GameObject tempObject = (GameObject) object.get(index); 
			tempObject.render(g);
			}
			
		}
	}
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void clearEnemies(){//Clears enemies at the end of the game/before each boss
		for (int index = 0; index < object.size(); index++){
			GameObject tempObject = object.get(index); 
			if (tempObject.getID() == ID.HUD){
				removeObject(object.get(index));
				object.clear();
			}
			if (tempObject.getID() == ID.Player){
				object.clear();
				if(Game.gameState != Game.STATE.End){
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
				}
			}
		}
	}
	
	public void clearPlayer(){//Gets rid of player particle at the end of the game
		for (int index = 0; index < object.size(); index++){
			GameObject tempObject = object.get(index); 	
			if (tempObject.getID() == ID.Player || tempObject.getID() == ID.HUD){
				removeObject(object.get(index));
			}
		}
	}
			
}
