package com.a225.model.vo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

import com.a225.model.loader.ElementLoader;
import com.a225.model.manager.ElementManager;

/**
 * 地图可破坏物体类
 * @ClassName: MapFragility  
 * @Description:    
 * @author: WeiXiao
 * @CreateDate: 2019年4月13日 下午6:31:49
 */
public class MapFragility extends MapSquare{

	public MapFragility(int i, int j, ImageIcon img, int sx, int sy, int dx, int dy, int scaleX, int scaleY) {
		super(i, j, img, sx, sy, dx, dy, scaleX, scaleY);
	}
	
	public static MapFragility createMapFragility(List<String> data,int i, int j) {
		ImageIcon img = ElementLoader.getElementLoader().getImageMap().get(data.get(0));
		int sx = Integer.parseInt(data.get(1));
		int sy = Integer.parseInt(data.get(2));
		int dx = Integer.parseInt(data.get(3));
		int dy = Integer.parseInt(data.get(4));
		int scaleX = Integer.parseInt(data.get(6));
		int scaleY = Integer.parseInt(data.get(7));
		MapFragility mapMapFragility = new MapFragility(i, j, img, sx, sy, dx, dy, scaleX, scaleY);
		return mapMapFragility;
	}
	
	@Override
	public void update() {
		destroy();
	}
	
	@Override
	public void destroy() {
//		判断是否被破坏
//		if
		Map<String, List<SuperElement>> elmenteMap = ElementManager.getManager().getMap();
		Random rd = new Random();
		int creating = rd.nextInt(2);
		if(creating==1) elmenteMap.get("magicBox").add(MagicBox.createMagicBox(getX(), getY()));
	}

}
