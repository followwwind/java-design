package com.wind.example;

/**
 * 单例模式 双重校验锁,在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 * @author wind
 */
public class Singleton {

    private volatile static Singleton singleton;
    private Singleton (){

    }
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}






