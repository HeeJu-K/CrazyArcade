package com.a225.frame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.a225.main.GameController;
import com.a225.main.GameStart;
import com.a225.model.loader.ElementLoader;

public class BeginJPanel extends JPanel{
	private ImageIcon img;
	private int w;
	private int h;
	
	//构造函数
	public BeginJPanel(){
		List<String> data = ElementLoader.getElementLoader().getGameInfoMap().get("windowSize");
		this.img = ElementLoader.getElementLoader().getImageMap().get("beginBackground");
		this.w = new Integer(data.get(0)).intValue();
		this.h = new Integer(data.get(1)).intValue();
		init();
	}

	private void init() {

		this.setLayout(null);
		
		JLabel jLabel = new JLabel(img);
		img.setImage(img.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
		jLabel.setBounds(0, 0, w, h);
		
		ImageIcon img2 = new ImageIcon("img/bg/introduce.png");
		final JLabel jLabel2 = new JLabel(img2);
		jLabel2.setBounds(w/2, h/6, 600, 800);
		jLabel2.setVisible(false);
		
		JButton easyModeButton = new JButton();
		easyModeButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("rect1"));
		easyModeButton.setBounds(w/6, h/6 + 100, 300, 80);
		easyModeButton.setBorderPainted(false);
		easyModeButton.setFocusPainted(false);
		easyModeButton.setContentAreaFilled(false);
		easyModeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameController.setMode(1);
				try {
					ElementLoader.getElementLoader().readSquarePro();
				} catch (IOException e) {
					System.out.println("资源加载失败");
					e.printStackTrace();
				}
				GameStart.startNewGame();
			}
		});

		
		JButton normalModeButton = new JButton();
		normalModeButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("rect2"));
		normalModeButton.setBounds(w/6, h/6 + 200, 300, 80);
		normalModeButton.setBorderPainted(false);
		normalModeButton.setFocusPainted(false);
		normalModeButton.setContentAreaFilled(false);
		normalModeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameController.setMode(2);
				try {
					ElementLoader.getElementLoader().readSquarePro();
				} catch (IOException e) {
					System.out.println("资源加载失败");
					e.printStackTrace();
				}
				GameStart.startNewGame();
			}
		});

		JButton hardModeButton = new JButton();
		hardModeButton.setIcon(ElementLoader.getElementLoader().getImageMap().get("rect3"));
		hardModeButton.setBounds(w/6, h/6 + 300, 300, 80);
		hardModeButton.setBorderPainted(false);
		hardModeButton.setFocusPainted(false);
		hardModeButton.setContentAreaFilled(false);
		hardModeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameController.setMode(3);
				try {
					ElementLoader.getElementLoader().readSquarePro();
					System.out.println("difficult chosen");
				} catch (IOException e) {
					System.out.println("资源加载失败");
					e.printStackTrace();
				}
				GameStart.startNewGame();
			}
		});

		JButton magicBoxButton = new JButton();
		magicBoxButton.setIcon(new ImageIcon("img/bg/rect4.png"));
		magicBoxButton.setBounds(w/6, h/6 + 400, 300, 80);
		magicBoxButton.setBorderPainted(false);
		magicBoxButton.setFocusPainted(false);
		magicBoxButton.setContentAreaFilled(false);
		magicBoxButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(!jLabel2.isVisible())
					jLabel2.setVisible(true);
				else {
					jLabel2.setVisible(false);
				}
			}
		});
		this.add(easyModeButton);
		this.add(normalModeButton);
		this.add(hardModeButton);
		this.add(magicBoxButton);
		this.add(jLabel2);
		this.add(jLabel);
		
		
		this.setVisible(true);
		this.setOpaque(true);
	}
	
}
