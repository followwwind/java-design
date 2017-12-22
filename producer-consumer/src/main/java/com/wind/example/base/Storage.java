package com.wind.example.base;

/**
 * @author wind
 */
public interface Storage {

    /**
     * 仓库最大存储量
     */
    int MAX_SIZE = 100;

    /**
     * 生产num个产品
     * @param num
     */
    void produce(int num);

    /**
     * 消费num个产品
     * @param num
     */
    void consume(int num);
}
