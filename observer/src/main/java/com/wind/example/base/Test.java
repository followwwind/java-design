package com.wind.example.base;

import com.wind.example.base.pull.PullObserver;
import com.wind.example.base.pull.PullSubject;
import com.wind.example.base.push.PushObserver;
import com.wind.example.base.push.PushSubject;

/**
 * Test
 * @author
 */
public class Test {

    /**
     * 测试观察者推数据模式
     */
    public static void push(){

        PushSubject subject = new PushSubject();
        PushObserver observer1 = new PushObserver("wind", 21);
        PushObserver observer2 = new PushObserver("follow", 27);
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        observer2.setAge(18);

        subject.changeMsg("hello");
        subject.notifyAllObserver();


    }

    /**
     * 测试观察者拉数据模式
     */
    public static void pull(){
        PullSubject subject = new PullSubject();
        PullObserver observer1 = new PullObserver(subject,"wind", true);
        PullObserver observer2 = new PullObserver(subject,"follow", false);

        subject.updateInfo("banana", 18, 20);
    }


    public static void main(String[] args) {
//        push();
        pull();
    }
}
