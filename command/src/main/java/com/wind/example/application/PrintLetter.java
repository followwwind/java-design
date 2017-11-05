package com.wind.example.application;

/**
 * 命令接收者 打印字母
 * @author wind
 */
public class PrintLetter {

    public void printLower(){
        for(char c = 'a'; c < 'z'; c++){
            System.out.print(c + "\t");
        }
    }

    public void printUpper(){
        for(char c = 'A'; c < 'Z'; c++){
            System.out.print(c + "\t");
        }
    }

}
