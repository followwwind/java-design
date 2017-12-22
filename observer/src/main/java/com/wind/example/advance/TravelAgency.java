package com.wind.example.advance;


/**
 * 旅行社
 * @author wind
 */
public class TravelAgency extends AbstractSubject{
    /**
     * 信息
     */
    private String message;

    public TravelAgency(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyAllObserver();
    }
}
