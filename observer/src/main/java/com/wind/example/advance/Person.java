package com.wind.example.advance;

/**
 * @author wind
 */
public class Person implements Observer{

    public Person(){

    }

    /**
     * 订阅主题
     * @param subject
     */
    public void subscribe(Subject subject){
        subject.addObserver(this);
    }


    @Override
    public void update(Subject subject) {
        if(subject instanceof WeatherStation){
            WeatherStation station = (WeatherStation) subject;
            System.out.println(station.getForecast());
        }else if(subject instanceof TravelAgency){
            TravelAgency travelAgency = (TravelAgency) subject;
            System.out.println(travelAgency.getMessage());
        }
    }
}
