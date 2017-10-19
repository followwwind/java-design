package com.wind.example;

/**
 * 饿汉，变种， 和第三种方式差不多，都是在类初始化即实例化instance
 * @author wind
 */
public class Singleton4{

    private static Singleton4 instance;
    static {
        instance = new Singleton4();
    }

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        return instance;
    }

}
