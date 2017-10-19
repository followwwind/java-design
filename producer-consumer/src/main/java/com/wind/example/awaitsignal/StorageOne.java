package com.wind.example.awaitsignal;

import com.wind.example.Storage;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仓库类Storage实现缓冲区
 * 在JDK5.0之后，Java提供了更加健壮的线程处理机制，包括同步、锁定、线程池等，它们可以实现更细粒度的线程控制。
 * await()和signal()就是其中用来做同步的两种方法，它们的功能基本上和wait() / nofity()相同，
 * 完全可以取代它们，但是它们和新引入的锁定机制Lock直接挂钩，具有更大的灵活性。
 * 通过在Lock对象上调用newCondition()方法，将条件变量和一个锁对象进行绑定，进而控制并发程序访问竞争资源的安全
 * @author wind
 */
public class StorageOne implements Storage {

    /**
     * 仓库存储的载体
      */
    private LinkedList<Object> list = new LinkedList<>();

    /**
     * 锁
      */
    private final Lock lock = new ReentrantLock();

    /**
     * 仓库满的条件变量
      */
    private final Condition full = lock.newCondition();

    /**
     * 仓库空的条件变量
      */
    private final Condition empty = lock.newCondition();

    /**
     * 生产num个产品
      * @param num
     */
    @Override
    public void produce(int num) {
        // 获得锁
        lock.lock();

        // 如果仓库剩余容量不足
        while (list.size() + num > MAX_SIZE) {
            System.out.println("【要生产的产品数量】:" + num + "/t【库存量】:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try {
                // 由于条件不满足，生产阻塞
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i) {
            list.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());

        // 唤醒其他所有线程
        full.signalAll();
        empty.signalAll();

        // 释放锁
        lock.unlock();
    }

    /**
     * 消费num个产品
      * @param num
     */
    @Override
    public void consume(int num) {
        // 获得锁
        lock.lock();

        // 如果仓库存储量不足
        while (list.size() < num) {
            System.out.println("【要消费的产品数量】:" + num + "/t【库存量】:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try {
                // 由于条件不满足，消费阻塞
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; ++i) {
            list.remove();
        }

        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());

        // 唤醒其他所有线程
        full.signalAll();
        empty.signalAll();

        // 释放锁
        lock.unlock();
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}
