package com.wind.example.push;


/**
 * 主题
 * @author wind
 */
public interface IPushSubject {
    /**
     * 添加观察者
     * @param observer
     */
    void addObserver(IPushObserver observer);

    /**
     * 删除观察者
     * @param observer
     */
    void removeObserver(IPushObserver observer);

    /**
     * 通知所有观察者
     */
    void notifyAllObserver();

}
