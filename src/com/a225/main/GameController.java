package com.a225.main;


public class GameController {
	private static boolean gameRunning = false;
	private static int difficulty;
	private static int npcNum;
	
	public static boolean isGameRunning() {
		return gameRunning;
	}
	public static void setGameRunning(boolean gameRunning) {
		GameController.gameRunning = gameRunning;
	}
	public static int seeMode() {
		return difficulty;
	}
	public static void setMode(int difficulty) {
		GameController.difficulty = difficulty;
		System.out.println("here"+difficulty);
	}
	public static int getNpcNum() {
		return npcNum;
	}
	public static void setNpcNum(int npcNum) {
		GameController.npcNum = npcNum;
	}
}
