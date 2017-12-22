package com.wind.example.base.semaphore;

/**
 * @author wind
 */
public class Test {

    public static void main(String[] args) {
        ResourceManage resourceManage = new ResourceManage();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            //创建多个资源使用者
            Thread thread = new Thread(new ResourceUser(resourceManage,i));
            threads[i] = thread;
        }
        for(int i = 0; i < 100; i++){
            Thread thread = threads[i];
            try {
                thread.start();//启动线程
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
