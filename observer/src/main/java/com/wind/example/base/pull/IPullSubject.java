package com.wind.example.base.pull;

/**
 * 拉模式主题接口
 * @author wind
 */
public interface IPullSubject {

    /**
     * 添加观察者
     * @param observer
     */
    void addObserver(IPullObserver observer);

    /**
     * 删除观察者
     * @param observer
     */
    void removeObserver(IPullObserver observer);

    /**
     * 通知所有观察者
     */
    void notifyAllObserver();
}
