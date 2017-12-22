package com.wind.example.base.pipedstream;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 生产者线程
 * @author wind
 */
public class Producer extends Thread{
    /**
     * 输出流
     */
    private PipedOutputStream out = new PipedOutputStream();

    /**
     * 构造方法
     * @param out
     */
    public Producer(PipedOutputStream out) {
        this.out = out;
    }
    @Override
    public void run() {
        writeMessage();
    }

    private void writeMessage() {
        StringBuilder sb = new StringBuilder("Hello World!!!");
        try {
            out.write(sb.toString().getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
