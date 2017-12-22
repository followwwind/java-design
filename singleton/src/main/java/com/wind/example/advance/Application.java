package com.wind.example.advance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wind
 */
public class Application extends JFrame implements ActionListener{

    public static final int MAX_DISTANCE = 500;
    private Player one, two, three;
    private JButton btnOne, btnTwo, btnThree;
    private JTextField showLabel;

    public Application() {
        setLayout(null);

        JButton start = new JButton("开始比赛");
        start.addActionListener(this);
        add(start);
        start.setBounds(200, 30, 90, 20);

        showLabel = new JTextField("冠军会是谁呢?");
        showLabel.setEditable(false);
        add(showLabel);
        showLabel.setBounds(300, 30, 120, 20);
        showLabel.setBackground(Color.ORANGE);
        showLabel.setFont(new Font("隶书", Font.BOLD, 16));

        btnOne = new JButton("小明");
        btnOne.setSize(60, 30);
        btnOne.setBackground(Color.yellow);
        one = new Player(18, 2, btnOne, showLabel);

        btnTwo = new JButton("小红");
        btnTwo.setSize(65, 30);
        btnTwo.setBackground(Color.cyan);
        two = new Player(19, 2, btnTwo, showLabel);

        btnThree = new JButton("小李");
        btnThree.setSize(62, 30);
        btnThree.setBackground(Color.green);
        three = new Player(21, 2, btnThree, showLabel);

        initPosition();
        setSize(600 ,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initPosition(){
        Champion.initChampion();
        showLabel.setText("冠军会是谁呢?");
        repaint();
        remove(btnOne);
        remove(btnTwo);
        remove(btnThree);
        add(btnOne);
        add(btnTwo);
        add(btnThree);
        btnOne.setLocation(1, 60);
        btnTwo.setLocation(1, 90);
        btnThree.setLocation(1, 120);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean flag = Champion.isChampion();
        if(flag){
            initPosition();
            one = new Player((int)(Math.random()*2 + 19), 2, btnOne, showLabel);
            two = new Player((int)(Math.random()*3 + 18), 2, btnTwo, showLabel);
            three = new Player((int)(Math.random()*4 + 17), 2, btnThree, showLabel);
        }

        one.start();
        two.start();
        three.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(MAX_DISTANCE, 0, MAX_DISTANCE, MAX_DISTANCE);
    }


    public static void main(String[] args) {
        new Application();
    }
}
