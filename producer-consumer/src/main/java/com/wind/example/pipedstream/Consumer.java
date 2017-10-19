package com.wind.example.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 消费线程
 * @author wind
 */
public class Consumer extends Thread {
    /**
     * 输入流, 默认缓冲区大小为1024
     */
    private PipedInputStream in = new PipedInputStream();

    /**
     * 构造方法
     * @param in
     */
    public Consumer(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        readMessage();
    }

    private void readMessage() {
        byte [] buf = new byte[1024];
        try {
            int len = in.read(buf);
            System.out.println("缓冲区的内容为: " + new String(buf, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
