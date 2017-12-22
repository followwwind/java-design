package com.wind.example.base;

import java.util.concurrent.*;

/**
 *
 * 单例模式一般分为五种 懒汉，恶汉，双重校验锁，枚举和静态内部类
 *
 * 如果涉及到反序列化创建对象时使用枚举的方式来实现单例
 *
 * 特点:
 *    1.单例类的构造方法是私有的
 *    2.单例类负责创建自己唯一的实例，并提供外部访问
 * @author wind
 */
public class Test {
    private static int i = 0;
    public static void main(String[] args) {
//        test();
        test2();
    }

    public static void test(){
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            Single s = Single.getInstance("single name:" + name);
            System.out.println("线程 " + name + "\t => " + s.hashCode());
        };
        // 模拟多线程环境下使用 Singleton 类获得对象
        for(int i = 0; i < 10000; i++){
            new Thread(task,"" + i).start();
        }
    }

    public static void test2(){
        ThreadFactory threadFactory = r -> {
            i++;
            System.out.println("i:" + i);
            return new Thread(r, "pool-name-" + i);
        };
        BlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(1024);
        ExecutorService executorService = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, runnables, threadFactory, new ThreadPoolExecutor.AbortPolicy());


        for(int j =0; j < 20; j++){
            System.out.println("j:" + j);
            executorService.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name);
                System.out.println(Single.getInstance("single name:" + name).getName());
            });
        }

        executorService.shutdown();
    }
}
