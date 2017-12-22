package com.wind.example.base.push;

/**
 * @author wind
 */
public interface IPushObserver {
    /**
     * 推模式接收数据（带参）
     * @param message
     */
    void receive(String message);
}
