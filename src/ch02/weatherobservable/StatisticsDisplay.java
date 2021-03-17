package ch02.weatherobservable;

import ch02.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    int times;
    float sumTemp;
    float maxTemp;
    float minTemp = Float.MAX_VALUE;
    Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;

        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Avg/Max/Min temperature = %.2f/%.2f/%.2f", sumTemp / times, maxTemp, minTemp));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            times ++;
            sumTemp += weatherData.getTemperature();
            maxTemp = Math.max(weatherData.getTemperature(), maxTemp);
            minTemp = Math.min(weatherData.getTemperature(), minTemp);
            display();
        }
    }
}
