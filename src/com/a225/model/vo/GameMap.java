package com.a225.model.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.a225.model.loader.ElementLoader;
import com.a225.model.manager.ElementManager;

/**
 * 地图类
 * @ClassName: Map  
 * @Description: 地图类   
 * @author: DaXiao
 * @CreateDate: 2019年4月11日 下午21：11
 */
public class GameMap {
	private int windowW;
	private int windowH;
	private int mapRows;
	private int mapCols;
	
	private static int biasX;
	private static int biasY;
	
	private static List<List<String>> mapList;//地图
	
	public GameMap() {}
	public GameMap(int windowW,int windowH) {
		this.windowW = windowW;
		this.windowH = windowH;
	}
	
	private void createFloor() {
		List<SuperElement> floorList = ElementManager.getManager().getElementList("floor");
		for(int i=0;i<mapRows;i++) {
			for(int j=0;j<mapCols;j++) {
				floorList.add(MapFloor.createMapFloor(i, j));
			}
		}
	}
	
	private void createSquare() {
		Map<String, List<String>> typeMap = ElementLoader.getElementLoader().getSquareTypeMap();
		Map<String, List<SuperElement>>elmenteMap = ElementManager.getManager().getMap();
		Map<String, List<String>> gameInfoMap = ElementLoader.getElementLoader().getGameInfoMap();
		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {
				String type = mapList.get(i).get(j);
				switch (type.charAt(0)) {
				case '0':
					elmenteMap.get("obstacle").add(MapObstacle.createMapObstacle(typeMap.get(type), i, j));
					break;
				case '2': 
					elmenteMap.get("fragility").add(MapFragility.createMapFragility(typeMap.get(type), i, j));
					break;
				case '6':
					elmenteMap.get("player").add(Player.createPlayer(gameInfoMap.get("playerOne"), i, j));
					break;
				default:
					break;
				}
				
			}
		}
	}
	
	//创建
	public void createMap(String pro){
		try {
			mapList = ElementLoader.getElementLoader().readMapPro(pro);
			List<String> size = ElementLoader.getElementLoader().getGameInfoMap().get("mapSize");
			mapRows = Integer.parseInt(size.get(0));
			mapCols = Integer.parseInt(size.get(1));
			biasX = (windowW-MapSquare.PIXEL_X*mapCols)/2;
			biasY = (windowH-MapSquare.PIXEL_Y*mapRows)/2;
			
			createFloor();
			createSquare();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> getIJ(int x,int y){
		//j-scaleX+1)*PIXEL_X+GameMap.getBiasX(),
		List<Integer> list = new ArrayList<>();
		list.add((x-biasX)/MapSquare.PIXEL_X-1);
		return list;
	}
	
	public void clearMap() {
		ElementManager.getManager().getElementList("obstacle").clear();
		ElementManager.getManager().getElementList("fragility").clear();
	}

	public static List<List<String>> getMapList(){
		return mapList; 
	}
	public static int getBiasX() {
		return biasX;
	}
	public static int getBiasY() {
		return biasY;
	}
	
}
