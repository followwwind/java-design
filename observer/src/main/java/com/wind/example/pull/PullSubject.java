package com.wind.example.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * 拉数据主题中心
 * @author wind
 */
public class PullSubject implements IPullSubject{

    private String goodName;

    private double oldPrice;

    private double newPrice;

    private List<IPullObserver> observers;

    public PullSubject() {
        this("", 0, 0 , new ArrayList<>());
    }

    public PullSubject(String goodName, double oldPrice, double newPrice, List<IPullObserver> observers) {
        this.goodName = goodName;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        if(observers == null){
            observers = new ArrayList<>();
        }
        this.observers = observers;
    }

    @Override
    public void addObserver(IPullObserver observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IPullObserver observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        observers.parallelStream().forEach(IPullObserver::update);
    }

    public void updateInfo(String goodName, double oldPrice, double newPrice){
        this.goodName = goodName;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        notifyAllObserver();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}
