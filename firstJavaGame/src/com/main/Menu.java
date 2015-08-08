package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import com.main.Game.STATE;

public class Menu extends MouseAdapter implements MouseMotionListener{
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
		
	public Menu( Handler handler, HUD hud){
	
	this.handler = handler;
	this.hud = hud;
	
	}
	public void mousePressed(MouseEvent e){
		int mx = e.getX();//mouse's x-position
		int my = e.getY();//mouse's y-position
		if(Game.gameState == STATE.Menu){
			//play button
			if(mouseHover(mx, my, 220, 100, 200, 64)){
				Game.gameState = STATE.Game;
				
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2 -32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 25), r.nextInt(Game.HEIGHT - 25), ID.BasicEnemy, handler));
				
			}
			//quit button
			if(mouseHover(mx, my,220, 300, 200, 64)){
				System.exit(0);
			}
			//help button
			if(mouseHover(mx, my, 220, 200, 200, 64)){
				Game.gameState = STATE.Help;
			}
		}
		
		//back button for help
		if(Game.gameState == STATE.Help){
			if(mouseHover(mx,my, 470, 350, 100, 54)){
				Game.gameState = STATE.Menu;
			}
		}
		//try again on game over 
		if(Game.gameState == STATE.End){
			if(mouseHover(mx,my, 250, 350, 145, 54)){
				Game.gameState = STATE.Game;		
				hud.setLevel(1);
				hud.setScore(0);
				hud.setWave(1);
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2 -32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 25), r.nextInt(Game.HEIGHT - 25), ID.BasicEnemy, handler));						
			}
		}
	}
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseHover(int mx, int my,int x, int y, int width, int height){
		if ((mx > x) && (mx < x + width)){ //If mouse position is between the corners 
			if (my > y && my < y + height){ //of the option box
				return true;
			}else return false;//Return false if we are not on top of the box
		}else return false;
		
	}
	public void render(Graphics g){
		Font font = new Font("arial", 1, 50);
		Font font2 = new Font("arial", 1, 30);
		Font font3 = new Font("arial", 1, 20);
		
		g.setColor(Color.white);
		
		if(Game.gameState == STATE.Menu){
			
			g.setFont(font);
			g.drawString("Dodger", 230, 60);//Title
			
			
			g.setFont(font2);//First box, play
			g.drawRect(220, 100, 200, 64);
			g.drawString("PLAY", 280, 140);
			
				
			g.drawRect(220, 200, 200, 64);//Second box, help
			g.drawString("HELP", 280, 240);

			g.drawRect(220, 300, 200, 64);//Third box, quit
			g.drawString("QUIT", 280, 340);
		}
		else if(Game.gameState == STATE.Help){
			g.setFont(font);
			g.drawString("Help", 270, 80);
			
			g.setFont(font3);
			g.drawString("Use arrow keys to play. Dodge the enemies.", 70, 130);
			g.drawString("Pink boxes increase your health. Beat all 4 waves!", 70, 170);
			g.drawString("Game created by Amrit Prasad.", 70, 210);
			g.drawString( "Good luck!", 70, 260);
			
			g.setFont(font2);
			g.drawRect(470, 350, 100, 54);//back box
			g.drawString("Back", 485, 388);

		}
		else if(Game.gameState == STATE.End){
			g.setFont(font);
			g.setColor(Color.cyan);
			g.drawString("Your game ends here!", 60, 80);
			
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("You ended with a score of:", 120, 170);
			g.drawString(hud.getScore() + " points", 230, 210);
			g.setColor(Color.green);
			g.drawString("High Score: " + Game.highScore, 190, 280);
			g.drawString( "", 70, 220);
			g.setColor(Color.white);
			g.setFont(font2);
			g.drawRect(225, 350, 160, 54);//back box
			g.drawString("Try Again?", 228, 388);

		}
		
	}
	public void tick(){
		
	}
}
