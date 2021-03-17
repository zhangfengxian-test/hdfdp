package ch02;

public class StatisticsDisplay implements Observer, DisplayElement {

    int times;
    float sumTemp;
    float maxTemp;
    float minTemp = Float.MAX_VALUE;
    Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;

        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        times ++;

        sumTemp += temperature;
        maxTemp = Math.max(temperature, maxTemp);
        minTemp = Math.min(temperature, minTemp);

        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Avg/Max/Min temperature = %.2f/%.2f/%.2f", sumTemp / times, maxTemp, minTemp));
    }
}
