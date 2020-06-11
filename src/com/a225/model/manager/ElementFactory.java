package com.a225.model.manager;

import java.util.List;
import java.util.Map;
import com.a225.model.loader.ElementLoader;
import com.a225.model.vo.Player;
import com.a225.model.vo.SuperElement;

public class ElementFactory {
	private static ElementFactory elementFactory;
	
	//���캯��
	private ElementFactory() {}
	
	public static ElementFactory getElementFactory() {
		if(elementFactory == null) {
			elementFactory = new ElementFactory();
		}
		return elementFactory;
	}
	
	public SuperElement produceElement(String name) {
		
		Map<String, List<String>> gameInfoMap = 
				ElementLoader.getElementLoader().getGameInfoMap();//��ȡ��Դ����������Ϸ��Ϣ�ֵ�

		switch(name) {
		case "playerOne":
			return Player.createPlayer(gameInfoMap.get(name),0);
		// case "playerTwo":
		// 	return Player.createPlayer(gameInfoMap.get(name),1);
//		case "bubble":
//			return Bubble.createBubble(gameInfoMap.get(name));
		}
		return null;
	}
	
	
}
