package com.wind.example.application;

import javax.swing.*;

/**
 * 选手
 * @author wind
 */
public class Player extends Thread{

    int stopTime;

    int step;

    JButton button;

    JTextField showMess;

    Champion champion;

    public Player(int stopTime, int step, JButton button, JTextField showMess) {
        this.stopTime = stopTime;
        this.step = step;
        this.button = button;
        this.showMess = showMess;
    }

    @Override
    public void run() {
        while(true){
            int x = button.getBounds().x;
            int y = button.getBounds().y;
            int width = button.getWidth();
            if((x + width) >= Application.MaxDistance ){
                champion = Champion.getChampion(button.getText());
                showMess.setText(champion.getMessage());
                return;
            }

            x += step;
            button.setLocation(x, y);
            try {
                sleep(stopTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
