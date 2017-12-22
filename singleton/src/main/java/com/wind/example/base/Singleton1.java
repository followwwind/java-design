package com.wind.example.base;

/**
 * 懒汉，线程不安全,多线程不能正常工作。
 * @author wind
 */
public class Singleton1{

    private static Singleton1 instance;

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }

        return instance;
    }

}
