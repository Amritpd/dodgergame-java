package com.main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();

	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		
		handler.clearEnemies();
	}
	
	public void tick(){
		
		scoreKeep++;
		
		if (getScoreKeep() >= 250 && hud.getScore() >= 250){//bug fixed
			setScoreKeep(0);
			hud.setLevel(hud.getLevel()+ 1);
			
			switch (hud.getLevel()){//Boss rounds last five levels
			case 1:	
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
			case 2:	
			case 3:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				break;
			case 4:
			case 6:
			    handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));			
				break;	
			case 8:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));			
				break;
			case 10:
				handler.clearEnemies();
				handler.addObject(new BossEnemy((Game.WIDTH/2) -48 , -101, ID.BossEnemy, handler));			
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 12: 
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));	
				break;
			case 14:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 15:	
				handler.clearEnemies();	
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));	
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 16:
				hud.setWave(2);
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				break;
			case 17: 
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));			
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));		
				break;
			case 18:
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));		
				break;
			case 19: 
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));	
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 20:
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));			
				break;
			case 21:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 22:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
				break;
			case 23:
				handler.clearEnemies();
				break;
			case 24:
				handler.addObject(new UpsidedownBoss((Game.WIDTH/2) -48 , Game.HEIGHT + 50 , ID.BossEnemy, handler));//	handler.addObject(new VerticalBoss(Game.WIDTH - 12, (Game.HEIGHT/2) -48 , ID.VerticalBoss, handler));	
				break;
			case 26:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 28:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 29:
				handler.clearEnemies();
				hud.setWave(3);
				for (int c = 0; c < 3; c++)
					handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 30:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				break;
			case 31:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));			
				break;
			case 32:
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));	
				break;
			case 33:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 34:
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 35:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));			
				handler.addObject(new HunterEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HunterEnemy, handler));		
				break;
			case 37:
				handler.clearEnemies();
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 38:
				handler.addObject(new BossEnemy((Game.WIDTH/2) -48 , -101, ID.BossEnemy, handler));		
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));		
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));		
				break;
			case 40:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 42:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 44:
				handler.clearEnemies();
				hud.setWave(4);
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 45:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));	
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));		
				break;
			case 46:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
				break;
			case 48://Mini-boss
				handler.addObject(new HunterEnemy(0, 0, ID.HunterEnemy, handler));//Spawn top left corner
				handler.addObject(new HunterEnemy(0, Game.HEIGHT - 50, ID.HunterEnemy, handler));//Spawn bottom left corner
				handler.addObject(new HunterEnemy(Game.WIDTH - 50, 0, ID.HunterEnemy, handler));//Spawn top right corner
				handler.addObject(new HunterEnemy(Game.WIDTH - 50, Game.HEIGHT - 50, ID.HunterEnemy, handler));//Spawn bottom right corner
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 49:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 51:
				handler.clearEnemies();
				handler.addObject(new UpsidedownBoss((Game.WIDTH/2) -48 , Game.HEIGHT + 50 , ID.BossEnemy, handler));//	handler.addObject(new VerticalBoss(Game.WIDTH - 12, (Game.HEIGHT/2) -48 , ID.VerticalBoss, handler));	
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 53:
				handler.addObject(new HunterEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HunterEnemy, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			case 55:
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));
				break;
			}
			if (hud.getLevel() > 55 && hud.getLevel() % 2 == 0)
				handler.addObject(new HealthParticle(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.HealthParticle, handler));		
		}
	}
	
	public int getScoreKeep() {
		return scoreKeep;
	}

	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = scoreKeep;
	}
}
