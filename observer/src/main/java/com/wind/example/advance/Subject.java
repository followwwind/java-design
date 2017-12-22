package com.wind.example.advance;


/**
 * 主题接口
 * @author wind
 */
public interface Subject {

    /**
     * 添加观察者
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyAllObserver();
}
