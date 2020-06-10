package com.a225.frame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.a225.main.GameStart;
import com.a225.model.loader.ElementLoader;


public class OverJPanel extends JPanel {
	private ImageIcon img;
	private int w;
	private int h;
	private static JButton result = new JButton();
	
	//¹¹Ôìº¯Êý
	public OverJPanel(){
		List<String> data = ElementLoader.getElementLoader().getGameInfoMap().get("windowSize");
		this.img = ElementLoader.getElementLoader().getImageMap().get("gameOver");
		this.w = new Integer(data.get(0)).intValue();
		this.h = new Integer(data.get(1)).intValue();
		init();
	}

	private void init() {

		this.setLayout(null);
		
		JLabel jLabel = new JLabel(img);
		img.setImage(img.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
		jLabel.setBounds(0, 0, w, h);
		
		JButton restart = new JButton();
		restart.setIcon(ElementLoader.getElementLoader().getImageMap().get("restart"));
		restart.setBounds(0, h-h/3, 256, 94);
		restart.setBorderPainted(false);
		restart.setFocusPainted(false);
		restart.setContentAreaFilled(false);
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameStart.changeJPanel("begin");
			}
		});
		
		JButton quit = new JButton();
		quit.setIcon(ElementLoader.getElementLoader().getImageMap().get("quit"));
		quit.setBounds(w/2, h-h/3, 256, 70);
		quit.setBorderPainted(false);
		quit.setFocusPainted(false);
		quit.setContentAreaFilled(false);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});


		this.add(restart);
		this.add(quit);
		this.add(jLabel);
	
		
		this.setVisible(true);
		this.setOpaque(true);
	}

	public static JButton getResult() {
		return result;
	}
	
}
