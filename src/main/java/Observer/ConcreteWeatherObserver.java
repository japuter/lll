package Observer;

public class ConcreteWeatherObserver implements WeatherObserver {

    private String observerName; // Name of the observer ("Apple Watch" or "phone")

    public ConcreteWeatherObserver(String observerName) {
        this.observerName = observerName; // Set the name of the observer
    }

    @Override
    public void update(float temperature) {
        System.out.println(observerName + " received temperature update: " + temperature);
    }
}
