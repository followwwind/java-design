package com.wind.example.advance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind
 */
public abstract class AbstractSubject implements Subject{

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if(observer == null){
            return;
        }

        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        observerList.forEach(observer -> observer.update(this));
    }
}
