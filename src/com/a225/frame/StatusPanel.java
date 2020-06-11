package com.a225.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import com.a225.main.GameController;
import com.a225.main.GameStart;
import com.a225.frame.GameFrame;
import com.a225.frame.GameJPanel;
import com.a225.model.manager.ElementManager;
import com.a225.model.vo.MapSquare;
import com.a225.model.vo.Player;
import com.a225.model.vo.SuperElement;
import com.a225.thread.GameThread;
import com.a225.model.loader.ElementLoader;
import java.awt.Image;
import com.a225.model.vo.Character;

/**
 * 游戏面板
 * @author Jenson
 * 窗体容器：画板类
 */
public class StatusPanel extends JPanel {

    private JLabel name;
    private JLabel power;
    private JLabel bubNum;
    private int countNeedle = 3;

    StatusPanel(){
        List<SuperElement> list = ElementManager.getManager().getElementList("player");
        System.out.println(" test " + list.size());
        // Player player = (Player) list.get(0);
        // System.out.println("bubble num + " + player.getBubbleNum());
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
        GridBagConstraints main = new GridBagConstraints();
        main.fill = GridBagConstraints.HORIZONTAL;

        JLabel profile = new JLabel();
        profile.setIcon(ElementLoader.getElementLoader().getImageMap().get("profile"));
        profile.setBounds(0, 0, 10, 10);
        main.gridx = 0;
        main.gridy = 0;
        this.add(profile, main);
        

        // JLabel playerInfo = new JLabel("Player Status");
        // playerInfo.setLayout(new GridBagLayout());
        // GridBagConstraints info = new GridBagConstraints();

        name = new JLabel("Name: Bazzy");
        main.gridx = 1;
        main.gridy = 0;
        this.add(name, main);

        //JLabel playerScore = new JLabel();
        power = new JLabel("power: 1");
        main.gridx = 0;
        main.gridy = 1;
        this.add(power, main);

        bubNum = new JLabel("number: 1");
        main.gridx = 1;
        main.gridy = 1;
        this.add(bubNum, main);
        

        JButton tools = new JButton("Use Needle:" + countNeedle);
        tools.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                if (countNeedle != 0){
                    countNeedle--;
                    tools.setText("Use Needle" + countNeedle);
                    List<SuperElement> playerList = ElementManager.getManager().getElementList("player");
                    // System.out.println("status panel player: " + playerList.get(0));
                    ((Player)(playerList.get(0))).setNeedle(true);
                    // this.gameJPanel.setFocusable(true);
                    //this.gameJPanel.requestFocusInWindow();
                    GameStart.gameFrame.gameJPanel.setFocusable(true);
                    GameStart.gameFrame.gameJPanel.requestFocusInWindow();
                }
			}
		});
        main.gridx = 0; main.gridy = 2;
        this.add(tools, main);
        
        //JLabel control = new JLabel("control");
        JButton pause = new JButton("PAUSE");
        JButton resume = new JButton("RESUME");
        main.gridx = 0; main.gridy = 3;
        this.add(pause, main);
        main.gridx = 1; main.gridy = 3;
        this.add(resume, main);
        //control.add(pause);
        //control.add(resume);

        // this.add(playerStatus);
        // this.add(playerScore);
        // //this.add(timer);
        // this.add(tools);
        // this.add(control);

    }
    
    // public String getPanelBubbleNum(){
    //     return String.valueOf(this.panelBubbleNum);
    // }

    public void setPanelBubbleNum(int num) {
        this.bubNum.setText("number: " + String.valueOf(num));
    }

    public void setPanelBubbleStrength(int num){
        this.power.setText("power: " + String.valueOf(num));
    }

}