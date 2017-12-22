package com.wind.example.base;


import com.wind.example.base.awaitsignal.StorageOne;
import com.wind.example.base.blockingqueue.StorageTwo;
import com.wind.example.base.waitnotify.StorageThree;

/**
 * 测试类
 * @author wind
 */
public class Test {

    private static Storage getStorage(String name){
        Storage storage = null;
        switch (name){
            //await/signal
            case "one" : storage = new StorageOne(); break;
            //blockingqueue
            case "two" : storage = new StorageTwo(); break;
            //wait/nofity
            default: new StorageThree(); break;
        }

        return storage;
    }

    public static void main(String[] args) {
        // 仓库对象
        Storage storage = getStorage("one");

        // 生产者对象和产品生产数量
        Producer p1 = new Producer(10, storage);
        Producer p2 = new Producer(10, storage);
        Producer p3 = new Producer(10, storage);
        Producer p4 = new Producer(10, storage);
        Producer p5 = new Producer(10, storage);
        Producer p6 = new Producer(10, storage);
        Producer p7 = new Producer(80, storage);

        // 消费者对象和产品消费数量
        Consumer c1 = new Consumer(50, storage);
        Consumer c2 = new Consumer(20, storage);
        Consumer c3 = new Consumer(30, storage);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
