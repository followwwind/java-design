package com.wind.example.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 推数据主题中心
 * @author wind
 */
public class PushSubject implements IPushSubject {

    private String message;

    private List<IPushObserver> observers;

    private boolean changed;

    public PushSubject() {
        this("", new ArrayList<>(), false);
    }

    public PushSubject(String message, List<IPushObserver> observers, boolean changed) {
        this.message = message;
        if(observers == null){
            observers = new ArrayList<>();
        }
        this.observers = observers;
        this.changed = changed;
    }

    @Override
    public void addObserver(IPushObserver observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IPushObserver observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        if(changed){
            observers.parallelStream().forEach(observer -> observer.receive(message));
        }
    }

    /**
     * 修改消息
     * @param str
     */
    public void changeMsg(String str){
        if(str != null && !str.equals(message)){
            changed = true;
            message = str;
        }else{
            changed = false;
        }
    }


}
