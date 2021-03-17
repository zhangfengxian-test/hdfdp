package ch02;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    float temperature;
    float humidity;
    float pressure;
    List<Observer> displays = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        displays.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        displays.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer display : displays) {
            display.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

}
