package com.wind.example;

/**
 * 测试是否线程安全
 * @author wind
 */
public class Single{

    private static Single instance;

    private String name;

    /**
     * 录这个 Singleton 类被实例化的次数
     */
    private static int count;

    private Single(String name){
        System.out.println("Singleton 私有的构造方法被实例化 " + (++count) + " 次");
        this.name = name;
    }

    public static Single getInstance(String name){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(instance == null){
            instance = new Single(name);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
