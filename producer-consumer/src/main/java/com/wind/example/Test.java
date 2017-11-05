package com.wind.example;


import com.wind.example.awaitsignal.StorageOne;
import com.wind.example.blockingqueue.StorageTwo;
import com.wind.example.waitnotify.StorageThree;

/**
 * 测试类
 * 在java应用中，生产者/消费者模式的实现有以下五种:
 * 1:wait() / nofity()方法是基类Object的两个方法，也就意味着所有Java类都会拥有这两个方法，这样，我们就可以为任何对象实现同步机制。
 * 2.await()和signal()就是其中用来做同步的两种方法，它们的功能基本上和wait() / nofity()相同。
 * 3:BlockingQueue是JDK5.0的新增内容，它是一个已经在内部实现了同步的队列，实现方式采用的是我们第2种await() / signal()方法。
 * 4:PipedOutputStream和PipedInputStream是管道输出流和管道输入流，配合使用可以实现线程间通信。
 * 5:Semaphore除了控制资源的多个副本的并发访问控制，也可以使用二进制信号量来实现类似synchronized关键字和Lock锁的并发访问控制功能。
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
