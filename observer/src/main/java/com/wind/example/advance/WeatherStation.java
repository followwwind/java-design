package com.wind.example.advance;



/**
 * 天气气象站
 * @author wind
 */
public class WeatherStation extends AbstractSubject{

    /**
     * 天气预报
     */
    private String forecast;

    public WeatherStation(){

    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
        notifyAllObserver();
    }
}
