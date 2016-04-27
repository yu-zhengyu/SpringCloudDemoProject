package io.pivotal.microservices.weather;

import javax.persistence.Id;


/**
 * @author zhengyu
 * @date 2016年4月21日
 */
public class Weather {
    private String cityName;
    private String currentWeather;
    public static Long nextId = 0L;
    @Id
    protected Long id;
    
    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }
    
    public Weather(String cityName, String currentWeather) {
        id = getNextId();
        this.cityName = cityName;
        this.currentWeather = currentWeather;
    }
    
    @Override
    public String toString() {
        return "City: " + cityName + ", " + "Current weather: " + currentWeather;
    }
}
