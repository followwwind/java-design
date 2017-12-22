package com.wind.example.advance;

/**
 * 多主题
 * @author wind
 */
public class Application {

    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency();
        WeatherStation station = new WeatherStation();

        Person person = new Person();
        person.subscribe(travelAgency);
        person.subscribe(station);

        station.setForecast("2017-12-22,多云,最高气温20℃,最低气温3℃");

        travelAgency.setMessage("2017-12-22起,杭州两日游.");
    }
}
