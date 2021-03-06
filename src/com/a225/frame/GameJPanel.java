package com.a225.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import com.a225.main.GameController;
import com.a225.model.manager.ElementManager;
import com.a225.model.vo.MapSquare;
import com.a225.model.vo.SuperElement;
import com.a225.thread.GameThread;

/**
 * 游戏面板
 * @author Jenson
 * 窗体容器：画板类
 */
public class GameJPanel extends JPanel implements Runnable{
	

	
//	显示画板内容，绘画
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		gameRuntime(g);

	}
	
	@Override
	public void run() {
		while(GameController.isGameRunning()) {
			// this.requestFocusInWindow();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint(); //每隔100毫秒刷新画板
		}
	}
	
	//展示元素管理器中所有的元素
	public void gameRuntime(Graphics g) {
		Map<String, List<SuperElement>> map = ElementManager.getManager().getMap();
		Set<String> set = map.keySet();
		Set<String> sortSet = new TreeSet<String>(ElementManager.getManager().getMapKeyComparator());
        sortSet.addAll(set);
		for(String key:sortSet) {
			List<SuperElement> list = map.get(key);
			for(int i=0; i<list.size(); i++) {
				list.get(i).showElement(g);
			}
		}
		
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		int allTime = GameThread.getRunTime()/1000;
		int minute = allTime / 60;
		int second = allTime % 60;
		String m;
		String s;
		if(minute < 10)
			m = "0" + Integer.toString(minute);
		else 
			m = Integer.toString(minute);
		if(second<10)
			s = "0" + Integer.toString(second);
		else
			s = Integer.toString(second);
		g.drawString("Time: "+ m + ":" + s, 0, 3*MapSquare.PIXEL_Y);
	}
	

}