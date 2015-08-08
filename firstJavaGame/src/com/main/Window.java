package com.main;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window extends JFrame{
private static final long serialVersionUID = 240840600533728354L;

public Window(int width, int height, String title, Game game){
    final JFrame frame = new JFrame(title);
	
	frame.setPreferredSize(new Dimension(width,height));//Set all sizes to same
	frame.setMaximumSize(new Dimension(width,height));
	frame.setMinimumSize(new Dimension(width,height));
	
	try {
		frame.setGlassPane(new JLabel(new ImageIcon(ImageIO.read(new File ("C:/Users/Amrit/Pictures/Fractal Pictures/galactic_infants_wallpapersuggest_com-1280x800.jpg")))));
	} catch (IOException e) {
		System.out.println("Can't find picture.");
		e.printStackTrace();
	}
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
