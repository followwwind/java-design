package com.wind.example.base.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源分配管理
 * Semaphore除了控制资源的多个副本的并发访问控制，也可以使用二进制信号量来实现类似synchronized关键字和Lock锁的并发访问控制功能
 * Semaphore是用来保护一个或者多个共享资源的访问，Semaphore内部维护了一个计数器，其值为可以访问的共享资源的个数。
 * 一个线程要访问共享资源，先获得信号量，如果信号量的计数器值大于1，意味着有共享资源可以访问，则使其计数器值减去1，再访问共享资源。
 * 如果计数器值为0,线程进入休眠。当某个线程使用完共享资源后，释放信号量，并将信号量内部的计数器加1，
 * 之前进入休眠的线程将被唤醒并再次试图获得信号量。
 * @author wind
 */
public class ResourceManage {

    private final Semaphore semaphore;
    private boolean[] resourceArray;
    private final ReentrantLock lock;

    public ResourceManage() {
        //存放厕所状态
        this.resourceArray = new boolean[10];
        //控制10个共享资源的使用，使用先进先出的公平模式进行共享;公平模式的信号量，先来的先获得信号量
        this.semaphore = new Semaphore(10,true);
        //公平模式的锁，先来的先选
        this.lock = new ReentrantLock(true);
        for(int i = 0 ;i < 10; i++){
            //初始化为资源可用的情况
            resourceArray[i] = true;
        }
    }

    /**
     * 使用资源
     * @param userId
     */
    public void useResource(int userId){
        try{
            semaphore.acquire();
            //占到一个坑
            int id = getResourceId();
            System.out.print("userId:"+userId+"正在使用资源，资源id:"+id+"\n");
            //do something，相当于于使用资源
            Thread.sleep(100);
            //退出这个坑
            resourceArray[id] = true;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();//释放信号量，计数器加1
        }
    }
    private int getResourceId(){
        int id = -1;
        lock.lock();
        try {
            //虽然使用了锁控制同步，但由于只是简单的一个数组遍历，效率还是很高的，所以基本不影响性能。
            for(int i = 0; i < 10; i++){
                if(resourceArray[i]){
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return id;
    }
}
