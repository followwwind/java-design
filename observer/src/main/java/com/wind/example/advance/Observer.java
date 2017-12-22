package com.wind.example.advance;

/**
 * 观察者
 * @author wind
 */
public interface Observer {
    /**
     * 更新信息
     * @param subject
     */
    void update(Subject subject);
}
