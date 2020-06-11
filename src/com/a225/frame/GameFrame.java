package com.a225.frame;

import java.awt.CardLayout;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.Component;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.a225.model.loader.ElementLoader;
import com.a225.thread.GameKeyListener;
import com.a225.thread.GameThread;

public class GameFrame extends JFrame {
	private JPanel contentPane;//主面板
	private BeginJPanel beginJPanel;//开始画板
	private GameJPanel gameJPanel;//画板
	private OverJPanel overJPanel;//结束画板
	private KeyListener keyListener; //游戏按键
	private CardLayout layout;//卡片布局
	private StatusPanel statuspanel;
	private JPanel container;

	
	public GameFrame() {
		init();
	}

//	初始化
	protected void init() {
		this.setTitle("CrazyArcade");
		List<String> data = ElementLoader.getElementLoader().getGameInfoMap().get("windowSize");
		this.setSize(new Integer(data.get(0)).intValue(), new Integer(data.get(1)).intValue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		keyListener = new GameKeyListener();
		
		this.contentPane = new JPanel();
		this.setContentPane(contentPane);
		
		this.layout = new CardLayout();
		this.contentPane.setLayout(layout);
		
		this.beginJPanel = new BeginJPanel();
		this.contentPane.add("begin",beginJPanel);
		
		this.overJPanel = new OverJPanel();
		this.contentPane.add("over",overJPanel);
		
		this.layout.show(contentPane, "begin");
		this.setVisible(true);
	}
	
	
//	切换画板
	public void changePanel(String name) {
		layout.show(contentPane, name);
	}
	

	
//	游戏启动
	public void startGame() {
		//新建游戏面板
		this.container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		gameJPanel = new GameJPanel();
		statuspanel = new StatusPanel();

		gameJPanel.setPreferredSize(new Dimension(1000, 1000));
		gameJPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

		container.add(statuspanel);
		container.add(gameJPanel);

		//??????frame
		contentPane.add("game",container);
		//contentPane.add("game",gameJPanel);

		//???????
		GameThread gameThread = new GameThread();
		gameThread.start();
		//??????????????
		if(gameJPanel instanceof Runnable) {
			new Thread(gameJPanel).start();
		}
	}
	
//	?????
	public void addListener() {
		if(keyListener!=null){
			this.addKeyListener(keyListener);

			this.gameJPanel.addKeyListener(keyListener);
			this.gameJPanel.setFocusable(true);
			this.gameJPanel.requestFocusInWindow();

			this.statuspanel.addKeyListener(keyListener);
			this.statuspanel.setFocusable(true);
			this.statuspanel.requestFocusInWindow();
		}
	}
	
//	???????
	public void removeListener() {
		this.removeKeyListener(keyListener);
		this.gameJPanel.removeKeyListener(keyListener);
		this.statuspanel.removeKeyListener(keyListener);
	}
	
	
//	getter and setter
	public KeyListener getKeyListener() {
		return keyListener;
	}

	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}

	public void setBeginJPanel(BeginJPanel beginJPanel) {
		this.beginJPanel = beginJPanel;
	}

	public GameJPanel getGameJPanel() {
		return gameJPanel;
	}

	public void setGameJPanel(GameJPanel gameJPanel) {
		this.gameJPanel = gameJPanel;
	}

	public void setStatusPanel(StatusPanel statuspanel){
		this.statuspanel = statuspanel;
	}

	public void setPanelBubbleNum(int num) {
		this.statuspanel.setPanelBubbleNum(num);
	}
	public void setPanelBubbleStrength(int num){
		this.statuspanel.setPanelBubbleStrength(num);
	}

}
