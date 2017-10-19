package com.wind.example.semaphore;

/**
 * 资源使用者
 * @author wind
 */
public class ResourceUser implements Runnable {

    private ResourceManage resourceManage;
    private int userId;

    public ResourceUser() {
    }

    public ResourceUser(ResourceManage resourceManage, int userId) {
        this.resourceManage = resourceManage;
        this.userId = userId;
    }

    @Override
    public void run() {

        System.out.print("userId:"+userId+"准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:"+userId+"使用资源完毕...\n");

    }
}
