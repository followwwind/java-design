package com.wind.example.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedOutputStream和PipedInputStream是管道输出流和管道输入流，配合使用可以实现线程间通信。
 * @author wind
 */
public class PipedTest {
    public static void main(String[] args) {
        /**
         * 流程
         * 1 建立输入输出流
         * 2 绑定输入输出流
         * 3 向缓冲区写数据
         * 4 读取缓冲区数据
         */
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
        Producer producer = new Producer(out);
        Consumer consumer = new Consumer(in);

        try {
            out.connect(in);
            producer.start();
            consumer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
