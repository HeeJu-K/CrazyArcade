package com.a225.frame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;
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
    
    private int panelBubbleStrength = 1;

    private JLabel name;
    private JLabel power;
    private JLabel panelBubbleNum;

    StatusPanel(){
        List<SuperElement> list = ElementManager.getManager().getElementList("player");
        System.out.println(" test " + list.size());
        // Player player = (Player) list.get(0);
        // System.out.println("bubble num + " + player.getBubbleNum());
        this.setLayout(new GridLayout(4, 1));
        this.setVisible(true);

        JLabel playerStatus = new JLabel("Player Status");
        playerStatus.setLayout(new GridLayout(2, 2));
        JLabel profile = new JLabel();
        profile.setIcon(ElementLoader.getElementLoader().getImageMap().get("PlayerA"));
        profile.setBounds(0, 100, 256, 70);
        playerStatus.add(profile);
        name = new JLabel("name");
        power = new JLabel("power:");
        power.setText(getPanelBubbleStrength());
        panelBubbleNum = new JLabel("number:");
        this.setPanelBubbleNum(1);
        playerStatus.add(name);
        playerStatus.add(power);
        playerStatus.add(panelBubbleNum);

        JLabel timer = new JLabel("timer");
        JLabel tools = new JLabel("tools");
        tools.setLayout(new GridLayout(1, 3));
        
        JLabel control = new JLabel("control");
        JButton pause = new JButton("PAUSE");
        JButton resume = new JButton("resume");
        control.add(pause);
        control.add(resume);

        this.add(playerStatus);
        this.add(timer);
        this.add(tools);
        this.add(control);

    }
    
    // public String getPanelBubbleNum(){
    //     return String.valueOf(this.panelBubbleNum);
    // }

    public void setPanelBubbleNum(int num) {
        this.panelBubbleNum.setText(String.valueOf(num));
        System.out.println("in States" + String.valueOf(num));
    }

    public String getPanelBubbleStrength(){
        return String.valueOf(this.panelBubbleStrength);
    } 

    public void setPanelBubbleStrength(int num){
        this.panelBubbleStrength = num;

    }

}