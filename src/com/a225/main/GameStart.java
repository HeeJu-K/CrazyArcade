package com.a225.main;

import java.io.IOException;

import com.a225.frame.GameFrame;
import com.a225.model.loader.ElementLoader;
import com.a225.thread.GameMusicPlayer;


public class GameStart {
	public static GameFrame gameFrame;

	//游戏启动入口
	public static void main(String[] args) {
		// 资源加载
		try {
			ElementLoader.getElementLoader().readGamePro();
			ElementLoader.getElementLoader().readImagePro();
			ElementLoader.getElementLoader().readCharactorsPro();
			ElementLoader.getElementLoader().readBubblePro();
			//ElementLoader.getElementLoader().readSquarePro();
		} catch (IOException e) {
			System.out.println("资源加载失败");
			e.printStackTrace();
		}
		//初始化
		gameFrame = new GameFrame();
		//界面显示
		gameFrame.setVisible(true);
		//音乐播放
		GameMusicPlayer musicPlayer = new GameMusicPlayer();
		musicPlayer.start();
	}
	
	/**
	 * 界面切换
	 * @param panelName 界面名称
	 */
	public static void changeJPanel(String panelName){
		if(panelName == "game") {
			GameController.setGameRunning(true);
			gameFrame.addListener();
		} else {
			GameController.setGameRunning(false);
			gameFrame.removeListener();
		}
		gameFrame.changePanel(panelName);
	
		//强制刷新，否则监听无效
		gameFrame.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	public static void startNewGame() {
		GameController.setGameRunning(true);
		gameFrame.startGame();
		changeJPanel("game");
	}

}
