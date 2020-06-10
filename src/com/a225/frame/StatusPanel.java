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
import com.a225.model.vo.SuperElement;
import com.a225.thread.GameThread;
import com.a225.model.loader.ElementLoader;
import java.awt.Image;

/**
 * 游戏面板
 * @author Jenson
 * 窗体容器：画板类
 */
public class StatusPanel extends JPanel {
    
    StatusPanel(){

        this.setLayout(new GridLayout(4, 1));
        this.setVisible(true);

        JLabel playerStatus = new JLabel("Player Status");
        playerStatus.setLayout(new GridLayout(2, 1));
        JLabel profile = new JLabel();
        profile.setIcon(ElementLoader.getElementLoader().getImageMap().get("playerA"));
        profile.setBounds(0, 100, 256, 70);
        playerStatus.add(profile);
        //JTextField score = new JTextField();
        //playerStatus.add(score);

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
    

}