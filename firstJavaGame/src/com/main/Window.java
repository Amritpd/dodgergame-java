package com.main;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends JFrame{
private static final long serialVersionUID = 240840600533728354L;

public Window(int width, int height, String title, Game game){
    final JFrame frame = new JFrame(title);
	
	frame.setPreferredSize(new Dimension(width,height));//Set all sizes to same
	frame.setMaximumSize(new Dimension(width,height));
	frame.setMinimumSize(new Dimension(width,height));
	
	//frame.AWTUtilities.setWindowOpacity(frame.this, 0.5F);
	frame.pack();	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);//Can't resize window
	frame.setLocationRelativeTo(null);
	frame.add(game);
	frame.setVisible(true);//Show window
	game.start();
	
}
}
