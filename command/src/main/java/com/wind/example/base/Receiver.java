package com.wind.example.base;

/**
 * 命令模式消息接收者
 * @author wind
 */
public class Receiver {

    public Receiver() {
    }

    public void receiveMsg(String message){
        System.out.println("接收到消息:" + message);
    }
}
