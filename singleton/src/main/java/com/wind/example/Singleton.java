package com.wind.example;

/**
 * 单例模式 双重校验锁,在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 * 单例模式一般分为五种 懒汉，恶汉，双重校验锁，枚举和静态内部类
 *
 * 如果涉及到反序列化创建对象时使用枚举的方式来实现单例
 *
 * 特点:
 *    1.单例类的构造方法是私有的
 *    2.单例类负责创建自己唯一的实例，并提供外部访问
 *
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






